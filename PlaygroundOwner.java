package control;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.Vector;
/**
 * 
 * @author Sara Ibrahim
 *
 */
public class PlaygroundOwner extends User {
	public PlaygroundOwner() {}
	/**
	 * parameterized constructor
	 * @param name
	 * @param id
	 * @param email
	 * @param password
	 * @param phone
	 * @param location
	 */
	public PlaygroundOwner(String name,int id,String email,String password,String phone,String location) {
		this.name=name;
		this.id=id;
		this.password=password;
		this.email=email;
		this.phone=phone;
		this.location=location;
	}
	private Vector<Playground> playgrounds = new Vector<Playground>(); //vector to hold all playgrounds for each playgroundOwner
	public void setPlayground(Playground playground) {
		playgrounds.add(playground);
	}
	/**
	 * register a playground on the system
	 */
	public void addPlayground() {
		String name,location;
		int size,duration;
		float price;
		int startTime,endTime,cancelPeriod;
		Scanner scanner = new Scanner(java.lang.System.in);
		java.lang.System.out.println("Enter your playground name:");
		name=scanner.nextLine();
		java.lang.System.out.println("Enter your playground location:");
		location=scanner.nextLine();
		java.lang.System.out.println("Enter your playground size:");
		size=scanner.nextInt();
		java.lang.System.out.println("Enter duration of every booking:");
		duration=scanner.nextInt();
		java.lang.System.out.println("Enter opening time:");
		startTime=scanner.nextInt();
		java.lang.System.out.println("Enter closing time:");
		endTime=scanner.nextInt();
		java.lang.System.out.println("Enter price per hour:");
		price=scanner.nextFloat();
		java.lang.System.out.println("Enter Cancellation period for every booking:");
		cancelPeriod=scanner.nextInt();
		//create object on PlayingHours according to owner requests to push into Playground object
		PlayingHours object1=new PlayingHours(duration,LocalTime.of(startTime,0),LocalTime.of(endTime,0));
		//create object on Playground according to owner requests
		Playground object2=new Playground(name,size,location,object1,price,cancelPeriod);
		java.lang.System.out.println("Wait until the administrator approves your playgound....\n\n\n");
		if(System.requestToRegisterPlayground(object2)) {
		java.lang.System.out.println("Congratulations! your playground is now added to the GoFo system.");
		playgrounds.add(object2);
		}
		else {
			java.lang.System.out.println("Sorry.It seems to be something wrong with the information you entered.Try again");
		}
	}
	/**
	 * update playground info	
	 */
	public void updatePlayground() {}
	/**
	 * view all bookings made for every playground he has
	 */
	public void viewBookings() {}

}
