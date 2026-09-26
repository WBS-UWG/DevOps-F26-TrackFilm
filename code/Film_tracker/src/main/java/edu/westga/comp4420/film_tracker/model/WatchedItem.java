package edu.westga.comp4420.film_tracker.model;

/**
 * Stores basic information for a single watched film or series.
 *
 * @author	Comp 4420
 * @version Fall 2026
 */
public final class WatchedItem {   

	private final String title;
    private final String director;
    
    public WatchedItem(String title, String director) {
        this.title = title;
        this.director = director;
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
     * Gets the item's director or creator.
     *
     * @return the director or creator
     */
    public String getDirector() {
        return this.director;
    }

    @Override
    public String toString() {
        return this.title + " (" + this.director + ")";
    }
}