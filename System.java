package control;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.Vector;
/**
 * 
 * @author Sara Ibrahim
 *
 */
public class System {
	// it is like the database of the system
	private static int NumofPlaygroundOwners = 0; // to be incremented in every sign up of a playground owner
	private static int NumofPlayers = 0; // to be incremented in every sign up of a player
	private static Vector<Player> players = new Vector<Player>();
	private static Vector<PlaygroundOwner> playgroundOwners = new Vector<PlaygroundOwner>();
	private static Vector<Playground> playgrounds = new Vector<Playground>();

	// Adding some users to the system database
	static Player player1 = new Player("Sara Ibrahim", ++NumofPlayers, "sara_ibrahim@gmail.com", "1542000",
			"01287079568", "Maadi");
	static Player player2 = new Player("Mariam Ihab", ++NumofPlayers, "mariam_ihab@yahoo.com", "3132000", "0100512589",
			"Shobra");
	static Player player3 = new Player("Amr Mohamed", ++NumofPlayers, "amr_mohamed@gmail.com", "5986333", "01282569568",
			"Sraya El Oba");
	static Player player4 = new Player("Ihab Mahmoud", ++NumofPlayers, "ihab_mahmoud@yahoo.com", "1472000",
			"0100154889", "Shobra");
	static Player player5 = new Player("Youusef Shawky", ++NumofPlayers, "youssef_shawky@gmail.com", "1129900",
			"0100079568", "Sheikh Zayed");
	static Player player6 = new Player("Hossam Ahmed", ++NumofPlayers, "hossam_ahmed@yahoo.com", "9862520",
			"0100987689", "Shobra");
	static Player player7 = new Player("Tarek Mohamed", ++NumofPlayers, "tarek_mohamed@gmail.com", "1546886",
			"01287070008", "Maadi");
	static Player player8 = new Player("Kareem Abdallah", ++NumofPlayers, "kareem_abdallah@yahoo.com", "6325784",
			"01001274758", "Tahrir");
	static Player player9 = new Player("Youusef mohamed", ++NumofPlayers, "youssef_mohamed@gmail.com", "1129900",
			"0100079568", "Sheikh Zayed");
	static Player player10 = new Player("Moemn Ahmed", ++NumofPlayers, "moemn_ahmed@yahoo.com", "9862520", "0100987689",
			"Shobra");
	static Player player11 = new Player("Tarek El Sayed", ++NumofPlayers, "tarek_elsayed@gmail.com", "1546886",
			"01287070008", "Maadi");
	static Player player12 = new Player("Belal Abdallah", ++NumofPlayers, "belal_abdallah@yahoo.com", "6325784",
			"01001274758", "Tahrir");
	static PlaygroundOwner playgroundOwner1 = new PlaygroundOwner("Ahmed Ali", ++NumofPlaygroundOwners,
			"ahmed_ali@yahoo.com", "7112000", "01005956855", "Rehab");
	static PlaygroundOwner playgroundOwner2 = new PlaygroundOwner("Mostafa Aymen", ++NumofPlaygroundOwners,
			"mostafa_ayman@yahoo.com", "1142000", "01044526258", "Fifth settlement");
	static PlayingHours playingHours1 = new PlayingHours(2, LocalTime.of(10, 0), LocalTime.of(23, 0));
	static Playground playground1 = new Playground("The Zig Zag Park", 1200, "Shobra", playingHours1, 120, 5);
	static PlayingHours playingHours2 = new PlayingHours(3, LocalTime.of(9, 0), LocalTime.of(1, 0));
	static Playground playground2 = new Playground("Crypto Wonder park", 1400, "Maadi", playingHours2, 140, 6);
	static PlayingHours playingHours3 = new PlayingHours(2, LocalTime.of(9, 0), LocalTime.of(23, 0));
	static Playground playground3 = new Playground("The Distant Shore Play land", 1500, "Maadi", playingHours3, 150, 4);
	static PlayingHours playingHours4 = new PlayingHours(3, LocalTime.of(8, 0), LocalTime.of(23, 0));
	static Playground playground4 = new Playground("Ramsis Park", 1600, "Ramsis", playingHours4, 100, 3);

	/**
	 * playground owner requests the system to register his playground
	 * @param playground
	 * @return true if request accepter by the administrator
	 */
	public static boolean requestToRegisterPlayground(Playground playground) {
		if (Administrator.approvePlayground(playground)) {
			// add approved playground to the database
			playgrounds.add(playground);
			return true;
		} else
			return false;
	}
	/**
	 * player requests the system to book playground
	 * @param playgroundName
	 * @param time
	 * @return true if the time slot is free
	 */
	public static boolean requestToBookPlayground(String playgroundName, int time) {
		boolean flag = false;
		for (int j = 0; j < playgrounds.size(); j++) {
			if (playgroundName.contentEquals(playgrounds.elementAt(j).getName())) {
				if (playgrounds.elementAt(j).getStartingHour().compareTo(LocalTime.of(time, 0)) < 0) {
					if (playgrounds.elementAt(j).bookings.size() != 0) {
						for (int k = 0; k < playgrounds.elementAt(j).bookings.size(); k++) {
							if (playgrounds.elementAt(j).bookings.elementAt(k).startingHour
									.compareTo(LocalTime.of(time, 0)) != 0) {
								flag = true;
								Booking object = new Booking(playgrounds.elementAt(j).getDuration(),
										LocalTime.of(time, 0),
										LocalTime.of((time + playgrounds.elementAt(j).getDuration()), 0),
										playgrounds.elementAt(j).getCencellationPeriod(), playgrounds.elementAt(j));
								playgrounds.elementAt(j).bookings.add(object);
							}
						}
					} else {
						flag = true;
						Booking object = new Booking(playgrounds.elementAt(j).getDuration(), LocalTime.of(time, 0),
								LocalTime.of((time + playgrounds.elementAt(j).getDuration()), 0),
								playgrounds.elementAt(j).getCencellationPeriod(), playgrounds.elementAt(j));
						playgrounds.elementAt(j).bookings.add(object);
						// player.Bookings.add(object);
					}

				}
			}
		}

		return flag;
	}
	/**
	 * sign up screen
	 */
	public static void signup() {
		java.lang.System.out.println("Do you want to signup as a \n1)playerground Owner \n2)Player");
		Scanner scanner = new Scanner(java.lang.System.in);
		String choice = scanner.nextLine();
		while (!choice.contentEquals("1") && !choice.contentEquals("2")) {
			java.lang.System.out.println("Please enter 1 or 2");
			choice = scanner.nextLine();
		}
		String name, email, phone, location, pass, confirmPass;
		java.lang.System.out.println("Enter your name");
		name = scanner.nextLine();
		java.lang.System.out.println("Enter your E-mail");
		email = scanner.nextLine();
		// checking validation of email
		while (true) {
			if (email.length() < 6) {
				java.lang.System.out.println("This email is not valid.Enter again");
				email = scanner.nextLine();
			} else
				break;
		}
		while (true) {
			boolean flag1, flag2, flag3;
			while (true) {
				flag1 = false;
				for (int i = 0; i < email.length(); i++) {
					if (email.charAt(i) == ' ') {
						java.lang.System.out.println("E-mail Can't contain spaces.Enter again");
						email = scanner.nextLine();
						flag1 = true;
						break;
					}
				}
				if (flag1) {
					continue;
				} else {
					flag1 = true;
					break;
				}

			}
			while (true) {
				flag2 = false;
				for (int i = 0; i < email.length(); i++) {
					if (email.charAt(i) == '@') {
						flag2 = true;
						break;
					}
				}
				if (flag2) {
					break;
				} else {
					java.lang.System.out.println("E-mail must contain '@'.Enter again");
					email = scanner.nextLine();
				}
			}
			while (true) {
				flag3 = false;
				for (int i = 0; i < email.length(); i++) {
					if (email.charAt(i) == '.') {
						flag3 = true;
						break;
					}
				}
				if (flag3) {
					break;
				} else {
					java.lang.System.out.println("E-mail must contain '.'.Enter again");
					email = scanner.nextLine();
				}
			}
			if (flag1 && flag2 && flag3)
				break;
		}
		java.lang.System.out.println("Enter your phone");
		phone = scanner.nextLine();
		// checking validation of password
		while (true) {
			while (true) {
				java.lang.System.out.println("Enter your new password");
				pass = scanner.nextLine();
				if (pass.length() < 6) {
					java.lang.System.out.println("Password must contain at least 6 characters");
				} else
					break;
			}
			java.lang.System.out.println("Confirm your password");
			confirmPass = scanner.nextLine();
			if (pass.contentEquals(confirmPass))
				break;
			else {
				java.lang.System.out.println("Password and confirmation are not identical");
			}

		}
		java.lang.System.out.println("Enter yout location");
		location = scanner.nextLine();
		if (choice.contentEquals("1")) {
			PlaygroundOwner object = new PlaygroundOwner(name, ++NumofPlaygroundOwners, email, pass, phone, location);
			playgroundOwners.add(object);
		} else {
			Player object = new Player(name, ++NumofPlaygroundOwners, email, pass, phone, location);
			players.add(object);
		}
		java.lang.System.out.println("We have sent you an e-mail with the verification code.Please enter it");
		choice = scanner.nextLine();
		java.lang.System.out.println("Congratulations " + name + "!\nYou signed up to GoFo successfully");
	}
	/**
	 * log in screen
	 */
	public static void login() {
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		players.add(player5);
		players.add(player6);
		players.add(player7);
		players.add(player8);
		playgroundOwner1.setPlayground(playground1);
		playgroundOwner1.setPlayground(playground4);
		playgroundOwner2.setPlayground(playground2);
		playgroundOwner2.setPlayground(playground3);
		playgroundOwners.add(playgroundOwner1);
		playgroundOwners.add(playgroundOwner2);
		playgrounds.add(playground1);
		playgrounds.add(playground2);
		playgrounds.add(playground3);
		playgrounds.add(playground4);
		String email, pass;
		Scanner scanner = new Scanner(java.lang.System.in);
		java.lang.System.out.println("\nPlease enter your E-mail and password to log in");
		while (true) {
			java.lang.System.out.println("E-mail:");
			email = scanner.nextLine();
			java.lang.System.out.println("Password:");
			pass = scanner.nextLine();
			int i;
			String role = "";

			for (i = 0; i < players.size(); i++) {
				if (players.elementAt(i).getEmail().contentEquals(email)
						&& players.elementAt(i).getPassword().contentEquals(pass)) {
					role = "player";
					break;
				} else if (playgroundOwners.elementAt(i).getEmail().contentEquals(email)
						&& playgroundOwners.elementAt(i).getPassword().contentEquals(pass)) {
					role = "playgroundOwner";
					break;
				}

			}
			if (i == players.size()) { // email and password don't exist
				java.lang.System.out.println("Wrong E-mail or Password.Try Again");
				continue;
			} else {

				if (role.contentEquals("player")) {
					// here goes player page
					playerMainPage(players.elementAt(i));
				} else {
					OwnerMainPage(playgroundOwners.elementAt(i));
				}
			}
			break;
		}

	}
	/**
	 * player options
	 * @param player
	 */
	public static void playerMainPage(Player player) {
		// here goes player page
		String choice = "";
		Scanner scanner = new Scanner(java.lang.System.in);
		java.lang.System.out.println("Welcome Player " + player.getName());
		while (true) {
			java.lang.System.out.println(
					"What do you want to do? \n1)Book a playgorund \n2)View playgrounds \n3)Create team \n4)Return to log in page \n5)Log out");
			choice = scanner.nextLine();
			if (choice.contentEquals("1")) {
				viewPlaygrounds();
				player.bookPlayground();
				playerMainPage(player);

			} else if (choice.contentEquals("2")) {
				viewPlaygrounds();
				playerMainPage(player);

			} else if (choice.contentEquals("3")) {
				player.createTeam();
				playerMainPage(player);
			} else if (choice.contentEquals("4")) {
				login();
			} else if (choice.contentEquals("5")) {
				break;
			} else {
				java.lang.System.out.println("Invalid.You sould enter 1,2,3 or 4");
				continue;
			}

		}

	}
	/**
	 * list all playgrounds on the system
	 */
	public static void viewPlaygrounds() {
		java.lang.System.out.println("\nHere are all Playgrounds of the System:\n");
		for (int j = 0; j < playgrounds.size(); j++) {
			java.lang.System.out.println((j + 1) + ") " + playgrounds.elementAt(j).getName() + ":");
			java.lang.System.out.println("Location: " + playgrounds.elementAt(j).getLocation());
			java.lang.System.out.println("Size: " + playgrounds.elementAt(j).getSize());
			java.lang.System.out.println("Opens from " + playgrounds.elementAt(j).getStartingHour() + " To "
					+ playgrounds.elementAt(j).getClosingHour());
			java.lang.System.out
					.println("The price per hour: " + playgrounds.elementAt(j).getPricePerHour() + " L.E\n");
		}
		java.lang.System.out.println("Do you want to filter them by hours?");
		Scanner scan = new Scanner(java.lang.System.in);
		String ans = "";
		ans = scan.nextLine();
		if (ans.contentEquals("yes") || ans.contentEquals("YES") || ans.contentEquals("y") || ans.contentEquals("Y")) {
			int time;
			java.lang.System.out.println("Enter starting hour");
			time = scan.nextInt();
			for (int j = 0; j < playgrounds.size(); j++) {
				if (playgrounds.elementAt(j).getStartingHour().compareTo(LocalTime.of(time, 0)) < 0) {
					if (playgrounds.elementAt(j).bookings.size() != 0) {
						for (int k = 0; k < playgrounds.elementAt(j).bookings.size(); k++) {
							if (playgrounds.elementAt(j).bookings.elementAt(k).startingHour
									.compareTo(LocalTime.of(time, 0)) != 0) {
								java.lang.System.out.println("\n" + playgrounds.elementAt(j).getName() + ":");
								java.lang.System.out.println("Location: " + playgrounds.elementAt(j).getLocation());
								java.lang.System.out.println("Size: " + playgrounds.elementAt(j).getSize());
								int endTime = time + playgrounds.elementAt(j).bookings.elementAt(k).duration;
								java.lang.System.out.println(
										"Avaialble From: " + LocalTime.of(time, 0) + " to " + LocalTime.of(endTime, 0));
							}
						}
					} else {
						java.lang.System.out.println("\n" + playgrounds.elementAt(j).getName() + ":");
						java.lang.System.out.println("Location: " + playgrounds.elementAt(j).getLocation());
						java.lang.System.out.println("Size: " + playgrounds.elementAt(j).getSize());
						int endTime = time + playgrounds.elementAt(j).getDuration();
						java.lang.System.out.println(
								"Avaialble From: " + LocalTime.of(time, 0) + " to " + LocalTime.of(endTime, 0));
					}

				}
			}
		}

	}
	/**
	 * playground owner options
	 * @param owner
	 */
	public static void OwnerMainPage(PlaygroundOwner owner) {
		// here goes owner page
		String choice = "";
		Scanner scanner = new Scanner(java.lang.System.in);
		java.lang.System.out.println("Welcome Owner " + owner.getName());
		while (true) {
			java.lang.System.out.println("What do you want to do?\n1)Add Playground\n2)Log out");
			choice=scanner.next();
			if (choice.contentEquals("1")) {
				owner.addPlayground();
				java.lang.System.out.println("\nThanks for using GoFo system!");
				break;
			} else if (choice.contentEquals("2")) {
				break;
			} else {
				java.lang.System.out.println("Invalid.You sould enter 1 or 2");
				continue;
			}
		}
	}
	/**
	 * check email if is valid or not
	 * @param email
	 * @return true if email is valid and false if is invalid
	 */
	public static boolean checkEmail(String email) {
		for (int i = 0; i < players.size(); i++) {
			if (players.elementAt(i).getEmail().contentEquals(email)) {
				return true;
			}
		}
		return false;
	}

}
