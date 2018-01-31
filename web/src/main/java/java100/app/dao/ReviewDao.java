package java100.app.dao;

import java.util.List;

import java100.app.domain.Review;

public interface ReviewDao {
    List<Review> list();
    int insert(Review review);
    Review findByNo(int no);
    int update(Review review);
    int checkMessage(Review review);
    int delete(int no);
}















