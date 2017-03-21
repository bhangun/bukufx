package bhangun.buku.fx.bab.chart;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BubbleChartSample extends Application {
    
    final static String itemA = "A";
    final static String itemB = "B";
    final static String itemC = "F";
    
    @SuppressWarnings("unchecked")
   	public BubbleChart<Number,Number> getBubbleChart() {
   	    
   	        final NumberAxis xAxis = new NumberAxis(1, 53, 4);
   	        final NumberAxis yAxis = new NumberAxis(0, 80, 10);
   	        final BubbleChart<Number,Number> blc = new
   	            BubbleChart<Number,Number>(xAxis,yAxis);
   	        xAxis.setLabel("Week");
   	        yAxis.setLabel("Product Budget");
   	        blc.setTitle("Budget Monitoring");
   	       
   	        XYChart.Series<Number,Number> series1 = new XYChart.Series<Number,Number>();
   	        series1.setName("Product 1");
   	        series1.getData().add(new XYChart.Data<Number,Number>(3, 35));
   	        series1.getData().add(new XYChart.Data<Number,Number>(12, 60));
   	        series1.getData().add(new XYChart.Data<Number,Number>(15, 15));
   	        series1.getData().add(new XYChart.Data<Number,Number>(22, 30));
   	        series1.getData().add(new XYChart.Data<Number,Number>(28, 20));
   	        series1.getData().add(new XYChart.Data<Number,Number>(35, 41));
   	        series1.getData().add(new XYChart.Data<Number,Number>(42, 17));
   	        series1.getData().add(new XYChart.Data<Number,Number>(49, 30));
   	                
   	        XYChart.Series<Number,Number> series2 = new XYChart.Series<Number,Number>();
   	        series2.setName("Product 2");
   	        series2.getData().add(new XYChart.Data<Number,Number>(8, 15));
   	        series2.getData().add(new XYChart.Data<Number,Number>(13, 23));
   	        series2.getData().add(new XYChart.Data<Number,Number>(15, 45));
   	        series2.getData().add(new XYChart.Data<Number,Number>(24, 30));
   	        series2.getData().add(new XYChart.Data<Number,Number>(38, 78));
   	        series2.getData().add(new XYChart.Data<Number,Number>(40, 41));
   	        series2.getData().add(new XYChart.Data<Number,Number>(45, 57));
   	        series2.getData().add(new XYChart.Data<Number,Number>(47, 23));
   	                           
   	        blc.getData().addAll(series1, series2);           
   	       return blc;
   	    }
    
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(getBubbleChart(), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
