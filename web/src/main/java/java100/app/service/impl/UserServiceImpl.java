package java100.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.AccountDao;
import java100.app.dao.PhotoDao;
import java100.app.dao.UserDao;
import java100.app.domain.Account;
import java100.app.domain.Photo;
import java100.app.domain.User;
import java100.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired AccountDao accountDao;
    @Autowired UserDao userDao;
    @Autowired PhotoDao photoDao;
    
    @Override
    public List<Account> listAccount() {
        return accountDao.list();
    }
    
    @Override
    public List<User> listUser() {
        return userDao.list();
    }
    
    
    @Override
    public Account getAccount(int no) {

        Account account = accountDao.findByNo(no);
        return account;
    }
    @Override
    public User getUser(int no) {
        
        // 게시물의 첨부 파일 정보를 가져올 때 
        // 방법1: 따로 따로 가져오기
        //  Board board = boardDao.findByNo(no);
        // board.setFiles(fileDao.findByBoardNo(no));
        
        // 방법2 : board 객체에 묶어서 가져오기
        User user = userDao.findByNo(no);
        return user;
    }

    @Override
    public int add(Account account, User user) {
        int count = accountDao.insert(account);
        user.setUserNo(account.getAccountsNo());
        userDao.insert(user);
        try {
            addFiles(user.getPhotos(),user.getUserNo());
            } catch (Exception e) {
                System.out.println("첨부파일 등록 중 예외 발생!");
            }
            
            //this.addFiles(user.getPhotos(),user.getUserNo());
        return count;
    }
    
    @Override
    public int update(Account account, User user) {
        int count = accountDao.update(account);
        user.setUserNo(account.getAccountsNo());
        if (!user.getPhotos().isEmpty()) {
        photoDao.deleteAllByUserNo(user.getUserNo());
        addFiles(user.getPhotos(), user.getUserNo());
        }
        userDao.update(user);

        return count;
    }

    @Override
    public int delete(int no) {

        return accountDao.delete(no);
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

}
