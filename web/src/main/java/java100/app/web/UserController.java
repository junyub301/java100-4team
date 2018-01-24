package java100.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java100.app.domain.Account;
import java100.app.domain.User;
import java100.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired UserService userService;
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "user/form";
    }

    @RequestMapping("add")
    public String add(Account account, User user) throws Exception {
        userService.add(account, user);
        return "redirect:form";
    }
    
    
}








