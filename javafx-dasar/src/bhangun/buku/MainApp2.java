/**
 * 
 */
package bhangun.buku;

import java.io.File;

import bhangun.buku.fx.bab.control.ButtonSample;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPaneBuilder;
import javafx.scene.control.Tab;
import javafx.scene.control.TabBuilder;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPaneBuilder;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeItemBuilder;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPaneBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Stage;

/**
 * @author bhangun
 *
 */
public class MainApp2 extends Application {

	public static void main(String[] args) {
        Application.launch(MainApp2.class, args);
    }


	private TreeView<String> tree;
    
    @Override
    public void start(Stage stage) throws Exception { 
    	//new DisysFactory().loadFXML("main").getController();

       // stage.setScene(new Scene((Parent)new DisysFactory().loadFXML("main").getRoot()));//BuilderFXML.setFXML("main").loadFXML().getScene());
    	TabPane pane =TabPaneBuilder.create()
    			.tabs(tab(tombol(),"Button"))
    			.build();
    			
    	Scene scene =new Scene((Parent)pane);
    	stage.setScene(scene);
    	stage.setWidth(800);
    	stage.setHeight(500);
    	stage.setTitle("Mengenal JavaFX 2.0");
        stage.show();
    }
    
    @SuppressWarnings("rawtypes")
	public TreeView addTree(String name,String parent){
    	String root = "Komponen";
		TreeItem<String> rootItem = new TreeItem<String> (root);
        rootItem.setExpanded(true);
        
        if(parent.equals(root)){
        	 TreeItem<String> item = new TreeItem<String> (name);  
        	 rootItem.getChildren().add(item);
        }else{
        	//rootItem.nextSibling(rootItem.getChildren())
        }
        
       
      // tree = new TreeView<String> (rootItem);  
        return tree;
	}
    
    private TreeItem<String> createNode(final String f) {
        return new TreeItem<String>(f) {
            private boolean isLeaf;
            private boolean isFirstTimeChildren = true;
            private boolean isFirstTimeLeaf = true;
             
            @Override public ObservableList<TreeItem<String>> getChildren() {
                if (isFirstTimeChildren) {
                    isFirstTimeChildren = false;
   
                    super.getChildren().setAll(buildChildren(this));
                }
                return super.getChildren();
            }

            @Override public boolean isLeaf() {
                if (isFirstTimeLeaf) {
                    isFirstTimeLeaf = false;
                    String f = (String) getValue();
                 //   isLeaf = f.isFile();
                }

                return isLeaf;
            }
   
            private ObservableList<TreeItem<String>> buildChildren(TreeItem<String> TreeItem) {
            	String f = TreeItem.getValue();
               /* if (f != null && f.isDirectory()) {
                	String[] files = f.listFiles();
                    if (files != null) {
                        ObservableList<TreeItem<String>> children = FXCollections.observableArrayList();

                        for (File childFile : files) {
                            children.add(createNode(childFile));
                        }

                        return children;
                    }
                }*/

                return FXCollections.emptyObservableList();
            }
        };
    }
    
    private Tab tab(Node content,String title){
    	Tab tab=TabBuilder.create()
    			.content(content)
    			.closable(false)
    			.text(title)
    			.build();
    	return tab;
    }
    
    
    private ScrollPane tombol(){
    	ButtonSample t=new ButtonSample();
    	VBox box= VBoxBuilder.create()
    			.children(t.buildButton1(),	
    					t.buildButton2(),
    					t.buildButton3(),
    					t.buildButton4(),
    					t.buildButton5(),
    					t.buildButton6(),
    					t.buildButton7(),t.buildButton8())
    			.padding(new Insets(10,10,10,10))
    			.spacing(10)
    			.build();
    	
    	return ScrollPaneBuilder.create().content(box).build();
    }

	

}
