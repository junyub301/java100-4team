package java100.app.web.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Account;
import java100.app.domain.Photo;
import java100.app.domain.User;
import java100.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired ServletContext servletContext;
    @Autowired UserService userService;
    
    @RequestMapping("list")
    public Object list() throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        
        result.put("account", userService.listAccount());
        result.put("user",userService.listUser());
        
        return result;
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {


        model.addAttribute("account", userService.getAccount(no));
        model.addAttribute("user", userService.getUser(no));


        return "user/view";
    }
    
    @RequestMapping("add")
    public String add(Account account, User user, MultipartFile[] photo) throws Exception {
        String uploadDir = servletContext.getRealPath("/download");
        ArrayList<Photo> uploadFiles = new ArrayList<>();
        for (MultipartFile part: photo) {
            if (part.isEmpty())
                continue;
            
            // part파일은 uploadDir경로에 저장해라.
            String filename = this.writeUploadFile(part, uploadDir);
            
            uploadFiles.add(new Photo(filename));
        }
        
        user.setPhotos(uploadFiles);
        userService.add(account, user);
        
        return "redirect:../main/main";
    }
    
    @RequestMapping("update")
    public String update(Account account, User user, MultipartFile[] photo) throws Exception  {
        // 업로드 파일을 정장할 위치를 가져온다.
        String uploadDir = servletContext.getRealPath("/download");

        // 업로드 파일 정보를 저장할 List 객체 준비
        
        ArrayList<Photo> uploadFiles = new ArrayList<>();
        for (MultipartFile part: photo) {
            if (part.isEmpty())
                continue;
            
            // part파일은 uploadDir경로에 저장해라.
            String filename = this.writeUploadFile(part, uploadDir);
            
            uploadFiles.add(new Photo(filename));
        }
        // Board 객체에 저장한 파일명을 등록한다. 
        user.setPhotos(uploadFiles);
        
        userService.update(account, user);
        
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception  {

        userService.delete(no);

        return "redirect:list";
    }
    

    
    
    
    
    long prevMillis = 0;
    int count = 0;
    
    synchronized private String getNewFilename(String filename) {
        long currMillis = System.currentTimeMillis();
        if (prevMillis != currMillis) {
            count = 0;
            prevMillis = currMillis;
        }
        return currMillis + "_" + count++ + extractFileExtName(filename); 
    }

    private String extractFileExtName(String filename) {
        int dotPosition = filename.lastIndexOf(".");
        if (dotPosition == -1)
            return "";
        return filename.substring(dotPosition);
    }

    private String writeUploadFile(MultipartFile part, String path) throws IOException{

        String filename = getNewFilename(part.getOriginalFilename());
        part.transferTo(new File(path + "/" + filename));

        return filename;
    }
    
   


    
}








