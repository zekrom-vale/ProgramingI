package pa2;

/**
* @title myMath
* @author Shawn Graven
* @email shawn.graven@my.uwrf.edu
* @created 9/20/18
* @modified 9/26/19 2:45p//Ignoring testing and very minor edits
* @description Calculates the area and perimeter of various shapes, also validates user input

 */
public final class myMath{//Do not name Math, java.lang.Math will not work!
	static java.util.Scanner user=new java.util.Scanner(System.in);//Create a new java.util.Scanner named user, scanning System.in (aka console)
	/**
	 * Code to automatically run
	 * @param iESA irrelevenEmptyStringArray
	 */
	public static void main(String[] iESA){
		
		/********
		 Triangle
		*********/
		
		//input decelerations
		System.out.print("Triangle side one:\t");
			double triangleSide1=user.nextDouble();
		System.out.print("Triangle side two:\t");
			double triangleSide2=user.nextDouble();
		System.out.print("Triangle side three:\t");
			double triangleSide3=user.nextDouble();
		
		System.out.print("Triangle Height:\t");
			double triangleHeight=user.nextDouble();
		System.out.print("Triangle Base:\t\t");
			double triangleBase=user.nextDouble();
		
		//Print known values (Via user input)
		System.out.println("Given: sides = {"+triangleSide1+", "+triangleSide2+", "+triangleSide3+
			"}, base = "+triangleBase+", and height = "+triangleHeight
		);
		
		//Calculate area and perimeter (Also declare)
		double perimeter=triangleSide1+triangleSide2+triangleSide3,//sum(sides)
		area=triangleHeight*triangleBase/2.;//bh/2
			//Print area and perimeter
			System.out.println("Area = "+perimeter+
				", Perimeter = "+area+"\n"
			);
		
		/********
		  Circle
		*********/
		
		//input decelerations
		System.out.print("Circle Radius:\t\t");
			double radius=user.nextDouble();
		
		//Print the known value (Via user input)
		System.out.println("Given: radius = "+radius);

		//Calculate area and perimeter
		perimeter=2.*Math.PI*radius;
		area=Math.PI*Math.pow(radius,2);
			//Print area and perimeter
			System.out.println("Area = "+area+
				", Perimeter = "+perimeter+"\n"
			);
		
		/********
		  Square
		*********/
		
		//input decelerations
		System.out.print("Square Side:\t\t");
			double squareSide=user.nextDouble();
		
		//Print the known value (Via user input)
		System.out.println("Given: side = "+squareSide);
		
		//Calculate area and perimeter
		area=Math.pow(squareSide, 2);//s^2
		perimeter=4*squareSide;//4s
			//Print area and perimeter
			System.out.println("Area = "+area+
				", Perimeter = "+perimeter+"\n"
			);
		
		/**********
		 Rectangle
		***********/
		
		System.out.print("Rectangle Height:\t");
			double rectangleHeight=user.nextDouble();
		System.out.print("Rectangle Width:\t");
			double rectangleWidth=user.nextDouble();
			user.close();//Closes scanner to prevent a leak

		//Print the known values (Via user input)
		System.out.println("Given: sides = {"+rectangleHeight+", "+rectangleWidth+"}");
		
		//Calculate area and perimeter
		area=rectangleHeight*rectangleWidth;//wh
		perimeter=rectangleHeight*2+rectangleWidth*2;//2h+2w
			//Print area and perimeter
			System.out.println("Area = "+area+
				", Perimeter = "+perimeter+"\n"
			);
	}//EOMM
}//EOMC
