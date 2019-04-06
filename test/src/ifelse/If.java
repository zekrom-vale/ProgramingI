package ifelse;//if and else is invalid

public class If{
	public static void number(int num){
		if(num<0)System.out.print("negative");
		else if(num==0);
		else if(num<100)System.out.print("Less than 100");
		else if(num<1_000)System.out.print("Less than 1000");
		else if(num<10_000)System.out.print("Less than 10000");
		else if(num<1_000_000)System.out.print("Less than 1000000");
		else System.out.print("Very big");
	}
	public static void grade(int of100){
		if(of100>100||of100<0)throw new Error();
		else if(of100>=96)System.out.print("S");
		else if(of100>=90)System.out.print("A");
		else if(of100>=80)System.out.print("B");
		else if(of100>=70)System.out.print("C");
		else if(of100>=60)System.out.print("D");
		else if(of100>=50)System.out.print("F");
		else if(of100<30)System.out.print("FD");
		else if(of100==0)System.out.print("Stop slacking!");
	}
	
	public static void gradeAlt(int of100){
		if(of100>100||of100<0)throw new Error();
		else
			if(of100>=95)System.out.print("S");
			else
				if(of100>=90)System.out.print("A");
				else
					if(of100>=80)System.out.print("B");
					else
						if(of100>=70)System.out.print("C");
						else
							if(of100>=60)System.out.print("D");
							else
								if(of100>=50)System.out.print("F");
								else
									if(of100<30)System.out.print("FD");
									else
										if(of100==0)System.out.print("Stop slacking!");
	}
	public static void main(String[] args){
		
	}

}
