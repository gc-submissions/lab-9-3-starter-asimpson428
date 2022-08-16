package co.grandcircus.trackerapi.model;

/**
 * A structure representing a token and an associated count.
 */
public class CountPair {

	private String token;
	private int count;

	public CountPair() {
		super();
	}

	public CountPair(String token, int count) {
		super();
		this.token = token;
		this.count = count;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String key) {
		this.token = key;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return token + ":" + count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountPair other = (CountPair) obj;
		if (count != other.count)
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

}
