package co.grandcircus.trackerapi;

import java.util.List;

import co.grandcircus.trackerapi.model.CountPair;
import co.grandcircus.trackerapi.service.TrackerService;

public class TrackerServiceA implements TrackerService {

	@Override
	public void add(String token) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getTokenExists(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTokenCount(String token) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLatest() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
