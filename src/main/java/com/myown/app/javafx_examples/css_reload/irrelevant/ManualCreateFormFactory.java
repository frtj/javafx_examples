package com.myown.app.javafx_examples.css_reload.irrelevant;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.GridPaneBuilder;
import javafx.scene.paint.Color;

/*
 * dead code. But this is how the layout could be created manually.
 * Notice the use of JavaFX builders...
 */
public class ManualCreateFormFactory {

	public static Scene createGridPaneScene() {
		GridPane gridpane = GridPaneBuilder.create()
				.padding(new Insets(5))
				.hgap(5)
				.vgap(5)
				.styleClass("mygrid")
				.build();

		Scene scene = SceneBuilder.create()
				.width(380)
				.height(118)
				.fill(Color.WHITE)
				.root(GroupBuilder.create().children(gridpane).build()).build();
		
		Label fNameLbl = new Label("First Name");
		TextField fNameFld = new TextField();
		Label lNameLbl = new Label("Last Name");
		TextField lNameFld = new TextField();
		Button saveButt = new Button("Save");

		// First name label
		GridPane.setHalignment(fNameLbl, HPos.RIGHT);
		gridpane.add(fNameLbl, 0, 0);

		// Last name label
		GridPane.setHalignment(lNameLbl, HPos.RIGHT);
		gridpane.add(lNameLbl, 0, 1);

		// First name field
		GridPane.setHalignment(fNameFld, HPos.LEFT);
		gridpane.add(fNameFld, 1, 0);

		// Last name field
		GridPane.setHalignment(lNameFld, HPos.LEFT);
		gridpane.add(lNameFld, 1, 1);

		// Save button
		GridPane.setHalignment(saveButt, HPos.RIGHT);
		gridpane.add(saveButt, 1, 2);

		return scene;
	}

}
