package java100.app.web.json;

import java.util.HashMap;

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
import java100.app.service.AccountService;
import java100.app.service.UserService;

@RestController
@RequestMapping("/auth")
@SessionAttributes("loginUser")
public class LoginController {
    
    @Autowired AccountService accountService;
    @Autowired UserService userService;
   
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
            result.put("user", userService.getUser(account.getAccountsNo()));
        } else {
            result.put("status", "fail");
        }
            
        return result;
    
    }
    
    
}









