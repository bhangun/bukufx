package bhangun.buku.fx.bab.animation.transition;


import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
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
public class ContohSequentialTransition extends Application{
	
		
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
		
		 FadeTransition fadeTransition = 
		            new FadeTransition(Duration.millis(1000), r);
		        fadeTransition.setFromValue(1.0f);
		        fadeTransition.setToValue(0.3f);
		        fadeTransition.setCycleCount(1);
		        fadeTransition.setAutoReverse(true);
		 
		        TranslateTransition translateTransition =
		            new TranslateTransition(Duration.millis(2000), r);
		        translateTransition.setFromX(50);
		        translateTransition.setToX(375);
		        translateTransition.setCycleCount(1);
		        translateTransition.setAutoReverse(true);
		 
		        RotateTransition rotateTransition = 
		            new RotateTransition(Duration.millis(2000), r);
		        rotateTransition.setByAngle(180f);
		        rotateTransition.setCycleCount(4);
		        rotateTransition.setAutoReverse(true);
		 
		        ScaleTransition scaleTransition = 
		            new ScaleTransition(Duration.millis(2000), r);
		        scaleTransition.setFromX(1);
		        scaleTransition.setFromY(1);
		        scaleTransition.setToX(2);
		        scaleTransition.setToY(2);
		        scaleTransition.setCycleCount(1);
		        scaleTransition.setAutoReverse(true);

		SequentialTransition sequentialTransition = new SequentialTransition();
		sequentialTransition.getChildren().addAll(
		        fadeTransition,
		        translateTransition,
		        rotateTransition,
		        scaleTransition);
		sequentialTransition.setCycleCount(Timeline.INDEFINITE);
		sequentialTransition.setAutoReverse(true);

		sequentialTransition.play();
		
		return StackPaneBuilder.create().children(r).build();
	}
	
	
	public ScrollPane getAll() {
		VBox box = VBoxBuilder.create().children(
				getTransition1())
				.build();
		return ScrollPaneBuilder.create().content(box).build();
	}

}
