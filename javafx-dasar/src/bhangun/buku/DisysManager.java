package bhangun.buku;



import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;




/**
 * 
 * @author bhangun
 *
 */
public class DisysManager {
	
	private StackPane mainPanel;
	private BuilderFXML factory;

	private Home home;
	private Scene scene;
	
	public DisysManager(){
		mainPanel = new StackPane();
		
		factory = new BuilderFXML();
		
	}
	
	
	
	protected void removeComponent(int comp){
		mainPanel.getChildren().remove(comp);
	}
	
	public Parent getRoot(){
		mainPanel.setId("mainPanel");
		return mainPanel;
	}
	
	
	public Scene getScene(){
        scene = new Scene(getRoot(),1000,700);
        scene.getStylesheets().add("syarikah/disys/view/styles.css");
        return scene;
	}
}
