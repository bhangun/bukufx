package bhangun.buku.fx.bab.others;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcBuilder;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class BindGroup extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();
		Scene scene = new Scene(root, 551, 400, Color.BLACK);
		Group buttonGroup = new Group();
		Arc rightButton = ArcBuilder.create().type(ArcType.ROUND).radiusX(15)
				.radiusY(15).startAngle(180 - 30).length(60).translateX(40)
				.build();
		buttonGroup.getChildren().add(rightButton);
		buttonGroup.translateYProperty().bind(
				scene.heightProperty().subtract(10));
		root.getChildren().add(buttonGroup);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
