package com.myown.app.javafx_examples.css_reload;

import java.io.IOException;
import java.io.InputStream;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

public class ControllerFactory {

	private AbstractController nameFormPresenter;
	private MainPresenter mainPresenter;

	public MainPresenter getMainPresenter() {
		if (mainPresenter == null) {
			mainPresenter = loadController("/css_reload/fxml/main.fxml", MainPresenter.class);
			mainPresenter.setNameFormPresenter(getNameFormPresenter());
		}
		return mainPresenter;
	}

	public AbstractController getNameFormPresenter() {
		if (nameFormPresenter == null) {
			nameFormPresenter = loadController( "/css_reload/fxml/nameform.fxml", NameFormPresenter.class);
		}
		return nameFormPresenter;
	}

	public static <T extends Controller> T loadController(String url, Class<T> type) 
	{
		try 
		{
			InputStream fxmlStream = null;
			try 
			{
				fxmlStream = type.getClass().getResourceAsStream(url);
				FXMLLoader loader = new FXMLLoader();
				Region view = (Region) loader.load(fxmlStream);

				Object controller = loader.getController();

				if (type.isInstance(controller)) {
					T controller2 = type.cast(controller);
					controller2.setView(view);
					return controller2;
				}

				return null;
			} finally {
				if (fxmlStream != null) {
					fxmlStream.close();
				}
			}
		} catch (IOException e) {
			throw new RuntimeException("Unable to load " + url, e);
		}
	}

}
