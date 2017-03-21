package bhangun.buku.fx.bab.others;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
 
public class TabelContoh extends Application {
 
    public static class Person {
 
        private final StringProperty firstName;
        private final StringProperty lastName;
        private final StringProperty email;
 
        private Person(String fName, String lName, String email) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
        }
 
        public String getFirstName() {
            return firstName.get();
        }
 
        public void setFirstName(String fName) {
            firstName.set(fName);
        }
 
        public String getLastName() {
            return lastName.get();
        }
 
        public void setLastName(String fName) {
            lastName.set(fName);
        }
 
        public String getEmail() {
            return email.get();
        }
 
        public void setEmail(String fName) {
            email.set(fName);
        }
 
    }
    private TableView<Person> table = new TableView<Person>();
    private final ObservableList<Person> data = 
        FXCollections.observableArrayList(
            new Person("Jacob", "Smith", "jacob.smith@example.com"),
            new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
            new Person("Ethan", "Williams", "ethan.williams@example.com"),
            new Person("Emma", "Jones", "emma.jones@example.com"),
            new Person("Michael", "Brown", "michael.brown@example.com")
        );
 
    private HBox hb = new HBox();
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(400);
        stage.setHeight(500);
 
        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));
 
        TableColumn firstNameCol = new TableColumn("First");
        firstNameCol.setCellValueFactory(
            new PropertyValueFactory<Person,String>("firstName")
        );
 
        TableColumn lastNameCol = new TableColumn("Last");
        lastNameCol.setCellValueFactory(
            new PropertyValueFactory<Person,String>("lastName")
        );
 
        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("email")
        );
 
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
 
        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("Last Name");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("Last Name");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Email");
        
        
        //Using a Cell Factory //---------------------------------------------------------------------------------------------
        Callback<TableColumn, TableCell> cellFactory = 
        	    new Callback<TableColumn, TableCell>() {
        	        public TableCell call(TableColumn p) {
        	            return new EditingCell();
        	    }
        	};

        	firstNameCol.setCellFactory(cellFactory);
        	lastNameCol.setCellFactory(cellFactory);
        	emailCol.setCellFactory(cellFactory);
      //---------------------------------------------------------------------------------------------
        	
      //Enabling editing//---------------------------------------------------------------------------------------------
        table.setEditable(true);

        //Modifying the firstName property
        firstNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
            @Override public void handle(CellEditEvent<Person, String> t) {
                ((Person)t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setFirstName(t.getNewValue());
            }
        });

        //Modifying the lastName property
        lastNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
            @Override public void handle(CellEditEvent<Person, String> t) {
                ((Person)t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setLastName(t.getNewValue());
            }
        }); 

        //Modifying the email property
        emailCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
            @Override public void handle(CellEditEvent<Person, String> t) {
                ((Person)t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setEmail(t.getNewValue());
             }
        });
      //---------------------------------------------------------------------------------------------
 
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                data.add(new Person(
                        addFirstName.getText(),
                        addLastName.getText(),
                        addEmail.getText()
                        ));
                addFirstName.setText("");
                addLastName.setText("");
                addEmail.setText("");
            }
        });
 
        hb.getChildren().addAll(addFirstName, addLastName, addEmail, addButton);
        hb.setSpacing(3);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().addAll(label, table, hb);
        vbox.setPadding(new Insets(10, 0, 0, 10));
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
}

