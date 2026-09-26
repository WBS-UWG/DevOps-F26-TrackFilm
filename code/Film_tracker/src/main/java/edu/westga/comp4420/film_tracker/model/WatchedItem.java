package edu.westga.comp4420.film_tracker.model;

/**
 * Stores information for a single watched film or series.
 *
 * @author	Comp 4420
 * @version Fall 2026
 */
public final class WatchedItem {

	private final String title;
	private final int rating;
	private final String description;

	/**
	 * Creates a watched item.
	 *
	 * @param title the item's title
	 * @param rating the item's rating, from 1 to 5
	 * @param description the item's description
	 */
	public WatchedItem(String title, int rating, String description) {
		if (rating < 1 || rating > 5) {
			throw new IllegalArgumentException("Rating must be between 1 and 5.");
		}
		this.title = title;
		this.rating = rating;
		this.description = description;
	}

	/**
	 * Gets the item's title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Gets the item's rating.
	 *
	 * @return the rating from 1 to 5
	 */
	public int getRating() {
		return this.rating;
	}

	/**
	 * Gets the item's description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	// @Override
	// public String toString() {
	// 	return this.title + " - Note : " + this.rating + "/5\n" + this.description;
	// }
}