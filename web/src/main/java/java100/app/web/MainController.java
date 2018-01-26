package java100.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
    
    @RequestMapping("main")
    public String main() throws Exception {
        return "main/main";
    }
    
    @RequestMapping("lend")
    public String lend() throws Exception {
        return "main/lend";
    }
    
    @RequestMapping("rent")
    public String rent() throws Exception {
        return "main/rent";
    }
     
    
}











