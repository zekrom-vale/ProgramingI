package math;

import java.util.Scanner;

public class AreaC{

	public static void main(String[] args){
		System.out.print("Radius of circle:\t");
		System.out.println(
			"The area of the circle is:\t"+
			areaCircle(new Scanner(System.in).nextDouble())
		);//Can not close local scanner
	}

	public static double areaCircle(double r){//signature
		return Math.PI*Math.pow(r, 2);
	}
	public static double areaCircle(){
		return Math.PI;
	}

}
