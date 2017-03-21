package bhangun.buku.fx.bab.control;



import bhangun.buku.BaseComponent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;



/**
 * 
 * @author bhangun
 * @since 2012
 * {@link http://bhangun.in}
 *
 */
public class MediaSample extends BaseComponent{
	
		
	private static final String MEDIA_URL = null;
	private Image IMAGE =new Image(getClass().getResourceAsStream("/bhangun/book/resources/icon_all_01.png"));
	
	public void buildButton1(String arg1){
		Media media = new Media((arg1 != null) ? arg1 : MEDIA_URL);
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);

		MediaView mediaView = new MediaView(mediaPlayer);
		

	}
	
	
		private MediaPlayer mp;
	    private MediaView mediaView;
	    private final boolean repeat = false;
	    private boolean stopRequested = false;
	    private boolean atEndOfMedia = false;
	
	    private Slider timeSlider;
	    private Label playTime;
	    private Slider volumeSlider;
	    private HBox mediaBar;

	   
	
	
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
