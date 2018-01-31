package java100.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.TransactionDao;
import java100.app.domain.Transaction;
import java100.app.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
    
    @Autowired TransactionDao transactionDao;
    
    @Override
    public List<Transaction> list() {
        return transactionDao.list();
    }

    @Override
    public int add(Transaction transaction) {
        return transactionDao.insert(transaction);
    }

    @Override
    public Transaction get(int no) {
        return transactionDao.findByNo(no);
    }

    @Override
    public int update(Transaction transaction) {
        return transactionDao.update(transaction);
    }

    @Override
    public int delete(int no) {
        return transactionDao.delete(no);
    }

    

}
