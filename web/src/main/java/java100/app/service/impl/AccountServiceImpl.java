package java100.app.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.AccountDao;
import java100.app.domain.Account;
import java100.app.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;
    @Override
    public Account get(String accountName, String password) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("accountName", accountName);
        params.put("password", password);
        
        return accountDao.findByaccountNameAndPassword(params);
    }
    @Override
    public Account get(String email) {
        return null;
    }

   

}
