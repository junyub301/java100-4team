package java100.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.RequestItemDao;
import java100.app.domain.RequestItem;
import java100.app.service.RequestItemService;

@Service
public class RequestItemServiceImpl implements RequestItemService {

    @Autowired RequestItemDao requestItemDao;
    
    @Override
    public List<RequestItem> list() {
        return requestItemDao.list();
    }
    @Override
    public int add(RequestItem requestItem) {
        
        return requestItemDao.insert(requestItem);
    }
    
    @Override
    public int update(RequestItem requestItem) {
        
        return requestItemDao.update(requestItem);
    }

    @Override
    public int delete(int no) {

        return requestItemDao.delete(no);
    }
    @Override
    public RequestItem get(int no) {
        RequestItem requestItem = requestItemDao.findByNo(no);
        return requestItem;
    }


}
