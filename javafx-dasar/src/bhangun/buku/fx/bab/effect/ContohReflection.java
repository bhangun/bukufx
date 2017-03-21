package bhangun.buku.fx.bab.effect;

import bhangun.buku.BaseComponent;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPaneBuilder;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPaneBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



/**
 * 
 * @author bhangun
 * @since 2012
 * {@link http://bhangun.in}
 *
 */
public class ContohReflection extends Application{
	
	private final String CSS = getClass().getResource("/bhangun/book/bab/control/Control.css").toExternalForm();
		
	@Override 
	public void start(Stage stage) {
               
        stage.setTitle("Contoh Reflection");
        Scene scene = new Scene(getAll(),400,400);
        scene.getStylesheets().add(CSS);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args){
        launch(args);
    }
    
	
	public StackPane getReflection1(){
		
		Reflection rc = new Reflection();
		
		Rectangle r = new Rectangle();
		r.setX(10.0f);
		r.setY(10.0f);
		r.setWidth(280.0f);
		r.setHeight(80.0f);
		r.setFill(Color.BLANCHEDALMOND);
		r.setEffect(rc);
		r.setCache(true);
		 
		Text t = new Text();
		t.setX(20.0f);
		t.setY(65.0f);
		t.setText("Reflection");
		t.setFill(Color.HOTPINK);
		t.setFont(Font.font(null, FontWeight.BOLD, 36));
		t.setEffect(rc);
		
		return StackPaneBuilder.create().children(r,t).build();
	}
	
	public StackPane getReflection2(){
		
		Reflection rc = new Reflection();
		rc.setBottomOpacity(2);
		rc.setFraction(3);
		rc.setTopOffset(56);
		rc.setTopOpacity(60);

		Rectangle r = new Rectangle();
		r.setX(10.0f);
		r.setY(10.0f);
		r.setWidth(280.0f);
		r.setHeight(80.0f);
		r.setFill(Color.MOCCASIN);
		r.setEffect(rc);
		r.setCache(true);
		 
		Text t = new Text();
		t.setX(20.0f);
		t.setY(65.0f);
		t.setText("Reflection");
		t.setFill(Color.FORESTGREEN);
		t.setFont(Font.font(null, FontWeight.BOLD, 36));
		t.setEffect(rc);
		
		return StackPaneBuilder.create().children(r,t).build();
	}
	
	public StackPane getReflection3(){
		
	DropShadow ds = new DropShadow();
	
	
	Reflection rc = new Reflection();
	rc.setInput(ds);
		
		Rectangle r = new Rectangle();
		r.setX(10.0f);
		r.setY(10.0f);
		r.setWidth(280.0f);
		r.setHeight(80.0f);
		r.setFill(Color.AZURE);
		//r.setEffect(rc);
		//r.setCache(true);
		 
		Text t = new Text();
		t.setX(20.0f);
		t.setY(65.0f);
		t.setText("Reflection");
		t.setFill(Color.YELLOW);
		t.setFont(Font.font(null, FontWeight.BOLD, 36));
		t.setEffect(rc);
		
		return StackPaneBuilder.create().children(r,t).build();
	}
	
	public ScrollPane getAll() {
		VBox vb=VBoxBuilder.create().children(
				getReflection1(),
				getReflection2(),
				getReflection3())
				.build();
		return ScrollPaneBuilder.create().content(vb).build();
	}

}
