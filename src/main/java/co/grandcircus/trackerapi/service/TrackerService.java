package co.grandcircus.trackerapi.service;

import java.util.List;

import co.grandcircus.trackerapi.model.CountPair;

public interface TrackerService {

	/**
	 * Register a hit for the given token
	 * 
	 * @param token
	 *            the token to add
	 */
	void add(String token);

	/**
	 * Clear out all records. Reset back to no tokens.
	 */
	void reset();

	/**
	 * Return the total number of tokens tracked (including duplicates)
	 */
	int getTotalCount();

	/**
	 * Return whether the token has been tracked at all
	 * 
	 * @param token
	 *            the token to check
	 */
	boolean getTokenExists(String token);

	/**
	 * Return the total number of times a given token has been tracked. The
	 * count may be zero.
	 * 
	 * @param token
	 *            the token to check
	 */
	int getTokenCount(String token);

	/**
	 * Return the most recent token tracked
	 */
	String getLatest();

	/**
	 * Return the token that has been tracked the most times AND how many times
	 * it has been tracked. If there are no tokens return a CountPair("", 0).
	 * 
	 * @return a CountPair including the token and count
	 */
	CountPair getTop();

	/**
	 * Return five the most recent token tracked in order with the most recent
	 * first. The list may contain duplicates if the same token was registered
	 * multiple times. If there are less than five total hits, return all the
	 * available tokens.
	 */
	List<String> getLatest5();

	/**
	 * Return the five tokens that have been tracked the most times AND how many
	 * times they have been tracked. If there are less than five unique tokens,
	 * return CountPairs the available tokens.
	 * 
	 * @return a List of CountPair ordered with the highest count first.
	 */
	List<CountPair> getTop5();

}