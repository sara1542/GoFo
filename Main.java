package control;

import java.util.Scanner;
/**
 * 
 * @author Sara Ibrahim
 *
 */
public class Main {
	/**
	 * 
	 * @param args the command lines arguments - unused
	 */
	public static void main(String[] args) {
		while(true) {
		java.lang.System.out
				.println("Welcome to GoFo Application.\nDo you want to: \n1)Sign up as a new user \n2)Log in \n3)Exit");
			String Answer="";
			Scanner scanner4 = new Scanner(java.lang.System.in);
			Answer=scanner4.nextLine();
			if(Answer.contentEquals("1")) {
				System.signup();
				continue;
			}
			else if(Answer.contentEquals("2")) {
				System.login();
				continue;
			}
			else if(Answer.contentEquals("3")) {
				break;
			}
			else {
				java.lang.System.out.println("Invalid.Please enter 1,2 or 3");	
			}
	}
		java.lang.System.out.println("Thanks for using GoFo system!");
		}
}
