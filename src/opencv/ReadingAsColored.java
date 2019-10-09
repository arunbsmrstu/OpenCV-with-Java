/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencv;

import java.awt.image.BufferedImage;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author Arun
 */
public class ReadingAsColored extends Application {
   @Override 
   public void start(Stage stage) throws Exception {
      WritableImage writableImage = loadAndConvert();
       
      // Setting the image view
      ImageView imageView = new ImageView(writableImage);

      // Setting the position of the image
      imageView.setX(10);
      imageView.setY(10);

      // setting the fit height and width of the image view
      imageView.setFitHeight(400);
      imageView.setFitWidth(600);
      
      // Setting the preserve ratio of the image view
      imageView.setPreserveRatio(true);
      
      // Creating a Group object
      Group root = new Group(imageView);

      // Creating a scene object
      Scene scene = new Scene(root, 600, 400);
     
      // Setting title to the Stage
      stage.setTitle("Reading as colored image");

      // Adding scene to the stage
      stage.setScene(scene);
      
      // Displaying the contents of the stage
      stage.show();
   } 
   public WritableImage loadAndConvert() throws Exception {     
      // Loading the OpenCV core library
      System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
       
      String input = "result/sample.jpg";
       
      Mat dst = new Mat();

      // Reading the image
      Mat src = Imgcodecs.imread(input, Imgcodecs.IMREAD_COLOR);

      byte[] data1 = new byte[src.rows() * src.cols() * (int)(src.elemSize())]; 
      src.get(0, 0, data1);
      
      // Creating the buffered image
      BufferedImage bufImage = new BufferedImage(src.cols(),src.rows(), 
         BufferedImage.TYPE_3BYTE_BGR);

      // Setting the data elements to the image 
      bufImage.getRaster().setDataElements(0, 0, src.cols(), src.rows(), data1);

      // Creating a WritableImage
      WritableImage writableImage = SwingFXUtils.toFXImage(bufImage, null);

      System.out.println("Image read");
      return writableImage;
   } 
   public static void main(String args[]) throws Exception {
      launch(args);
   } 

  
}
