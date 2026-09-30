package edu.westga.comp4420.film_tracker.test.model.film_tracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.comp4420.film_tracker.model.WatchedItem;

/**
 * Tests for the WatchedItem model.
 *
 * @author Comp 4420
 * @version Fall 2026
 */
public class WatchedItemTest {

	/**
	 * Verifies that a valid item keeps all supplied values.
	 */
	@Test
	public void ValidItemStoredCorrectly() {
		WatchedItem item = new WatchedItem("Inception", 5, "A classic.");

		assertEquals("Inception", item.getTitle());
		assertEquals(5, item.getRating());
		assertEquals("A classic.", item.getDescription());
	}

	/**
	 * Verifies that the minimum rating is accepted.
	 */
	@Test
	public void minimumRatingOk() {
		WatchedItem item = new WatchedItem("Film", 1, "");

		assertEquals(1, item.getRating());
	}

	/**
	 * Verifies that the maximum rating is accepted.
	 */
	@Test
	public void maximumRatingOk() {
		WatchedItem item = new WatchedItem("Film", 5, "");

		assertEquals(5, item.getRating());
	}

	/**
	 * Verifies that ratings below the allowed range are rejected.
	 */
	@Test
	public void ratingBelowOnRejected() {
		assertThrows(IllegalArgumentException.class,
				() -> new WatchedItem("Film", 0, ""));
	}

	/**
	 * Verifies that ratings above the allowed range are rejected.
	 */
	@Test
	public void ratingAboveFiveRejected() {
		assertThrows(IllegalArgumentException.class, () -> new WatchedItem("Film", 6, ""));
	}

	/**
	 * Verifies that null titles are rejected.
	 */
	@Test
	public void nullTitleRejected() {
		assertThrows(IllegalArgumentException.class, () -> new WatchedItem(null, 3, ""));
	}

	/**
	 * Verifies that empty titles are rejected.
	 */
	@Test
	public void emptyTitleRejected() {
		assertThrows(IllegalArgumentException.class, () -> new WatchedItem("", 3, ""));
	}
}