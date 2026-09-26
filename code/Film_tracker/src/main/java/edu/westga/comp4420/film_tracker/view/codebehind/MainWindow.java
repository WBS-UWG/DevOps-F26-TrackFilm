package edu.westga.comp4420.film_tracker.view.codebehind;

import edu.westga.comp4420.film_tracker.model.WatchedItem;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

/**
 * CodeBehind To Handle Processing for the MainWindow
 *
 * @author	Comp 4420
 * @version Fall 2026
 */
public class MainWindow {
	@FXML private ListView<WatchedItem> filmItems;
	@FXML private ListView<WatchedItem> seriesItems;
	@FXML private BorderPane guiPane;

	@FXML
	void initialize() {
		assert this.filmItems != null : "fx:id=\"filmItems\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.seriesItems != null : "fx:id=\"seriesItems\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.guiPane != null : "fx:id=\"guiPane\" was not injected: check your FXML file 'MainWindow.fxml'.";

		this.filmItems.getItems().addAll(
				new WatchedItem("Inception", "Christopher Nolan"),
				new WatchedItem("Interstellar", "Christopher Nolan"),
				new WatchedItem("Very bad trip", "Todd Phillips")
		);
		this.seriesItems.getItems().addAll(
				new WatchedItem("Breaking Bad", "Vince Gilligan"),
				new WatchedItem("The 100", "Jason Rothenberg")
			);
	}
}
