package bhangun.buku.fx.bab.animation;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BlendMultiply extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Text Fonts");

        Group g = new Group();
        Scene scene = new Scene(g, 550, 250,Color.web("0x0000FF",1.0));

        Rectangle r = new Rectangle();
        r.setX(50);
        r.setY(50);
        r.setWidth(50);
        r.setHeight(50);
        r.setFill(Color.BLUE);

        Circle c = new Circle();
        c.setFill(Color.rgb(255, 0, 0, 0.5));
        c.setCenterX(50);
        c.setCenterY(50);
        c.setRadius(25);
        c.setBlendMode(BlendMode.MULTIPLY);

        g.getChildren().add(r);
        g.getChildren().add(c);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}