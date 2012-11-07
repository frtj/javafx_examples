package com.myown.app.javafx_examples.css_reload;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import com.javafx.experiments.scenicview.ScenicView;

public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		ControllerFactory factory = new ControllerFactory();
		MainPresenter mainPresenter = factory.getMainPresenter();
		mainPresenter.showNameForm();
	    final Scene scene = new Scene(mainPresenter.getView());

        stage.setScene(scene);
        stage.setHeight(200);
		
		stage.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {      
        	@Override public void handle(KeyEvent keyEvent) {
        		if( keyEvent.getCode().equals(KeyCode.F5))
        		{
        			System.out.println("F5 pressed");
        			
        			scene.getStylesheets().addAll(Main.class.getResource(getCssFile()).toExternalForm());
        			com.sun.javafx.css.StyleManager.getInstance().reloadStylesheets(scene);
        		}
    		}    
    	}); 
		
		// debugging, but very little css at this point
//		ScenicView.show(scene); 

		stage.setTitle("Demo css reload");
		stage.show();
	}

	private int valg = 0;

	private String[] cssFiles = new String[] { "mycss1.css", "mycss2.css" };

	public String getCssFile() {
		if (valg > cssFiles.length - 1)
			valg = 0;
		return "/css_reload/" + cssFiles[valg++];
	}
}
