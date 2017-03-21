package bhangun.buku;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;


/**
 * 
 * @author bhangun
 *
 */
public class DisysFactory {
	
	

	private DisysManager manager;
	private Home home;
	private Scene scene;
	private FXMLLoader loader;
	private String path="/bhangun/fxml/";
	public DisysFactory(){
		
	}
	
	public Scene getScene(){
        scene = new Scene((Parent) loader.getRoot(),1000,700);
       // scene.getStylesheets().add("bhangun/fxml/styles.css");
        return scene;
	}
	
	public FXMLLoader loadFXML(String fxml){
		 loader = new FXMLLoader();
        try {
			loader.load(getClass().getResourceAsStream(path+fxml+".fxml"));		
		} catch (IOException e) {
			throw new RuntimeException("Unable to load "+path, e);
		}
		return loader;
	}
}
