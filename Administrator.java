package control;
/**
 * 
 * @author Sara Ibrahim
 *
 */
public class Administrator {
	/**
	 * 
	 * @param playground
	 * @return true if the playground information is right
	 */
	public static boolean approvePlayground(Playground playground) {
		//administrator should check if information given is right or not
		if(!playground.getName().contentEquals("")&&playground.getSize()>1000&&!playground.getLocation().contentEquals("")&&playground.getDuration()!=0&&playground.getStartingHour()!=null&&playground.getClosingHour()!=null&&playground.getPricePerHour()>0)
			return true;
		else 
			return false;
	}
	/**
	 * remove playground from the system if it had many complains from users
	 */
	public static void deletePlayground() {}
	/**
	 * 
	 */
	public static void suspendPlayground() {}
	/**
	 * stop the playground temporarily
	 */
	public static void activatePlayground() {}
}
