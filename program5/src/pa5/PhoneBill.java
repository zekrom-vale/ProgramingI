package pa5;
import java.util.Scanner;
//Eclipse loves to automatically add imports
/************************************************************************************
* @title PhoneBill
* @author Shawn Graven
* @email shawn.graven@my.uwrf.edu
* @created 10/28/18
* @modified 11/02/18 8:38a		//Most code was written on the first day
* @description Calculates a theoretical phone bill
************************************************************************************/
public class PhoneBill{
	//Apparently there is an externalize strings wizard, but there is no option to combine strings or set name as the value.  Plus, it does not account for the suppressions 
	/*************************
	 STATIC FINAL Declaration
	**************************/
	final static Scanner USER=new Scanner(System.in);//Declare a scanner scanning System.in
	//Declare premium costs/rates
		//This final is only for the class
	static final class PREMIUM{//Just too many variables to easily deal without classes
		final static float COST=25;//Used float if they want to use 24.99f
		final static short DAY_MAX=75,
			NIGHT_MAX=100;
		final static float DAY_RATE=.1f,//Could use double
			NIGHT_RATE=.05f;
	}
	//Declare regular costs/rates
	static final class REGULAR{
		final static short MAX=50;//Is there a way to mass declare finals and other options?  Other than the ',' method as it only works if it is the same type
		final static float COST=10,
			RATE=.2f;
	}
	/**
	 * Values used to format output
	 *///Declare formating settings
	private static final class FORMAT{
		//Declare spacing numbers so it is easy to change, useful like CSS var() function
		final static byte RIGHT=30,
			LEFT=-30;
		//Declare output format strings
		final static String STR_LEFT="%"+LEFT+"s",//Do not use `'%'` as it will add and not concat
			STR_FLOAT=STR_LEFT+"%"+RIGHT+".2f\n",
			STR_INT=STR_LEFT+"%"+RIGHT+"d\n",
			STR_STR=STR_LEFT+"%"+RIGHT+"s"+"\n";
	}
	static final String UNIT="$";//Could use char if knowing it is one character
	
	/************
	 MAIN METHOD
	*************/
	public static void main(String[] args){
		//Ask for inputs
		System.out.printf(FORMAT.STR_LEFT,"Account number:");
		long accountNumber=USER.nextLong();
		System.out.printf(FORMAT.STR_LEFT,"Service code:");
		String serviceCode=USER.next();
		double charge=0d;
		/*********************
		 SPLIT BASED ON INPUT
		*********************/
		/*
		""=="" Sometime works, new String("") is when it does not work.  Perhaps regular string is just a reference where new String is a completely different string
																			JavaScript does this with objects and arrays
		If using JavaScript && HTML I would use an input box, HTML makes GUI easy!
		Can not use switch, would be way too many cases to be worth it
		*/
		//Apparently `"x".equals(var);` avoids null pointer exceptions (Ctrl+1 to see reverse equals and other fixes/options)
		//To prevent invalid system code See last lines
		if("Premium".equalsIgnoreCase(serviceCode)||"P".equalsIgnoreCase(serviceCode)){//If serviceCode matches premium or p
			/********************
			 ASK FOR MORE INPUTS
			********************/
			System.out.printf("Minutes Used"+"\n"+FORMAT.STR_LEFT,"Day:");
			double dayMinutesUsed=Math.abs(USER.nextDouble());//Assume that negatives are a typo of positive a number
			System.out.printf(FORMAT.STR_LEFT,"Night:");
			double nighMinutesUsed=Math.abs(USER.nextDouble());
			
			/**********
			 CALCULATE
			***********/
			charge=PREMIUM.COST;
			//If used is more than the max charge extra over the max
											//same as `charge=charge+...;`
			if(dayMinutesUsed>PREMIUM.DAY_MAX)charge+=(dayMinutesUsed-PREMIUM.DAY_MAX)*PREMIUM.DAY_RATE;
			//if used as both are independent of each other 
			if(nighMinutesUsed>PREMIUM.NIGHT_MAX)charge+=(nighMinutesUsed-PREMIUM.NIGHT_MAX)*PREMIUM.NIGHT_RATE;
											//Refactor>Rename is so nice if you misspell something or change the name
			/**************
			 FORMAT OUTPUT
			**************/
			System.out.printf(
				//Construct format string
				"\n"+
				FORMAT.STR_INT+//STR_* includes '\n'
				FORMAT.STR_STR+
				FORMAT.STR_FLOAT+
				FORMAT.STR_FLOAT,
				//Vars
				"Account Number:", accountNumber,
				"Service Type:", "Premium",
				"Minutes Service Used (Day):", dayMinutesUsed,
				"Minutes Service Used (Night):", nighMinutesUsed
			);
		}
		//Just use else if you want it to be default or preventing invalid input
		else if("Regular".equalsIgnoreCase(serviceCode)||"R".equalsIgnoreCase(serviceCode)){//If serviceCode matches regular or p
			/********************
			 ASK FOR MORE INPUTS
			********************/
			System.out.printf(FORMAT.STR_LEFT,"Minutes Used:");
			double minutesUsed=Math.abs(USER.nextDouble());
			
			/**********
			 CALCULATE
			***********/
			charge=REGULAR.COST;
			if(minutesUsed>REGULAR.MAX)charge+=(minutesUsed-REGULAR.MAX)*REGULAR.RATE;//If used is more than the max charge extra over the max
			
			/**************
			 FORMAT OUTPUT
			**************/
			System.out.printf(
				//Format string
				"\n"+
				FORMAT.STR_INT+
				FORMAT.STR_STR+
				FORMAT.STR_FLOAT,
				//Vars
				"Account Number:", accountNumber,
				"Service Type:", "Regular",
				"Minutes Service Used (Day):", minutesUsed
			);
		}
		else{
			/*****************
			 END WITH FAILURE
			******************/
			System.err.print("Invalid Service Type");//You can also `throw new Error("Invalid Service Type");`
		}
		/************
		 OUTPUT COST
		  IFF != 0
		*************/
		if(charge!=0)System.out.printf(//Prevent output if charge is 0
			FORMAT.STR_STR,
			"Amount due:", UNIT+String.format("%.2f", charge)//Attach unit to number //$NON-NLS-2$
		);
	}//End of Main Method
}//End of Class
//-------------------------------------------------------------------------------------------
/*
Boolean isPremium;
while(true) {
	if("Premium".equalsIgnoreCase(serviceCode)||"P".equalsIgnoreCase(serviceCode)){
		isPremium=true;
		break;
	}
	else if("Regular".equalsIgnoreCase(serviceCode)||"R".equalsIgnoreCase(serviceCode)) {
		false;
		break;
	}
	else{
		System.out.print("Invalid Service");
		serviceCode=USER.next();
	}
}
if(isPremium)...
else ...
*/