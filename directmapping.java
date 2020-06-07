package cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class directmapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("Please enter the size of the main memory :-");
		int N=s.nextInt();
		System.out.println("Please enter the size of the cache memory :-");
		int S=s.nextInt();
		System.out.println("Please enter the size of the block :-");
		int B=s.nextInt();
		int CL=S/B;
		int[] tagarray=new int[CL];
		Arrays.fill(tagarray, -1);
		String[] dataarray=new String[N];
		System.out.println("NUMBER OF CACHE LINES ="+ " "+ CL);
		while(true)
		{
			System.out.println("PLEASE SELECT FROM THE FOLLOWING OPTIONS :-");
			System.out.println("1.) READ ");
			System.out.println("2.) WRITE");
			System.out.println("3.) DISPLAY CACHE");
			System.out.println("4.) EXIT");
			
			int i=s.nextInt();
			
			if(i==1)
			{	
				
				System.out.println("Please enter a word number to be read :- ");
				int wordno=s.nextInt();
				int blockno=wordno/B;
				int lineno=blockno%CL;
				if(tagarray[lineno]==-1)
				{
					tagarray[lineno]=blockno;
					System.out.println("Cache miss, Cache updated ");
				}
				
				else if (tagarray[lineno]!=-1 && tagarray[lineno]!=blockno)
				{
					tagarray[lineno]=blockno;
					System.out.println("Cache miss, Cache updated ");
					
				}
				else
				{
					System.out.println("Cache hit"+" "+"DATA FOUND ="+" "+dataarray[wordno]);
				}
			
			
			}
			else if(i==2)
			{	
				System.out.println("Please enter the address and corresponding data :-");
				int wordno=s.nextInt();
				int blockno=wordno/B;
				int lineno=blockno%CL;
				dataarray[wordno]=s.next();
				
				if(tagarray[lineno]!=blockno)
				{
					tagarray[lineno]=blockno;
				}
			}
			else if(i==3)
			{	
				for(int j=0;j<CL;j++)
				{
					if(tagarray[j]==-1)
					{
						System.out.print("CACHE LINE="+" "+j+"  " + "line empty");
						System.out.println();
					}
						
					else
					{	
					System.out.print("CACHE LINE="+" "+j+"  " + "BLOCK NO. ="+ " "+tagarray[j]+" "+"DATA = "+" "+"("+" ");
					for(int m=0;m<B;m++)
					{
					  System.out.print(dataarray[tagarray[j]*B+m]+" ");
					
					}
					System.out.print(")");
					System.out.println();
					}
				}
			
			}
			
			else if(i==4)
			{
				break;
			}
			else
			{
				System.out.println("Invalid Input");
				break;
			}
		}
	}

}
