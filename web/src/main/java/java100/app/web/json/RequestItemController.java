package java100.app.web.json;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java100.app.domain.Message;
import java100.app.domain.RequestItem;
import java100.app.domain.User;
import java100.app.service.RequestItemService;

@RestController
@RequestMapping("/lend")
public class RequestItemController {

    @Autowired ServletContext servletContext;
    @Autowired RequestItemService requestItemService;
    
    @RequestMapping("list")
    public Object list(HttpSession session) throws Exception {
        User user = (User)session.getAttribute("loginUser");
        HashMap<String,Object> result = new HashMap<>();
        result.put("requestItem", requestItemService.list(user.getUserNo()));
        
        return result;
    }
    
    @RequestMapping("add")
    public Object add(RequestItem requestItem, HttpSession session) throws Exception {
        User user = (User) session.getAttribute("loginUser");
        requestItem.setUserNo(user.getUserNo());
        requestItemService.add(requestItem);
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
    }
    @RequestMapping("update")
    public Object update(RequestItem requestItem) throws Exception  {
        requestItemService.update(requestItem);
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
    }

    @RequestMapping("delete")
    public Object delete(int no) throws Exception  {
        requestItemService.delete(no);
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");

        return result;
    }
    @RequestMapping("{no}")
    public Object view(@PathVariable int no) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("requestItem", requestItemService.get(no));

        return result;
    }
}
