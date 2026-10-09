package edu.westga.comp4420.film_tracker.view.codebehind;

import java.util.function.Consumer;

import edu.westga.comp4420.film_tracker.model.WatchlistItem;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

/**
 * CodeBehind for adding an item to the watchlist.
 *
 * @author William sitt
 * @version Fall 2026
 */
public class AddWatchlistItemWindow {
	@FXML private TextField titleField;
	@FXML private ToggleButton seriesButton;
	@FXML private ToggleButton filmButton;

	private Stage dialogStage;
	private Consumer<WatchlistItem> itemAddedHandler;

	/**
	 * Sets the dialog stage.
	 *
	 * @param dialogStage the dialog stage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Sets the callback invoked after a valid item is added.
	 *
	 * @param itemAddedHandler the callback
	 */
	public void setItemAddedHandler(Consumer<WatchlistItem> itemAddedHandler) {
		this.itemAddedHandler = itemAddedHandler;
	}

	@FXML
	private void addItem() {
		String title = this.titleField.getText().trim();
		if (title.isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Titre manquant");
			alert.setHeaderText(null);
			alert.setContentText("Veuillez saisir un titre.");
			alert.showAndWait();
			return;
		}

		this.itemAddedHandler.accept(new WatchlistItem(title, this.seriesButton.isSelected()));
		this.dialogStage.close();
	}

	@FXML
	private void cancel() {
		this.dialogStage.close();
	}
}
