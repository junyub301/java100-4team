package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Account;

public interface AccountDao {
    List<Account> list();
    int insert(Account account);
    Account findByNo(int no);
    int update(Account account);
    int update2(Account account);
    int delete(int no);
    Account findByaccountNameAndPassword(Map<String,Object> params);
}















