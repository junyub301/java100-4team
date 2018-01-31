package java100.app.dao;

import java.util.List;

import java100.app.domain.Item;

public interface ItemDao {
    int insert(Item item);
    List<Item> findAll(); 
    Item findByNo(int no);
    int countAll();
}


















