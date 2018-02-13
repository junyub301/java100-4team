package java100.app.web.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Account;
import java100.app.domain.Item;
import java100.app.domain.Photo;
import java100.app.service.ItemService;
import java100.app.service.UserService;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired ServletContext servletContext;
    @Autowired ItemService itemService;
    @Autowired UserService userService;
    
    @RequestMapping("add")
    public Object add(Item item,MultipartFile[] photo, HttpSession session) throws Exception {
        Account account = (Account) session.getAttribute("loginUser"); //로그인정보 받아오기
        String uploadDir = servletContext.getRealPath("/download");
        item.setUserNo(account.getAccountsNo()); //user번호 저장하기
        ArrayList<Photo> uploadFiles = new ArrayList<>();
        for (MultipartFile part: photo) {
            if (part.isEmpty())
                continue;

            // part파일은 uploadDir경로에 저장해라.
            String filename = this.writeUploadFile(part, uploadDir);
            //썸네일 생성 메소드 호출 = 이름리턴     ** Thumbnail(저장경로,원본파일이름,썸네일너비,썸네일높이)
            String Thumbnail = this.Thumbnail(uploadDir,filename,50,50);
            uploadFiles.add(new Photo(filename,Thumbnail));
        }
        
        itemService.add(item, uploadFiles);
        return "아이템 등록 성공!";
}
    
    @RequestMapping("list")
    public Object list(
            @RequestParam(value="ut", defaultValue="0") int userType,
            @RequestParam(value="cr", defaultValue="0") int categoryNo,
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="6") int pageSize,
            @RequestParam(value="words", required=false) String word,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String alignColumn) throws Exception {
        
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageSize < 6 || pageSize > 15) {
            pageSize = 6;
        }
        HashMap<String,Object> options = new HashMap<>();
        options.put("orderColumn", orderColumn);
        options.put("alignColumn", alignColumn);
        String[] words = null;
        if (word != null) {
        words = word.split(" ");
        }
        options.put("words", words);
        int totalCount = itemService.getTotalCount(userType, words, categoryNo);
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        if (totalCount == 0) {
            lastPageNo = 1;
        }
        HashMap<String,Object> result = new HashMap<>();
        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        result.put("list", itemService.list(pageNo, pageSize, options, userType, categoryNo));
        
        return result;
    }
    
    
    @RequestMapping("{no}")
    public Object view(@PathVariable int no) throws Exception {
        HashMap<String,Object> result = new HashMap<>();
        Item item = itemService.getItem(no);
        result.put("item", item);
        result.put("user", userService.getUser(item.getUserNo()));
        result.put("account", userService.getAccount(item.getUserNo()));
        return result;
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








