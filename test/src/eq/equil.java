package eq;

//Java program to understand 
//the concept of == operator 
public class equil { 
	@SuppressWarnings("fallthrough")
	public static void main(String[] args) 
	{ 
		{ 
			System.out.println("--Using new String and String--");
			String s1 =new String("HELLO"); 
			String s2 ="HE"+"LLO"; 
			System.out.println(s1 == s2); 
			System.out.println(s1.equals(s2)); 
		} 
		{ 
			System.out.println("--Using new String--");
			String s1 =new String("HELLO"); 
			String s2 =new String("HELLO");  
			System.out.println(s1 == s2); 
			System.out.println(s1.equals(s2)); 
		} 
		{ 
			System.out.println("--Using String--");
			String s1 ="HELLO";
			String s2 ="HELLO";
			System.out.println(s1 == s2); 
			System.out.println(s1.equals(s2)); 
		}
		char x='1';
		switch(x) {
			case '0':
				System.out.print(x);
			case '1':
				System.out.print(x);
			case '3':break;
			case '4':
				System.out.print(x);
		}
	}
} 
