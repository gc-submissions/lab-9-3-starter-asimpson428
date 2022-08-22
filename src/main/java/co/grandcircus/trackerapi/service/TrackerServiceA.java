package co.grandcircus.trackerapi.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.grandcircus.trackerapi.model.CountPair;

@Service
public class TrackerServiceA implements TrackerService {

	private HashMap<String, Integer> tokenMap;
	private LinkedList<String> lastTokenTracker;

	public TrackerServiceA() {
		tokenMap = new HashMap<>();
		lastTokenTracker = new LinkedList<>();
	}

	@Override
	public synchronized void add(String token) {
		if (!getTokenExists(token)) {
			tokenMap.put(token, 1);
		} else {
			tokenMap.put(token, tokenMap.get(token) + 1);

		}
		lastTokenTracker.add(token);
		if (lastTokenTracker.size() > 5) {
				lastTokenTracker.remove();
		}
	}

	@Override
	public void reset() {
		tokenMap.clear();
		lastTokenTracker.clear();
	}

	@Override
	public int getTotalCount() {
		int totalValue = 0;
		for (int value : tokenMap.values()) {
			totalValue += value;

		}
		return totalValue;
	}

	@Override
	public boolean getTokenExists(String token) {
		if (tokenMap.containsKey(token)) {
			return true;
		}
		return false;
	}

	@Override
	public int getTokenCount(String token) {
		if (!tokenMap.containsKey(token)) {
			return 0;
		}
		return tokenMap.get(token);
	}

	@Override
	
	public String getLatest() {
		if(lastTokenTracker.isEmpty()) {
			return "";
		}

		return lastTokenTracker.getLast();
	}

	@Override
	public CountPair getTop() {
		if (tokenMap.isEmpty()) {
			return new CountPair("", 0);
		}
		String maxResult = tokenMap.keySet().stream().max((keyA, keyB) -> tokenMap.get(keyA) - tokenMap.get(keyB))
				.get();

		return new CountPair(maxResult, tokenMap.get(maxResult));
	}

	@Override
	public List<String> getLatest5() {
		List<String>copiedList = new ArrayList<>();
		copiedList.addAll(lastTokenTracker);
		Collections.reverse(copiedList);
		
		return copiedList;
	}

	@Override
	public List<CountPair> getTop5() {
		List<String> topFiveList = tokenMap.keySet().stream()
				.sorted((keyA, keyB) -> tokenMap.get(keyB) - tokenMap.get(keyA)).limit(5).toList();
		List<CountPair> countPairs= new ArrayList<>();
		
		for (String key : topFiveList) {
			countPairs.add(new CountPair(key,tokenMap.get(key)));
		}
		return countPairs;
	}

}
