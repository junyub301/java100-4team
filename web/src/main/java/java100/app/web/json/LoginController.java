package java100.app.web.json;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
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
   
    @RequestMapping(value="login", method=RequestMethod.POST)
    public Object login(
            String accountName, 
            String password,
            boolean saveaccountName,
            HttpServletResponse response,
            HttpSession session,
            Model model) {
        
        Account account = accountService.get(accountName, password);
        
        if (saveaccountName) {
            Cookie cookie = new Cookie("accountName", accountName);
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("accountName", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
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
        } else {
            result.put("status", "fail");
        }
            
        return result;
    
    }
    
        @RequestMapping(value="facebookLogin")
    public Object facebookLogin(
            String accessToken, 
            HttpSession session, /* 세션 객체가 없을 경우 미리 생성할 필요가 있다.*/
            Model model) {
        
        
        // Facebook에서 사용자 정보를 가져온다.
        @SuppressWarnings("rawtypes")
        Map fbResponse = facebookService.me(accessToken, Map.class);
        
        if (fbResponse.get("error") != null) {
            model.addAttribute("loginUser", null);
            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "fail"); 
            return result;
        }
        
        // 이메일로 회원 정보를 찾는다.
        Account account = accountService.get((String)fbResponse.get("email"));
        
        if (account == null) {
            // 회원 정보가 없으면 페이스북 회원 정보를 등록한다.
            account = new Account();
            User user = new User();
            account.setName((String)fbResponse.get("name"));
            account.setEmail((String)fbResponse.get("email"));
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
    }      
        
        @RequestMapping(value="kakaoLogin")
        public Object kakaoLogin(
                String accessToken, 
                HttpSession session, /* 세션 객체가 없을 경우 미리 생성할 필요가 있다.*/
                Model model) {
            
            
            
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
        }      
    
    
}









