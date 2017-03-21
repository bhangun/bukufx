package bhangun.buku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bhangun.buku.fx.bab.animation.AnimationSample;
import bhangun.buku.fx.bab.chart.ChartSample;
import bhangun.buku.fx.bab.control.ButtonSample;
import bhangun.buku.fx.bab.control.CheckboxSample;
import bhangun.buku.fx.bab.control.ChoiceboxSample;
import bhangun.buku.fx.bab.control.HyperlinkSample;
import bhangun.buku.fx.bab.control.LabelSample;
import bhangun.buku.fx.bab.control.ListviewSample;
import bhangun.buku.fx.bab.control.MediaSample;
import bhangun.buku.fx.bab.control.MenuSample;
import bhangun.buku.fx.bab.control.ProgressbarSample;
import bhangun.buku.fx.bab.control.RadioButtonSample;
import bhangun.buku.fx.bab.control.ScrollbarSample;
import bhangun.buku.fx.bab.control.SliderSample;
import bhangun.buku.fx.bab.control.TableviewSample;
import bhangun.buku.fx.bab.control.TextFieldSample;
import bhangun.buku.fx.bab.control.TextSample;
import bhangun.buku.fx.bab.control.TitlepaneSample;
import bhangun.buku.fx.bab.control.ToggleSample;
import bhangun.buku.fx.bab.control.TooltipSample;
import bhangun.buku.fx.bab.control.TreeViewSample;
import bhangun.buku.fx.bab.effect.ContohPerspectiveTransform;
import bhangun.buku.fx.bab.layout.SeparatorSample;
import bhangun.buku.fx.bab.view.HTMLEditorSample;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabBuilder;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPaneBuilder;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPaneBuilder;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;


/**
 * @author bhangun
 *
 */
public class MainApp extends Application {
	
	private final Node rootIcon = new ImageView(new Image(getClass()
			.getResourceAsStream("/bhangun/book/resources/brainstorming.png")));
	
	private final String TITLE="Mengenal JavaFX 2.0";
	
	private String[] cat = {"Control", 			"Layout", 		"Container", 	"Multimedia",
							"Label & Text",		"Effect",		"Animation",	"Chart"};
	
	private String[] komp = {	"Animation", 	"Button", 		"Chart",		"Checkbox",		"ChoiceBox",
								"Effect",		"HTMLEditor",	"Hyperlink",	"Label",		"ListView",
								"Media",		"Menu",			"ProgressBar",	"RadioButton",	"Scrollbar",
								"Separator",	"Slider",		"TableView",	"Text",			"TextField", 	
								"TitlePane",	"Toggle",		"Tooltip", 		"TreeView"};
	private TreeView<Text> tree;

	private StackPane content;
	
	private List<Komponen> komponen = Arrays.<Komponen>asList(
				new Komponen(komp[0], cat[5],new AnimationSample().getAll()),	            
	            new Komponen(komp[1], cat[0],new ButtonSample().getAll()),
	            new Komponen(komp[2], cat[0],new ChartSample().getAll()),
	            new Komponen(komp[3], cat[0],new CheckboxSample().getAll()),
	            new Komponen(komp[4], cat[0],new ChoiceboxSample().getAll()),
	            new Komponen(komp[5], cat[5],new ContohPerspectiveTransform().getAll()),
	            new Komponen(komp[6], cat[0],new HTMLEditorSample().getAll()),
	            new Komponen(komp[7], cat[0],new HyperlinkSample().getAll()),
	            new Komponen(komp[8], cat[4],new LabelSample().getAll()),
	            new Komponen(komp[9], cat[0],new ListviewSample().getAll()),
	            new Komponen(komp[10], cat[3],new MediaSample().getAll()),
	            new Komponen(komp[11], cat[0],new MenuSample().getAll()),
	            new Komponen(komp[12], cat[0],new ProgressbarSample().getAll()),
	            new Komponen(komp[13], cat[0],new RadioButtonSample().getAll()),
	            new Komponen(komp[14], cat[1],new ScrollbarSample().getAll()),
	            new Komponen(komp[15], cat[1],new SeparatorSample().getAll()),
	            new Komponen(komp[16], cat[0],new SliderSample().getAll()),
	            new Komponen(komp[17], cat[0],new TableviewSample().getAll()),
	            new Komponen(komp[18], cat[4],new TextSample().getAll()),	                     
	            new Komponen(komp[19], cat[0],new TextFieldSample().getAll()),
	            new Komponen(komp[20], cat[1],new TitlepaneSample().getAll()),
	            new Komponen(komp[21], cat[0],new ToggleSample().getAll()),
	            new Komponen(komp[22], cat[0],new TooltipSample().getAll()),
	            new Komponen(komp[23], cat[0],new TreeViewSample().getAll())
	            );
	    
	public static void main(String[] args) {
        Application.launch(MainApp.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception { 		
    	
    	Scene scene =new Scene(panes(initTree(),initPane()));
    	stage.setScene(scene);
    	stage.setWidth(800);
    	stage.setHeight(500);
    	stage.setTitle(TITLE);
        stage.show();
    }
    
    private void setContent(ScrollPane node,String name){
    	TabPane pane =TabPaneBuilder.create()
    			.prefHeight(500)
    			.prefWidth(600)
    			.tabs(tab(node,name))
    			.build();	
    	content.getChildren().add(pane);
    }
    
    private void removeContent(Node node,int index){
    	if (node==null)
    		content.getChildren().remove(index);
    	else
    		content.getChildren().remove(node);
    }
    
    
    private StackPane initPane(){
    	content = StackPaneBuilder.create().build();
    	return content;
    }
    
    @SuppressWarnings("rawtypes")
	private TreeView initTree(){
    
    	TreeItem<Text> rootNode = new TreeItem<Text>(TextBuilder.create().text("Mengenal Komponen JavaFX").build());//, rootIcon);
        rootNode.setExpanded(true);
        for (Komponen komp : komponen) {
            TreeItem<Text> empLeaf = new TreeItem<Text>(TextBuilder.create().text(komp.getName()).build());
            boolean found = false;
            for (TreeItem<Text> catNode : rootNode.getChildren()) {
                if (catNode.getValue().getText().contentEquals(komp.getCategory())){              	
                	catNode.getChildren().add(empLeaf);               	
                    found = true;
                    break;
                }
            }
            if (!found) {
                TreeItem<Text> depNode = new TreeItem<Text>(TextBuilder.create().text(komp.getCategory()).build());          
                rootNode.getChildren().add(depNode);
                depNode.getChildren().add(empLeaf);
            }
        }
 
        tree = new TreeView<Text> (rootNode);  
        tree.autosize();     
        tree.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {  
            	if(e.getTarget()!=null){
            		if(e.getTarget() instanceof Text){
            			Text t= (Text)e.getTarget();
            			 for (Komponen komp : komponen) {
            				 if (t.getText().equals(komp.getName())){
            					 	if(content.getChildren()!=null){
            					 		if(content.getChildren().contains(komp.getNode()))
            					 			content.getChildren().remove(0);
            					 		else
            					 			setContent(komp.getNode(),komp.getName());
            					 	}
            				 }
            			 }
            		}
            	}
            };
        });
        return tree;
	}
    
   
    private Tab tab(Node content,String title){
    	Tab tab=TabBuilder.create()
    			.content(content)
    			.closable(false)
    			.text(title)
    			.build();
    	return tab;
    }
    
    private HBox panes(Node... nodes){
    	return HBoxBuilder.create().children(nodes).build();
    }
    
   
    
    public static class Komponen {
    	 
        private final SimpleStringProperty name;
        private final SimpleStringProperty category;
        private ScrollPane node;
 
        public ScrollPane getNode() {
			return node;
		}
        public void setNode(ScrollPane node) {
			this.node = node;
		}

		private Komponen(String name, String category,ScrollPane node) {
            this.name = new SimpleStringProperty(name);
            this.category = new SimpleStringProperty(category);
            this.node = node;
        }
 
        public String getName() {
            return name.get();
        }
 
        public void setName(String name) {
            this.name.set(name);
        }
 
        public void setCategory(String category) {
			this.category.set(category);
		}

		public String getCategory() {
			return category.get();
		}
    }
	

}
