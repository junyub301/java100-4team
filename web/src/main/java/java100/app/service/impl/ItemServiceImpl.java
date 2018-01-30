package java100.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.ItemDao;
import java100.app.dao.PhotoDao;
import java100.app.domain.Item;
import java100.app.domain.Photo;
import java100.app.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired ItemDao itemDao;
    @Autowired PhotoDao photoDao;
    
    @Override
    public int add(Item item, List<Photo> photoList) {
        int count = itemDao.insert(item);
        for (Photo photo : photoList) {
            photo.setItemNo(item.getItemNo());
            photoDao.insertItem(photo);
        } 
        return count; 
    }

    @Override
    public List<Item> list() {
        return itemDao.findAll();
    }
    
    

}
