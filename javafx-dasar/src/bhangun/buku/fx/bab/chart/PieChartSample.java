package bhangun.buku.fx.bab.chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PieChartSample extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage primaryStage) {
    StackPane root = new StackPane();
    root.getChildren().add(getPieChart());
    primaryStage.setScene(new Scene(root, 300, 250));
    primaryStage.show();
  }
  
  public PieChart getPieChart() {
		
      ObservableList<PieChart.Data> pieChartData =
              FXCollections.observableArrayList(
              new PieChart.Data("Grapefruit", 13),
              new PieChart.Data("Oranges", 25),
              new PieChart.Data("Plums", 10),
              new PieChart.Data("Pears", 22),
              new PieChart.Data("Apples", 30));
      final PieChart chart = new PieChart(pieChartData);
      chart.setTitle("Imported Fruits");
      
      
      final Label caption = new Label("");
      caption.setTextFill(Color.DARKORANGE);
      caption.setStyle("-fx-font: 24 arial;");

      for (final PieChart.Data data : chart.getData()) {
          data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
              new EventHandler<MouseEvent>() {
                  @Override public void handle(MouseEvent e) {
                      caption.setTranslateX(e.getSceneX());
                      caption.setTranslateY(e.getSceneY());
                      caption.setText(String.valueOf(data.getPieValue()) + "%");
                   }
              });
      }

      return chart;
  }
  
  
}
