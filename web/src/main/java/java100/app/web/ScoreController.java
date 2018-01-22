package java100.app.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java100.app.domain.Score;
import java100.app.service.ScoreService;

@Controller
@RequestMapping("/score")
public class ScoreController {
    
    @Autowired ScoreService scoreService;
    
    @RequestMapping("update")
    public String update(Score score) throws Exception {
        
        scoreService.update(score);
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list"; 
    }
    
}








