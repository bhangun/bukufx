package bhangun.buku.fx.util;

import java.io.File;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
/**
 *
 * @web http://java-buddy.blogspot.com/
 * http://java-buddy.blogspot.com/2012/03/javafx-20-implement-source-and-target.html
 */
public class DragDropFile extends Application {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
     
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("java-buddy.blogspot.com");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 400);
         
        HBox hBox1 = new HBox();
        hBox1.setPrefWidth(400);
        hBox1.setPrefHeight(200);
        hBox1.setStyle("-fx-border-color: red;"
              + "-fx-border-width: 1;"
              + "-fx-border-style: solid;");
       
        HBox hBox2 = new HBox();
        hBox2.setPrefWidth(400);
        hBox2.setPrefHeight(200);
        hBox2.setStyle("-fx-border-color: blue;"
              + "-fx-border-width: 1;"
              + "-fx-border-style: solid;");
         
        insertImage(new Image(getClass().getResourceAsStream("/bhangun/book/resources/brainstorming.png")), hBox1);
        insertImage(new Image(getClass().getResourceAsStream("/bhangun/book/resources/check.png")), hBox2);
         
        setupGestureTarget(hBox1);
        setupGestureTarget(hBox2);
         
        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox1, hBox2);
        root.getChildren().addAll(vBox);
         
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.show();
    }
     
    void insertImage(Image i, HBox hb){
         
        ImageView iv = new ImageView();
        iv.setImage(i);
         
        setupGestureSource(iv);
        hb.getChildren().add(iv);
    }
     
 
    void setupGestureTarget(final HBox targetBox){
         
        targetBox.setOnDragOver(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
 
                Dragboard db = event.getDragboard();
                 
                if(db.hasImage()){
                    event.acceptTransferModes(TransferMode.COPY);
                }
                 
                event.consume();
            }
        });
 
        targetBox.setOnDragDropped(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
  
                Dragboard db = event.getDragboard();
 
                if(db.hasImage()){
 
                    insertImage(db.getImage(), targetBox);
                     
                    event.setDropCompleted(true);
                }else{
                    event.setDropCompleted(false);
                }
 
                event.consume();
            }
        });
         
    }
     
    void setupGestureSource(final ImageView source){
         
        source.setOnDragDetected(new EventHandler <MouseEvent>() {
           @Override
           public void handle(MouseEvent event) {
                
               /* allow any transfer mode */
               Dragboard db = source.startDragAndDrop(TransferMode.COPY);
                
               /* put a image on dragboard */
               ClipboardContent content = new ClipboardContent();
                
               Image sourceImage = source.getImage();
               content.putImage(sourceImage);
               db.setContent(content);
                
               event.consume();
           }
       });
 
    }
}
