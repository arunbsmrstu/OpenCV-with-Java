/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencv;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Arun
 */
public class LoadingImage_JSE_library {

    public static void main(String[] args) throws IOException {
        //Input File 
        File input = new File("image/image.jpg");

        //Reading the image 
        BufferedImage image = ImageIO.read(input);

        //Saving the image with a different name
        File ouptut = new File("result/sample.jpg");
        ImageIO.write(image, "jpg", ouptut);

        System.out.println("image Saved");
    }
}
