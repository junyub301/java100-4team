package java100.app.web.json;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java100.app.domain.Maps;
import java100.app.domain.User;
import java100.app.service.MapsService;

@RestController
@RequestMapping("/maps")
public class MapsController {
    
    @Autowired ServletContext servletContext;
    @Autowired MapsService mapsService;
    
    
    @RequestMapping("add")
    public Object add(Maps maps) throws Exception {
        mapsService.add(maps);
        HashMap<String, Object> result = new HashMap<>();
        result.put("stauts", "success");
        return result;
    }
    
    @RequestMapping("get")
    public Object getUserMap(HttpSession session) throws Exception {
        User user = (User)session.getAttribute("loginUser");
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("map",mapsService.getUser(user.getUserNo()));
        return result;
    }
    
    
    
}








