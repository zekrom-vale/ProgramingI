package ex1;
import zUtil.*;
/*
 * Write a java program to add, multiply, subtract and divide 2 numbers
 * Determine the Input
 * Processing
 * Output
 */
public class MainClass {

	public static void main(String[] iESA){
		Input.Open();
		double value=Input.Double(null,"NAN");
		while(true) {
			String op=Input.Any(null,"^([\\+\\-\\*\\/^]|>{2,3}|<<)$","Not a valid operator");
			double input=Input.Double(null,"NAN"),
				store=value;
			switch(op) {
				case "+":
					value+=input;
					break;
				case "-":
					value-=input;
					break;
				case "*":
					value*=input;
					break;
				case "^":
				case "**":
					value=Math.pow(value, input);
					break;
				case ">>":
					value=(int)value>>(int)input;
					break;
				case ">>>":
					value=(int)value>>>(int)input;
					break;
				case "<<":
					value=(int)value<<(int)input;
					break;
			}
			System.out.println(store+op+input+"="+value);
		}
	}//EOMM

}//EOMC
