package pa2;
import zUtil.*;//Import all classes under the package zUtil, My API that I created recently

/**
* @title Area
* @author Shawn Graven
* @email shawn.graven@my.uwrf.edu
* @created 9/20/18
* @modified 9/26/19 10:44a//Ignoring testing and very minor edits
* @description Calculates the area and perimeter of various shapes, also validates user input

 */
public final class myMath{//Do not name Math, java.lang.Math will not work!
	/**
	 * Error to throw if input is invalid
	 */
	static final String nan="Not a number",//Store error when value is invalid
		negErr="Cannot be negative";
	/**
	 * Infinity (Double and positive)
	 * @see Double.POSITIVE_INFINITY
	 */
	static final double inf=Double.POSITIVE_INFINITY;
	/**
	 * Code to automatically run
	 * @param iESA irrelevenEmptyStringArray
	 */
	public static void main(String[] iESA){//iESA (Why is this even required as an array, and at all?)
		Input.Open();
		//Triangle
		double[] triangleSides=new double[3];//Declare array(double[]) with length of 3
		for(byte i=1;i<=3;i++){//For 1 to 3 (inclusive) do:
			//i++ increment i by one
			//In JavaScript it is very common to use i as an iterable variable
			triangleSides[i-1]=Input.Double("Triangle side "+NumberToWord.word(i)+":\t", nan, negErr, 0, inf);
						//Get var at i-1 (As indexes start at 0)
							//Call method Input.Double to get and store valid user input
															//Call Numbers.word to convert i
		}//EOF
		double triangleHeight=Input.Double("Triangle Height:\t", nan, negErr, 0, inf),
			triangleBase=Input.Double("Triangle Base:\t\t", nan, negErr, 0, inf);//Declare triangleHeight and triangleBase from user input, handled by zUtil.Input (using Input.Double for this as it should accept all numbers)
		System.out.println("Given: sides = {"+NumberToWord.join(", ", triangleSides)+
			"}, base = "+triangleBase+", and height = "+triangleHeight
		);//Print the known values (Via user input)
		System.out.println("Area = "+Area.triangle(triangleHeight, triangleBase)+
			", Perimeter = "+Perimeter.triangle(triangleSides)+"\n"
		);//Calculate area and perimeter then print it, it is not saved to any variable
		//Circle
		double radius=Input.Double("Circle Radius:\t\t", nan, negErr, 0, inf);//Declare radius from user input
		System.out.println("Given: radius = "+radius);//Print the known value (Via user input)
		System.out.println("Area = "+Area.circle(radius)+
			", Perimeter = "+Perimeter.circle(radius)+"\n"
		);//Calculate area and perimeter then print it, it is not saved to any variable
		//Square
		double squareSide=Input.Double("Square Side:\t\t", nan, negErr, 0, inf);//Declare squareSide from user input
		System.out.println("Given: side = "+squareSide);
		//Print the known value (Via user input)
		System.out.println("Area = "+Area.square(squareSide)+
			", Perimeter = "+Perimeter.square(squareSide)+"\n"
		);//Calculate area and perimeter then print it, it is not saved to any variable
		//Rectangle
		double[] rectangleSides={
			Input.Double("Rectangle Height:\t", nan, negErr, 0, inf),
			Input.Double("Rectangle Width:\t", nan, negErr, 0, inf)
		};//Declare rectangleSides from user input
		System.out.println("Given: sides = {"+NumberToWord.join(", ", rectangleSides)+"}");
		//Print the known values (Via user input)
		Input.Close();//Closes scanner to prevent a leak
		System.out.println("Area = "+Area.rectangle(rectangleSides)+
			", Perimeter = "+Perimeter.rectangle(rectangleSides)+"\n"
		);//Calculate area and perimeter then print it, it is not saved to any variable
	}//EOMM

	//Functions/Methods to calculate area or perimeter (in nested classes)
	/**
	 * Calculates the perimeter of shapes
	 */
	public final static class Perimeter{
		//Declares a new static final method named "perimeterTriangle" that returns a double given a double[]
		/**
		 * @param sides
		 * @return sum
		 */
		static final double triangle(double[] sides){
			return sides[0]+sides[1]+sides[2];//Return the sum of the sides
		}
		/**
		 * @param radius
		 * @return perimeter
		 */
		static final double circle(double radius){
			return 2d*Math.PI*radius;
		}
		/**
		 * @param side
		 * @return perimeter
		 */
		static final double square(double side){
			return 4d*side;
		}
		/**
		 * @param sides
		 * @return perimeter
		 */
		static final double rectangle(double sides[]){
			return 2d*(sides[0]+sides[1]);
		}
	}
	/**
	* Calculates the area of shapes
	*/
	public final static class Area{
		/**
		 * @param base
		 * @param height
		 * @return perimeter
		 */
		static final double triangle(double base, double height){
			return base*height/2d;//Floats force 2 to be a double (processed ltr)
		}
		/**
		 * @param radius
		 * @return area
		 */
		static final double circle(double radius){
			return Math.PI*Math.pow(radius,2);
		}
		/**
		 * @param side
		 * @return area
		 */
		static final double square(double side){
			return Math.pow(side,2);
		}
		/**
		 * @param sides
		 * @return area
		 */
		static final double rectangle(double sides[]){
			return sides[0]*sides[1];
		}
	}
}//EOMC
