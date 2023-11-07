import java.lang.*;
import java.util.*;
import java.io.*;
public class FibonacciSeries
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of terms you want :");
		int num=sc.nextInt();
		//*****************************************
		System.out.print("Fibonacci Series Using Iterative Approach: ");
		fibonacciIterative(num);
		//*****************************************
		System.out.print("\nFibonacci Series Using Recursive Approach with O(n) time complexity: 0 1 ");
		fibonacciRecursive(0,1,num-2);
		//*****************************************
		System.out.print("\nFibonacci Series Using Recursive Approach with O(2^n) time complexity: ");
		for(int i=0;i<num;i++)
		{
			System.out.print( fibRecursion(i)+" ");
		}
	}
	
	public static void fibonacciIterative(int num)
	{
		int fib1=0;
		int fib2=1;
		System.out.print(fib1+" "+fib2+" ");
		for(int i=2;i<num;i++)
		{
			int fib3=fib1+fib2;
			System.out.print(fib3+" ");
			fib1=fib2;
			fib2=fib3;
		}
	}
	public static void fibonacciRecursive(int fib1,int fib2,int num)
	{
		if(num==0)
		{
			return;
		}
		System.out.print((fib1+fib2)+" ");
		fibonacciRecursive(fib2,(fib1+fib2),num-1);
	}
	public static int fibRecursion(int count)
	{
		if(count==0)
		{
			return 0;
		}
		else if(count==1 || count == 2)
		{
			return 1;
		}
		else
		{
			return fibRecursion(count-1)+fibRecursion(count-2);
		}
	}

}