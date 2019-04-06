package loop;

import java.util.Scanner;

public class Loop{

	public static void main(String[] args){
		final var user=new Scanner(System.in);
		var i=0;
		System.out.print("Students:\t");
		final var max=user.nextInt();
		if(max>0){
			var score=0.0;
			while(i<max){
				System.out.print("Enter score "+ ++i+":\t");
				score+=user.nextDouble();
			}
			System.out.println(score/max);
		}
		else System.err.println("Good bye!");
		user.close();
	}
	public static void main2(String[] args){
		byte format=20;
		System.out.printf("%"+-format+"s %"+format+"s\n", "Number", "Cube");
		for(byte i=1; i<=100; i+=2) System.out.printf("%"+-format+"d %"+format+".0f\n", i, Math.pow(i,3));
		System.out.println("Done");
		//for(byte n=0; n<=10; n++)System.out.print(n+" ");
		//System.out.println("Done");
	}

}
