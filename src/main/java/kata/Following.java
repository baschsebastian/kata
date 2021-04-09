package kata;

import java.util.ArrayList;
import java.util.List;

public class Following{
	private List<Person> following = new ArrayList<Person>();

	public List<Person> getFollowing() {
		return following;
	}

	public void setFollowing(List<Person> following) {
		this.following = following;
	}
	
	public void addFollowing(Person person) {
		this.following.add(person);
	}

}
