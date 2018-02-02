package java100.app.web.json;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java100.app.domain.Transaction;
import java100.app.service.TransactionService;

@Controller
@RequestMapping("/tr")
public class TransactionController {
    
    @Autowired ServletContext servletContext;
    @Autowired TransactionService transactionService;
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "tr/form";
    }

    
    @RequestMapping("add")
    public String add(Transaction transaction) throws Exception {
        transactionService.add(transaction);
        return "redirect:list";
    }
    
    @RequestMapping("list")
    public String list(Model model) throws Exception {
        model.addAttribute("transaction", transactionService.list());
        return "tr/list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        model.addAttribute("transaction", transactionService.get(no));
        
        return "tr/view";
    }
    
    
    
    @RequestMapping("update")
    public String update(Transaction transaction) throws Exception  {
        System.out.println(transaction);
        transactionService.update(transaction);
        
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception  {

        transactionService.delete(no);

        return "redirect:list";
    }
    
    
}








