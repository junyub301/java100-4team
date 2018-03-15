package java100.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.MapsDao;
import java100.app.domain.Maps;
import java100.app.service.MapsService;

@Service
public class MapsServiceImpl implements MapsService {

    @Autowired MapsDao mapsDao;

    @Override
    public List<Maps> list() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int add(Maps maps) {
        mapsDao.insert(maps);
        return 0;
    }

    @Override
    public Maps getItem(int no) {
        Maps maps = new Maps();
        maps = mapsDao.findByItemNo(no);
        return maps;
    }
    
    @Override
    public Maps getUser(int no) {
        Maps maps = new Maps();
        maps = mapsDao.findByUserNo(no);
        return maps;
    }

    @Override
    public int update(Maps maps) {
        return mapsDao.update(maps);
    }

    @Override
    public int delete(int no) {
        return mapsDao.delete(no);
    }


    

}
