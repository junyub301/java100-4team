package java100.app.web;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Thumbnail {
    public static void main(String args[]){
        try {
            int thumbnail_width = 100;
            int thumbnail_height = 100;
            File origin_file_name = new File("C:\\Users\\bit-user\\git\\java100-4team\\web\\src\\main\\webapp\\img\\portfolio"+File.separator+"rg.jpg");
            File thumb_file_name = new File("C:\\Users\\bit-user\\git\\java100-4team\\web\\src\\main\\webapp\\img\\portfolio"+File.separator+"thumbnail_image.jpg");
 
            BufferedImage buffer_original_image = ImageIO.read(origin_file_name);
            BufferedImage buffer_thumbnail_image = new BufferedImage(thumbnail_width, thumbnail_height, BufferedImage.TYPE_3BYTE_BGR);
            Graphics2D graphic = buffer_thumbnail_image.createGraphics();
            graphic.drawImage(buffer_original_image, 0, 0, thumbnail_width, thumbnail_height, null);
            ImageIO.write(buffer_thumbnail_image, "jpg", thumb_file_name);
            System.out.println("썸네일 생성완료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


