package bhangun.buku.fx.bab.chart;

import java.util.ArrayList;
import java.util.List;

import bhangun.buku.fx.bab.others.Produk;
import bhangun.buku.fx.bab.others.TabelContoh.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
 
public class LineChartSample extends Application {

	private TableView<Produk> table = new TableView<Produk>();
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private final ObservableList data = FXCollections.observableArrayList(
    		 new XYChart.Data(new PropertyValueFactory<Produk,Integer>("harga"),
    				 new PropertyValueFactory<Produk,Integer>("tahun")));
        		
	 public static void main(String[] args) {
	        launch(args);
	    }
	 
    @Override
    public void start(final Stage stage) {
        stage.setTitle("");
        stage.setWidth(500);
        stage.setHeight(500);
        Scene scene = new Scene(getLineChart2());
       
        stage.setScene(scene);
        stage.show();
    }
 
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public HBox getLineChart2() {
        
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart lineChart = new LineChart(xAxis,yAxis);
                
        lineChart.setTitle("Stock Monitoring, 2010");
        
        //defining a series
        XYChart.Series series = new XYChart.Series(data);
       // series.getData().add(data);
        series.setName("My portfolio");
        
        final Label label = new Label("Kenaikan Harga Cabe");
        label.setFont(new Font("Arial", 20));
        
        TableColumn produk = new TableColumn("Nama Produk");
        produk.setMinWidth(200);
        produk.setCellValueFactory(
                new PropertyValueFactory<Produk,String>("nama")
        );
        
        TableColumn harga = new TableColumn("Harga");
        harga.setCellValueFactory(
            new PropertyValueFactory<Produk,String>("harga")
        );
 
        TableColumn tahun = new TableColumn("Tahun");
        tahun.setCellValueFactory(
        		new PropertyValueFactory<Produk,String>("tahun")
        );
 
       
 
        table.setItems(data);
        table.getColumns().addAll(produk, harga, tahun);
 
        final TextField fproduk = new TextField();
        fproduk.setPromptText("Nama Produk");
        fproduk.setMaxWidth(produk.getPrefWidth());
        final TextField fharga = new TextField();
        fharga.setMaxWidth(harga.getPrefWidth());
        fharga.setPromptText("Harga");
        final TextField ftahun = new TextField();
        ftahun.setMaxWidth(tahun.getPrefWidth());
        ftahun.setPromptText("Tahun");
        
        
        //Using a Cell Factory //---------------------------------------------------------------------------------------------
        Callback<TableColumn, TableCell> cellFactory = 
        	    new Callback<TableColumn, TableCell>() {
        	        public TableCell call(TableColumn p) {
        	            return null;//new EditingCell();
        	    }
        	};

        	produk.setCellFactory(cellFactory);
        	harga.setCellFactory(cellFactory);
        	tahun.setCellFactory(cellFactory);
      //---------------------------------------------------------------------------------------------
        	
      //Enabling editing//---------------------------------------------------------------------------------------------
        table.setEditable(true);

        //Modifying the firstName property
        produk.setOnEditCommit(new EventHandler<CellEditEvent<Produk, String>>() {
            @Override public void handle(CellEditEvent<Produk, String> t) {
             //   ((Produk)t.getTableView().getItems().get(
                  //  t.getTablePosition().getRow())).setNama(t.getNewValue());
            }
        });

        //Modifying the lastName property
        harga.setOnEditCommit(new EventHandler<CellEditEvent<Produk, String>>() {
            @Override public void handle(CellEditEvent<Produk, String> t) {
               // ((Produk)t.getTableView().getItems().get(
                 //   t.getTablePosition().getRow())).setLastName(t.getNewValue());
            }
        }); 

        //Modifying the email property
        tahun.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
            @Override public void handle(CellEditEvent<Person, String> t) {
                ((Person)t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setEmail(t.getNewValue());
             }
        });
      //---------------------------------------------------------------------------------------------
 
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                data.add(new Produk(fproduk.getText(),   
                		(fharga.getText()!=null? Integer.parseInt(fharga.getText()):0),
                        (ftahun.getText()!=null? Integer.parseInt(ftahun.getText()):0)));
                fproduk.setText("");
                fharga.setText("");
                ftahun.setText("");
            }
        });
        
        HBox hb = new HBox();
        hb.getChildren().addAll(fproduk, fharga, ftahun, addButton);
        hb.setSpacing(3);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().addAll(label, table, hb);
        vbox.setPadding(new Insets(10, 0, 0, 10));
       
       
       // ObservableList data = FXCollections.observableArrayList();
     
        lineChart.getData().add(series);
       
        HBox box = new HBox();
        box.getChildren().addAll(lineChart,table);
        return box;
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
        
     //   new XYChart.Data<Produk,Produk>(nama,harga);
        
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
}
