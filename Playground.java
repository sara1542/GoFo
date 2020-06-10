package control;
import java.util.*;
import java.time.LocalTime;
public class Playground {
	private String name;
	private int size;
	private int cancellationPeriod;
	private String location;
	private PlayingHours availableHours;
	private float pricePerHour;
	private PlaygroundOwner Owner;
	public Vector<Booking> bookings = new Vector<Booking>(); //vector to hold all bookings for each playground
	//parameterized constructor
	public Playground() {}
	/**
	 * parameterized constructor
	 * @param name
	 * @param size
	 * @param location
	 * @param availableHours
	 * @param pricePerHour
	 * @param cancellationPeriod
	 */
	public Playground(String name,int size,String location,PlayingHours availableHours,float pricePerHour,int cancellationPeriod) {
		this.name=name;
		this.size=size;
		this.location=location;
		this.availableHours=availableHours;
		this.pricePerHour=pricePerHour;
		this.cancellationPeriod=cancellationPeriod;
	}
	/**
	 * 
	 * @param Owner
	 */
	public void setOwner(PlaygroundOwner Owner) {
		this.Owner=Owner;
	}
	/**
	 * print all playground info 
	 */
	public void viewDetails() {
		java.lang.System.out.println("Playground information:\n\nName: "+name);
	java.lang.System.out.println("size: "+size+" square feet");
	java.lang.System.out.println("Location: "+location);
	availableHours.print();
	java.lang.System.out.println("Price per hour is "+pricePerHour+" L.E");}
	/**
	 * 
	 * @return playground name
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return playground size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * 
	 * @return playground location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 
	 * @return playground cancellation period
	 */
	public int getCencellationPeriod() {
		return cancellationPeriod;
	}
	/**
	 * 
	 * @return price per hour
	 */
	public float getPricePerHour() {
		return pricePerHour;
	}
	/**
	 * 
	 * @return duration of every booking
	 */
	public int getDuration() {
		return availableHours.duration;
	}
	/**
	 * 
	 * @return starting hour of the playground-- when it opens every day
	 */
	public LocalTime getStartingHour() {
		return availableHours.startingHour;
	}
	/**
	 * 
	 * @return closing hour of the playground-- when it closes every day
	 */
	public LocalTime getClosingHour() {
		return availableHours.closingHour;
	}
	
}
