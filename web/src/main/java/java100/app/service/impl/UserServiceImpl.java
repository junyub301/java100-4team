package java100.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.AccountDao;
import java100.app.dao.UserDao;
import java100.app.domain.Account;
import java100.app.domain.User;
import java100.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired AccountDao accountDao;
    @Autowired UserDao userDao;
    
    @Override
    public int add(Account account, User user) {
        int count = accountDao.insert(account);
        user.setUserNo(account.getAccountsNo());
        userDao.insert(user);
        return count;
    }
    
    

    
    


}
