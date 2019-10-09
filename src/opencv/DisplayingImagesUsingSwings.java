/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencv;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author Arun
 */
public class DisplayingImagesUsingSwings {
    public static void main(String args[]) throws Exception { 
      //Loading the OpenCV core library  
      System.loadLibrary( Core.NATIVE_LIBRARY_NAME ); 
    
      //Reading the Image from the file and storing it in to a Matrix object 
      String file = "result/sample.jpg"; 
      Mat image = Imgcodecs.imread(file); 
    
      //Encoding the image 
      MatOfByte matOfByte = new MatOfByte();       
      Imgcodecs.imencode(".jpg", image, matOfByte); 

      //Storing the encoded Mat in a byte array 
      byte[] byteArray = matOfByte.toArray(); 

      //Preparing the Buffered Image 
      InputStream in = new ByteArrayInputStream(byteArray); 
      BufferedImage bufImage = ImageIO.read(in); 

      //Instantiate JFrame 
      JFrame frame = new JFrame(); 

      //Set Content to the JFrame 
      frame.getContentPane().add(new JLabel(new ImageIcon(bufImage))); 
      frame.pack(); 
      frame.setVisible(true);
      
      System.out.println("Image Loaded");     
   } 
    
}
