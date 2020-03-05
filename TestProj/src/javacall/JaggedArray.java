package javacall;

import java.util.Scanner;

public class JaggedArray 
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
		int size1;
		//System.out.println("ENTER THE SIZE OF THE ARRAY = ");
		size1=scn.nextInt();
		int size2 = 0;
		int [][]arr = new int [size1][];
		
		for(int i=0;i<size1;i++)
		{
			//System.out.println("Enter the size = "+i+" of the array");
			size2=scn.nextInt();
			//System.out.println("ENTER THE NUMBER OF DISTINCT VARIABLE = ");
			int distinct=scn.nextInt();
			arr[i]=new int[size2];
			for(int j=0;j<arr[i].length;j++)
			{
				arr[i][j]=scn.nextInt();	
			}
			//int element = scn.nextInt();
		}
		for(int i=0;i<arr.length;i++)
		{
		for (int val : arr[i]) 
			{
				System.out.print(val+" ");    	
			}

			System.out.println("");
		}
	}

}



//		for(int i=0;i<arr.length;i++)
//	{
//		for(int j=0;j<arr[i].length;j++)
//		{
//			arr[i][j]=scn.nextInt();
//		}
//	}
	//int[] var;
	
	
//	for(int j=0;j<arr[i].length;j++)
//	{
//		var = arr[j];
//		System.out.println(var);
//	}