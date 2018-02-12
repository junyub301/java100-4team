package java100.app.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Item;
import java100.app.domain.Photo;
import java100.app.service.ItemService;
import java100.app.service.UserService;
import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping("/item")
public class ItemController {
    
    @Autowired ServletContext servletContext;
    @Autowired ItemService itemService;
    @Autowired UserService userService;
    
    @RequestMapping("rent")
    public String form() throws Exception {
        return "item/rent"; 
    }
    
    @RequestMapping("lend")
    public String form2() throws Exception {
        return "item/lend";
    }
    
    @RequestMapping("add")
    public String add(Item item, MultipartFile[] photo) throws Exception {
        String uploadDir = servletContext.getRealPath("/download");
        ArrayList<Photo> uploadFiles = new ArrayList<>();
        for (MultipartFile part: photo) {
            if (part.isEmpty())
                continue;
            
            String filename = this.writeUploadFile(part, uploadDir);
            
            //썸네일 생성 메소드 호출 = 이름리턴     ** Thumbnail(저장경로,원본파일이름,썸네일너비,썸네일높이)
            
            String Thumbnail = this.Thumbnail(uploadDir,filename,50,50);
            
            //포토도메인 수정해서 썸네일도 추가해야함...DB도 추가해야함
            uploadFiles.add(new Photo(filename));
        }
        itemService.add(item,uploadFiles);
        
        return "redirect:../item/list";
    }
    @RequestMapping("list")
    public String rentlist(
            @RequestParam(value="cr", defaultValue="0") int categoryNo,
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="6") int pageSize,
            @RequestParam(value="words", required=false) String word,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {
        
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageSize < 6 || pageSize > 15) {
            pageSize = 6;
        } 
        
        int userType = 0;
        HashMap<String,Object> options = new HashMap<>();
        String[] words = word.split(" ");
        options.put("words", words);
        
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        
        int totalCount = itemService.getTotalCount(userType, words);
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        // view 컴포넌트가 사용할 값을 Model에 담는다.
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", itemService.list(pageNo, pageSize, options, userType, categoryNo));
        
        return "item/list";
        
    }
    
    @RequestMapping("lendlist")
    public String lendlist(
            @RequestParam(value="cr", defaultValue="0") int categoryNo,
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="6") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {
        
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageSize < 6 || pageSize > 15) {
            pageSize = 6;
        } 
        
        int userType = 1;
        HashMap<String,Object> options = new HashMap<>();
        if (words != null && words[0].length() > 0) {
            options.put("words", words);
        }
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        
        int totalCount = itemService.getTotalCount(userType,words);
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        // view 컴포넌트가 사용할 값을 Model에 담는다.
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", itemService.list(pageNo, pageSize, options, userType, categoryNo));
        
        return "item/lendlist";
        
    }
    
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {


        model.addAttribute("item", itemService.getItem(no));
        model.addAttribute("user", userService.getUser(no));
        return "item/view";
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








