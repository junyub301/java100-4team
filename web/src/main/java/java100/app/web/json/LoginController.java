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

import java100.app.domain.User;
import java100.app.service.FacebookService;
import java100.app.service.GoogleService;
import java100.app.service.KakaoService;
import java100.app.service.UserService;

@RestController
@RequestMapping("/auth")
@SessionAttributes("loginUser")
public class LoginController {

    @Autowired UserService userService;
    @Autowired FacebookService facebookService;
    @Autowired KakaoService kakaoService;
    @Autowired GoogleService googleService;

    @RequestMapping(value="login", method=RequestMethod.POST)
    public Object login(
            String id, 
            String password,
            HttpServletResponse response,
            HttpSession session,
            Model model) {

        User user = userService.get(id, password);

        HashMap<String,Object> result = new HashMap<>();

        if (user == null) {
            model.addAttribute("loginUser", null);
            result.put("status", "fail"); 
        } else {
            model.addAttribute("loginUser", user);
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

            User user = userService.get(
                    (String)userInfo.get("email"));

            if (user == null) { // 등록된 회원이 아니면,
                // 페이스북에서 받은 정보로 회원을 자동 등록한다.
                user = new User();
                user.setUserName((String)userInfo.get("name"));
                user.setEmail((String)userInfo.get("email"));
                String[] a = user.getEmail().split("@");
                user.setUserId(a[0]);
                user.setPassword("1111");
                user.setAccountNo("");
                user.setBank("");
                user.setPhone("");
                user.setPostNo("");
                user.setBaseAddress("");
                user.setDetailAddress("");
                userService.addUser(user);
            }

            // 회원 정보를 세션에 저장하여 자동 로그인 처리를 한다.
            model.addAttribute("loginUser", user);

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
            User user = userService.get((String)koResponse.get("kaccount_email"));
            if (user == null) {
                // 회원 정보가 없으면 페이스북 회원 정보를 등록한다.
                user = new User();
                user.setUserName((String)((Map)koResponse.get("properties")).get("nickname"));
                user.setEmail((String)koResponse.get("kaccount_email"));
                String[] a = user.getEmail().split("@");
                user.setUserId(a[0]);
                user.setPassword("1111");
                user.setAccountNo("");
                user.setBank("");
                user.setPhone("");
                user.setBaseAddress("");
                user.setDetailAddress("");
                user.setPostNo("");
                userService.addUser(user);
            }

            model.addAttribute("loginUser", user);

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
            User user = userService.get((String)userInfo.get("email"));

            if (user == null) {
                // 회원 정보가 없으면 페이스북 회원 정보를 등록한다.
                user = new User();
                user.setUserName((String)userInfo.get("name"));
                user.setEmail((String)userInfo.get("email"));
                String[] a = user.getEmail().split("@");
                user.setUserId(a[0] + "_google");
                user.setPassword("1111");
                user.setAccountNo("");
                user.setBank("");
                user.setPhone("");
                user.setBaseAddress("");
                user.setDetailAddress("");
                user.setPostNo("");
                userService.addUser(user);
            }

            model.addAttribute("loginUser", user);

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
            User naccount,
            HttpSession session,
            HttpServletRequest request,
            Model model) {
        try {
            User user = userService.get(naccount.getEmail());

            if (user == null) { // 등록된 회원이 아니면,
                
                user = new User();
                user.setUserName(naccount.getUserName());
                user.setEmail(naccount.getEmail());
                String[] a = user.getEmail().split("@");
                user.setUserId(a[0]);
                user.setPassword("1111");
                user.setAccountNo("");
                user.setBank("");
                user.setPhone("");
                user.setBaseAddress("");
                user.setDetailAddress("");
                user.setPostNo("");
                userService.addUser(user);
                
            }

            // 회원 정보를 세션에 저장하여 자동 로그인 처리를 한다.
            model.addAttribute("loginUser", user);

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

            User user = (User)session.getAttribute("loginUser");

            HashMap<String,Object> result = new HashMap<>();

            if (user != null) {
                result.put("status", "success");
                result.put("user", user);
            } else {
                result.put("status", "fail");
            }

            return result;

        }


    }









