package pa6;

import javax.swing.JOptionPane;
/*
 Swing is too small ONLY in 1.8 for 4K displays and not 11 or 10 (I don't know when they fixed it) 
*/

/**
* Title:		Guessing<br>
* Author:		Shawn Graven<br>
* Email:		shawn.graven@my.uwrf.edu<br>
* Created: 		11/14/18<br>
* Modified: 	11/27/18 9p<br>
* Description:	Runs a guessing game with given parameters
*/
public class Guessing{
	/**********************
	 SETTINGS DECLARATIONS<br>
	 	    ~FINAL~
	**********************/
	@SuppressWarnings("unused")//Ignore the unused warning in SETTINGS
	final private static class SETTINGS{
		/**
		 * Amount of tries the user has to guess the number
		 */
		final static byte TRYS=5;
		
		
		/**
		 * Values defining number<br>
		 * Maximum and Minimum
		 */
		private static final long MIN=0,
			MAX=100;
		/**
		 * @param start
		 * @param end
		 * @return A random value between start and end with a step of one
		 */
		static long random(long start, long end){
			return (long)(Math.random()*(end-start+1))+start;
		}
		/**
		 * @param start
		 * @param end
		 * @param step
		 * @return A random value between start and end with a specific step
		 */
		static double random(long start, long end, double step){
			return step*(long)((Math.random()*(end-start+1)+start)/step);
		}
		/**
		 * @param start
		 * @param end
		 * @return A random value between start and end with no step
		 */
		static double randomAnyStep(long start, long end){
			return Math.random()*(end-start+1)+start;
		}
		
		//Values guiding guessing
		/**
		 Minimum value to qualify<br>
		 Ex: For 50, 30, 15, 0 results in (inf,50] (50,30] (30,15] (15,0]
		 */
		final static byte[] RANGE={
			50,
			30,
			15,
			5,
			0
		};
		/**
		 Scale<br>
		 Must include the first space for correct spacing<br>
		 "" is blank
		 */
		final static String[] SCALE={
			" very",
			"",
			" moderately",
			" somewhat",
			" just"
		};
		/**
		 Severity<br>
		 A list of integers defining display icons<br>
		 JOptionPane has *_MESSAGE that corispons to each icon
		 */
		final static int[] SEVERITY={
			JOptionPane.ERROR_MESSAGE,
			JOptionPane.ERROR_MESSAGE,
			JOptionPane.WARNING_MESSAGE,
			JOptionPane.WARNING_MESSAGE,
			JOptionPane.INFORMATION_MESSAGE
		};
	}
	/**
	 Value to control developer information<br>
	 Only use for debug, not cheating!
	 */
	private static final boolean $$DEBUG=false;//Debug value to display number in console, this is called cheating (Or testing)
	
	/************
	 MAIN METHOD
	************/
	@SuppressWarnings("unused")
	public static void main(String[] args){
		/****************
		 GENERATE NUMBER 
		****************/
		final int number=(int)SETTINGS.random(SETTINGS.MIN, SETTINGS.MAX);//Variable to store the random number, calling the method SETTINGS.random
		if($$DEBUG)System.out.print(number);
		byte tryI=0;//Define iterator for try loop
		int guess=0;//Value the user has guessed
		guess:for(/*byte tryI=0*/; tryI<SETTINGS.TRYS; tryI++){
			/***********************
			 GET AND VALIDATE GUESS
			***********************/
			//@SuppressWarnings is invalid here
			{
				String stringInput;
				int intInput;
				boolean flagInvalid=false;
				outer:do{
					
					inner:do{
						stringInput=JOptionPane.showInputDialog(
							(flagInvalid?"Invalid input\nTry again!\n":"")+
							"Enter an Integer:\nGreater than or equal "+SETTINGS.MIN
							+" and less than or equal to "+SETTINGS.MAX,
							guess//Default to last guessed number (starts at 0)
						);
						flagInvalid=true;//Only sets to invalid after first input, only invalid input will call this value
					}while(!stringInput.matches("\\d*"));//Only continue if input is an int, otherwise go to inner do
					
					intInput=Integer.parseInt(stringInput);
					
				}while(intInput<SETTINGS.MIN||intInput>SETTINGS.MAX);//Only continue if input is within range, otherwise go to outer do
				//Was `!(inputDouble>=SETTINGS.MIN&&inputDouble<=SETTINGS.MAX)` until Ctrl+1 allowed me to push negation down 
				guess=Integer.parseInt(stringInput);// variable to store the number guessed by the user
				//Garbage Collect input and inputDouble
			}
			/**************
			 ANALYZE GUESS
			**************/
				//Equality
			if(guess==number){//With floats `if(Math.abs(guess-num)<1E-6)`
				JOptionPane.showMessageDialog(
					null, "You guessed the correct number.", "Correct!", JOptionPane.INFORMATION_MESSAGE
				);
				break guess;//Exit the loop without setting tryI
			}
				//Low/High
			String position=guess<number?"low":"high";//Tinerary operator like if and else but directly returns the value
			
			int difference=Math.abs(guess-number);
			if($$DEBUG)System.err.println(number+"\n"+difference);
				//Severity and display message
			//Result constructor		//Easy to scale, just modify SETTINGS.SCALE, SETTINGS.RANGE, and SETTINGS.SEVERITY
										//I just love how arrays can work!  (If objects were easy I would use one object array)
			test:for(int testJ=0; testJ<SETTINGS.SCALE.length; testJ++){
				if(difference>SETTINGS.RANGE[testJ]){
					JOptionPane.showMessageDialog(
						null,
						"Your guess is"+SETTINGS.SCALE[testJ]+" "+position+".\n"+
							SETTINGS.RANGE[testJ]+(testJ==0?" or more":" to "+SETTINGS.RANGE[testJ-1])+" off\n"+
							"Try: "+(tryI+1)+" of "+SETTINGS.TRYS+"\n"+//^Prevent null pointer exception
							"Previous number: "+guess,
						"Guess again!",
						SETTINGS.SEVERITY[testJ]
					);
					break test;//Prevent multiple messages from displaying
				}
			}//End of for

		}//End of while
		if(tryI>=SETTINGS.TRYS){//If the statement is too long I prefer to use {} 
			//If you do not win execute the following
			JOptionPane.showMessageDialog(null, "The number was "+number, "Out Of Tries", JOptionPane.ERROR_MESSAGE);
		}
	}//End of method
}//End of class
