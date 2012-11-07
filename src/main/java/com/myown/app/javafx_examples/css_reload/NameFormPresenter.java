package com.myown.app.javafx_examples.css_reload;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NameFormPresenter extends AbstractController implements Initializable {
	//com.myown.app.javafx_examples.css_reload.NameFormPresenter

	@FXML 
    private Node root;
    
    @FXML 
    private TextField firstnameField;
    
    @FXML 
    private TextField lastnameField;
    
    @FXML
    private Button submitButton;

    private MainPresenter mainPresenter;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		submitButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("OMG!!! I GOT PUSHED");
			}
		});		
	}

	public void setMainPresenter(MainPresenter mainPresenter) {
		this.mainPresenter = mainPresenter;
	}
}
