package bhangun.buku.fx.bab.others;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;


import javafx.animation.KeyFrame;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;



public class SmileyFXDemo extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	Button btn = new Button("ok");
    	btn.setOnAction(buttonActionHandler(btn));
    	
    
        stage.setScene(new Scene(new Button()));
        stage.setTitle("Smiley FX");
        stage.show();
    }
    
    
    private EventHandler<ActionEvent> buttonActionHandler(final Button button) {
    	
    	       return new EventHandler<ActionEvent>() {
    	
    	           @Override
    	
    	           public void handle(ActionEvent event) {
    	
    	               System.out.println("Hello World!");
    	
    	               final Scene scene = button.getScene();
    	
    	               final Point2D windowCoord = new Point2D(scene.getWindow().getX(), scene.getWindow().getY());
    	
    	               final Point2D sceneCoord = new Point2D(scene.getX(), scene.getY());
    	
    	               final Point2D nodeCoord = button.localToScene(0.0, 0.0);
    	
    	               final double clickX = Math.round(windowCoord.getX() + sceneCoord.getX() + nodeCoord.getX());
    	
    	               final double clickY = Math.round(windowCoord.getY() + sceneCoord.getY() + nodeCoord.getY());
    	
    	               clickMeAgainLater(clickX, clickY);
    	
    	           }
    	
    	 
    	
    	           private void clickMeAgainLater(double x, double y) {
    	
    	               TimelineBuilder
    	
    	                       .create()
    	
    	                       .keyFrames(
    	
    	                          new KeyFrame(Duration.seconds(5), clickIt(x, y)))
    	
    	                       .build()
    	
    	                       .play();
    	
    	           }
    	
    	 
    	
    	           private EventHandler<ActionEvent> clickIt(final double x, final double y) {
    	
    	               return new EventHandler<ActionEvent>() {
    	
    	                   @Override
    	
    	                   public void handle(ActionEvent t) {
    	
    	                       try {
    	
    	                           Robot robot = new Robot();
    	
    	                           robot.mouseMove(new Double(x).intValue(), new Double(y).intValue());
    	
    	                           robot.mousePress(InputEvent.BUTTON1_MASK);
    	
    	                           robot.mouseRelease(InputEvent.BUTTON1_MASK);
    	
    	                       } catch (AWTException ex) {
    	
    	                          // logger.log(Level.SEVERE, "bad mouse", ex);
    	
    	                       }
    	
    	                   }
    	
    	               };
    	
    	           }
    	
    	       };
    	
    	   }

    
    public static void main(String[] args) {
        launch(args);
    }

}
