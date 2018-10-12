package j36_7;

public class Java36_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = new int[7];
		for(int i= 0; i < a.length;i++)
		{
//			loop:
//			while(true)	
//			{
				a[i]=(int)(Math.random()*36)+1;
				loop:
				for(int j=0;j<i;j++)
				{
					if(a[i]==a[j])
					{
						continue loop;
					}
				}
//			break;
//			}
		}
		for(int num : a)
		{
			System.out.print(num+" ");
		}
	}

}
