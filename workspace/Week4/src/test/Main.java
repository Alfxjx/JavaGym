package test;
/*
 * ��дһ��С�ĳ������ж���һЩ�ӿڡ��ࡢ�����࣬�������ǵĳ�Ա���ֶμ���������
 *  Ҫ��ʹ��ʹ��setter/getter, static, final, abstract��@Override���﷨Ҫ�أ���дһ��main������ʹ������.
 *  ��Щ�ࡢ�ӿڿ�����Χ������ѡ��֮һ
 *  �������磺��һ�η��������������ɷ���Ķ������ε��ã�;
 *  �������磺��һ�γ����ϴ���;
 *  ͼ��ݣ�ģ��һ��Ľ��Ĺ���;
 *  ѧУ��ģ��ѡ�ι���;
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
