package main;
import zUtil.*;
/**
 * @author Zekrom
 *
 */
public class FirstJava{
	//main is a special function immediately invoked
	private static String sOFR="Out of Range";
	private static String sII="Invalid Input";
	public static void main(String[] a){//Must be String[]
		Version.error("^[0-9]\\..*");
		Input.Open();
		short hAge=(short) Input.Int("Your age", sII, sOFR, 0, 200);
		float fGpa=(float) Input.Double("Your GPA", sII, sOFR, 0, 4.34);
		String sName=Input.Any("Your Name", "Empty string");
		Input.Close();
		System.out.println("My first Java program in CSIS 161\nI am "+hAge+" years old ("+hAge*12+" months)\nand my GPA is "+fGpa+"\nI almost forgot my name witch is "+sName.split(" ")[0]);
	}
}