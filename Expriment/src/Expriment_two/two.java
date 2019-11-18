package Expriment_two;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class two {

    static int get_val(int n)
    {
        int sum=1;
        for(int i=1;i<=n;++i)
        {
            sum*=i;
        }
        return sum;
    }
    static void factorial(int n)
    {
        int result=0;
        for(int i=1;i<=n;++i){
            result+=get_val(i);
        }
        System.out.println(n+"的阶乘和为："+result);
    }

    static void prime(int n)
    {
        int a[]=new int[n+1];
        for(int i=2;i<=n;++i)a[i]=1;

        int sum=0;
        for(int i=2;i<=n;++i){
            if(a[i]!=0)
            {
                sum+=i;
                for(int j=i*2;j<=n;j+=i){
                    a[j]=0;
                }
            }
        }
        System.out.println("1~"+n+"的所有素数和为："+sum);
    }

   static void randomNum()
    {
        Random num=new Random(1);
        int a[]=new int[10];
        for(int i=0;i<10;++i)
        {
            int ran=num.nextInt(100);
            a[i]=ran;
        }
        System.out.print("得到的数组为：");
        for (int c:a) {
            System.out.print(c+" ");
        }
        System.out.println();
        System.out.print("排序后之后的数组元素为：");
        Arrays.sort(a);
        for (int c:a) {
            System.out.print(c+" ");
        }
        System.out.println();
    }

    static void randomNum_2()
    {
        Random num=new Random(1);
        int a[]=new int[20];
        for(int i=0;i<20;++i)
        {
            a[i]=num.nextInt(50)+50;
        }
        Arrays.sort(a);
        System.out.println("随机产生的20个范围内50~100的整数最大值为："+a[19]);
        System.out.println("随机产生的20个范围内50~100的整数最小值为："+a[0]);
    }

    static void circle()
    {
        System.out.print("请输入圆的半径：");
        int r=0;
        Scanner in=new Scanner(System.in);
        r=in.nextInt();
        System.out.println("圆的周长为："+2*r*3.14);
        System.out.println("圆的面积为："+r*r*3.14);
    }

    public static void main(String[] args)
    {
        factorial(10);
        prime(50);
        randomNum();
        randomNum_2();
        circle();
    }
}
