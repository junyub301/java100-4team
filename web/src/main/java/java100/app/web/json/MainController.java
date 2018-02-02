package java100.app.web.json;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {
    
    @RequestMapping("main")
    public String main() throws Exception {
        return "main/main";
    }
    
    
}











