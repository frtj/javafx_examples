package com.myown.app.javafx_examples.text_wordwrap;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{
	
	private static final String SMALL_CONTENT = "Lorem ipsum dolor sit amet";
	private static final String BIG_CONTENT = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod" +
	" tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, " +
	"quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo" +
	" consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie" +
	" consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto" +
	" odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait" +
	" nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet" +
	" doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam;" +
	" est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt " +
	"lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus," +
	" qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica," +
	" quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula " +
	"quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, " +
	"fiant sollemnes in futurum.";

	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception
    {
		Scene scene = new Scene(new View(), 300, 250);
        
        stage.setScene(scene);
        stage.setTitle("Test");
        stage.show();
    }
	
	
	class View extends Pane
	{
		private boolean toggle = false;
		
		public View()
		{
			buildView();
		}
		
		private void buildView()
		{
			VBox vbox = new VBox();
			
		    final Text text = new Text(SMALL_CONTENT);
		    text.setWrappingWidth(getWidth() - 15);
			
			widthProperty().addListener( new ChangeListener<Object>() {
		    	public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) 
		    	{ 
		    		Double width = (Double)newValue;    
		    		text.setWrappingWidth(width -15);
		    	}    
		    });
			
			Button button = new Button("Change..");
		    button.setMinWidth(Control.USE_PREF_SIZE);
		    button.setOnAction(new EventHandler<ActionEvent>() {
		        @Override public void handle(ActionEvent e) {
		        	toggle = !toggle;
		        	if( toggle )
		        	{       		
		        		text.setText(SMALL_CONTENT);
		        	}
		        	else
		        	{
		        		text.setText(BIG_CONTENT);
		        	}
		        }	        
		    });
			vbox.getChildren().addAll(button,text);
			getChildren().add(vbox);
		}
	}
}
