package java100.app.web.json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
    
    @RequestMapping("main")
    public String main() throws Exception {
        return "main/main";
    }
    
    
}











