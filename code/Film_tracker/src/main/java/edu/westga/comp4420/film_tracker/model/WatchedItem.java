package edu.westga.comp4420.film_tracker.model;

/**
 * Stores basic information for a single item in a grocery list.
 *
 * @author	Comp 4420
 * @version Fall 2026
 */
public final class WatchedItem {   

	private String title;
    private String director;
    
    public WatchedItem(String title, String director) {
        this.title = title;
        this.director = director;
    }
}