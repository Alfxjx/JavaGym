package week6;
//��ĳ���Ҫ����һ���ı��������Կո�ָ�Ϊ���ɸ����ʣ��ԡ�.��������
//��Ҫ��������ı���ÿ�����ʵĳ��ȡ�����ĵ����������޹أ�
//���԰������ַ��ţ����硰it's����һ�����ʣ�����Ϊ4��
//ע�⣬���п��ܳ��������Ŀո�
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		//String s = in.next();
		while(true)	
			{
				String s = in.next();
				if(s.equals("."))
				{
					continue;
				}
				else if(s.substring(s.length()-1, s.length()).equals("."))
				{
					System.out.print(s.length()-1);
					break;
				}
				else
				{
					System.out.print(s.length()+" ");
				}
			}
		in.close();
	}

}
//������2 ����ͨ�� ��֪��Ϊɶ
//1017 ֪���ˣ� �����ֻ��һ���㣬�Ͳ���ʶ����ȷ�ˡ�
//It's great to see you here .
//4 5 2 3 3 4 0