package pa3;
import javax.swing.*;//javax=2005 java
/*
If this java code does not work for Java 8 Try:
	A) Open /setings/org.eclipse.jdt.core.preferences
		1) Change org.eclipse.jdt.core.compiler.codegen.targetPlatform to equal 8
		2) Change org.eclipse.jdt.core.compiler.compliance to equal 8
		ALT) Change Java Build Path
			1) Open `Project>Properties`
			2) Select `Java Build Path(Side Bar)>Libraries (Top bar)`
			3) Select `JRE System Library [...]`
			4) Click `Edit`
			5) Select a JRE you have (Selecting from alternative JRE is easer as it has your installed JREs)
	B) Remove or delete contents of /src/module-info.java
	D) Clean the project (Project>Clean)
*/
/**
* @title MyAge
* @author Shawn Graven
* @email shawn.graven@my.uwrf.edu
* @created 10/08/18
* @modified 10/12/19 2:08p//Ignoring testing and very minor edits
* @description Calculates your age on various planets
 */

public final class MyAge{
	//Declare year length per planets in year (Access by year.*)
	/**
	 * Sores finals of planetary year lengths.  
	 * No decimal pression required, so declared as int or less
	 */
	private final static class YEAR{
		final static byte MERCURY=88;//88 is small enough to fit in a byte [-128-127]
		final static short VENUS=225,//Char is the same size as short but is shifted to 0-0xffff (Java has no unsigned operators so it must be converted to int to calculate as most unsigned and signed ops are different)
			EARTH=365,
			JUPITER=4_380,//`_` is like whitespace for numbers
			SATURN=10_767;
	}//EOYC
	public final static void main(String[] iESA){
		System.out.println("\\\\Console shows that JOptionPane is synchronous and a model");//Eclipse will auto escape in strings with paste
		/*******
		  INPUT
		 *******/
		System.out.println("Waiting for user input...");
		float ageEarth=Float.parseFloat(JOptionPane.showInputDialog(//Nested methods work just fine, why waste space storing a temporary string?
			null,//Frame, null is default frame
			"Enter an Age:",//Prompt
			"Your age on Earth",//Title
			JOptionPane.INFORMATION_MESSAGE//Icon
		));//Does not handle null
		//Prompt user for an age, input is a String so must be parsed to number		//Search `Java <version> <package and Class>` and select oracle, search on page `<Class>` to find parameter information
		System.out.println("User input received, continuing \u25B6");//Program stops until input is received, no other processes can run on that thread
		
		/*******
		  CALC
		 *******/
		float ageDays=ageEarth*YEAR.EARTH;//Prevent redundant calculation
		//Calculate age on planets
		float ageMercury=ageDays/YEAR.MERCURY,//float cascades forcing YEAR.* to be float as well
			ageVenus=ageDays/YEAR.VENUS,
			ageJupiter=ageDays/YEAR.JUPITER,
			ageSaturn=ageDays/YEAR.SATURN;
		
		/********************
		  OUPTPUT and FORMAT
		 *******************/
		System.out.println("Displaying info, waiting for exit...");
		String format="%-20s%13.2f%n";//Still does not format correctly non-monospaced  font
		JOptionPane.showMessageDialog(
			null,//Frame
			String.format(//Format numbers to 0.01 precision
				format+format+format+format+format,
				//format.repeat(5),//Java 11 only
				"Age on Earth:", ageEarth,
				"Age on Mercury:", ageMercury,
				"Age on Venus:", ageVenus,
				"Age on Jupiter:", ageJupiter,
				"Age on Saturn:", ageSaturn
			),
			"Age on Other Worlds",//Popup title
			JOptionPane.INFORMATION_MESSAGE//Image of Popup, oddly the value is an int
		);
		System.out.println("Exit received, continuing \u25B6\n"
			+ "Displaying info, waiting for exit...");//Eclipse auto splits stings when hitting enter
		
		
		JOptionPane.showMessageDialog(//Print alt dialogue box
			null,//Frame
			String.format(
				"I am %.2f years old on %s but I would be very old on %s with %.2f years. Not so \n"
				+ "old on %s with %.2f years, very young on %s with %.2f years and really young on \n"
				+ "%s with %.2f years.",
				ageEarth, "Earth",//Grouping by correspondence
				"Mercury", ageMercury,
				"Venus", ageVenus,
				"Jupiter", ageJupiter,
				"Saturn", ageSaturn
			),
			"Age Details on Other Planets",//Popup title
			JOptionPane.PLAIN_MESSAGE//Image of Popup, oddly the value is an int
		);
									//% escape must be formated
		System.out.println("Program fi%nished \u220E"+(char)(0xffff*Math.random()));//Multiplies character max (65535 [0xffff]) by a random number [1-0] to create a random character
	}//EOMM

}//EOMC
