package pa1;//Deceleration of package, import as a package with import, ie `import pa1.*`

/*
* Title:		CS 161 PA1
* Author:		Shawn Graven
* Email:		shawn.graven@my.uwrf.edu
* Created: 		9/10/18 @ 3p
* Modified: 	9/11/19 910:50p//Ignoring testing and very minor edits
* Description:	Prints info about Minnesota
*/
public class PrintInfo{
	public static final void main(String[] irreleventEmptyStringArray){
		/*
		 * Had to change `org.eclipse.jdt.core.prefs` to make it work with Java 8
		 * Changed from 10 to 8 or 9:
		 * org.eclipse.jdt.core.compiler.codegen.targetPlatform=8
		 * org.eclipse.jdt.core.compiler.compliance=9
		 * 
		 * Most of the time describing variables are redundant if you name them well
		 * */
		final String state="Minnesota",//Name of state (final: can not change)
			location="Midwestern",
			country="United States";//Name of country
		String[] knownAs={"Owing its large number of lakes, the\nstate is informaly known as the","the land of 10,000 Lakes"};//What the state is known as
		int pop=5_379_139;//Population of the state
		short popYear=20__12;//Year the population info was gathered
		String weather="experiences tempature extremes charateristic of its continental climate, with cold\nwinters and hot summers.";//Description of the weather
		short[] temp={-60,114,174};//Tempters from lowest to highest
		String tempUnit="Fahrenheit";//Unit of the tempters
		String[] tempDates={"February 2, 1996", "July 6,\n1936", null},//Dates the tempters were recorded
			tempLocation= {"Tower", "Moorhead", null}; 
		//Corresponds to the tempters in order
		String taxType="progressive";
		double[] tax={5.35,7.05,7.85,9.85};//Array of the tax rates
		//float[] tax=(float[]){5.35,7.05,7.85,9.85};//does not work
		System.out.println(
			state+" is a state in the "+location+' '+country+". "+String.join(" \"",knownAs)+"\". The "+country+" Census\n"
				+ "Bureau estimates the population of "+state+" was "+pop+" in "+popYear+"."
			+dupe("\n",2)+
			
			state+" "+weather+" The record high and low span is "+temp[2]+" degrees "+tempUnit+", from\n"
				+ temp[0]+" "+tempUnit+" at "+tempLocation[0]+" on "+tempDates[0]+", to "+temp[1]+" "+tempUnit+" at "+tempLocation[1]+" on "+tempDates[1]+
			dupe("\n")+
			
			state+" has a "+taxType+" income tax structure; the "+nums[tax.length]+" brackets of state income tax rates\n"
				+ "are "+join(tax, true)+" percent."
		);
	}//EOM
	/*
	 * Functions
	*/
	//public is implied
	final static String join(double[] vals, Boolean comma){
		//This method/function formats the tax to a readable string
		String result="";
		byte _t=(byte)(vals.length-2);
		for(byte i=0;i<_t;i++)result+=vals[i]+", ";
		return result+vals[_t]+(comma?',':"")+" and "+vals[_t+1];
	}
	final static String join(String[] vals, Boolean comma){
		//Overloading a method/function
		//This method/function formats the tax to a readable string
		String result="";
		byte _t=(byte)(vals.length-2);
		for(byte i=0;i<_t;i++)result+=vals[i]+", ";
		return result+vals[_t]+(comma?',':"")+" and "+vals[_t+1];
	}
	final static String dupe(String entity, int x){
		if(x==1) return entity;
		//For ints x>>1 is always the same as x/2
		else if(x>>1==((float)x)/2) return dupe(entity+entity, x/2);
		else return entity+dupe(entity, x-1);
		//Recursive function (calls it's self)
	}
	final static String dupe(String entity){
		return entity+entity;
	}
	static final String[] nums={
		"zero","one","two","three","four","five","six","seven","eight","nine","ten"
	};
}//EOC
