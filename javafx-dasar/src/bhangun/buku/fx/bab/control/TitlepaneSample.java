package bhangun.buku.fx.bab.control;


import bhangun.buku.BaseComponent;
import javafx.scene.control.Button;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;




/**
 * 
 * @author bhangun
 * @since 2012
 * {@link http://bhangun.in}
 *
 */
public class TitlepaneSample extends BaseComponent{
	
	
	private Image IMAGE =new Image(getClass().getResourceAsStream("/bhangun/book/resources/icon_all_01.png"));
	
	public TitledPane pane1(){
		//using a two-parameter constructor
		TitledPane tp1 = new TitledPane("My Titled Pane", new Button("Button"));
		//applying methods
		TitledPane tp = new TitledPane();
		tp.setText("My Titled Pane");
		tp.setContent(new Button("Button"));
		return tp1;
	}
	
	

	@Override
	public ScrollPane getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
