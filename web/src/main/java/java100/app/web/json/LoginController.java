package java100.app.web.json;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java100.app.domain.Account;
import java100.app.service.AccountService;
import java100.app.service.UserService;

@RestController
@RequestMapping("/auth")
@SessionAttributes("loginUser")
public class LoginController {
    
    @Autowired AccountService accountService;
    @Autowired UserService userService;
    
    @RequestMapping(value="login", method=RequestMethod.GET)
    public Object form(HashMap<String, Object> result) {
        
        result.put("menuVisible", false);
        return result;
    }
    
    @RequestMapping(value="login", method=RequestMethod.POST)
    public Object login(
            String accountName, 
            String password,
            String saveaccountName,
            HttpServletResponse response) {
        
        Account account= accountService.get(accountName, password);
        
        if (saveaccountName != null) {
            Cookie cookie = new Cookie("accountName", accountName);
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("email", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        HashMap<String,Object> result = new HashMap<>();

        if (account == null) {
            result.put("loginUser", null);
            result.put("menuVisible", false);
            return result; 
        }
         
        result.put("loginUser", account);
        
        return result;
    }
    
    @RequestMapping("logout")
    public Object logout(HttpSession session, SessionStatus status) {
        
        status.setComplete();
        session.invalidate();
        
        return "redirect:login";
    }
    
    @RequestMapping("userName")
    public String userName(HttpSession session) {
        String name = ((Account)session.getAttribute("loginUser")).getName();
        return name;
    }
    
    
}









