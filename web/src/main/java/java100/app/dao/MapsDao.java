package java100.app.dao;

import java.util.List;

import java100.app.domain.Maps;

public interface MapsDao {
    List<Maps> list();
    int insert(Maps maps);
    Maps findByUserNo(int no);
    Maps findByItemNo(int no);
    int update(Maps maps);
    int delete(int no);
}















