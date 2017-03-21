package bhangun.buku.fx.bab.chart;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class AreaChartSample extends Application implements ChangeListener<Number> {
    
    final static String itemA = "A";
    final static String itemB = "B";
    final static String itemC = "F";
    
    public static void main(String[] args) {
        launch(args);
    }

	private Stage stage;
	private Button btn;
	private double h;
	private double w;
    
    @Override
    public void start(Stage stage) {
    	HBox hb = new HBox();
    	btn = new Button("tombol");
    	btn.setMinSize(20, 20);
    	hb.getChildren().addAll(getAreaChart(),btn);
    
        Scene scene = new Scene(hb,800,600);
        this.stage = stage;
        this.stage.setScene(scene);
        w=this.stage.getWidth();
        h=this.stage.getHeight();
   	   this.stage.widthProperty().addListener(this);
       this.stage.heightProperty().addListener(this);
       
       System.out.println(w+"----"+this.stage.getWidth()+"---"+h);
       
       this.stage.show();
    }

    private void resize(double width, double height) {
		// relayout the application to match given size
    	
	}
    
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

	@Override
	public void changed(ObservableValue<? extends Number> observable,
			Number oldValue, Number newValue) {
		resize(stage.getWidth(), stage.getHeight());
	
		double s = btn.getWidth()*(stage.getWidth()/w)*100;
		double sh = btn.getHeight()*(stage.getHeight()/h)*100;
		btn.setMinSize(s, sh);
		System.out.println(sh+"--"+w+"---brubah--"+stage.getWidth()+"---"+s);
		
	}
	
	
}
