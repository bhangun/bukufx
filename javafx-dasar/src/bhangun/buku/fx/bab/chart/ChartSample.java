package bhangun.buku.fx.bab.chart;

import bhangun.buku.BaseComponent;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPaneBuilder;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;



/**
 * 
 * @author bhangun
 * @since 2012
 * {@link http://bhangun.in}
 *
 */
public class ChartSample extends BaseComponent{
		
    final static String austria = "Austria";
    final static String brazil = "Brazil";
    final static String france = "France";
    final static String italy = "Italy";
    final static String usa = "USA";


	
	 
	 @SuppressWarnings("unchecked")
	public AreaChart<Number,Number> getAreaChart() {
	       
	        final NumberAxis xAxis = new NumberAxis();
	        final NumberAxis yAxis = new NumberAxis();
	        final AreaChart<Number,Number> ac = 
	            new AreaChart<Number,Number>(xAxis,yAxis);
	        ac.setTitle("Temperature Monitoring (in Degrees C)");
	 
	        XYChart.Series<Number,Number> seriesApril= new XYChart.Series<Number,Number>();
	        seriesApril.setName("April");
	        seriesApril.getData().add(new XYChart.Data<Number,Number>(0, 4));
	        seriesApril.getData().add(new XYChart.Data<Number,Number>(3, 10));
	        seriesApril.getData().add(new XYChart.Data<Number,Number>(6, 15));
	        seriesApril.getData().add(new XYChart.Data<Number,Number>(9, 8));
	        seriesApril.getData().add(new XYChart.Data<Number,Number>(12, 5));
	        seriesApril.getData().add(new XYChart.Data<Number,Number>(15, 18));
	        seriesApril.getData().add(new XYChart.Data<Number,Number>(18, 15));
	        seriesApril.getData().add(new XYChart.Data<Number,Number>(21, 13));
	        seriesApril.getData().add(new XYChart.Data<Number,Number>(24, 19));
	        seriesApril.getData().add(new XYChart.Data<Number,Number>(27, 21));
	        seriesApril.getData().add(new XYChart.Data<Number,Number>(30, 21));
	        
	        XYChart.Series<Number,Number> seriesMay = new XYChart.Series<Number,Number>();
	        seriesMay.setName("May");
	        seriesMay.getData().add(new XYChart.Data<Number,Number>(0, 20));
	        seriesMay.getData().add(new XYChart.Data<Number,Number>(3, 15));
	        seriesMay.getData().add(new XYChart.Data<Number,Number>(6, 13));
	        seriesMay.getData().add(new XYChart.Data<Number,Number>(9, 12));
	        seriesMay.getData().add(new XYChart.Data<Number,Number>(12, 14));
	        seriesMay.getData().add(new XYChart.Data<Number,Number>(15, 18));
	        seriesMay.getData().add(new XYChart.Data<Number,Number>(18, 25));
	        seriesMay.getData().add(new XYChart.Data<Number,Number>(21, 25));
	        seriesMay.getData().add(new XYChart.Data<Number,Number>(24, 23));
	        seriesMay.getData().add(new XYChart.Data<Number,Number>(27, 26));
	        seriesMay.getData().add(new XYChart.Data<Number,Number>(31, 26));
	        
	        final NumberAxis xAxis2 = new NumberAxis(1, 31, 1);
	      //Using the correcponding methods
	      xAxis2.setLowerBound(1);
	      xAxis2.setUpperBound(30);
	      xAxis2.setTickUnit(1);

	        ac.getData().addAll(seriesApril, seriesMay);
	      return ac;
	    }
	 
	 @SuppressWarnings({ "unchecked", "rawtypes" })
		public BarChart getBarChart() {
	   
	        final CategoryAxis xAxis = new CategoryAxis();
	        final NumberAxis yAxis = new NumberAxis();
	        final BarChart<String,Number> bc = 
	            new BarChart<String,Number>(xAxis,yAxis);
	        bc.setTitle("Country Summary");
	        xAxis.setLabel("Country");       
	        yAxis.setLabel("Value");
	 
	        XYChart.Series series1 = new XYChart.Series();
	        series1.setName("2003");       
	        series1.getData().add(new XYChart.Data(austria, 25601.34));
	        series1.getData().add(new XYChart.Data(brazil, 20148.82));
	        series1.getData().add(new XYChart.Data(france, 10000));
	        series1.getData().add(new XYChart.Data(italy, 35407.15));
	        series1.getData().add(new XYChart.Data(usa, 12000));      
	        
	        XYChart.Series series2 = new XYChart.Series();
	        series2.setName("2004");
	        series2.getData().add(new XYChart.Data(austria, 57401.85));
	        series2.getData().add(new XYChart.Data(brazil, 41941.19));
	        series2.getData().add(new XYChart.Data(france, 45263.37));
	        series2.getData().add(new XYChart.Data(italy, 117320.16));
	        series2.getData().add(new XYChart.Data(usa, 14845.27));  
	        
	        XYChart.Series series3 = new XYChart.Series();
	        series3.setName("2005");
	        series3.getData().add(new XYChart.Data(austria, 45000.65));
	        series3.getData().add(new XYChart.Data(brazil, 44835.76));
	        series3.getData().add(new XYChart.Data(france, 18722.18));
	        series3.getData().add(new XYChart.Data(italy, 17557.31));
	        series3.getData().add(new XYChart.Data(usa, 92633.68));  
	        
	        bc.getData().addAll(series1, series2, series3);
	        
	        return bc;
	    }

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
		
		
		public LineChart<Number,Number> getLineChart() {
	       
	        final NumberAxis xAxis = new NumberAxis();
	        final NumberAxis yAxis = new NumberAxis();
	        xAxis.setLabel("Number of Month");
	        //creating the chart
	        final LineChart<Number,Number> lineChart = 
	                new LineChart<Number,Number>(xAxis,yAxis);
	                
	        lineChart.setTitle("Stock Monitoring, 2010");
	        //defining a series
	        XYChart.Series<Number,Number> series = new XYChart.Series<Number,Number>();
	        series.setName("My portfolio");
	        
	        //populating the series with data
	        series.getData().add(new XYChart.Data<Number,Number>(1, 23));
	        series.getData().add(new XYChart.Data<Number,Number>(2, 14));
	        series.getData().add(new XYChart.Data<Number,Number>(3, 15));
	        series.getData().add(new XYChart.Data<Number,Number>(4, 24));
	        series.getData().add(new XYChart.Data<Number,Number>(5, 34));
	        series.getData().add(new XYChart.Data<Number,Number>(6, 36));
	        series.getData().add(new XYChart.Data<Number,Number>(7, 22));
	        series.getData().add(new XYChart.Data<Number,Number>(8, 45));
	        series.getData().add(new XYChart.Data<Number,Number>(9, 43));
	        series.getData().add(new XYChart.Data<Number,Number>(10, 17));
	        series.getData().add(new XYChart.Data<Number,Number>(11, 29));
	        series.getData().add(new XYChart.Data<Number,Number>(12, 25));
	        
	        lineChart.getData().add(series);
	       
	        return lineChart;
	    }	 
 
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public ScatterChart getScatterChart() {
	     
	        final NumberAxis xAxis = new NumberAxis(0, 10, 1);
	        final NumberAxis yAxis = new NumberAxis(-100, 500, 100);        
	        final ScatterChart<Number,Number> sc = new
	            ScatterChart<Number,Number>(xAxis,yAxis);
	        xAxis.setLabel("Age (years)");                
	        yAxis.setLabel("Returns to date");
	        sc.setTitle("Investment Overview");
	       
	        XYChart.Series series1 = new XYChart.Series();
	        series1.setName("Equities");
	        series1.getData().add(new XYChart.Data(4.2, 193.2));
	        series1.getData().add(new XYChart.Data(2.8, 33.6));
	        series1.getData().add(new XYChart.Data(6.2, 24.8));
	        series1.getData().add(new XYChart.Data(1, 14));
	        series1.getData().add(new XYChart.Data(1.2, 26.4));
	        series1.getData().add(new XYChart.Data(4.4, 114.4));
	        series1.getData().add(new XYChart.Data(8.5, 323));
	        series1.getData().add(new XYChart.Data(6.9, 289.8));
	        series1.getData().add(new XYChart.Data(9.9, 287.1));
	        series1.getData().add(new XYChart.Data(0.9, -9));
	        series1.getData().add(new XYChart.Data(3.2, 150.8));
	        series1.getData().add(new XYChart.Data(4.8, 20.8));
	        series1.getData().add(new XYChart.Data(7.3, -42.3));
	        series1.getData().add(new XYChart.Data(1.8, 81.4));
	        series1.getData().add(new XYChart.Data(7.3, 110.3));
	        series1.getData().add(new XYChart.Data(2.7, 41.2));
	        
	        XYChart.Series series2 = new XYChart.Series();
	        series2.setName("Mutual funds");
	        series2.getData().add(new XYChart.Data(5.2, 229.2));
	        series2.getData().add(new XYChart.Data(2.4, 37.6));
	        series2.getData().add(new XYChart.Data(3.2, 49.8));
	        series2.getData().add(new XYChart.Data(1.8, 134));
	        series2.getData().add(new XYChart.Data(3.2, 236.2));
	        series2.getData().add(new XYChart.Data(7.4, 114.1));
	        series2.getData().add(new XYChart.Data(3.5, 323));
	        series2.getData().add(new XYChart.Data(9.3, 29.9));
	        series2.getData().add(new XYChart.Data(8.1, 287.4));
	 
	        sc.getData().addAll(series1, series2);
	       
	        return sc;
	    }

	 
	
	 
	    

		@Override
		public ScrollPane getAll() {
			VBox box = new VBox();
			
			box.getChildren().addAll(
					getPieChart(),
					getLineChart(),
					getAreaChart(),
					getBubbleChart(),
					getScatterChart(),
					getBarChart());
	
			return ScrollPaneBuilder.create().content(box).build();
		}

    

	
	
	/*
	 .default-color0.chart-area-symbol { -fx-background-color: #e9967a, #ffa07a; }
.default-color1.chart-area-symbol { -fx-background-color: #f0e68c, #fffacd; }
.default-color2.chart-area-symbol { -fx-background-color: #dda0dd, #d8bfd855; }
 
.default-color0.chart-series-area-line { -fx-stroke: #e9967a; }
.default-color1.chart-series-area-line { -fx-stroke: #f0e68c; }
.default-color2.chart-series-area-line { -fx-stroke: #dda0dd; }
 
.default-color0.chart-series-area-fill { -fx-fill: #ffa07a55; }
.default-color1.chart-series-area-fill { -fx-fill: #fffacd55; }
.default-color2.chart-series-area-fill { -fx-fill: #d8bfd855; }
 
 
  final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();
        final BarChart<Number, String> bc = new BarChart<Number, String>(xAxis, yAxis);
        bc.setTitle("Summary");
        xAxis.setLabel("Value");
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Item");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");
        series1.getData().add(new XYChart.Data(2, itemA));
        series1.getData().add(new XYChart.Data(20, itemB));
        series1.getData().add(new XYChart.Data(10, itemC));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(50, itemA));
        series2.getData().add(new XYChart.Data(41, itemB));
        series2.getData().add(new XYChart.Data(45, itemC));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(45, itemA));
        series3.getData().add(new XYChart.Data(44, itemB));
        series3.getData().add(new XYChart.Data(18, itemC));

        Timeline tl = new Timeline();
        tl.getKeyFrames().add(new KeyFrame(Duration.millis(500), 
            new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent actionEvent) {
                for (XYChart.Series<Number, String> series : bc.getData()) {
                    for (XYChart.Data<Number, String> data : series.getData()) {
                        data.setXValue(Math.random() * 100);
                    }
                }
            }
        }));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();

        Scene scene = new Scene(bc, 800, 600);
        bc.getData().addAll(series1, series2, series3);
        stage.setScene(scene);
        stage.show();
	 */

}
