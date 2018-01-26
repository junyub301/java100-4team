package java100.app.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java100.app.domain.Message;
import java100.app.service.MessageService;

@Controller
@RequestMapping("/msg")
public class MessageController {
    
    @Autowired ServletContext servletContext;
    @Autowired MessageService messageService;
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "message/form";
    }

     
    @RequestMapping("list")
    public String list(Model model) throws Exception {
        model.addAttribute("message", messageService.list());
        
        return "message/list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        model.addAttribute("message", messageService.get(no));

        return "message/view";
    }
    
    @RequestMapping("add")
    public String add(Message message) throws Exception {
        message.setUserNo(1); //임시로 받는 사람번호 설정
        messageService.add(message);
        return "redirect:list";
    }
    
    @RequestMapping("update")
    public String update(Message message) throws Exception  {
        
        messageService.update(message);
        
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception  {

        messageService.delete(no);

        return "redirect:list";
    }
    
    
}








