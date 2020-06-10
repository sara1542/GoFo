package control;

import java.time.LocalTime;
/**
 * 
 * @author Sara Ibrahim
 *
 */
public class Booking {
	public int duration;
	public LocalTime startingHour;
	public LocalTime closingHour; // an object of the struct PlayingHours
	private int cancellationPeriod; //in days
	private Playground playground;	
	/**
	 * parameterized constructor
	 * @param duration
	 * @param startingHour
	 * @param closingHour
	 * @param cancellationPeriod
	 * @param playground
	 */
	public Booking(int duration,LocalTime startingHour, LocalTime closingHour,int cancellationPeriod,Playground playground) {
		this.duration=duration;
		this.startingHour=startingHour;
		this.closingHour=closingHour;
		this.cancellationPeriod=cancellationPeriod;
		this.playground=playground;
	}
}
