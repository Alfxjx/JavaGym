package week6;
//你的程序要读入一行文本，其中以空格分隔为若干个单词，以‘.’结束。
//你要输出这行文本中每个单词的长度。这里的单词与语言无关，
//可以包括各种符号，比如“it's”算一个单词，长度为4。
//注意，行中可能出现连续的空格。
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
//测试例2 不能通过 不知道为啥
//1017 知道了！ 是最后只有一个点，就不能识别正确了。
//It's great to see you here .
//4 5 2 3 3 4 0