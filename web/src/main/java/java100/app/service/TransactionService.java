package java100.app.service;

import java.util.List;

import java100.app.domain.Transaction;

public interface TransactionService {
    List<Transaction> list(int no);
    List<Transaction> sellList(int no);
    int add(Transaction transaction);
    Transaction get(int no);
    int update(Transaction transaction);
    int delete(int no);
}





