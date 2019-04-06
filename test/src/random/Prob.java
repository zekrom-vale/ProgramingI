package random;

public class Prob{
	static long random(long start, long end){
		return (long)(Math.random()*(end-start+1))+start;
	}
	final static int min=1,
		max=100;
	final static long length=1000000000L;
	static long[] dist=new long[max+1];
	
	public static void main(String[] args){
		for (int i=0; i<length; i++){
			dist[(int)random(min, max)]++;
		}
		for (int j=min; j<max+1; j++){
			System.out.printf("%-14d",dist[j]);
			if(j%10==0)System.out.println();
		}
		System.out.println("-".repeat(160));
		for(int j=min; j<max+1; j++){
			System.out.printf("%-14f", (double)dist[j]*(max-min+1)/length);
			if(j%10==0)System.out.println();
		}
	}
}