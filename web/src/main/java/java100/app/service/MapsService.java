package java100.app.service;

import java.util.List;

import java100.app.domain.Maps;

public interface MapsService {
    List<Maps> list();
    int add(Maps maps);
    Maps getUser(int no);
    Maps getItem(int no);
    int update(Maps maps);
    int delete(int no);
}





