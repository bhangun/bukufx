package bhangun.buku.fx.bab.layout;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;

public class ResizeLayout extends Application implements ChangeListener<Number> {
	
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		// be resize friendly

		stage.widthProperty().addListener(this);
		stage.heightProperty().addListener(this);

		// resize content
		resize(stage.getWidth(), stage.getHeight());

		stage.show();
	}

	private void resize(double width, double height) {
		// relayout the application to match given size

	}

	@Override
	public void changed(ObservableValue<? extends Number> arg0, Number arg1,
			Number arg2) {
		// TODO Auto-generated method stub

	}

	/*
	 * public void changed(ObservableValue<? extends Number> ov,Number t, Number
	 * t1) { resize(stage.getWidth(), stage.getHeight()); }
	 */
}
