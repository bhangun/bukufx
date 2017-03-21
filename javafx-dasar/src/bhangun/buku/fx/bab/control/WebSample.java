package bhangun.buku.fx.bab.control;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Callback;
 
public class WebSample extends Application {
 
    private Scene scene;
 
    @Override public void start(Stage stage) {
        // create scene
        stage.setTitle("Web View");
        VBox root = new VBox();
        root.getChildren().addAll(new Browser(), new Browser());
        scene = new Scene(root,590,610, Color.web("#666970"));
        stage.setScene(scene);
        scene.getStylesheets().add("webviewsample/BrowserToolbar.css");
        // show stage
        stage.show();
    }
 
    public static void main(String[] args){
        launch(args);
    }
}
class Browser extends Region {
 
   private HBox toolBar;
 
   private static String[] imageFiles = new String[]{
        "/bhangun/book/resources/check.png",
        "/bhangun/book/resources/check.png",
        "/bhangun/book/resources/check.png",
        "/bhangun/book/resources/check.png"        
    };
    private static String[] captions = new String[]{
        "Products",
        "Blogs",
        "Forums",
        "Partners"
        
    };
 
    private static String[] urls = new String[]{
        "http://www.oracle.com/products/index.html",
        "http://blogs.oracle.com/",
        "http://forums.oracle.com/forums/main.jspa",
        "http://www.oracle.com/partners/index.html"        
    };
 
    final ImageView selectedImage = new ImageView();
    final Hyperlink[] hpls = new Hyperlink[captions.length];
    final Image[] images = new Image[imageFiles.length];
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
    final Button hideAll = new Button("Hide All");
    final Button showAll = new Button("ShowAll");
    final WebView smallView = new WebView();
    final SepiaTone effect = new SepiaTone();          
 
    public Browser() {
        browser.setOpacity(0.5);
        effect.setLevel(0.6);
        browser.setEffect(effect);      
        
        //apply the styles
        getStyleClass().add("browser");
 
        // load the home page        
        webEngine.load("http://www.oracle.com/products/index.html");
        
        for (int i = 0; i < captions.length; i++) {
            final Hyperlink hpl = hpls[i] = new Hyperlink(captions[i]);
            final Image image = images[i] =
                    new Image(getClass().getResourceAsStream(imageFiles[i]));
            hpl.setGraphic(new ImageView (image));
            final String url = urls[i];
 
            hpl.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    webEngine.load(url);
                    if (hpl.getText().equals("Forums")){
                        toolBar.getChildren().removeAll(showAll, hideAll);
                        toolBar.getChildren().addAll(showAll, hideAll);
                    } else
                    {
                        toolBar.getChildren().removeAll(showAll, hideAll);
                        
                    }
                    toolBar.getChildren().remove(smallView);
                }
            });
        }        
        // create the toolbar
        toolBar = new HBox();
        toolBar.setAlignment(Pos.CENTER);
        toolBar.getStyleClass().add("browser-toolbar");
        toolBar.getChildren().addAll(hpls);
 
        toolBar.getChildren().add(createSpacer());
 
        hideAll.setOnAction(new EventHandler() {
            @Override public void handle(Event t) {
                webEngine.executeScript("hideAll()"); 
            }
        });
        
 
        showAll.setOnAction(new EventHandler() {
            @Override public void handle(Event t) {
                webEngine.executeScript("showAll()");                
            }
        });
        
    
        //add components
        getChildren().add(toolBar);
        getChildren().add(browser);
     
        //applying effects
        browser.addEventHandler(MouseEvent.MOUSE_ENTERED,
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    browser.setOpacity(1.0);
                    effect.setLevel(0.0);
                }
        });
        browser.addEventHandler(MouseEvent.MOUSE_EXITED,
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    browser.setOpacity(0.5);
                    effect.setLevel(0.5);
                }
        });
               
        smallView.setPrefSize(120, 80);                                    
        webEngine.setCreatePopupHandler(
            new Callback<PopupFeatures, WebEngine>() {
                @Override public WebEngine call(PopupFeatures config) {                
                    smallView.setFontScale(0.8);
                    if (!toolBar.getChildren().contains(smallView)) {
                        toolBar.getChildren().add(smallView);
                    }                
                    return smallView.getEngine();
                }
        });
 
    }
 
    private Node createSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }
 
    @Override protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        double tbHeight = toolBar.prefHeight(w);
        layoutInArea(browser,0,0,w,h-tbHeight,0, HPos.CENTER, VPos.CENTER);
        layoutInArea(toolBar,0,h-tbHeight,w,tbHeight,0,HPos.CENTER,VPos.CENTER);
    }
 
    @Override protected double computePrefWidth(double height) {
        return 800;
    }
 
    @Override protected double computePrefHeight(double width) {
        return 600;
    }
}

