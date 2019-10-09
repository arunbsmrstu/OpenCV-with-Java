/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author Arun
 */
public class WritingImages {
     public static void main(String args[]) { 
      //Loading the OpenCV core library  
      System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
      
      //Instantiating the imagecodecs class 
      Imgcodecs imageCodecs = new Imgcodecs(); 

      //Reading the Image from the file and storing it in to a Matrix object 
      String file ="result/sample.jpg";   
      Mat matrix = imageCodecs.imread(file); 

      System.out.println("Image Loaded ..........");
      String file2 = "result/sample_resaved.jpg"; 

      //Writing the image 
      imageCodecs.imwrite(file2, matrix); 
      System.out.println("Image Saved ............"); 
   } 
    
}
