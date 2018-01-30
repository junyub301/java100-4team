package java100.app.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
//github.com/junyub301/java100-4team.git
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("list")
    public String list(Model model) throws Exception {
        model.addAttribute("list", itemService.list());
        return "item/list";
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
    
}








