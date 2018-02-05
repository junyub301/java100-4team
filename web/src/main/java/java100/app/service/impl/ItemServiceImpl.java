package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public int add(Item item) {
      
        return itemDao.insert(item);
    }
 
    @Override
    public List<Item> list(int pageNo, int pageSize, Map<String, Object> options) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        if (options != null) {
            params.putAll(options);
        }
        return itemDao.findAll(params);
    }

    @Override
    public Item getItem(int no) {
        Item item = itemDao.findByNo(no);
        return item;
    }
    @Override
    public int getTotalCount() {
        return  itemDao.countAll();
    }

    @Override
    public int upload(int no, List<Photo> photoList) {
        if (!photoList.isEmpty()) {
            for (Photo photo : photoList) {
                photo.setItemNo(no);
                photoDao.insertItem(photo);
            }
        }
        return 0;
    }
    

}
