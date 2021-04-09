package kata;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TimeLine {
	private List<String> timeLine = new ArrayList<String>();
	private List<Timestamp> times = new ArrayList<Timestamp>();

	public List<Timestamp> getTimes() {
		return times;
	}

	public void setTimes(List<Timestamp> times) {
		this.times = times;
	}

	public List<String> getTimeLine() {
		return timeLine;
	}

	public void setTimeLine(List<String> timeLine) {
		this.timeLine = timeLine;
	}

	public void addTimeLine(String event, Timestamp now) {
		timeLine.add(event);
		times.add(now);
	}

	public void readTimeLine() {
		for (int j = this.timeLine.size(); j > 0; j--) {
			long seconds = secondsSince(j);

			if (seconds % 60 == 0) {
				System.out.println(this.timeLine.get(j) + " (" + seconds / 60 + " minutes ago)");
			} else {
				System.out.println(this.timeLine.get(j) + " (" + seconds + " seconds ago)");
			}
		}

	}

	private long secondsSince(int j) {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		Timestamp time = this.times.get(j);
		long seconds = (now.getTime() - time.getTime()) / 1000;
		return seconds;
	}

}
