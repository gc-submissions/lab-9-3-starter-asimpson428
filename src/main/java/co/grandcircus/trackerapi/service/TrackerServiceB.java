package co.grandcircus.trackerapi.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import co.grandcircus.trackerapi.model.CountPair;

@Service

public class TrackerServiceB implements TrackerService {

	private ArrayList<String> tokenList = new ArrayList<>();

	@Override
	public void add(String token) {

		tokenList.add(token);

	}

	@Override
	public void reset() {

		tokenList.clear();

	}

	@Override
	public int getTotalCount() {
		return tokenList.size();

	}

	@Override
	public boolean getTokenExists(String token) {
		if (tokenList.contains(token)) {
			return true;
		}
		return false;
	}

	@Override
	public int getTokenCount(String token) {
		//tokenList.stream().filter(null)
		return 0;
	}

	@Override
	public String getLatest() {
		return tokenList.get(tokenList.size() - 1);

	}

	@Override
	public CountPair getTop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getLatest5() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountPair> getTop5() {
		HashMap<String, Integer> tokenMap = new HashMap<>();
		for (String token : tokenList) {
			if (!tokenMap.containsKey(token)) {
				tokenMap.put(token, 1);
			} else {
				tokenMap.put(token, tokenMap.get(token) + 1);
			}

		}

		List<String> tokenList = tokenMap.keySet().stream().toList();
		tokenList.sort((key1, key2) -> tokenMap.get(key1) - tokenMap.get(key2));
		Collections.reverse(tokenList);
		List<CountPair> result = new ArrayList<>();
		for (String token : tokenList.subList(0, 5)) {
		result.add(	new CountPair(token, tokenMap.get(token)));
		}
		return result;
	}

}
