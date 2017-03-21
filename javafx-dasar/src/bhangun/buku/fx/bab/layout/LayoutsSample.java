package bhangun.buku.fx.bab.layout;

import bhangun.buku.BaseComponent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;



/**
 * 
 * @author bhangun
 * @since 2012
 * {@link http://bhangun.in}
 *
 */
public class LayoutsSample extends BaseComponent{
	
	
	private Image IMAGE =new Image(getClass().getResourceAsStream("/bhangun/book/resources/icon_all_01.png"));
	
	public void buildButton1(){
		BorderPane layout = new BorderPane();
		layout.setTop(new Rectangle(200, 50, Color.DARKCYAN));
		layout.setBottom(new Rectangle(200, 50, Color.DARKCYAN));
		layout.setCenter(new Rectangle(100, 100, Color.MEDIUMAQUAMARINE));
		layout.setLeft(new Rectangle(50, 100, Color.DARKTURQUOISE));
		layout.setRight(new Rectangle(50, 100, Color.DARKTURQUOISE));

	}
	
	public void buildButton2(){
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);
		hbox.setStyle("-fx-background-color: #336699");

		Button buttonCurrent = new Button("Current");
		buttonCurrent.setPrefSize(100, 20);

		Button buttonProjected = new Button("Projected");
		buttonProjected.setPrefSize(100, 20);
		hbox.getChildren().addAll(buttonCurrent, buttonProjected);

	}
	
	public void buildButton3(){
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10, 10, 10, 10));
		vbox.setSpacing(10);

		Text title = new Text("Data");
		title.setFont(Font.font("Amble CN", FontWeight.BOLD, 14));
		vbox.getChildren().add(title);

		Text options[] = new Text[] {
		                 new Text("  Sales"),
		                 new Text("  Marketing"),
		                 new Text("  Distribution"),
		                 new Text("  Costs")};

		for (int i=0; i<4; i++) {
		     vbox.getChildren().add(options[i]);
		}

	}
	
	public void buildButton4(){
		StackPane stack = new StackPane();
		Rectangle helpIcon = new Rectangle(35.0, 25.0);
		helpIcon.setFill(new LinearGradient(0,0,0,1, true, CycleMethod.NO_CYCLE,
		    new Stop[]{
		    new Stop(0,Color.web("#4977A3")),
		    new Stop(0.5, Color.web("#B0C6DA")),
		    new Stop(1,Color.web("#9CB6CF")),}));
		helpIcon.setStroke(Color.web("#D0E6FA"));
		helpIcon.setArcHeight(3.5);
		helpIcon.setArcWidth(3.5);

		Text helpText = new Text("?   ");
		helpText.setFont(Font.font("Amble Cn", FontWeight.BOLD, 18));
		helpText.setFill(Color.WHITE);
		helpText.setStroke(Color.web("#7080A0")); 

	}
	
	public void buildButton5(){
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(0, 0, 0, 10));

		// Category in column 2, row 1
		Text category = new Text("Sales:");
		category.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
		grid.add(category, 1, 0); 

		// Title in column 3, row 1
		Text chartTitle = new Text("Current Year");
		chartTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
		grid.add(chartTitle, 2, 0);

		// Subtitle in columns 2-3, row 2
		Text chartSubtitle = new Text("Goods and Services");
		grid.add(chartSubtitle, 1, 1, 2, 1);

		// House icon in column 1, rows 1-2
		ImageView imageHouse = new ImageView(
		    new Image(getClass().getResourceAsStream("graphics/house.png")));
		grid.add(imageHouse, 0, 0, 1, 2); 

		// Left label in column 1 (bottom), row 3
		Text goodsPercent = new Text("Goods\n80%");
		GridPane.setValignment(goodsPercent, VPos.BOTTOM);
		grid.add(goodsPercent, 0, 2); 

		// Chart in columns 2-3, row 3
		ImageView imageChart = new ImageView(IMAGE);
		grid.add(imageChart, 1, 2, 2, 1); 

		// Right label in column 4 (top), row 3
		Text servicesPercent = new Text("Services\n20%");
		GridPane.setValignment(servicesPercent, VPos.TOP);
		grid.add(servicesPercent, 3, 2);

	}
	
	public void buildButton6(){
		FlowPane flow = new FlowPane();
		flow.setPadding(new Insets(5, 0, 5, 0));
		flow.setVgap(4);
		flow.setHgap(4);
		flow.setPrefWrapLength(170); // preferred width allows for two columns
		flow.setStyle("-fx-background-color: DAE6F3");

		ImageView pages[] = new ImageView[8];
		for (int i=0; i<8; i++) {
		     pages[i] = new ImageView(IMAGE);
		     flow.getChildren().add(pages[i]);
		}

	}
	

	public void buildButton7(){
		TilePane tile = new TilePane();
		tile.setPadding(new Insets(5, 0, 5, 0));
		tile.setVgap(4);
		tile.setHgap(4);
		tile.setPrefColumns(2);
		tile.setStyle("-fx-background-color: DAE6F3");

		ImageView pages[] = new ImageView[8];
		for (int i=0; i<8; i++) {
		     pages[i] = new ImageView(IMAGE);
		     tile.getChildren().add(pages[i]);
		}

	}
	
	
	public void getlay(){
		AnchorPane anchorpane = new AnchorPane();
		Button buttonSave = new Button("Save");
		Button buttonCancel = new Button("Cancel");

		HBox hbox = new HBox();
		hbox.setPadding(new Insets(0, 10, 10, 10));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(buttonSave, buttonCancel);

		anchorpane.getChildren().addAll(hbox);   // Add grid from Example 1-5
		AnchorPane.setBottomAnchor(hbox, 8.0);
		AnchorPane.setRightAnchor(hbox, 5.0);
		

	}

	@Override
	public ScrollPane getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
