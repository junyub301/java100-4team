package java100.app.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java100.app.domain.Score;
import java100.app.service.ScoreService;

@Controller
@RequestMapping("/score")
public class ScoreController {
    
    @Autowired ScoreService scoreService;
    
    
}








