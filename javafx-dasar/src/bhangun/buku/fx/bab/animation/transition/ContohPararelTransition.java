package bhangun.buku.fx.bab.animation.transition;


import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
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
public class ContohPararelTransition extends Application{
	
		
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
		
		final Duration SEC_2 = Duration.millis(2000);
	     final Duration SEC_3 = Duration.millis(3000);
	 
	     FadeTransition ft = new FadeTransition(SEC_3);
	     ft.setFromValue(1.0f);
	     ft.setToValue(0.3f);
	     ft.setCycleCount(2);
	     ft.setAutoReverse(true);
	     TranslateTransition tt = new TranslateTransition(SEC_2);
	     tt.setFromX(-100f);
	     tt.setToX(100f);
	     tt.setCycleCount(2);
	     tt.setAutoReverse(true);
	     RotateTransition rt = new RotateTransition(SEC_3);
	     rt.setByAngle(180f);
	     rt.setCycleCount(4);
	     rt.setAutoReverse(true);
	     ScaleTransition st = new ScaleTransition(SEC_2);
	     st.setByX(1.5f);
	     st.setByY(1.5f);
	     st.setCycleCount(2);
	     st.setAutoReverse(true);
	 
	     ParallelTransition pt = new ParallelTransition(r, ft, tt, rt, st);
	     pt.play();

		return StackPaneBuilder.create().children(r).build();
	}
	
	
	public ScrollPane getAll() {
		VBox box = VBoxBuilder.create().children(
				getTransition1())
				.build();
		return ScrollPaneBuilder.create().content(box).build();
	}

}
