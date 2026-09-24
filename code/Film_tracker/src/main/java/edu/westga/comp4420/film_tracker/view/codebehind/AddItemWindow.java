package edu.westga.comp4420.film_tracker.view.codebehind;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import java.util.List;

import edu.westga.comp4420.film_tracker.model.WatchedItem;

/**
 * CodeBehind To Handle Processing for the AddItemWindow
 *
 * @author	Comp 4420
 * @version Fall 2026
 */
public class AddItemWindow {   
	@FXML private AnchorPane guiPane;
	
	private List<WatchedItem> watchedItems;
	
	public void setItemList(List<WatchedItem> watchedItems) {
		this.watchedItems = watchedItems;
	}
	
	@FXML
	void initialize() {
		assert this.guiPane != null : "fx:id=\"guiPane\" was not injected: check your FXML file 'MainWindow.fxml'.";
	}
}
