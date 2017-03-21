package bukuFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AppsDasar extends Application {

	public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(new Button("bismillah"));
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
