package zUtil;

public class Version{
	public static void error(String test){
		if(
				System.getProperty("java.version").matches(test)
			)System.out.println(
				"Your Java version is out of date, functionality may be comprimised as this was writen in Java 10"
			);
	}
}
