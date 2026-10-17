package edu.westga.comp4420.film_tracker.model;

/**
 * Stores an item in the user's watchlist.
 *
 * @author William sitt
 * @version Fall 2026
 */
public final class WatchlistItem {
	private final String title;
	private final boolean series;

	/**
	 * Creates a watchlist item.
	 *
	 * @param title the item's title
	 * @param series true when the item is a series
	 */
	public WatchlistItem(String title, boolean series) {
		if (title == null || title.trim().isEmpty()) {
			throw new IllegalArgumentException("Title cannot be null or empty.");
		}
		this.title = title.trim();
		this.series = series;
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
	 * Indicates whether the item is a series.
	 *
	 * @return true when the item is a series
	 */
	public boolean isSeries() {
		return this.series;
	}
}
