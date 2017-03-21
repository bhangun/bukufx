package bhangun.buku.fx.bab.control;

import bhangun.buku.BaseComponent;
import javafx.beans.property.ObjectProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPaneBuilder;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;



/**
 * 
 * @author bhangun
 * @since 2012
 * {@link http://bhangun.in}
 *
 */
public class ButtonSample extends BaseComponent{
	
	private Image IMAGE =new Image(getClass().getResourceAsStream("/bhangun/book/resources/icon_all_01.png"));
	private String style=getClass().getResource("/bhangun/book/resources/Tombol.css").toExternalForm();
	
	public Button buildButton1(){
		Button btn = new Button("Tombol 1");
		return btn;
	}
	
	public Button buildButton2(){
		Button btn = new Button();
		btn.setText("Tombol 2");
		return btn;
	}
	
	public Button buildButton3(){
		Button btn = ButtonBuilder
				.create()
				.text("Tombol 3")
				.build();
		return btn;
	}
	
	public Button buildButton4(){
		ImageView  img = ImageViewBuilder.create()
				.image(
						new Image(getClass().getResourceAsStream("/bhangun/book/resources/check.png")))
				.build();
		Button btn = ButtonBuilder.create()
				.graphic(img)
				.text("Tombol 4")
				.build();
		return btn;
	}
	
	public Button buildButton5(){
		ImageView  img = ImageViewBuilder.create()
				.image(IMAGE)
				.viewport(
						new Rectangle2D(0,0,50,50))
				.build();
		Button btn = ButtonBuilder.create()
				.graphic(img)
				.text("Tombol 5")
				.build();
		return btn;
	}
	
	public Button buildButton6(){
		ImageView  img = ImageViewBuilder.create()
				.image(IMAGE)
				.viewport(
						new Rectangle2D(62,62,54,58))
				.build();
		Button btn = ButtonBuilder.create()
				.graphic(img)
				.text("Tombol 6")
				.build();
		return btn;
	}
	
	boolean open=true;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Button buildButton7(){
		final ImageView  img = ImageViewBuilder.create()
				.image(IMAGE)
				.viewport(new Rectangle2D(147,210,35,50))
				.build();
		
		final Button btn = ButtonBuilder.create()
				.graphic(img)
				.text("Tombol 7")
				.build();
		
		btn.setOnMouseClicked(new EventHandler(){
			@Override
			public void handle(Event event) {
				if(open){
					img.setViewport(new Rectangle2D(113,210,35,50));
					open=false;
			}else{
					img.setViewport(new Rectangle2D(147,210,35,50));
					open=true;
			}
			}});
		return btn;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Button buildButton8(){
		final ImageView  img = ImageViewBuilder.create()
				.image(IMAGE)
				.viewport(new Rectangle2D(147,210,35,50))
				.build();
		
		final Button btn = ButtonBuilder.create()
				.graphic(img)
				.id("shiny-orange")
				.stylesheets(style)
				.text("Tombol 8")
				.build();
		
		btn.setOnMouseClicked(new EventHandler(){
			@Override
			public void handle(Event event) {
				if(open){
					img.setViewport(new Rectangle2D(113,210,35,50));
					btn.setId("record-sales");
					open=false;
			}else{
					img.setViewport(new Rectangle2D(147,210,35,50));
					btn.setId("shiny-orange");
					open=true;
			}
			}});
		
			
		return btn;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Button buildButton9(){
		final ImageView  img = ImageViewBuilder.create()
				.image(IMAGE)
				.viewport(new Rectangle2D(147,210,35,50))
				.build();
		
		final Button btn = ButtonBuilder.create()
				.graphic(img)
				.id("shiny-orange")
				.stylesheets(style)
				.text("Tombol 8")
				.build();
		
		btn.setOnMouseClicked(new EventHandler(){
			@Override
			public void handle(Event event) {
				if(open){
					img.setViewport(new Rectangle2D(113,210,35,50));
					btn.setId("green");
					open=false;
			}else{
					img.setViewport(new Rectangle2D(147,210,35,50));
					btn.setId("shiny-orange");
					open=true;
			}
			}});
		
		
		return btn;
	}
	
	public ScrollPane getAll(){
   
    	VBox box= new VBox();
    			box.getChildren().addAll(buildButton1(),	
    					buildButton2(),
    					buildButton3(),
    					buildButton4(),
    					buildButton5(),
    					buildButton6(),
    					buildButton7(),
    					buildButton8());
    			box.setPadding(new Insets(10,10,10,10));
    			box.setSpacing(10);
    			
    	
    	return new ScrollPane(box);
    }


}
