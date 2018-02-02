package java100.app.web.json;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java100.app.domain.Message;
import java100.app.service.MessageService;

@RestController
@RequestMapping("/msg")
public class MessageController {
    
    @Autowired ServletContext servletContext;
    @Autowired MessageService messageService;
    
     
    @RequestMapping("list")
    public Object list() throws Exception {
        HashMap<String,Object> result = new HashMap<>();
        result.put("message", messageService.list());
        
        return result;
    }
    
    @RequestMapping("{no}")
    public Object view(@PathVariable int no) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("message", messageService.get(no));

        return result;
    }
    
    @RequestMapping("add")
    public Object add(Message message) throws Exception {
        message.setUserNo(1); //임시로 받는 사람번호 설정
        messageService.add(message);
        HashMap<String, Object> result = new HashMap<>();
        result.put("stauts", "success");
        return result;
    }
    
    @RequestMapping("update")
    public Object update(Message message) throws Exception  {
        messageService.update(message);
        HashMap<String, Object> result = new HashMap<>();
        result.put("stauts", "success");
        return result;
    }

    @RequestMapping("delete")
    public Object delete(int no) throws Exception  {
        messageService.delete(no);
        HashMap<String, Object> result = new HashMap<>();
        result.put("stauts", "success");

        return result;
    }
    
    
}








