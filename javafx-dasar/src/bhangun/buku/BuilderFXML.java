package bhangun.buku;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;



/**
 * 
 * @author bhangun
 *
 */
public class BuilderFXML extends FXMLLoader {
	
	private static BuilderFXML loader;
	private final static String PATH="bhangun/fxml/";
	private static Scene scene;
	private static String fxml;
	
	public BuilderFXML(){
		System.out.println("sdfsfsdfsdfsfsdf------------------");
	}
	
	
	public Scene getScene(){
        scene = new Scene((Parent) loader.getRoot(),1000,700);
       // scene.getStylesheets().add("bhangun/fxml/styles.css");
        return scene;
	}
	public static  BuilderFXML setFXML(String name){
		fxml = name;
		loader = new BuilderFXML();
		return loader;
	}
	
	
	public BuilderFXML loadFXML(){
		
		try {
			FXMLLoader load = new FXMLLoader();
			load.load(getClass().getResourceAsStream(PATH+fxml+".fxml"));	
			loader = (BuilderFXML)load;
		} catch (IOException e) {
			throw new RuntimeException("Unable to load "+fxml+".fxml : ", e);
		}
	return loader;
	}
	/*private InputStream getFile(String fxml){
		String p=PATH+fxml+".fxml";
		System.out.println(p);
		return getClass().getResourceAsStream(PATH+fxml+".fxml");
	}
	
	
	static public BuilderFXML loadFXML(String fxml){
		BuilderFXML loader = new BuilderFXML();
		//FXMLLoader.load(this.getResource(PATH+fxml+".fxml"));
        try {
        	//loader.setLocation(new URL(PATH+fxml+".fxml"));
			loader.load(stream);	
		} catch (IOException e) {
			throw new RuntimeException("Unable to load "+fxml+".fxml : ", e);
		}
		return loader;
	}*/
}
