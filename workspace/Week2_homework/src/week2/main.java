package week2;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num_left;
		int num_right;
		num_left = (int)(Math.pow(3, 3)+Math.pow(4, 3)+Math.pow(5, 3));
		num_right = (int)(Math.pow(6, 3));
		if(num_left==num_right)
		{
			System.out.println(num_left+"="+num_right);
		}//第一个式子
		
		int num_left_1 = 0;
		int num_right_1 = (int)(Math.pow(180,3));;
		for(int i=6; i<70; i++)
		{
			num_left_1 += (int)(Math.pow((double)i,3));
		}
		if(num_left_1==num_right_1)
		{
			System.out.println(num_left_1+"="+num_right_1);
		}//第二个式子
		long sum=0,cbrtSum=0; 
	     for(long a=1;a<=1000;a++){
	         for(long n=2;n<=1000;n++){ 
	           /*此为求从起始项到结束项的立方和公式*/
	             sum=n*a*a*a+((n*(n-1))>>1)*(3*a*a+((n<<1)-1)*a+((n*(n-1))>>1));
	             cbrtSum=(long)Math.cbrt(sum); 
	             if((long)Math.pow(cbrtSum, 3)==sum){  
	                 System.out.println(a+"^3+...+"+(a+n-1)+"^3="+cbrtSum+"^3");
	            }
	         }
	    	 }
	    	 System.out.println("Finished");
	    //找出前1000里面的可能结果
	}

}
