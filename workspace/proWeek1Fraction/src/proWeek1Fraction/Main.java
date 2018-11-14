package proWeek1Fraction;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Fraction a = new Fraction(in.nextInt(), in.nextInt());
		Fraction b = new Fraction(in.nextInt(),in.nextInt());
		a.print();
		b.print();
		a.plus(b).print();
		a.multiply(b).plus(new Fraction(5,6)).print();
		a.print();
		b.print();
		in.close();
	}
}

class Fraction{
	//分子和分母
	private int fz;
	private int fm;
	Fraction(int a, int b){
		this.fz = a;
		this.fm = b;
	}
	public double ToDouble(){
		return (double)fz/fm;
	}
	public Fraction plus(Fraction r){
		Fraction tmp = new Fraction(0, 1);
		tmp.fm = this.fm *r.fm;
		tmp.fz = this.fz*r.fm + r.fz*this.fm;
		return tmp;
		
	}
	public Fraction multiply(Fraction r){
		Fraction tmp = new Fraction(0,1);
		tmp.fm = this.fm*r.fm;
		tmp.fz = this.fz*r.fz;
		return tmp;
	}
	public void print(){
		int temp = gcd(fz, fm);
		fz/= temp;
		fm/= temp;
		if(fz==fm){
			System.out.println(1);
		}else{
			System.out.println(fz+"/"+fm);
		}
	}
	public static int gcd(int x, int y){
		if(y==0){
			return x;
		}else{
			return gcd(y, x%y);
		}
	}
}
