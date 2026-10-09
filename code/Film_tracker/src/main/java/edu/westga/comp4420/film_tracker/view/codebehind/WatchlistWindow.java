package edu.westga.comp4420.film_tracker.view.codebehind;

import java.io.IOException;

import edu.westga.comp4420.film_tracker.model.WatchlistItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * CodeBehind for the user's watchlist window.
 *
 * @author William sitt
 * @version Fall 2026
 */
public class WatchlistWindow {
	@FXML private ListView<WatchlistItem> watchlistItems;
	@FXML private BorderPane guiPane;

	@FXML
	private void initialize() {
		assert this.watchlistItems != null : "fx:id=\"watchlistItems\" was not injected: check your FXML file 'WatchlistWindow.fxml'.";
		assert this.guiPane != null : "fx:id=\"guiPane\" was not injected: check your FXML file 'WatchlistWindow.fxml'.";

		this.configureItemList(this.watchlistItems);
	}

	private void configureItemList(ListView<WatchlistItem> itemList) {
		itemList.setCellFactory(list -> new ListCell<WatchlistItem>() {
			@Override
			protected void updateItem(WatchlistItem item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setGraphic(null);
					setPrefHeight(0.0);
				} else {
					Label title = new Label((item.isSeries() ? "Série : " : "Film : ") + item.getTitle());
					title.setFont(Font.font("System", FontWeight.BOLD, 15.0));
					setGraphic(title);
					setPrefHeight(40.0);
				}
			}
		});
	}

	@FXML
	private void openAddItem() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AddWatchlistItemWindow.fxml"));
		Parent parent = loader.load();
		AddWatchlistItemWindow controller = loader.getController();
		Stage addItemStage = new Stage();
		addItemStage.setTitle("Ajouter à la liste à voir");
		addItemStage.initModality(Modality.WINDOW_MODAL);
		addItemStage.initOwner(this.guiPane.getScene().getWindow());
		addItemStage.setScene(new Scene(parent));
		controller.setDialogStage(addItemStage);
		controller.setItemAddedHandler(item -> {
			this.watchlistItems.getItems().add(item);
		});
		addItemStage.showAndWait();
	}
}
