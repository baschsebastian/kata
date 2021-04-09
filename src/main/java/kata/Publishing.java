package kata;

import java.sql.Timestamp;

public class Publishing {
	private String published;
	private TimeLine timeLine = new TimeLine();
	private Timestamp time = null;

	public String getPublished() {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		long seconds = 0;

		seconds = secondsSince(now, seconds);
		// minutes
		if (seconds % 60 == 0) {
			return published + " (" + seconds / 60 + " minutes ago)";
		} else {
			return published + " (" + seconds + " seconds ago)";
		}

	}

	private long secondsSince(Timestamp now, long seconds) {
		if (time != null) {
			long difference = (now.getTime() - time.getTime()) / 1000;
			seconds = difference;
		}
		return seconds;
	}

	public void setPublished(String published, Timestamp now) {
		this.published = published;
		timeLine.addTimeLine(published, now);

		time = now;
	}

	public TimeLine getTimeLine() {
		return timeLine;
	}

}