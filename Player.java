package control;

import java.util.Scanner;
import java.util.Vector;
/**
 * 
 * @author Sara Ibrahim
 *
 */
public class Player extends User {
	public Vector<Booking> bookings = new Vector<Booking>(); // vector to hold all bookings for each player
	public Player() {}
	/**
	 * parameterized constructor
	 * @param name
	 * @param id
	 * @param email
	 * @param password
	 * @param phone
	 * @param location
	 */
	public Player(String name, int id, String email, String password, String phone, String location) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.location = location;
	}
	/**
	 * view playgrounds with free time slots
	 */
	public void bookPlayground() {
		
		String playgroundName="";
		int time;
		Scanner scanner2 = new Scanner(java.lang.System.in);
		java.lang.System.out.println("Enter Playground name:");
		playgroundName=scanner2.nextLine();
		java.lang.System.out.println("Enter starting hour:");
		time=scanner2.nextInt();
		if(System.requestToBookPlayground(playgroundName,time)) {
			java.lang.System.out.println("Booking is done successfully!");
		}
		else {
			java.lang.System.out.println("The system has refused you request.Check the information you enterd and the avaialable time slots");
		}
	}
	/**
	 * 
	 */
	public void cancelBooking() {
	}
	/**
	 * player can send invitation to his friends to create a team
	 */
	public void createTeam() {
		int number;
		String email;
		Scanner scanner3 = new Scanner(java.lang.System.in);
		java.lang.System.out.println("How many players do you want to add in your team (up to 11 players)?");
		number=scanner3.nextInt();
		while(true) {
		if(number<0||number>11) {
			java.lang.System.out.println("Not allowed.You must choose between 1 and 11 players.Enter again");
			number=scanner3.nextInt();
		}
		else 
			break;
		}
		for(int x=0;x<number;x++) {
			java.lang.System.out.println("Enter player's e-mail number "+(x+1)+" :");
			email=scanner3.next();
			while(true) {
			if(System.checkEmail(email)) {
				break;
			}
			else {
				java.lang.System.out.println("This email doesn't exist.Try again and enter email");
				email=scanner3.nextLine();
			}
			}
		}
		java.lang.System.out.println("We have sent invitations to the players and we will let you know when they accept\n");
		
	}
	

}
