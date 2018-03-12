package java100.app.web.json;

import java.sql.Date;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java100.app.domain.Item;
import java100.app.domain.Message;
import java100.app.domain.Transaction;
import java100.app.domain.User;
import java100.app.service.ItemService;
import java100.app.service.MessageService;
import java100.app.service.TransactionService;
import java100.app.service.UserService;

@RestController
@RequestMapping("/tr")
public class TransactionController {
    
    @Autowired ServletContext servletContext;
    @Autowired TransactionService transactionService;
    @Autowired ItemService itemService;
    @Autowired MessageService messageService;
    @Autowired UserService userService;
    
    @RequestMapping("add")
    public Object add(Transaction transaction, HttpSession session, int selectAdd) throws Exception {
        User user = (User)session.getAttribute("loginUser");
        Item item = itemService.getItem(transaction.getItemNo());
        transaction.setLenderNo(user.getUserNo());
        transaction.setSellerNo(item.getUserNo());
        if (selectAdd == 1) {
            transactionService.add(transaction);
            item.setStatus(3);
            itemService.changeStatus(item);
            Message message = new Message(user.getUserNo(),"결제 완료","결제가 완료 되었습니다. 배송이 곧 시작됩니다");
            messageService.add(message);
        } else {
            transaction.setDeliveryPayType(0);
            transaction.setPayMethod(null);
            Date sqlDate = new java.sql.Date(System.currentTimeMillis());
            transaction.setPayDate(sqlDate);
            transactionService.add(transaction);
            item.setStatus(1);
            itemService.changeStatus(item);
            User seller = userService.getUser(item.getUserNo());
            //구매자에게 보내는 메세지
            Message message = new Message(user.getUserNo(),"연락을 시도하세요","판매자:"+seller.getUserName()+
                    ",연락처:"+seller.getPhone());
            messageService.add(message);
            //판매자에게 보내는 메세지
            Message message2 = new Message(item.getUserNo(),"거래 요청을 확인하세요","거래 신청이 되었습니다. 이용내역에 현황을 참고하세요 ");
            messageService.add(message2);
        }
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
    }
    
    @RequestMapping("list")
    public Object list(HttpSession session) throws Exception {
        User user = (User) session.getAttribute("loginUser");
        HashMap<String,Object> result = new HashMap<>();
        result.put("transaction", transactionService.list(user.getUserNo()));
        return result;
    }
    
    @RequestMapping("list2")
    public Object sellList(HttpSession session) throws Exception {
        User user = (User)session.getAttribute("loginUser");
        HashMap<String,Object> result = new HashMap<>();
        result.put("transaction", transactionService.sellList(user.getUserNo()));
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
        item.setStatus(4); // 배송중 상태
        itemService.changeStatus(item);
        result.put("status", "success");
        return result;
    }

    @RequestMapping("delete")
    public Object delete(int rentNo,int itemNo) throws Exception  {
        transactionService.delete(rentNo);
        Item item = new Item();
        item.setItemNo(itemNo);
        item.setStatus(0);
        itemService.changeStatus(item);
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
    }
    
    
}








