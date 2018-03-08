package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.User;

public interface UserDao {
    List<User> list();
    int insert(User user);
    int checkId(String id);
    int checkEmail(String email);
    User findByNo(int no);
    int update(User user);
    int update2(User user);
    int delete(int no);
    User findByaccountNameAndPassword(Map<String,Object> params);
    User findByEmail(String email);
    int checkPassword(Map<String,Object> params);
}















