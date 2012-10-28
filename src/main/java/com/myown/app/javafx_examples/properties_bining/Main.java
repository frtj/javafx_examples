package com.myown.app.javafx_examples.properties_bining;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception
    {
		Model model = new Model();
		Scene scene = new Scene(new View(model), 200, 100);
        
        stage.setScene(scene);
        stage.setTitle("Test");
        stage.show();
    }
	
	class Model
	{
		private StringProperty text = new SimpleStringProperty("");

		public StringProperty textProperty() { 
	    	return text; 
	    }
	    public String getText() { 
	    	return textProperty().get(); 
	    }
	    public void setText(String text) { 
	    	textProperty().set(text); 
	    }
	}
	
	class View extends Pane
	{
		private Model model;

		public View(Model model) {
			this.model = model;
			buildView();
		}
		
		private void buildView()
		{
			VBox vbox = new VBox();
			
			Button button = new Button("Uppercase!!!");
		    button.setMinWidth(Control.USE_PREF_SIZE);
		    button.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					System.out.println(model.getText());
					model.setText(model.getText().toUpperCase());
				}
			});
			
			TextField txf = new TextField();
			txf.textProperty().bindBidirectional(model.textProperty());
			
			Label label = new Label("text to uppercase");
			vbox.getChildren().addAll(label, txf, button);
			getChildren().add(vbox);
		}
	}
}

