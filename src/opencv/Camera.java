/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencv;

import com.github.sarxos.webcam.Webcam;
import org.opencv.core.Core;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author Arun
 */
public class Camera {
    
    public static void main(String arg[]){
        Webcam webcam = Webcam.getDefault();
        System.out.println(">>>>>>>"+webcam.getWebcamListenersCount());
        if (webcam != null) {
			System.out.println("Webcam: " + webcam.getName());
		} else {
			System.out.println("No webcam detected");
		}

    }
    
   
    
}
