package java100.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.ReviewDao;
import java100.app.domain.Review;
import java100.app.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired ReviewDao reviewDao;

    @Override
    public List<Review> list() {
        
        return reviewDao.list();
    }

    @Override
    public int add(Review review) {
        return reviewDao.insert(review);
    }

    @Override
    public Review get(int no) {
        return reviewDao.findByNo(no);
    }

    @Override
    public int update(Review review) {
        return reviewDao.update(review);
    }

    @Override
    public int delete(int no) {
        return reviewDao.delete(no);
    }
    
    

}
