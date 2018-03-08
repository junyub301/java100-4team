package java100.app.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java100.app.domain.Account;
import java100.app.service.AccountService;
import java100.app.service.UserService;

//@Controller
@RequestMapping("/auth")
@SessionAttributes("loginUser")
public class LoginController {
    
    @Autowired AccountService accountService;
    @Autowired UserService userService;
    
    @RequestMapping(value="login", method=RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("menuVisible", false);
        return "auth/loginform";
    }
    
    @RequestMapping(value="login", method=RequestMethod.POST)
    public String login(
            String accountName, 
            String password,
            String saveaccountName,
            HttpServletResponse response,
            Model model) {
        
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
        
        if (account == null) {
            model.addAttribute("loginUser", null);
            model.addAttribute("menuVisible", false);
            return "auth/loginfail"; 
        }
         
        model.addAttribute("loginUser", account);
        
        return "redirect:../main/main";
    }
    
    @RequestMapping("logout")
    public String logout(HttpSession session, SessionStatus status) {
        
        status.setComplete();
        
        session.invalidate();
        
        return "redirect:login";
    }
}









