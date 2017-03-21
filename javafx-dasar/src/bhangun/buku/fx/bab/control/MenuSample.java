package bhangun.buku.fx.bab.control;

import java.util.Map.Entry;

import bhangun.buku.BaseComponent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.VBox;

import java.util.AbstractMap.SimpleEntry;

/**
 * 
 * @author bhangun
 * @since 2012
 * {@link http://bhangun.in}
 *
 */
public class MenuSample extends BaseComponent{
	
		
	private Image IMAGE =new Image(getClass().getResourceAsStream("/bhangun/book/resources/icon_all_01.png"));
	
	public void buildButton1(){
		final String[] viewOptions = new String[] {
		        "Title", 
		        "Binomial name", 
		        "Picture", 
		        "Decsription"
		    };
		 
		    final Entry<String, Effect>[] effects = new Entry[] {
		        new SimpleEntry<String, Effect>("Sepia Tone", new SepiaTone()),
		        new SimpleEntry<String, Effect>("Glow", new Glow()),
		        new SimpleEntry<String, Effect>("Shadow", new DropShadow())
		    };
		 
		    final ImageView pic = new ImageView();
		    final Label name = new Label();
		    final Label binName = new Label();
		    final Label description = new Label();
		    
		    
		    MenuBar menuBar = new MenuBar();
		    
	        final VBox vbox = new VBox();
	        vbox.setAlignment(Pos.CENTER);
	        vbox.setSpacing(10);
	        vbox.setPadding(new Insets(0, 10, 0, 10));
	        vbox.getChildren().addAll(name, binName, pic, description);
	 
	        // --- Menu File
	        Menu menuFile = new Menu("File");
	        MenuItem add = new MenuItem("Shuffle",
	            new ImageView(new Image("src/menusample/new.png")));
	        add.setOnAction(new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent t) {
	                
	                vbox.setVisible(true);
	            }
	        });        
	 
	        menuFile.getItems().addAll(add);
	 
	        // --- Menu Edit
	        Menu menuEdit = new Menu("Edit");
	        
	        // --- Menu View
	        Menu menuView = new Menu("View");
	        
	        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
	   
	    }
	 
	   
	 
	    
	    private class PageData {
	        public String name;
	        public String description;
	        public String binNames;
	        public Image image;
	        public PageData(String name, String description, String binNames) {
	            this.name = name;
	            this.description = description;
	            this.binNames = binNames;
	            image = new Image(getClass().getResourceAsStream(name + ".jpg"));
	        }

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
