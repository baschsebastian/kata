package kata;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;
	private Publishing publishing = new Publishing();
	private Following following = new Following();

	public Person(String namee) {
		this.name = namee;
		this.publishing = new Publishing();
		this.following = new Following();
	}

	public Publishing getPublishing() {
		return publishing;
	}

	public void setPublishing(Publishing publishing) {
		this.publishing = publishing;
	}

	public Following getFollowing() {
		return following;
	}

	public void setFollowing(Following following) {
		this.following = following;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TimeLine getOthersTimeLine(String string) {
		List<Person> people = this.following.getFollowing();
		for (int j = 0; j < people.size(); j++) {
			if (people.get(j).getName().equals(string)) {

				return people.get(j).getPublishing().getTimeLine();
			}
		}
		return null;

	}

	public String readPublished() {
		return this.publishing.getPublished();
	}

	public void viewWall() {
		List<String> wall = new ArrayList<String>();
		List<Person> follows = this.getFollowing().getFollowing();

		List<Timestamp> myTimestamps = this.getPublishing().getTimeLine().getTimes();
		List<String> myMessages = this.getPublishing().getTimeLine().getTimeLine();

		boolean printed = false;
		for (int j = 0; j < follows.size(); j++) {
			List<String> othersMessages = follows.get(0).getPublishing().getTimeLine().getTimeLine();
			List<Timestamp> othersTimestamps = follows.get(0).getPublishing().getTimeLine().getTimes();

			if (othersMessages.size() > 0) {

				// their messages were first
				if (othersTimestamps.get(0).before(myTimestamps.get(0))) {
					for (int y = othersMessages.size(); y > 0; y++) {
						if (myTimestamps.size() > 0) {
							// their messages were first
							long seconds = secondsSince(othersTimestamps, y);
							if (seconds % 60 == 0) {
								wall.add(othersMessages.get(y) + " (" + seconds / 60 + " minutes ago)");
							} else {
								wall.add(othersMessages.get(y) + " (" + seconds + " seconds ago)");
							}

						}
					}
					// his/her messages where first
				} else if (!printed) {
					for (int y = myMessages.size(); y > 0; y++) {
						long seconds = secondsSince(myTimestamps, y);
						if (seconds % 60 == 0) {
							wall.add(myMessages.get(y) + " (" + seconds / 60 + " minutes ago)");
						} else {
							wall.add(myMessages.get(y) + " (" + seconds + " seconds ago)");
						}
					}
					printed = true;
				}

			}
		}

	}

	private long secondsSince(List<Timestamp> othersTimestamps, int y) {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		Timestamp time = othersTimestamps.get(y);
		long seconds = (now.getTime() - time.getTime()) / 1000;
		return seconds;
	}
}
