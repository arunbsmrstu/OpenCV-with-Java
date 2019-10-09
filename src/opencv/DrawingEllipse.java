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

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Point;
import org.opencv.core.RotatedRect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Arun
 */
public class DrawingEllipse extends Application {
    Mat matrix = null;

   @Override
   public void start(Stage stage) throws Exception {
      // Capturing the snapshot from the camera
      DrawingEllipse obj = new DrawingEllipse();
      WritableImage writableImage = obj.LoadImage();

      // Setting the image view
      ImageView imageView = new ImageView(writableImage);

      // setting the fit height and width of the image view
      imageView.setFitHeight(600);
      imageView.setFitWidth(600);

      // Setting the preserve ratio of the image view
      imageView.setPreserveRatio(true);

      // Creating a Group object
      Group root = new Group(imageView);

      // Creating a scene object
      Scene scene = new Scene(root, 600, 400);

      // Setting title to the Stage
      stage.setTitle("Drawing Ellipse on the image");

      // Adding scene to the stage
      stage.setScene(scene);

      // Displaying the contents of the stage
      stage.show();
   }
   public WritableImage LoadImage() throws Exception {
      // Loading the OpenCV core library
      System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

      // Reading the Image from the file and storing it in to a Matrix object
      String file ="result/sample.jpg";
      Mat matrix = Imgcodecs.imread(file);

      // Drawing an Ellipse
      Imgproc.ellipse (
         matrix,                          //Matrix obj of the image
         new RotatedRect (                // RotatedRect(Point c, Size s, double a)
            new Point(200, 150),
            new Size(260, 180), 180 
         ),
         new Scalar(0, 0, 255),           //Scalar object for color
         10                               //Thickness of the line
      );
      
      // Encoding the image
      MatOfByte matOfByte = new MatOfByte();
      Imgcodecs.imencode(".jpg", matrix, matOfByte);

      // Storing the encoded Mat in a byte array
      byte[] byteArray = matOfByte.toArray();

      // Displaying the image
      InputStream in = new ByteArrayInputStream(byteArray);
      BufferedImage bufImage = ImageIO.read(in);

      this.matrix = matrix;
      
      // Creating the Writable Image
      WritableImage writableImage = SwingFXUtils.toFXImage(bufImage, null);

      return writableImage;
   }
   public static void main(String args[]) {
      launch(args);
   }
    
}
