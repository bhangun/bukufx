package bhangun.buku.fx.bab.control;

import bhangun.buku.BaseComponent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;



/**
 * 
 * @author bhangun
 * @since 2012
 * {@link http://bhangun.in}
 *
 */
public class LabelSample extends BaseComponent{
	
	
	private Image IMAGE =new Image(getClass().getResourceAsStream("/bhangun/book/resources/icon_all_01.png"));
	
	public Label buildButton1(){
		//label kosong
		Label label1 = new Label();
		//label dengan elemen teks
		Label label2 = new Label("Search");
		//label dengan elemen teks dan icon 
		Image image = new Image(getClass().getResourceAsStream("labels.jpg"));
		Label label3 = new Label("Search", new ImageView(image));
		return label1;
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
		
		Button btn = ButtonBuilder.create()
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

	@Override
	public ScrollPane getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
