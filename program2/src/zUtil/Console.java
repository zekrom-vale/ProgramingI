package zUtil;
/**
 *Does not work with windows
 */
public final class Console{
	public static final String reset="\u001B[0m",
		black="\u001B[30m",
		red="\u001B[31m",
		green="\u001B[32m",
		yellow="\u001B[33m",
		blue="\u001B[34m",
		purple="\u001B[35m",
		cyan="\u001B[36m",
		white="\u001B[37m";
	public static final String black(String in){
		return black+in+reset;
	}
	public static final String red(String in){
		return red+in+reset;
	}
	public static final String green(String in){
		return green+in+reset;
	}
	public static final String yellow(String in){
		return yellow+in+reset;
	}
	public static final String blue(String in){
		return blue+in+reset;
	}
	public static final String purple(String in){
		return purple+in+reset;
	}
	public static final String cyan(String in){
		return cyan+in+reset;
	}
	public static final String white(String in){
		return white+in+reset;
	}
}
