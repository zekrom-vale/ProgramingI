package zUtil;
import java.util.Scanner;

/*
* Title:		Input API
* Author:		Shawn Graven
* Email:		shawn.graven@my.uwrf.edu
* Created: 		9/07/18
* Modified: 	9/12/19 5:30p//Ignoring testing and very minor edits
* Description:	Provides valid input from the user, weather it be an int, bool, or string.
*/

public class Input{
	public static final String rInt=wrap("\\d+"),
		rDouble=wrap("\\d+(\\.\\d+)?"),
		rBool=wrap("true|false");
	private static Scanner user;
	public static void Open(){
		user=new Scanner(System.in);
	}
	public static int Int(String sPrompt, String sErr){
		while(true){
			String sOut=get(sPrompt);
			if(sOut.matches(rInt))return Integer.parseInt(sOut);
			System.out.println(sErr);
		}
	}
	public static int Int(String sPrompt, String sErr, String sBound, int iMin, int iMax){
		while(true){
			String sOut=get(sPrompt);
			if(sOut.matches(rInt)){
				int iOut=Integer.parseInt(sOut);
				if(iOut>=iMin&&(iOut<=iMax))return iOut;
				System.out.println(sBound + " ["+iMin+","+iMax+"]");
					//continue;
			}
			else System.out.println(sErr);
		}
	}
	public static double Double(String sPrompt, String sErr){
		while(true){
			String sOut=get(sPrompt);
			if(sOut.matches(rDouble))return Double.parseDouble(sOut);
			System.out.println(sErr);
		}
	}
	public static double Double(String sPrompt, String sErr, String sBound, double dMin, double dMax){
		while(true){
			String sOut=get(sPrompt);
			if(sOut.matches(rDouble)){
				double iOut=Double.parseDouble(sOut);
				if(iOut>=dMin&&iOut<=dMax)return iOut;
				System.out.println(sBound + " ["+dMin+","+dMax+"]");
				//continue;
			}
			else System.out.println(sErr);
		}
	}
	public static String Any(String sPrompt, String reg, String sErr){
		String sOut="";
		while(true){
			sOut=get(sPrompt);
			if(sOut.length()>0&&sOut.matches(reg))return sOut;
			System.out.println(sErr);
		}
	}
	public static String Any(String sPrompt, String sErr){
		String sOut="";
		while(true){
			sOut=get(sPrompt);
			if(sOut.length()>0)return sOut;
			System.out.println(sErr);
		}
	}
	public static String Any(String sPrompt){
		return get(sPrompt);
	}
	public static Boolean Bool(String sPrompt, String sErr){
		String sOut="";
		while(true){
			sOut=get(sPrompt);
			if(sOut.matches(rBool))return IsTrue(sOut);
			System.out.println(sErr);
		}
	}
	public static Boolean IsTrue(String sOut) {
		return sOut.matches("^\\s*(?i)true\\s*$");
	}
	public static String[] Type(String sPrompt){
		String[] sResult={get(sPrompt),null};
		if(sResult[0].matches(rInt)) sResult[1]="int";
		else if(sResult[0].matches(rDouble)) sResult[1]="double";
		else if(sResult[0].matches(rBool)) sResult[1]="Boolean";
		else sResult[1]="String";
		return sResult;
	}
	private static final String wrap(String sReg) {
		return "(?i)^\\s*("+sReg+")\\s*$";
	}
	public static String get(String sPrompt){
		//Scanner user=new Scanner(System.in);
		if(sPrompt!=null)System.out.println(sPrompt);
		return user.nextLine();
	}
	public static void Close(){
		user.close();
	}
}
