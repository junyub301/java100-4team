package java100.app.service;

import java.util.List;
import java100.app.domain.Item;
import java100.app.domain.Photo;

public interface ItemService {
    int add(Item item, List<Photo> photoList);
    Item getItem(int no);
}





