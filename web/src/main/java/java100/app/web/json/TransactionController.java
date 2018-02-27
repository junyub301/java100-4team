package java100.app.web.json;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java100.app.domain.Account;
import java100.app.domain.Item;
import java100.app.domain.Message;
import java100.app.domain.Transaction;
import java100.app.service.ItemService;
import java100.app.service.MessageService;
import java100.app.service.TransactionService;

@RestController
@RequestMapping("/tr")
public class TransactionController {
    
    @Autowired ServletContext servletContext;
    @Autowired TransactionService transactionService;
    @Autowired ItemService itemService;
    @Autowired MessageService messageService;
    
    @RequestMapping("add")
    public Object add(Transaction transaction, HttpSession session) throws Exception {
        Account account = (Account) session.getAttribute("loginUser");
        Item item = itemService.getItem(transaction.getItemNo());
        transaction.setLenderNo(account.getAccountsNo());
        transaction.setSellerNo(item.getUserNo());
        transactionService.add(transaction);
        item.setStatus(1);
        itemService.update(item);
        Message message = new Message(account.getAccountsNo(),"결제 완료","결제가 완료 되었습니다. 배송이 곧 시작됩니다");
        messageService.add(message);
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
    }
    
    @RequestMapping("list")
    public Object list(HttpSession session) throws Exception {
        Account account = (Account) session.getAttribute("loginUser");
        HashMap<String,Object> result = new HashMap<>();
        result.put("transaction", transactionService.list(account.getAccountsNo()));
        return result;
    }
    
    @RequestMapping("list2")
    public Object sellList(HttpSession session) throws Exception {
        Account account = (Account) session.getAttribute("loginUser");
        HashMap<String,Object> result = new HashMap<>();
        result.put("transaction", transactionService.sellList(account.getAccountsNo()));
        return result;
    }
    
    @RequestMapping("{no}")
    public Object view(@PathVariable int no) throws Exception {
        HashMap<String,Object> result = new HashMap<>();
        result.put("transaction", transactionService.get(no));
        return result;
    }
    
    
    
    @RequestMapping("update")
    public Object update(Transaction transaction) throws Exception  {
        HashMap<String,Object> result = new HashMap<>();
        transactionService.update(transaction);
        Item item = new Item();
        item.setItemNo(transaction.getItemNo());
        item.setStatus(2);
        itemService.update(item);
        result.put("status", "success");
        return result;
    }

    /*@RequestMapping("delete")
    public String delete(int no) throws Exception  {

        transactionService.delete(no);

        return "redirect:list";
    }*/
    
    
}








