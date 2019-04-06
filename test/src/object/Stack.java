package object;

public class Stack{
	@SuppressWarnings({"hiding"})//Prevent hiding error as it is irrelevant in this case
	public class construct{
		private int x=0;
		private String y="";
		private double z=0,
			a=-0;
		private String d="\n";
		construct x(int x){
			this.x=x;
			return this;//To perpetuate the chain
		}
		construct y(String y){
			this.y=y;
			return this;
		}
		construct z(double z){
			this.z=z;
			return this;
		}
		construct a(double a){
			this.a=a;
			return this;
		}
		construct delimnator(String d){
			this.d=d;
			return this;
		}
		construct delimnator(char d){
			this.d=""+d;
			return this;
		}
	}
	public static void main(String[] args){
		Stack stack=new Stack();
		process(stack.new construct().x(22).y("Ewe").z(2.332));//In line use
		System.out.println(" ");
		process(stack.new construct().y("A string \n").z(6453.453467));
	}
	public final static void process(construct obj){
		System.out.println(obj.x+obj.d+obj.y+obj.d+obj.z+obj.d+obj.a);
	}
}
