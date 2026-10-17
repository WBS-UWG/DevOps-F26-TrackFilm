package edu.westga.comp4420.film_tracker.test.model.film_tracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.comp4420.film_tracker.model.WatchlistItem;

/**
 * Tests for the WatchlistItem model.
 *
 * @author William Sitt
 * @version Fall 2026
 */
public class WatchlistItemTest {
	/**
	 * Verifies that a valid film is stored correctly.
	 */
	@Test
	public void validFilmStoredCorrectly() {
		WatchlistItem item = new WatchlistItem("Inception", false);

		assertEquals("Inception", item.getTitle());
		assertEquals(false, item.isSeries());
	}

	/**
	 * Verifies that a valid series is stored correctly.
	 */
	@Test
	public void validSeriesStoredCorrectly() {
		WatchlistItem item = new WatchlistItem("Breaking Bad", true);

		assertEquals("Breaking Bad", item.getTitle());
		assertEquals(true, item.isSeries());
	}

	/**
	 * Verifies that a null title is rejected.
	 */
	@Test
	public void nullTitleRejected() {
		assertThrows(IllegalArgumentException.class, () -> new WatchlistItem(null, false));
	}

	/**
	 * Verifies that an empty title is rejected.
	 */
	@Test
	public void emptyTitleRejected() {
		assertThrows(IllegalArgumentException.class, () -> new WatchlistItem("", false));
	}
}
