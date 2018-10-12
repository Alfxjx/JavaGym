package homework_7;

import java.util.Scanner;

public class Main {

    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        int m=0,n=0;
        n=in.nextInt();
        m=in.nextInt();
        int k=2;
        int count=0,sum=0;
        while (k!=0) {
            Boolean flag=true;
            for(int i=2;i<=Math.sqrt(k);i++) {
                if(k%i==0) {
                    flag=false;break;
                }
            }
            if(flag==true)
            {
                count++;
                if (count>=n&&count<=m) {
                    sum+=k;
                }
                 if (count>m) {
                    break;
                }
            }
            k++;
        }
        System.out.print(sum);
    }
}


