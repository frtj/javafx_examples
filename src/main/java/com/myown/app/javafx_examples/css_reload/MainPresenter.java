package com.myown.app.javafx_examples.css_reload;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class MainPresenter extends AbstractController {
	//com.myown.app.javafx_examples.css_reload.MainPresenter
	
	@FXML 
	private VBox contentArea;
		
    private AbstractController nameFormPresenter;

	public AbstractController getNameFormPresenter() {
		return nameFormPresenter;
	}

	public void setNameFormPresenter(AbstractController nameFormPresenter) {
		this.nameFormPresenter = nameFormPresenter;
	}
		
    public void showNameForm()
    {
    	contentArea.getChildren().clear();
    	contentArea.getChildren().add(nameFormPresenter.getView());
    }
}
