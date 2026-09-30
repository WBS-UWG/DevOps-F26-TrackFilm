package edu.westga.comp4420.film_tracker.view.codebehind;

import java.io.IOException;

import edu.westga.comp4420.film_tracker.model.WatchedItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * CodeBehind To Handle Processing for the MainWindow
 *
 * @author	William sitt
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

		this.configureItemList(this.filmItems);
		this.configureItemList(this.seriesItems);

	}

	private void configureItemList(ListView<WatchedItem> itemList) {
		itemList.setCellFactory(list -> new ListCell<WatchedItem>() {
			@Override
			protected void updateItem(WatchedItem item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setGraphic(null);
					setPrefHeight(0.0);
				} else {
					Label title = new Label(item.getTitle());
					title.setFont(Font.font("System", FontWeight.BOLD, 15.0));

					Label rating = new Label("Note : " + item.getRating() + "/5");
					Label description = new Label(item.getDescription());
					description.setWrapText(true);

					VBox itemContent = new VBox(3.0, title, rating, description);
					setGraphic(itemContent);
					setPrefHeight(80.0);
				}
			}
		});
	}

	@FXML
	private void openAddItem() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AddItemWindow.fxml"));
		Parent parent = loader.load();
		AddItemWindow controller = loader.getController();
		Stage addItemStage = new Stage();
		addItemStage.setTitle("Add a film or series");
		addItemStage.initModality(Modality.WINDOW_MODAL);
		addItemStage.initOwner(this.guiPane.getScene().getWindow());
		addItemStage.setScene(new javafx.scene.Scene(parent));
		controller.setDialogStage(addItemStage);
		controller.setItemAddedHandler(item -> {
			if (controller.isSeriesSelected()) {
				this.seriesItems.getItems().add(item);
			} else {
				this.filmItems.getItems().add(item);
			}
		});
		addItemStage.showAndWait();
	}
}
