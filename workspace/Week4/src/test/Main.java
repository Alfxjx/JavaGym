package test;
/*
 * 编写一个小的程序，其中定义一些接口、类、抽象类，定义它们的成员（字段及方法），
 *  要求使用使用setter/getter, static, final, abstract，@Override等语法要素，并写一个main函数来使用它们.
 *  这些类、接口可以是围绕以下选题之一
 *  飞翔世界：来一次飞翔接力（即多个可飞翔的对象依次调用）;
 *  动物世界：来一次吃西瓜大赛;
 *  图书馆：模拟一天的借阅过程;
 *  学校：模拟选课过程;
 */
interface fly{
	void canfly();
}

abstract class animal implements fly{
	public void canfly(){
		System.out.println("can fly!");
	}
}

class flyanimals extends animal{
	private String animal;
	public void setter(String animal) {
		this.animal = animal;
	}
	public String getter() {
		return animal;
	}
	public String output(){
		return " can fly.";
	}
	
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String animal1 = "Butterflies";
		String animal2 = "Hawks";
		String animal3 = "Bees";
		flyanimals flyanimal1 = new flyanimals();
		flyanimals flyanimal2 = new flyanimals();
		flyanimals flyanimal3 = new flyanimals();
		flyanimal1.setter(animal1);
		flyanimal2.setter(animal2);
		flyanimal3.setter(animal3);
		System.out.println(animal1+flyanimal1.output());
		System.out.println(animal2+flyanimal2.output());
		System.out.println(animal3+flyanimal3.output());
	}

}
