package java100.app.web.json;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java100.app.domain.Account;
import java100.app.domain.User;
import java100.app.service.AccountService;
import java100.app.service.FacebookService;
import java100.app.service.GoogleService;
import java100.app.service.KakaoService;
import java100.app.service.UserService;

@RestController
@RequestMapping("/auth")
@SessionAttributes("loginUser")
public class LoginController {

    @Autowired AccountService accountService;
    @Autowired UserService userService;
    @Autowired FacebookService facebookService;
    @Autowired KakaoService kakaoService;
    @Autowired GoogleService googleService;

    @RequestMapping(value="login", method=RequestMethod.POST)
    public Object login(
            String accountName, 
            String password,
            HttpServletResponse response,
            HttpSession session,
            Model model) {

        Account account = accountService.get(accountName, password);

        HashMap<String,Object> result = new HashMap<>();

        if (account == null) {
            model.addAttribute("loginUser", null);
            result.put("status", "fail"); 
        } else {
            model.addAttribute("loginUser", account);
            result.put("status", "success");
        }

        return result;
    }

    @RequestMapping(value="facebookLogin")
    public Object facebookLogin(
            String accessToken, 
            HttpSession session,
            Model model) {

        try {
            @SuppressWarnings("rawtypes")
            Map userInfo = facebookService.me(accessToken, Map.class);

            Account account = accountService.get(
                    (String)userInfo.get("email"));

            if (account == null) { // 등록된 회원이 아니면,
                // 페이스북에서 받은 정보로 회원을 자동 등록한다.
                User user = new User();
                account = new Account();
                account.setName((String)userInfo.get("name"));
                account.setEmail((String)userInfo.get("email"));
                String[] a = account.getEmail().split("@");
                account.setAccountName(a[0]);
                account.setPassword("1111");
                user.setAccountNo("");
                user.setBank("");
                user.setPhone("");
                user.setPostNo("");
                user.setBaseAddress("");
                user.setDetailAddress("");
                userService.add(account, user);
            }

            // 회원 정보를 세션에 저장하여 자동 로그인 처리를 한다.
            model.addAttribute("loginUser", account);

            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "success");
            return result;

        } catch (Exception e) {
            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "fail");
            result.put("exception", e.getStackTrace());
            return result;
        }
    }

    @RequestMapping(value="kakaoLogin")
    public Object kakaoLogin(
            String accessToken, 
            HttpSession session,
            Model model) {

        try {
            // Facebook에서 사용자 정보를 가져온다.
            @SuppressWarnings("rawtypes")
            Map koResponse = kakaoService.me(accessToken, Map.class);
            if (koResponse.get("error") != null) {
                model.addAttribute("loginUser", null);
                HashMap<String,Object> result = new HashMap<>();
                result.put("status", "fail"); 
                return result;
            }
            // 이메일로 회원 정보를 찾는다.
            Account account = accountService.get((String)koResponse.get("kaccount_email"));
            if (account == null) {
                // 회원 정보가 없으면 페이스북 회원 정보를 등록한다.
                account = new Account();
                User user = new User();
                account.setName((String)((Map)koResponse.get("properties")).get("nickname"));
                account.setEmail((String)koResponse.get("kaccount_email"));
                String[] a = account.getEmail().split("@");
                account.setAccountName(a[0]);
                account.setPassword("1111");
                user.setAccountNo("");
                user.setBank("");
                user.setPhone("");
                user.setBaseAddress("");
                user.setDetailAddress("");
                user.setPostNo("");
                userService.add(account,user);
            }

            model.addAttribute("loginUser", account);

            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "success");
            return result;
        } catch (Exception e) {
            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "fail");
            result.put("exception", e.getStackTrace());
            return result;
        }
    }
    
    @RequestMapping(value="googleLogin")
    public Object GoogleLogin(
            String accessToken, 
            HttpSession session,
            Model model) {
    	@SuppressWarnings("rawtypes")
        Map userInfo = null;
        try {
            // Facebook에서 사용자 정보를 가져온다.
            
            userInfo = googleService.me(accessToken, Map.class);

            if (userInfo.get("error") != null) {
                model.addAttribute("loginUser", null);
                HashMap<String,Object> result = new HashMap<>();
                result.put("status", "fail"); 
                return result;
            }

            // 이메일로 회원 정보를 찾는다.
            Account account = accountService.get((String)userInfo.get("email"));

            if (account == null) {
                // 회원 정보가 없으면 페이스북 회원 정보를 등록한다.
                account = new Account();
                User user = new User();
                account.setName((String)userInfo.get("name"));
                account.setEmail((String)userInfo.get("email"));
                String[] a = account.getEmail().split("@");
                account.setAccountName(a[0] + "_google");
                account.setPassword("1111");
                user.setAccountNo("");
                user.setBank("");
                user.setPhone("");
                user.setBaseAddress("");
                user.setDetailAddress("");
                user.setPostNo("");
                userService.add(account,user);
            }

            model.addAttribute("loginUser", account);

            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "success");
            return result;
        } catch (Exception e) {
            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "fail");
            return result;
        }
    }     
    @RequestMapping(value="naverLogin")
    public Object naverLogin(
            Account naccount,
            HttpSession session,
            HttpServletRequest request,
            Model model) {
        try {
            Account account = accountService.get(naccount.getEmail());

            if (account == null) { // 등록된 회원이 아니면,
                // 페이스북에서 받은 정보로 회원을 자동 등록한다.
                User user = new User();
                account = new Account();
                account.setName(naccount.getName());
                account.setEmail(naccount.getEmail());
                String[] a = account.getEmail().split("@");
                account.setAccountName(a[0]);
                account.setPassword("1111");
                user.setAccountNo("");
                user.setBank("");
                user.setPhone("");
                user.setPostNo("");
                user.setBaseAddress("");
                user.setDetailAddress("");
                userService.add(account, user);
            }

            // 회원 정보를 세션에 저장하여 자동 로그인 처리를 한다.
            model.addAttribute("loginUser", account);

            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "success");
            return result;

        } catch (Exception e) {
            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "fail");
            result.put("exception", e.getStackTrace());
            return result;
        }
    }



        @RequestMapping("logout")
        public Object logout(HttpSession session, SessionStatus status) {

            status.setComplete();
            session.invalidate();

            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "success");
            return result;
        }

        @RequestMapping("loginUser")
        public Object userName(HttpSession session) {

            Account account = (Account)session.getAttribute("loginUser");

            HashMap<String,Object> result = new HashMap<>();

            if (account != null) {
                result.put("status", "success");
                result.put("account", account);
                result.put("user", userService.getUser(account.getAccountsNo()));
            } else {
                result.put("status", "fail");
            }

            return result;

        }


    }









