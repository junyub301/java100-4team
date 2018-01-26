package java100.app.dao;

import java.util.List;

import java100.app.domain.Photo;

public interface PhotoDao {

    List<Photo> findByUserNo(int no);
    
    void insertUser(Photo photo);
    void insertItem(Photo photo);

    void deleteAllByUserNo(int no);


}
