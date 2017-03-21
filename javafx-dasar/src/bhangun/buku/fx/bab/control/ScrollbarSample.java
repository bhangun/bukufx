package bhangun.buku.fx.bab.control;

import bhangun.buku.BaseComponent;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 * 
 * @author bhangun
 * @since 2012
 * {@link http://bhangun.in}
 *
 */
public class ScrollbarSample extends Application{
		
	
	@Override 
	public void start(Stage stage) {
        
 
        
        stage.setTitle("ProgressBar");
       // Scene scene = new Scene(getAll(),400,400);
        Scene scene = new Scene(getScrolbar(),400,400);
        scene.getStylesheets().add(getClass().getResource("/bhangun/book/bab/control/Control.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args){
        launch(args);
    }
	public StackPane getScrolbar(){
		ScrollBar sc = new ScrollBar();
		sc.setId("scroll");
		sc.setMinHeight(50);
		sc.setMin(0);
		sc.setMax(100);
		sc.setValue(50);
		
		Button b=new Button("bt");
		b.setId("btn");
		StackPane p =new StackPane();
		p.setId("panel");
		
		p.getChildren().addAll(sc,b );
		return p;
	}
	
	

	public ScrollPane getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
