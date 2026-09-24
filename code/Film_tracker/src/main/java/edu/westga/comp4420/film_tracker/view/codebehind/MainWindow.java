package edu.westga.comp4420.film_tracker.view.codebehind;

import java.io.IOException;

import edu.westga.comp4420.film_tracker.Main;
import edu.westga.comp4420.film_tracker.model.WatchedItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * CodeBehind To Handle Processing for the MainWindow
 *
 * @author	Comp 4420
 * @version Fall 2026
 */
public class MainWindow {   
	@FXML private ListView<WatchedItem> watchedItems;
	@FXML private AnchorPane guiPane;

	@FXML
	void addItem(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Main.ADD_ITEM_WINDOW_RESOURCE));
			loader.load();
			Parent parent = loader.getRoot();
			Scene scene = new Scene(parent);
			Stage addItemStage = new Stage();
			addItemStage.setTitle(Main.WINDOW_TITLE);
			addItemStage.setScene(scene);
			addItemStage.initModality(Modality.APPLICATION_MODAL);

			AddItemWindow controller = (AddItemWindow) loader.getController();
			controller.setItemList(this.watchedItems.getItems());

			addItemStage.showAndWait();
		} catch (IOException error) {
			Alert errorBox = new Alert(AlertType.ERROR);
			errorBox.setContentText("Unable to open add window");
			errorBox.showAndWait();
		}
	}

	@FXML
	void removeItem(ActionEvent event) {
		WatchedItem selectedItem = this.watchedItems.getSelectionModel().getSelectedItem();
		if (selectedItem != null) {
			this.watchedItems.getItems().remove(selectedItem);
		}
	}
	
	@FXML
	void initialize() {
		assert this.watchedItems != null : "fx:id=\"watchedItems\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.guiPane != null : "fx:id=\"guiPane\" was not injected: check your FXML file 'MainWindow.fxml'.";
	}
}
