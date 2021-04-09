package kata;

import java.sql.Timestamp;

public class kata {
	private static Person charlie = new Person("Charlie");
	private static Person alice = new Person("Alice");
	private static Person bob = new Person("Bob");
	
	public static void main(String[] args) throws Exception{
		//setting the initial messages
		setMessages(charlie, alice, bob);
		
		
		//part 1
		readAlicesMessage(alice);
		
		//part2
		readBobsTimeline(alice, bob);
		
		//part3
		charlie.getFollowing().addFollowing(alice);
		charlie.getFollowing().addFollowing(alice);
		charlie.viewWall();
		
	}

	private static void setMessages(Person charlie, Person alice, Person bob) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		alice.getPublishing().setPublished("I love the weather today.", timestamp);
		
		//just to get different timestamps
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		timestamp = new Timestamp(System.currentTimeMillis());
		bob.getPublishing().setPublished("Darn! We lost!", timestamp);
		
		//just to get different timestamps
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		timestamp = new Timestamp(System.currentTimeMillis());
		bob.getPublishing().setPublished("Good game though.", timestamp);
		
		//just to get different timestamps
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		timestamp = new Timestamp(System.currentTimeMillis());
		charlie.getPublishing().setPublished("I'm in New York today! Anyone wants to have a coffee?", timestamp);
	}

	private static void readBobsTimeline(Person alice, Person bob) {
		alice.getFollowing().addFollowing(bob);
		TimeLine bobsTimeline = alice.getOthersTimeLine("bob");
		if(bobsTimeline != null) {
			bobsTimeline.readTimeLine();
		}
		System.out.println(">>>");
	}

	private static void readAlicesMessage(Person alice) {
		if(alice.readPublished() != null) {
			System.out.println(alice.readPublished());
		} else {
			System.out.println("none");
		}
		System.out.println(">>>");
	}

}
