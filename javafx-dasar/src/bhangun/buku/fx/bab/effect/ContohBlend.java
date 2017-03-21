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
public class ContohBlend extends Application{
	
	private final String CSS = getClass().getResource("/bhangun/book/bab/control/Control.css").toExternalForm();
		
	@Override 
	public void start(Stage stage) {
               
        stage.setTitle("Contoh Blend ");
        Scene scene = new Scene(getAll(),400,400);
        scene.getStylesheets().add(CSS);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args){
        launch(args);
    }
    
	
	public StackPane getPerspective1(){
		
		Blend b = new Blend();
		b.setMode(BlendMode.MULTIPLY);
		 
		Rectangle r = new Rectangle();
		r.setX(10.0f);
		r.setY(10.0f);
		r.setWidth(280.0f);
		r.setHeight(80.0f);
		r.setFill(Color.AZURE);
		r.setEffect(b);
		r.setCache(true);
		 
		Text t = new Text();
		t.setX(20.0f);
		t.setY(65.0f);
		t.setText("Perspective");
		t.setFill(Color.AQUA);
		t.setFont(Font.font(null, FontWeight.BOLD, 36));
		//t.setEffect(pt);
		
		
		return StackPaneBuilder.create().children(r,t).build();

	}
	
	public void getEfek(){
		
		new GaussianBlur();
		
		
		DropShadow ds0 = new DropShadow();
		ds0.setOffsetY(3.0f);
		ds0.setColor(Color.color(0.4f, 0.4f, 0.4f));

		
		InnerShadow is3 = new InnerShadow();
		is3.setOffsetX(4.0f);
		is3.setOffsetY(4.0f);

		
		Reflection r = new Reflection();
		r.setFraction(0.7f);

		
		/////////////
		Blend blend = new Blend();
		blend.setMode(BlendMode.MULTIPLY);

		DropShadow ds = new DropShadow();
		ds.setColor(Color.rgb(254, 235, 66, 0.3));
		ds.setOffsetX(5);
		ds.setOffsetY(5);
		ds.setRadius(5);
		ds.setSpread(0.2);

		blend.setBottomInput(ds);

		DropShadow ds1 = new DropShadow();
		ds1.setColor(Color.web("#f13a00"));
		ds1.setRadius(20);
		ds1.setSpread(0.2);

		Blend blend2 = new Blend();
		blend2.setMode(BlendMode.MULTIPLY);

		InnerShadow is = new InnerShadow();
		is.setColor(Color.web("#feeb42"));
		is.setRadius(9);
		is.setChoke(0.8);
		blend2.setBottomInput(is);

		InnerShadow is1 = new InnerShadow();
		is.setColor(Color.web("#f13a00"));
		is.setRadius(5);
		is.setChoke(0.4);
		blend2.setTopInput(is1);

		Blend blend1 = new Blend();
		blend1.setMode(BlendMode.MULTIPLY);
		blend1.setBottomInput(ds1);
		blend1.setTopInput(blend2);

		blend.setTopInput(blend1);
		
		Text text = new Text();
		text.setEffect(blend);
		/////------------
	
	}

	
	public ScrollPane getAll() {
		VBox vb=VBoxBuilder.create().children(getPerspective1()).build();
		return ScrollPaneBuilder.create().content(vb).build();
	}

}
