package edu.westga.comp4420.film_tracker.view.codebehind;

import java.io.IOException;
import java.util.function.Consumer;

import edu.westga.comp4420.film_tracker.model.WatchedItem;
import edu.westga.comp4420.film_tracker.model.WatchlistItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
	private Consumer<WatchedItem> watchedItemAddedHandler;

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
					Button watchedButton = new Button("Noter comme vu");
					watchedButton.setOnAction(event -> WatchlistWindow.this.markAsWatched(item));
					HBox row = new HBox(10.0, title, watchedButton);
					row.setPrefWidth(500.0);
					setGraphic(row);
					setPrefHeight(40.0);
				}
			}
		});
	}

	/**
	 * Sets the callback invoked when a watchlist item is marked as watched.
	 *
	 * @param watchedItemAddedHandler the callback
	 */
	public void setWatchedItemAddedHandler(Consumer<WatchedItem> watchedItemAddedHandler) {
		this.watchedItemAddedHandler = watchedItemAddedHandler;
	}

	private void markAsWatched(WatchlistItem item) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddItemWindow.fxml"));
			Parent parent = loader.load();
			AddItemWindow controller = loader.getController();
			Stage addItemStage = new Stage();
			addItemStage.setTitle("Ajouter un film ou une série");
			addItemStage.initModality(Modality.WINDOW_MODAL);
			addItemStage.initOwner(this.guiPane.getScene().getWindow());
			addItemStage.setScene(new Scene(parent));
			controller.prefillItem(item.getTitle(), item.isSeries());
			controller.setDialogStage(addItemStage);
			controller.setItemAddedHandler(watchedItem -> {
				if (this.watchedItemAddedHandler != null) {
					this.watchedItemAddedHandler.accept(watchedItem);
				}
				this.watchlistItems.getItems().remove(item);
			});
			addItemStage.showAndWait();
		} catch (IOException exception) {
			throw new IllegalStateException("Unable to open the add item window.", exception);
		}
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
