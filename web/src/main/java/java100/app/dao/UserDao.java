package java100.app.dao;

import java.util.List;

import java100.app.domain.User;

public interface UserDao {
    List<User> list();
    int insert(User user);
    User findByNo(int no);
    int update(User user);
    int delete(int no);
}















