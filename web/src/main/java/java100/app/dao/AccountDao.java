package java100.app.dao;

import java.util.List;

import java100.app.domain.Account;

public interface AccountDao {
    List<Account> list();
    int insert(Account account);
    Account findByNo(int no);
    int update(Account account);
    int delete(int no);
}















