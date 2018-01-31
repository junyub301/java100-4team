package java100.app.service;

import java.util.List;

import java100.app.domain.Review;

public interface ReviewService {
    List<Review> list();
    int add(Review review);
    Review get(int no);
    int update(Review review);
    int delete(int no);
}





