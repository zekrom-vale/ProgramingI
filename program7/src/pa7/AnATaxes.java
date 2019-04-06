package pa7;

import java.util.Scanner;

/**
* Title:		Guessing<br>
* Author:		Shawn Graven<br>
* Email:		shawn.graven@my.uwrf.edu<br>
* Created: 		12/3/18<br>
* Modified: 	12/15/18 3:54p<br>
* Description:	Calculates your fees for AnATaxes to do your taxes
* @see #main(String[])
* @see input
* @see PROPERTY
* @see SETTING
*/
public class AnATaxes{//Hover over anything to to see the JavaDoc 
	/**
	 * Flag used to terminate the program<br>
	 * Needs to be global as `input.query` and main uses it
	 */
	static boolean terminateFlag=false;
	//Classes are different with scope, to access them you must do `class.*`
	/**
	 * @author Zekrom
	 * Class containing properties for script.<br>
	 * Access with {@code PROPERTY.*}.
	 */
	static final private class PROPERTY{
		/**
		 * Value to deliminate each estimate
		 * @see String#repeat(int) String.repeat(int) / *Only for java 11)* /
		 *///Order of `static`, `abstract`, ``; `final`, ; `private`, `protected`, ``, `public` is irrelevent
		static final String SPACER="--------------------------------------------";
		/**
		 * Fields defining the monetary unit
		 * @see #UNIT
		 * @see #UNIT_NAME
		 */
		final static String UNIT_NAME="USD",
			UNIT="$";
		/**
		 * RegExp used to check weather to terminate or not
		 */
		final static String TERMINATE="(q(uit)?|e(xit)?|leave|terminate)";
		/**
		 * Message to print at end
		 * @see PROPERTY#goodBuy()
		 */
		final static String EXIT="Thank you for using A&A for your taxes!";
		/**
		 * Prompt for directions<br>
		 * Use at start of program
		 * @see AnATaxes#main(String[])
		 */
		final static String WELCOME="Enter you A&A tax information to calculate your fee.\nType quit, terminate, or end at any time to quit.";
		//Must full declare to use JavaDoc, `,` applies JavaDoc to all fields
	}
	//Reference as SETTING.FORMAT.LEFT
	/**
	 * Class containing settings for the program
	 */
	static private final class SETTING{
		//Reference as FORMAT.LEFT
		/**
		 * Class containing string formating info
		 */
		final static class FORMAT{
			//Reference as LEFT
			/**
			 * Number used to format strings left<br>
			 * {@code Value************}
			 */
			final static int LEFT=-40;
		}
	}
	public static void main(String[] args){//JavaDoc does not work locally, variables do not work
		System.out.println(PROPERTY.WELCOME);
		//`System.err.println(...);` is inconsistent here
		System.out.println(PROPERTY.SPACER);
		input.open();
		while(true){
			//Could have done `({"","$",0},{"","$",0},{"",null,0}])` but java does not easily accept any type in arrays
			/*****************
			 PROMPT and INPUT 
			*****************/
			//`AnATaxes` is not necessary as it is in the scope of `AnATaxes`, and implied
			double income=input.query("Yearly income in "+PROPERTY.UNIT_NAME+":", PROPERTY.UNIT, SETTING.FORMAT.LEFT);
			if(terminateFlag)break;//Rather than asking at the end the user can quit any time, makes input faster
			double rate=input.query("Rate per hour:", PROPERTY.UNIT, SETTING.FORMAT.LEFT);
			if(terminateFlag)break;//Can not use `System.exit(0);` as it will skip `goodBuy()`
			double time=input.query("Consulting time in minutes:", null, SETTING.FORMAT.LEFT);
			if(terminateFlag)break;
			/**********
			 CALCULATE
			***********/
			double fee=calculateFee(income, rate, time);
			/******
			 PRINT
			*******/
			printFee(fee);
		}
		/**************
		 CLOSE SCANNER
		**************/
		input.close();
		/***************
		 Print Good Buy
		***************/
		goodBuy();

	}
	/**
	 * Prints the good buy message.
	 * @see PROPERTY#EXIT
	 *///	class#method||field
	private static void goodBuy(){
		System.out.println(PROPERTY.EXIT);
	}
	/**
	 * Prints and formats the fee for the user.
	 * @param fee The fee to print out.
	 * This should be the amount the user owes. (or estimated to owe)
	 * @see #calculateFee(double, double, double)
	 */
	private static void printFee(double fee){//@peram defines the description
		System.out.printf("%"+(SETTING.FORMAT.LEFT+1)+"s"+PROPERTY.UNIT+"%.2f\n", "Your calculated fee is:", fee);
		System.out.println(PROPERTY.SPACER);
	}
	/**
	 * Calculates the fee based on parameters.
	 * @param income How much the user earns in a year.
	 * @param rate The price per minute of AnA services.
	 * @param time The amount of time AnATaxes spent on taxes
	 * @return The fee the user owes. (or estimated to owe)
	 * @see #printFee(double)
	 */
	private static double calculateFee(double income, double rate, double time){
		//Low income
		if(income<=25_000)return time<=30? 0:.4*rate*time/60;
		//High income
		return time<=20?0:.7*rate*time/60;//else is not required due to return above (Redundant)
	}
	/**
	 * Class used to manage prompts and inputs
	 * @see #open()
	 * @see #query(String, String, int)
	 * @see #close()
	 */
	static class input{
		/**
		 * Scanner scanning {@link System#in}
		 * @see #open()
		 * @see #query(String, String, int)
		 * @see #close()
		 */
		private static Scanner user;
		/**
		 * Opens the scanner required for input
		 * @see #open()
		 */
		public static void open(){
			user=new Scanner(System.in);//I don't know how to pass System.in as a parameter
		}
		/**
		 * Closes the scanner to prevent a memory leak
		 * @see #open()
		 */
		public static void close(){
			user.close();
		}
		/**
		 * Formats and prompts the user for input then validates the input.<br>
		 * If it matches exit const it will quit.<br>
		 * Must open {@code Scanner} with {@link #open()}<br>
		 * Prevent a memory leak with {@link #close()}
		 * @param prompt What to prompt the user. (Display)
		 * @param unit The monetary unit to print. Pass {@code null} to ignore this.
		 * @param left Left formating to create a standard column.
		 * @return input Validated user input from the console
		 */
		public static double query(String prompt, String unit, int left /*Could have directly accessed SETTING.FORMAT.LEFT*/){
			if(unit!=null)System.out.printf("%"+(left+1)+"s"+unit, prompt);//Connect should be after `-` to prevent err
			else System.out.printf("%"+left+"s", prompt);
			while(true){//Loop forever, only stop if broken
				String in=user.nextLine();
				if(in.matches("(?i)"+PROPERTY.TERMINATE)){
					terminateFlag=true;
					return -1;//Must return a value );
				}
				try{//Prevent a termination of the script
					return Double.parseDouble(in);
				}catch(@SuppressWarnings("unused") NumberFormatException e){//Override waning for required e
					System.err.println("Invalid double: "+in);
				}
			}
		}
	}
}//EOMC
