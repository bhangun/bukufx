package bhangun.buku;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class Home extends BaseFX {
	
	@FXML private AnchorPane root;
	private DisysManager manager;
	
	public Home(){
		
	}

	public void setManager(DisysManager disysManager) {
		manager = disysManager;
	}

	public AnchorPane getRoot() {
		return root;
	}
	
	public void logoutAction(ActionEvent event){
		manager.removeComponent(0);
		
	}

}
