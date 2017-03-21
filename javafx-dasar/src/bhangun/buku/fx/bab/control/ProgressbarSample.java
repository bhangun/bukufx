package bhangun.buku.fx.bab.control;

import bhangun.buku.BaseComponent;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPaneBuilder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



/**
 * 
 * @author bhangun
 * @since 2012
 * {@link http://bhangun.in}
 *
 */
public class ProgressbarSample extends Application{
	
	final Float[] values = new Float[] {-1.0f, 0f, 0.6f, 1.0f};
	final Label [] labels = new Label[values.length];
	final ProgressBar[] pbs = new ProgressBar[values.length];
	final ProgressIndicator[] pins = new ProgressIndicator[values.length];
	final HBox hbs [] = new HBox [values.length];

	@Override 
	public void start(Stage stage) {
        for (int i = 0; i < values.length; i++) {
            final Label label = labels[i] = new Label();
            label.setText("progress:" + values[i]);
 
            final ProgressBar pb = pbs[i] = new ProgressBar();
            pb.setProgress(values[i]);
 
            final ProgressIndicator pin = pins[i] = new ProgressIndicator();
            pin.setProgress(values[i]);
            final HBox hb = hbs[i] = new HBox();
            hb.setSpacing(5);
            hb.setAlignment(Pos.CENTER);
            hb.getChildren().addAll(label, pb, pin);
        }
 
        final VBox vb = new VBox();
        vb.setSpacing(5);
        vb.getChildren().addAll(hbs);
        
        stage.setTitle("ProgressBar");
       // Scene scene = new Scene(getAll(),400,400);
        Scene scene = new Scene(vb,400,400);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args){
        launch(args);
    }
    
	public ProgressBar progressBar1(){ 
		ProgressBar pb = new ProgressBar(0.6);
		pb.setProgress(0.50);
		
		return pb;
	}
	
	public ProgressBar progressBar2(){ 
		ProgressBar pb = new ProgressBar(0.6);
		pb.setProgress(0.50);
		pb.autosize();
	
		return pb;
	}
	
	public ProgressBar progressBar12(){
        double y = 15;

        final double SPACING = 15;

        ProgressBar p1 = new ProgressBar();

        p1.setLayoutY(y);

 

        y += SPACING;

        ProgressBar p2 = new ProgressBar();

        p2.setPrefWidth(150);

        p2.setLayoutY(y);

 

        y += SPACING;

        ProgressBar p3 = new ProgressBar();

        p3.setPrefWidth(200);

        p3.setLayoutY(y);

 

        y = 15;

        ProgressBar p4 = new ProgressBar();

        p4.setLayoutX(215);

        p4.setLayoutY(y);

        p4.setProgress(0.25);

 

        y += SPACING;

        ProgressBar p5 = new ProgressBar();

        p5.setPrefWidth(150);

        p5.setLayoutX(215);

        p5.setLayoutY(y);

        p5.setProgress(0.50);

 

        y += SPACING;

        ProgressBar p6 = new ProgressBar();

        p6.setPrefWidth(200);

        p6.setLayoutX(215);

        p6.setLayoutY(y);

        p6.setProgress(1);


		return null;
	}
	
	
	public ScrollPane getAll(){
	    
    	VBox box= VBoxBuilder.create()
    			.children(progressBar1())
    			.padding(new Insets(10,10,10,10))
    			.spacing(10)
    			.build();
    	return ScrollPaneBuilder.create().content(box).build();
    }

}
