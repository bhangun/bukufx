package bhangun.buku.fx.util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.stage.Stage;
 
public class WriteImageIO extends Application {
 
    public static void main(String[] args) {
        launch(args);
    }
 
    public static Image createImage(java.awt.Image image) throws IOException {
        if (!(image instanceof RenderedImage)) {
          BufferedImage bufferedImage = new BufferedImage(image.getWidth(null),
                  image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
          Graphics g = bufferedImage.createGraphics();
          g.drawImage(image, 0, 0, null);
          g.dispose();
     
          image = bufferedImage;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write((RenderedImage) image, "png", out);
        out.flush();
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        return new Image(in);
      }
    
    @Override
    public void start(Stage primaryStage) {
       
        
        Circle circle = CircleBuilder.create()
                .radius(75)
                .fill(Color.RED)
                .build();
        
        WritableImage wimg = new WritableImage(200, 200) ;
        
        circle.snapshot(null, wimg);
        
        ImageView view = ImageViewBuilder.create()
                .image(wimg)
                .translateX(400)
                .translateY(200)
                .build();
              
                
        Group root = new Group();
        
        root.getChildren().addAll(circle, view);
 
        Scene scene = new Scene(root, 600, 400);
 
        primaryStage.setTitle("Hello Snapshot!!!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
