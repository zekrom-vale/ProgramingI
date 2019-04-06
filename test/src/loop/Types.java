package loop;

import java.util.Scanner;

public class Types{

	private static Scanner user=new Scanner(System.in);

	public static void main(String[] args){
		{//Counter
			int i=0,
				m=100;
			while(i<m){
				
				i++;
			}
		}
		{//Sentinel
			int sen=-999,
				v=0;
			while(v!=sen) {
				System.out.println("Enter an value or -999 to stop");
				v=user.nextInt();
			}
		}
		{//Flag
			boolean flag=false;
			while(!flag){
				System.out.println("Exit?");
				if(user.next().equalsIgnoreCase("Exit"))flag=true;
			}
		}
	}

}
