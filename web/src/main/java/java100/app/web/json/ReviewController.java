package java100.app.web.json;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java100.app.domain.Review;
import java100.app.service.ReviewService;
import java100.app.service.TransactionService;

@RestController
@RequestMapping("/rv")
public class ReviewController {
    
    @Autowired ServletContext servletContext;
    @Autowired ReviewService reviewService;
    @Autowired TransactionService transactionService;
    
    /*@RequestMapping("list")
    public String list(Model model) throws Exception {
        model.addAttribute("review", reviewService.list());
        
        return "rv/list";
    }*/
    
    @RequestMapping("{no}")
    public Object view(@PathVariable int no) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("review", reviewService.get(no));
        return result;
    }
    
    @RequestMapping("add")
    public Object add(Review review) throws Exception {
        reviewService.add(review);
        transactionService.updateState(review.getRentNo());
        HashMap<String, Object> result = new HashMap<>();
        result.put("stauts", "success");
        return result;
    }
    
    /*@RequestMapping("update")
    public String update(Review review) throws Exception  {
        
        reviewService.update(review);
        
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception  {

        reviewService.delete(no);

        return "redirect:list";
    }*/
    
    
}








