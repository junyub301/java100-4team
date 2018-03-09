package java100.app.web.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Item;
import java100.app.domain.Maps;
import java100.app.domain.Photo;
import java100.app.domain.User;
import java100.app.service.ItemService;
import java100.app.service.MapsService;
import java100.app.service.UserService;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired ServletContext servletContext;
    @Autowired ItemService itemService;
    @Autowired UserService userService;
    @Autowired MapsService mapsService;
    
    static Logger logger = Logger.getLogger(ItemController.class);
    
    @RequestMapping("add")
    public Object add(Item item,MultipartFile[] photo, HttpSession session, Maps maps) throws Exception {
        User user = (User) session.getAttribute("loginUser"); //로그인정보 받아오기
        String uploadDir = servletContext.getRealPath("/download");
        item.setUserNo(user.getUserNo()); //user번호 저장하기
        ArrayList<Photo> uploadFiles = new ArrayList<>();
        for (MultipartFile part: photo) {
            if (part.isEmpty())
                continue;

            // part파일은 uploadDir경로에 저장해라.
            String filename = this.writeUploadFile(part, uploadDir);
            //썸네일 생성 메소드 호출 = 이름리턴     ** Thumbnail(저장경로,원본파일이름,썸네일너비,썸네일높이)
            String Thumbnail = this.Thumbnail(uploadDir,filename,250,220, "ipre");
            uploadFiles.add(new Photo(filename,Thumbnail));
        }
        
        itemService.add(item, uploadFiles,maps);
        return "아이템 등록 성공!";
}
    
    @RequestMapping("list")
    public Object list(
            @RequestParam(value="cr", defaultValue="0") int categoryNo,
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="8") int pageSize,
            @RequestParam(value="distance", defaultValue="0") int distance,
            @RequestParam(value="price1", defaultValue="0") int priceStart,
            @RequestParam(value="price2", defaultValue="0") int priceEnd,
            @RequestParam(value="dealEnd", defaultValue="6") int dealPossible,
            @RequestParam(value="words", required=false) String words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String alignColumn,
            HttpSession session) throws Exception {
        User user = (User)session.getAttribute("loginUser");
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageSize < 8 || pageSize > 15) {
            pageSize = 8;
        }
        HashMap<String,Object> options = new HashMap<>();
        options.put("order", orderColumn);
        options.put("align", alignColumn);
        options.put("categoryNo", categoryNo);
        options.put("words", words);
        options.put("priceStart", priceStart);
        options.put("priceEnd", priceEnd);
        options.put("dealPossible", dealPossible);
        options.put("distance", distance);
        logger.debug("words ------------"+words);
        logger.debug("categoryNo ------------"+categoryNo);
        logger.debug("distance ------------"+distance);
        logger.debug("priceStart ------------"+priceStart);
        logger.debug("priceEnd ------------"+priceEnd);
        logger.debug("dealPossible ------------"+dealPossible);
        logger.debug("orderColumn ------------"+orderColumn);
        logger.debug("alignColumn ------------"+alignColumn);
        if (user != null) {
        options.put("user",user.getUserNo());
        }
        int totalCount = itemService.getTotalCount(words, categoryNo, priceStart, priceEnd, dealPossible);
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
        result.put("list", itemService.list(pageNo, pageSize, options));
        
        return result;
    }
    
    
    @RequestMapping("{no}")
    public Object view(@PathVariable int no) throws Exception {
        HashMap<String,Object> result = new HashMap<>();
        Item item = itemService.getItem(no);
        result.put("item", item);
        result.put("user", userService.getUser(item.getUserNo()));
        result.put("maps", mapsService.getItem(item.getItemNo()));
        return result;
    }
    
    @RequestMapping("update")
    public Object update(int itemNo,int status) throws Exception {
        Item item = new Item();
        item.setItemNo(itemNo);
        item.setStatus(status);
        itemService.changeStatus(item);
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
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
    private String Thumbnail(String uploadDir, String filename, int width, int height,String ipre) {
        File image = new File(uploadDir+"//"+filename); 
        File thumbnail = new File(uploadDir+"//"+ipre+"_"+filename); 
        if (image.exists()) { 
            try {
                int pos = filename.lastIndexOf(".");
                String format = filename.substring(pos + 1);
                Thumbnails.of(image).size(width, height).outputFormat(format).toFile(thumbnail);
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
        return ipre+"_"+filename;
    }
}








