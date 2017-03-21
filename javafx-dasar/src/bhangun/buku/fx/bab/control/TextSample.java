package bhangun.buku.fx.bab.control;

import bhangun.buku.BaseComponent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;



/**
 * 
 * @author bhangun
 * @since 2012
 * {@link http://bhangun.in}
 *
 */
public class TextSample extends BaseComponent{
		
	private Image IMAGE =new Image(getClass().getResourceAsStream("/bhangun/book/resources/icon_all_01.png"));
	
	public Text contohText1(){
		Text text = new Text();
		text.setText("Contoh Text 1");
		text.autosize();		
		return text;
	}
	
	public Text contohText2(){
		Text text = TextBuilder.create()
				.text("Contoh Text 2")
				.fill(Color.AQUAMARINE)
				.build();
		return text;
	}
	
	public Text contohText3(){
		Text text = TextBuilder.create()
				.text("Contoh Text 3")
				.build();
		return text;
	}
	
	public Text contohText4(){
		Text text = TextBuilder.create()
				.text("Contoh Text 4")
				.build();
		return text;
	}
	
	public Text contohText5(){
		Text text = TextBuilder.create()
				.text("Contoh Text 5")
				.build();
		return text;
	}
	
	public Text contohText6(){
		Text text = TextBuilder.create()
				.text("Contoh Text 6")
				.build();
		return text;
	}
	
	public Text contohText7(){
		Text text = TextBuilder.create()
				.text("Contoh Text")
				.build();
		return text;
	}
	
	public Text contohText8(){
		Text text = TextBuilder.create()
				.text("Contoh Text")
				.build();
		return text;
	}

	@Override
	public ScrollPane getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
