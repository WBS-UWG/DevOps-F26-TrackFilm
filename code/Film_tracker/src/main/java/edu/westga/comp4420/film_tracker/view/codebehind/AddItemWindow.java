package edu.westga.comp4420.film_tracker.view.codebehind;

import java.util.function.Consumer;

import edu.westga.comp4420.film_tracker.model.WatchedItem;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * CodeBehind To Handle Processing for the AddItemWindow.
 *
 * @author william sitt
 * @version Fall 2026
 */
public class AddItemWindow {
	@FXML private TextField titleField;
	@FXML private Spinner<Integer> ratingSpinner;
	@FXML private TextArea descriptionField;
	@FXML private ToggleButton seriesButton;
	@FXML private ToggleButton filmButton;

	private Stage dialogStage;
	private Consumer<WatchedItem> itemAddedHandler;

	@FXML
	private void initialize() {
		SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory =
				new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5);
		this.ratingSpinner.setValueFactory(valueFactory);
		this.ratingSpinner.setEditable(true);
	}

	/**
	 * Sets the dialog stage for this window.
	 *
	 * @param dialogStage the stage to set
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}


	public void setItemAddedHandler(Consumer<WatchedItem> itemAddedHandler) {
		this.itemAddedHandler = itemAddedHandler;
	}

	@FXML
	private void addItem() {
		String title = this.titleField.getText().trim();
		String ratingText = this.ratingSpinner.getEditor().getText().trim();
		int rating;

		if (title.isEmpty()) {
			this.showValidationError("Please enter a title.");
			return;
		}
		try {
			rating = Integer.parseInt(ratingText);
		} catch (NumberFormatException exception) {
			this.showValidationError("Please add a rate to your film or series");
			return;
		}
		if (rating < 1 || rating > 5) {
			this.showValidationError("Please enter a rating between 1 and 5.");
			return;
		}
		if (!this.filmButton.isSelected() && !this.seriesButton.isSelected()) {
			this.showValidationError("Please tell us if it's a film or a series");
			return;
		}

		WatchedItem item = new WatchedItem(title, rating, this.descriptionField.getText().trim());
		this.itemAddedHandler.accept(item);
		this.dialogStage.close();
	}

	@FXML
	private void cancel() {
		this.dialogStage.close();
	}

	private void showValidationError(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Invalid item");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	/**
	 * Indicates whether the item should be added to the series list.
	 *
	 * @return true when the Series button is selected
	 */
	public boolean isSeriesSelected() {
		return this.seriesButton.isSelected();
	}
}
