package bhangun.buku.fx.bab.animation;

import bhangun.buku.BaseComponent;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * @author bhangun
 * @since 2012 {@link http://bhangun.in}
 *
 */
public class AnimationSample extends BaseComponent {

	private Image IMAGE = new Image(getClass().getResourceAsStream("/bhangun/book/resources/icon_all_01.png"));

	public void buildButton1() {
		final Rectangle rect1 = new Rectangle(10, 10, 100, 100);
		rect1.setArcHeight(20);
		rect1.setArcWidth(20);
		rect1.setFill(Color.RED);

		FadeTransition ft = new FadeTransition(Duration.millis(3000), rect1);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();

	}

	public void buildButton2() {
		final Rectangle rectPath = new Rectangle(0, 0, 40, 40);
		rectPath.setArcHeight(10);
		rectPath.setArcWidth(10);
		rectPath.setFill(Color.ORANGE);
		Path path = new Path();
		path.getElements().add(new MoveTo(20, 20));
		path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
		path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(4000));
		pathTransition.setPath(path);
		pathTransition.setNode(rectPath);
		pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition.setCycleCount(Timeline.INDEFINITE);
		pathTransition.setAutoReverse(true);
		pathTransition.play();

	}

	public void buildButton3() {
		Rectangle rectParallel = new Rectangle(10, 200, 50, 50);
		rectParallel.setArcHeight(15);
		rectParallel.setArcWidth(15);
		rectParallel.setFill(Color.DARKBLUE);
		rectParallel.setTranslateX(50);
		rectParallel.setTranslateY(75);

		FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), rectParallel);
		fadeTransition.setFromValue(1.0f);
		fadeTransition.setToValue(0.3f);
		fadeTransition.setCycleCount(2);
		fadeTransition.setAutoReverse(true);
		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000), rectParallel);
		translateTransition.setFromX(50);
		translateTransition.setToX(350);
		translateTransition.setCycleCount(2);
		translateTransition.setAutoReverse(true);
		RotateTransition rotateTransition = new RotateTransition(Duration.millis(3000), rectParallel);
		rotateTransition.setByAngle(180f);
		rotateTransition.setCycleCount(4);
		rotateTransition.setAutoReverse(true);
		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), rectParallel);
		scaleTransition.setToX(2f);
		scaleTransition.setToY(2f);
		scaleTransition.setCycleCount(2);
		scaleTransition.setAutoReverse(true);

		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(fadeTransition, translateTransition, rotateTransition, scaleTransition);
		parallelTransition.setCycleCount(Timeline.INDEFINITE);
		parallelTransition.play();

	}

	public void buildButton4() {
		Rectangle rectSeq = new Rectangle(25, 25, 50, 50);
		rectSeq.setArcHeight(15);
		rectSeq.setArcWidth(15);
		rectSeq.setFill(Color.CRIMSON);
		rectSeq.setTranslateX(50);
		rectSeq.setTranslateY(50);

		FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), rectSeq);
		fadeTransition.setFromValue(1.0f);
		fadeTransition.setToValue(0.3f);
		fadeTransition.setCycleCount(1);
		fadeTransition.setAutoReverse(true);

		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000), rectSeq);
		translateTransition.setFromX(50);
		translateTransition.setToX(375);
		translateTransition.setCycleCount(1);
		translateTransition.setAutoReverse(true);

		RotateTransition rotateTransition = new RotateTransition(Duration.millis(2000), rectSeq);
		rotateTransition.setByAngle(180f);
		rotateTransition.setCycleCount(4);
		rotateTransition.setAutoReverse(true);

		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), rectSeq);
		scaleTransition.setFromX(1);
		scaleTransition.setFromY(1);
		scaleTransition.setToX(2);
		scaleTransition.setToY(2);
		scaleTransition.setCycleCount(1);
		scaleTransition.setAutoReverse(true);

		SequentialTransition sequentialTransition = new SequentialTransition();
		sequentialTransition.getChildren().addAll(fadeTransition, translateTransition, rotateTransition,
				scaleTransition);
		sequentialTransition.setCycleCount(Timeline.INDEFINITE);
		sequentialTransition.setAutoReverse(true);

		sequentialTransition.play();

	}

	public void buildButton5() {
		final Rectangle rectBasicTimeline = new Rectangle(100, 50, 100, 50);
		rectBasicTimeline.setFill(Color.BROWN);
		final Timeline timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);
		final KeyValue kv = new KeyValue(rectBasicTimeline.xProperty(), 300);
		final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
		timeline.getKeyFrames().add(kf);
		timeline.play();

	}

	public void buildButton6(Stage stage) {
		Group p = new Group();
		Scene scene = new Scene(p);
		stage.setScene(scene);
		stage.setWidth(500);
		stage.setHeight(500);
		p.setTranslateX(80);
		p.setTranslateY(80);

		// create a circle with effect
		final Circle circle = new Circle(20, Color.rgb(156, 216, 255));
		circle.setEffect(new Lighting());
		// create a text inside a circle
		final Text text = new Text("bbbbbbb");
		text.setStroke(Color.BLACK);
		// create a layout for circle with text inside
		final StackPane stack = new StackPane();
		stack.getChildren().addAll(circle, text);
		stack.setLayoutX(30);
		stack.setLayoutY(30);

		p.getChildren().add(stack);
		stage.show();

		// create a timeline for moving the circle
		Timeline timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);
		Object i;
		// You can add a specific action when each frame is started.
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long l) {

				// text.setText(i.toString());
				// i++;
			}

		};

		// create a keyValue with factory: scaling the circle 2times
		KeyValue keyValueX = new KeyValue(stack.scaleXProperty(), 2);
		KeyValue keyValueY = new KeyValue(stack.scaleYProperty(), 2);

		// create a keyFrame, the keyValue is reached at time 2s
		Duration duration = Duration.millis(2000);
		// one can add a specific action when the keyframe is reached
		EventHandler onFinished = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				stack.setTranslateX(java.lang.Math.random() * 200 - 100);
				// reset counter
				// i = 0;
			}
		};

		KeyFrame keyFrame = new KeyFrame(duration, onFinished, keyValueX, keyValueY);

		// add the keyframe to the timeline
		timeline.getKeyFrames().add(keyFrame);

		timeline.play();
		timer.start();
	}

	public void buildButton7() {
		final Rectangle rectBasicTimeline = new Rectangle(100, 50, 100, 50);
		rectBasicTimeline.setFill(Color.BROWN);
		final Timeline timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);
		final KeyValue kv = new KeyValue(rectBasicTimeline.xProperty(), 300, Interpolator.EASE_BOTH);
		final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
		timeline.getKeyFrames().add(kf);
		timeline.play();

	}

	@Override
	public ScrollPane getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
