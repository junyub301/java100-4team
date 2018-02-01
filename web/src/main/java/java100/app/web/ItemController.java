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
//github.com/junyub301/java100-4team.git
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.Item;
import java100.app.domain.Photo;
import java100.app.service.ItemService;
import java100.app.service.UserService;

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
            
            uploadFiles.add(new Photo(filename));
        }
        itemService.add(item,uploadFiles);
        
        return "redirect:../main/main";
    }
    @RequestMapping("lendlist")
    public String lendlist(@RequestParam(value="ps", defaultValue="5") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {
        if (pageNo < 1) {
            pageNo = 1;
        }
        
        if (pageSize < 5 || pageSize > 15) {
            pageSize = 5;
        } 
        
        HashMap<String,Object> options = new HashMap<>();
        if (words != null && words[0].length() > 0) {
            options.put("words", words);
        }
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        
        int totalCount = itemService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        // view 컴포넌트가 사용할 값을 Model에 담는다.
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", itemService.list(pageNo, pageSize, options));
        return "item/lendlist";
    }
    @RequestMapping("rentlist")
    public String rentlist(@RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {
        if (pageNo < 1) {
            pageNo = 1;
        }
        
        if (pageSize < 5 || pageSize > 15) {
            pageSize = 5;
        } 
        
        HashMap<String,Object> options = new HashMap<>();
        if (words != null && words[0].length() > 0) {
            options.put("words", words);
        }
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        
        int totalCount = itemService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        // view 컴포넌트가 사용할 값을 Model에 담는다.
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", itemService.list(pageNo, pageSize, options));
        
        
        return "item/rentlist";
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

   /* private String Thumbnail(File filename, String uploadDir) {
        try {
            int thumbnail_width = 100;
            int thumbnail_height = 100;
            
             * File origin_file_name = new File(원본경로 + File.separator+"main_img.jpg"); File
             * thumb_file_name = new File(썸네일경로 + File.separator+"thumbnail_image.jpg");
             

            BufferedImage buffer_original_image = ImageIO.read(filename);
            BufferedImage buffer_thumbnail_image = new BufferedImage(thumbnail_width, thumbnail_height,
                    BufferedImage.TYPE_3BYTE_BGR);
            Graphics2D graphic = buffer_thumbnail_image.createGraphics();
            graphic.drawImage(buffer_original_image, 0, 0, thumbnail_width, thumbnail_height, null);
            ImageIO.write(buffer_thumbnail_image, "jpg", thumb_file_name);
            System.out.println("썸네일 생성완료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    
}








