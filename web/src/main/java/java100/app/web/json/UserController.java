package java100.app.web.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Account;
import java100.app.domain.Photo;
import java100.app.domain.User;
import java100.app.service.UserService;
import net.coobird.thumbnailator.Thumbnails;

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
    public Object view(@PathVariable int no) throws Exception {

        HashMap<String,Object> result = new HashMap<>();

        result.put("account", userService.getAccount(no));
        result.put("user", userService.getUser(no));

        return result;
    }
    
    @RequestMapping("add")
    public Object add(Account account, User user, MultipartFile[] photo) throws Exception {
        String uploadDir = servletContext.getRealPath("/download");
        ArrayList<Photo> uploadFiles = new ArrayList<>();
        for (MultipartFile part: photo) {
            if (part.isEmpty())
                continue;
            
            // part파일은 uploadDir경로에 저장해라.
            String filename = this.writeUploadFile(part, uploadDir);
            
            String Thumbnail = this.Thumbnail(uploadDir,filename,50,50) ;

            uploadFiles.add(new Photo(filename,Thumbnail));
        }
        
        user.setPhotos(uploadFiles);
        userService.add(account, user); 
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status",  "success");
        return result;
    }
        
    @RequestMapping("update")
    public Object update(Account account, User user, MultipartFile[] photo) throws Exception  {
        // 업로드 파일을 정장할 위치를 가져온다.
        String uploadDir = servletContext.getRealPath("/download");

        // 업로드 파일 정보를 저장할 List 객체 준비
        
        ArrayList<Photo> uploadFiles = new ArrayList<>();
        for (MultipartFile part: photo) {
            if (part.isEmpty())
                continue;
            
            // part파일은 uploadDir경로에 저장해라.
            String filename = this.writeUploadFile(part, uploadDir);
            
            String Thumbnail = this.Thumbnail(uploadDir,filename,150,150);

            uploadFiles.add(new Photo(filename,Thumbnail));
        }
        // Board 객체에 저장한 파일명을 등록한다. 
        user.setPhotos(uploadFiles);
        
        userService.update(account, user);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", uploadFiles);
        return result;
    }

    @RequestMapping("delete")
    public Object delete(int no) throws Exception  {
        
        userService.delete(no);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }
    


    @ResponseBody
    @RequestMapping(value = "/checkSignup", method = RequestMethod.POST)
    public String checkSignup(HttpServletRequest request, Model model) {
        String id = request.getParameter("accountName");
        int rowcount = userService.checkSignup(id);
        
        return String.valueOf(rowcount);
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
    
  //썸네일 저장 코드(s_원본파일로 저장)
    private String Thumbnail(String uploadDir, String filename, int width, int height) {
        File image = new File(uploadDir+"//"+filename); 
        File thumbnail = new File(uploadDir+"//s_"+filename); 
        if (image.exists()) { 
            try {
                int pos = filename.lastIndexOf(".");
                String format = filename.substring(pos + 1);
                Thumbnails.of(image).size(width, height).outputFormat(format).toFile(thumbnail);
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
        return "s_"+filename;
    }
   


    
}








