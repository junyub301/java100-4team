package java100.app.dao;

import java.util.List;

import java100.app.domain.Transaction;

public interface TransactionDao {
    List<Transaction> list();
    int insert(Transaction transaction);
    Transaction findByNo(int no);
    int update(Transaction transaction);
    int delete(int no);
}















