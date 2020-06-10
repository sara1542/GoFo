package control;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 * the same as struct in cpp
 * @author Sara Ibrahim
 *
 */
public class PlayingHours {
	public int duration;
	public LocalTime startingHour;
	public LocalTime closingHour;
	/**
	 * parameterized constructor
	 * @param duration
	 * @param startingHour
	 * @param closingHour
	 */
	public PlayingHours(int duration,LocalTime startingHour, LocalTime closingHour) {
		this.duration=duration;
		this.startingHour=startingHour;
		this.closingHour=closingHour;
	}
	/**
	 * print every time slot details
	 */
	public void print() {
		java.lang.System.out.println("Duration of every booking is "+duration+" hours");
		java.lang.System.out.println("opens from "+startingHour+" to "+closingHour);
	}
}
