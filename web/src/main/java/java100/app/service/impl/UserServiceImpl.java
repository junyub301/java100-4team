package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.MapsDao;
import java100.app.dao.PhotoDao;
import java100.app.dao.UserDao;
import java100.app.domain.Maps;
import java100.app.domain.Photo;
import java100.app.domain.User;
import java100.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    
    @Autowired UserDao userDao;
    @Autowired PhotoDao photoDao;
    @Autowired MapsDao mapsDao;
    
    
    @Override
    public List<User> list() {
        return userDao.list();
    }
    
    @Override
    public User getUser(int no) {
        User user = userDao.findByNo(no);
        return user;
    }

    @Override
    public int add( User user, Maps maps) {
        int count = userDao.insert(user);
        maps.setUserNo(user.getUserNo());
        mapsDao.insert(maps);
        try {
            addFiles(user.getPhotos(),user.getUserNo());
            } catch (Exception e) {
                System.out.println("첨부파일 등록 중 예외 발생!");
            }
            
        return count;
    }
    
    @Override
    public int addUser(User user) {
        int count = userDao.insert(user);
        try {
            addFiles(user.getPhotos(),user.getUserNo());
        } catch (Exception e) {
            System.out.println("첨부파일 등록 중 예외 발생!");
        }
        
        return count;
    }
    

    
    @Override
    public int update(User user, Maps maps) {
        int count;
        // 패스워드가 비었으면 패스워드를 제외한 업데이트(sql)를 실행
        if (user.getPassword().isEmpty()) {
            count = userDao.update2(user);
        } else {
            count = userDao.update(user);
        }
        if (!user.getPhotos().isEmpty()) {
        photoDao.deleteAllByUserNo(user.getUserNo());
        addFiles(user.getPhotos(), user.getUserNo());
        }
        if (!maps.getAddress().isEmpty()) {
            mapsDao.delete(user.getUserNo());
            mapsDao.insert(maps);
        }
        return count;
    }
    
    
    @Override
    public int delete(int no) {

        return userDao.delete(no);
    }


    @Override
    //@Transactional // XML 설정으로 대체
    public void addFiles(List<Photo> photos, int userNo) {

        for (Photo photo : photos) {
            // 파일 정보를 insert하기 전에 게시물 no를 설정한다.
            photo.setUserNo(userNo);
            photoDao.insertUser(photo);
        }

    }
    @Override
    public int checkId(String id) {
        return userDao.checkId(id);
    }

    @Override
    public int checkEmail(String email) {
        return userDao.checkEmail(email);
    }
    
    @Override
    public User get(String id, String password) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("id", id);
        params.put("password", password);
        
        return userDao.findByaccountNameAndPassword(params);
    }
    @Override
    public User get(String email) {
        return userDao.findByEmail(email);
    }
    
    @Override
    public int checkPassword(String id, String password) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("id", id);
        params.put("password", password);
        return userDao.checkPassword(params);
    }

}
