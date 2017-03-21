package bhangun.buku.fx.bab.animation.transition;


import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.StrokeTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPaneBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPaneBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;



/**
 * 
 * @author bhangun
 * @since 2012
 * {@link http://bhangun.in}
 *
 */
public class ContohPathTransition extends Application{
	
		
	@Override 
	public void start(Stage stage) {
       stage.setTitle("Fade Transition");
        Scene scene = new Scene(getAll(),400,400);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args){
        launch(args);
    }
	
	public StackPane getTransition1(){
		final Rectangle r = new Rectangle(10, 10, 100, 100);
		r.setArcHeight(20);
		r.setArcWidth(20);
		r.setFill(Color.RED);
		
		Path path = new Path();
	     path.getElements().add (new MoveTo (0f, 50f));
	     path.getElements().add (new CubicCurveTo (40f, 10f, 390f, 240f, 1904, 50f));
	 
	     PathTransition pathTransition = new PathTransition();
	     pathTransition.setDuration(Duration.millis(10000));
	     pathTransition.setNode(r);
	     pathTransition.setPath(path);
	     pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
	     pathTransition.setCycleCount(4);
	     pathTransition.setAutoReverse(true);
	 
	     pathTransition.play();

		return StackPaneBuilder.create().children(r).build();
	}
	
	
	public ScrollPane getAll() {
		VBox box = VBoxBuilder.create().children(
				getTransition1())
				.build();
		return ScrollPaneBuilder.create().content(box).build();
	}

}
