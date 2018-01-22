package java100.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java100.app.domain.Score;
import java100.app.service.ScoreService;

@Controller
@RequestMapping("/score")
public class ScoreController { 
    
    @Autowired ScoreService scoreService;
    
    @RequestMapping("delete")
    public String delete(int no) throws Exception {
        
        scoreService.delete(no);
        return "redirect:list";
    }
    @RequestMapping("update")
    public String update(Score score) throws Exception {
        
        scoreService.update(score);
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list"; 
    }
    
    @RequestMapping("add")
    public String add(Score score) throws Exception {
        
        scoreService.add(score);
        return "redirect:list";
    }
    
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        model.addAttribute("score", scoreService.get(no));
        return "score/view";        
    }

    
}








