//package test;

import java.util.Random;
/* 
 * java practice about class and interface in coursera
 * theme 
 * Animal World£º watermelon-eating contest;
 */
 

interface Eat_watermelon{
	void eat();
}
 
abstract class animal implements Eat_watermelon{
	public void eat() {
		System.out.println("begin contest!");
		System.out.println("finish contest!");
	}
}//@override
 
class Contest_begin implements Eat_watermelon{
	protected static final int  total_time = 20;
	public void eat() {
		System.out.println("The total time of this contest is "+total_time+ " minutes.");
		System.out.println("Now, the contestants are ready for eating!");
	}
}
 
class Contestant extends animal{
	private String animal;
	public void setter(String animal) {
		this.animal = animal;
	}
	public String getter() {
		return animal;
	}
	public int RandomEaten(){
		Random random = new Random();
		int used_time = Math.abs(random.nextInt())%20;
		return used_time;
	}// generate a used_time by random 
	
}
 
 
 
public class eatMelon {
	public static void main(String[] args) {
		Contest_begin begin = new Contest_begin();
		begin.eat();
		System.out.println("The watermelon-eating contest is begining!");
		String animal1 = "horse";
		String animal2 = "cow";
		System.out.println("The contestants of this contest are "+animal1+" and "+animal2+".");
		Contestant  contestant1  = new Contestant();
		contestant1.setter(animal1);
		int time1 = contestant1.RandomEaten();
		System.out.println("Contestant "+animal1+" finish eating watermelon with "+time1+" minutes.");
		Contestant  contestant2  = new Contestant();
		contestant2.setter(animal2);
		int time2 = contestant2.RandomEaten();
		System.out.println("Contestant "+animal2+" finish eating watermelon with "+time2+" minutes.");
		
		if(time1 == time2) {
			System.out.println("The winner of this watermelon-eating contest are both "+animal1+" and "+animal2+".");
		}else if(time1 < time2) {
			System.out.println("The winner is "+animal1+".");
		}else{
			System.out.println("The winner is "+animal2+".");
		}
		
		System.out.println("The watermelon-eating contest is ending!");
	}	
}
