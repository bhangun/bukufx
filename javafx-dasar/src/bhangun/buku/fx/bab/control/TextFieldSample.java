package bhangun.buku.fx.bab.control;

import bhangun.buku.BaseComponent;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPaneBuilder;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFieldBuilder;
import javafx.scene.effect.ReflectionBuilder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;



/**
 * 
 * @author bhangun
 * @since 2012
 * {@link http://bhangun.in}
 *
 */
public class TextFieldSample extends BaseComponent{
	
	
	private Image IMAGE =new Image(getClass().getResourceAsStream("/bhangun/book/resources/icon_all_01.png"));
	
	public TextField textField1(){
		TextField field = new TextField();
		field.prefHeight(10);
		field.prefWidth(100);
		return field;
	}
	
	public TextField textField2(){
		return TextFieldBuilder.create()
						.text("nama")
						.prefHeight(20)						
						.prefWidth(100)
						.maxWidth(100)
						.build();
	}
	
	public TextField textField3(){
		return TextFieldBuilder.create()
						.prefHeight(20)
						.alignment(Pos.BASELINE_RIGHT)				
						.promptText("nama")
						.prefWidth(100)						
						.build();
	}
	
	
	public VBox textField4(){
		TextField field =TextFieldBuilder.create()
						.prefHeight(20)
						.promptText("nama")
						.prefWidth(100)						
						.build();
		
		Label label = new Label();
		Label label2 = new Label("xxxx");
		label.textProperty().bind(field.textProperty());
		label.setLabelFor(field);
		field.setStyle("-fx-border-color: #23ff45; -fx-border-width: 1px");
		//field.
		//field.onInputMethodTextChangedProperty());
			
		
		
		
		VBox box=VBoxBuilder.create().build();
		box.getChildren().addAll(label,field);
		
		return box;
	}
	
	public TextField textField5(){
		return TextFieldBuilder.create()
						.prefHeight(20)
						.promptText("nama")
						.prefWidth(100)	
						.effect(ReflectionBuilder
								.create()
								.fraction(5)
								.bottomOpacity(10)
								.build())
						.build();
	}
	
	public Button textField6(){
		ImageView  img = ImageViewBuilder.create()
				.image(IMAGE)
				.viewport(
						new Rectangle2D(62,62,54,58))
				.build();
		Button btn = ButtonBuilder.create()
				.graphic(img)
				.text("Tombol 6")
				.build();
		return btn;
	}
	
	boolean open=true;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Button textField7(){
		
		return null;
	}
	
	public PasswordField textField8(){
		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("Your password");

		return passwordField;
	}

	public ScrollPane getAll(){
    
    	VBox box= VBoxBuilder.create()
    			.children(textField1(),	
    					textField2() ,
    					textField3(),
    					textField4(),
    					textField5()
    					//textField6(),
    					//textField7()
    					)
    			.padding(new Insets(10,10,10,10))
    			.spacing(10)
    			.build();
    	
    	return ScrollPaneBuilder.create().content(box).build();
    }


}
