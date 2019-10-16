
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arun
 */
public class DLLTest {
    public static void loadJarDll(String name) throws IOException {
    InputStream in = DLLTest.class.getResourceAsStream(name);
    byte[] buffer = new byte[1024];
    int read = -1;
    File temp = File.createTempFile(name, "");
    FileOutputStream fos = new FileOutputStream(temp);

    while((read = in.read(buffer)) != -1) {
        fos.write(buffer, 0, read);
    }
    fos.close();
    in.close();

        try {
            System.load(temp.getAbsolutePath());
        } catch (Exception e) {
            System.out.println(">>"+e);
        }
}
    
    public static void main(String argv[]) throws IOException 
  {
      loadJarDll("C:/Users/Arun/Documents/NetBeansProjects/OpenCV-with-Java/opencv_java343.dll");
  }
}
