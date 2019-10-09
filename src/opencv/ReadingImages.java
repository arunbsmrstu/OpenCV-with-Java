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
public class ReadingImages {
    public static void main(String args[]) { 
      //Loading the OpenCV core library  
      System.loadLibrary( Core.NATIVE_LIBRARY_NAME ); 
     
      //Instantiating the Imagecodecs class 
      Imgcodecs imageCodecs = new Imgcodecs(); 
     
      //Reading the Image from the file  
      String file ="result/sample.jpg"; 
      Mat matrix = imageCodecs.imread(file); 
     
      System.out.println("Image Loaded");     
   } 
}
