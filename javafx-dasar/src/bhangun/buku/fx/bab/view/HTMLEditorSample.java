package bhangun.buku.fx.bab.view;

import bhangun.buku.BaseComponent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.HTMLEditor;



/**
 * 
 * @author bhangun
 * @since 2012
 * {@link http://bhangun.in}
 *
 */
public class HTMLEditorSample extends BaseComponent{
	
		
	private Image IMAGE =new Image(getClass().getResourceAsStream("/bhangun/book/resources/icon_all_01.png"));
	
	public void buildButton1(){
        final HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.setPrefHeight(245);
        Scene scene = new Scene(htmlEditor);       


	}
	
	public Button buildButton2(){
		Button btn = new Button();
		btn.setText("Tombol 2");
		return btn;
	}
	
	public Button buildButton3(){
		Button btn = new Button("Tombol 3");
		return btn;
	}
	
	public Button buildButton4(){
		ImageView  img = new ImageView ();
		img.setImage(new Image(getClass().getResourceAsStream("/bhangun/book/resources/check.png")));
		Button btn = new Button();
				btn.setGraphic(img);
				btn.setText("Tombol 4");

		return btn;
	}
	
	public Button buildButton5(){
		ImageView  img = new ImageView ();
				img.setImage(IMAGE);
				img.setViewport(new Rectangle2D(0,0,50,50));

				Button btn = new Button();
				btn.setGraphic(img);
				btn.setText("Tombol 5");
		return btn;
	}
	
	public Button buildButton6(){
		ImageView  img = new ImageView ();
		img.setImage(IMAGE);
		img.setViewport(new Rectangle2D(62,62,54,58));

		Button btn = new Button();
		btn.setGraphic(img);
		btn.setText("Tombol 6");
		return btn;
	}
	
	boolean open=true;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Button buildButton7(){
		final ImageView  img = new ImageView ();
		img.setImage(IMAGE);
		img.setViewport(new Rectangle2D(147,210,35,50));
		
		Button btn = new Button();
		btn.setGraphic(img);
		btn.setText("Tombol 7");
		
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

	@Override
	public ScrollPane getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
