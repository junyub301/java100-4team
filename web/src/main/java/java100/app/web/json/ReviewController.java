package java100.app.web.json;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java100.app.domain.Review;
import java100.app.service.ReviewService;

@Controller
@RequestMapping("/rv")
public class ReviewController {
    
    @Autowired ServletContext servletContext;
    @Autowired ReviewService reviewService;
    
    @RequestMapping("form")
    public String form(int no, Model model) throws Exception {
        model.addAttribute("no", no);
        return "rv/form";
    }

     
    @RequestMapping("list")
    public String list(Model model) throws Exception {
        model.addAttribute("review", reviewService.list());
        
        return "rv/list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        model.addAttribute("review", reviewService.get(no));

        return "rv/view";
    }
    
    @RequestMapping("add")
    public String add(Review review) throws Exception {
        reviewService.add(review);
        return "redirect:list";
    }
    
    @RequestMapping("update")
    public String update(Review review) throws Exception  {
        
        reviewService.update(review);
        
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception  {

        reviewService.delete(no);

        return "redirect:list";
    }
    
    
}








