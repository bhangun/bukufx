package bhangun.buku.fx.bab.control;

import bhangun.buku.BaseComponent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxBuilder;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;



/**
 * 
 * @author bhangun
 * @since 2012
 * {@link http://bhangun.in}
 *
 */
public class CheckboxSample extends BaseComponent{
	
	private ImageView IMAGE =new ImageView(new Image(getClass().getResourceAsStream("/bhangun/book/resources/brainstorming.png")));
	
	public VBox contohCheckbox1(){
		CheckBox cb1 = new CheckBox("Pilihan 1");
		
		CheckBox cb2 = CheckBoxBuilder.create()
				.text("Pilihan 2")
				.build();
		
		return VBoxBuilder.create().children(cb1,cb2).build();
	}
	
	public CheckBox buildButton1(){
		CheckBox cb = CheckBoxBuilder.create()
				.text("Pilihan 1")
				.graphic(IMAGE)
				.build();
		return cb;
	}

	@Override
	public ScrollPane getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
