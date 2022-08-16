package co.grandcircus.trackerapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import co.grandcircus.trackerapi.model.CountPair;
import co.grandcircus.trackerapi.service.TrackerService;
import co.grandcircus.trackerapi.service.TrackerServiceA;

public class TrackerServiceExtendedChallengeTests {
	
	private TrackerService service = new TrackerServiceA();
	
	@Test
	void testLatest5() {
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Delta");
		service.add("Epsilon");
		assertEquals(Arrays.asList("Epsilon", "Delta", "Gamma", "Beta", "Alpha"), service.getLatest5());
	}

	@Test
	void testLatest5WithMore() {
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Delta");
		service.add("Epsilon");
		service.add("Zeta");
		service.add("Eta");
		service.add("Theta");
		assertEquals(Arrays.asList("Theta", "Eta", "Zeta", "Epsilon", "Delta"), service.getLatest5());
	}
	
	@Test
	void testLatest5WithoutEnough() {
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		assertEquals(Arrays.asList("Gamma", "Beta", "Alpha"), service.getLatest5());
	}

	@Test
	void testLatest5WithDuplicates() {
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Delta");
		service.add("Beta");
		service.add("Epsilon");
		service.add("Beta");
		service.add("Alpha");
		assertEquals(Arrays.asList("Alpha", "Beta", "Epsilon", "Beta", "Delta"), service.getLatest5());
	}
	
	@Test
	void testTop5() {
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Delta");
		service.add("Epsilon");
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Delta");
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Alpha");
		service.add("Beta");
		service.add("Alpha");
		assertEquals(Arrays.asList(
				new CountPair("Alpha", 5),
				new CountPair("Beta", 4),
				new CountPair("Gamma", 3),
				new CountPair("Delta", 2),
				new CountPair("Epsilon", 1)
		), service.getTop5());
	}
	
	@Test
	void testTop5WithMore() {
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Delta");
		service.add("Epsilon");
		service.add("Zeta");
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Delta");
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Alpha");
		service.add("Beta");
		service.add("Alpha");
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Delta");
		service.add("Zeta");
		assertEquals(Arrays.asList(
				new CountPair("Alpha", 6),
				new CountPair("Beta", 5),
				new CountPair("Gamma", 4),
				new CountPair("Delta", 3),
				new CountPair("Zeta", 2)
		), service.getTop5());
	}
	
	@Test
	void testTop5WithLess() {
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Delta");
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Delta");
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Alpha");
		service.add("Beta");
		service.add("Alpha");
		assertEquals(Arrays.asList(
				new CountPair("Alpha", 5),
				new CountPair("Beta", 4),
				new CountPair("Gamma", 3),
				new CountPair("Delta", 2)
		), service.getTop5());
	}

}
