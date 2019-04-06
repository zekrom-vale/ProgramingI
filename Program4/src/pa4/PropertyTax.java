package pa4;
import java.util.Scanner;//Import can be used instead of doing it in line, on the other hand modules MUST use requires, this helps reduce security concerns
/**********
MAIN CLASS
***********/
/**
* @title PropertyTax
* @author Shawn Graven
* @email shawn.graven@my.uwrf.edu
* @created 10/18/18
* @modified 10/26/19 3:04p
* @description Calculates your property tax
*///Javadoc is apparently quite complex, or does it use HTML?
public class PropertyTax{
	/*************************
	 STATIC FINAL Declaration
	**************************/
	//Could have used var to declare them all, but is only supported in Java 10+
	private static final byte FORMAT_LEFT=(byte)-30,
		FORMAT_RIGHT=20;//Formating to easly change spacing
	private static final String UNIT="$";//$€¥£元₩₺₽₹
		//Using String so longer currency units can be used
	private static final double TAXABLE_RATE=1.05, //Rate per TAXABLE_RATE_PER
		TAXABLE_RATE_PER=100,//int promoted to double
		RATE=TAXABLE_RATE/TAXABLE_RATE_PER,//Rate to find taxable amount
		TAX_RATE=.92;//Rate to take from taxable amount
		//Refactored names to correct them, tax is complicated.  Why can't they just use a tax rate, it is a flat overall rate
	private static final Scanner USER=new Scanner(System.in);//Declare a new Scanner named user scanning System.in
								//Used refactor to change to uppercase throughout the code
	/************
	 MAIN METHOD
	*************/
	public static void main(String[] args){
		/***********
		 USER INPUT
		************/
		System.out.printf("%"+(FORMAT_LEFT-1)+"s","Name:");//Unable to right justify user input
		String name=USER.nextLine();
		System.out.printf("%"+(FORMAT_LEFT-1)+"s","Assessed Value:");//'%' will not work, it will try to add
		/**********
		 CALCULATE
		***********/
		double value=USER.nextDouble(),//Amount they make
			taxable=value*TAX_RATE,//Value that can be taxed
			tax=taxable*RATE;//Amount of tax they owe / pay
		/****************
		 FORMAT && PRINT  //Lua is an odd language and does not use &&,||,{} ; instead they use and,or,then do end 
		-----------------
			  BLOCK		  //Local block of code, decelerations will be garbaged collected after corresponding '}'
		****************/
		{
			//Construct main format string
			String format="%"+FORMAT_LEFT+"s %s %"+FORMAT_RIGHT+".2f\n";//% does not escape until formated
			System.out.printf(//Directly print to console
				//Construct format string
				"\n%"+FORMAT_LEFT+"s %s\n\n"+
				format+//format.repeat(4)//Java 11+
				format+
				format+
				format+
				"%"+FORMAT_LEFT+"s %s %"+FORMAT_RIGHT+".4f\n",
				//Values to format, grouped by row
				"Property Tax Report For:", name,
				"Assessed Value:", UNIT, value,
				"Taxable Amount:", UNIT, taxable,
				"Taxable Rate for each " + UNIT+ " " + TAXABLE_RATE_PER+":", UNIT, TAXABLE_RATE,
				"Property Tax:", UNIT, tax,//Can not escape `%` with `%%` or `\%` or `\\%`, a big flaw
				"Overall Rate:", '%', tax/value*100//Turns out it is always 0.9660%
			);//I think it is easer to use HTML
		}
		/***END****
		   BLOCK
		****END****/
		//System.out.println("78.8%5.4="+78.8%5.4);//Mathematical modulation works with floats, so programical mod should work with floats as well.
	}									//Do be warned that IEEE precision does .199999999999992 instead of .2
	/****END****
	 MAIN METHOD
	*****END****/
}
/***END****
 MAIN CLASS
****END****/

/*
ORDER OF OPERATORS
() [] -> . ::
! - + type cast ++ --
* / %
+ -
<< >>
>= > < <=
== !=
&
^
|
&&
||
?:
= += -= /= %= &= |= ^= <<= >>=
,
*/