package com.myown.app.javafx_examples.css_reload;

import javafx.scene.layout.Region;

public interface Controller {
	
	Region getView();

    /**
     * This method is needed because @FXML is not allowed in Abstract classes.
     */
	void setView(Region view);
}
