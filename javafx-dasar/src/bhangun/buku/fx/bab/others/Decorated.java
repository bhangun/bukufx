package bhangun.buku.fx.bab.others;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Decorated extends Application {

    @Override
    public void start(Stage stage) {
       // stage.initStyle(StageStyle.TRANSPARENT);
        Text text = new Text("bhangun");
        text.setFont(new Font(40));
        VBox box = new VBox();
        VBox box2 = new VBox();
        box2.setMinSize(50, 50);
        VBox box3 = new VBox();
        box2.setMaxSize(50, 50);
        Stage s = new Stage();
        final Scene sc = new Scene(box3,400, 450);
        s.setScene(sc);
        s.showAndWait();
       // s.show();
        //box.setStyle("-fx-background-color: red");//linear-gradient(from 0% 0% to 0% 100%, #007 0%, #00d 100%);");
        box2.setStyle("-fx-background-color: green;");
        box.getChildren().addAll(box2,text);
        box.setMinSize(100, 100);
        box.setMaxSize(50, 50);
        final Scene scene = new Scene(box,300, 550);
        scene.setFill(null);
        stage.setScene(scene);
        
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
