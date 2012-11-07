package com.myown.app.javafx_examples.css_reload;

import javafx.scene.layout.Region;

public class AbstractController implements Controller {

	private Region view;

	public AbstractController() {
		super();
	}

	public Region getView() {
	    return view;
	}

	public void setView(Region view) {
	    this.view = view;
	}

}