package cache;

import java.util.*;
import java.lang.*;


public class setassociative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("Please enter the size of the main memory :-");
		int N=s.nextInt();
		System.out.println("Please enter the size of the cache memory :-");
		int S=s.nextInt();
		System.out.println("Please enter the size of the block :-");
		int B=s.nextInt();
		System.out.println("Please enter the value of n :-");
		int n=s.nextInt();
		int CL=S/B;
		System.out.println("NUMBER OF CACHE LINES ="+ " "+ CL);
		int noofsets=CL/n;
		int[] tagarray=new int[CL];
		Arrays.fill(tagarray, -1);
		Queue<Integer> q=new LinkedList<>();
		ArrayList<Integer> q1=new ArrayList<Integer>();
		String[] dataarray=new String[N];
		
		
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
				int setno=blockno%noofsets;
				  int x=0;int y=0;
				for(int j=setno*n;j<setno*n+n;j++)
				{
					if(tagarray[j]==blockno)
					{
						System.out.println("Cache hit"+" "+"DATA FOUND ="+" "+dataarray[wordno]);
						x++;
						break;
					}
				}
				if(x==0)
				{	
					for(int j=setno*n;j<setno*n+n;j++)
					
					{
						if(tagarray[j]!=blockno && tagarray[j]==-1)
					
						{
							tagarray[j]=blockno;
							q.add(blockno);
							y++;
							System.out.println("Cache miss"+", "+"Cache updated");
							break;
							
						}
					}
				}
				if(x==0 && y==0)
				{	
					int z=q.remove();
					int rand=(int)Math.random()*(setno*n+n-1-setno*n+1)+setno*n;
					tagarray[rand]=blockno;
					System.out.println("Cache miss, Cache updated");
				}
			}
				
			
			else if(i==2)
			{	
				System.out.println("Please enter the address and corresponding data :-");
				int wordno=s.nextInt();
				dataarray[wordno]=s.next();
				int blockno=wordno/B;
				int setno=blockno%noofsets;
				int y=0;
					
				for(int j=setno*n;j<setno*n+n;j++)
						
				{
							if(tagarray[j]!=blockno && tagarray[j]==-1)
						
							{
								tagarray[j]=blockno;
								q.add(blockno);
								y++;
								break;
								
							}
				}
					
					if(y==0)
					{	
						int rand=(int)(Math.random()*(setno*n+n-1-setno*n+1))+setno*n;
						tagarray[rand]=blockno;
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
						System.out.print("CACHE LINE="+" "+j+"  " + "BLOCK NO. ="+ " "+tagarray[j]+" "+"DATA = "+" "+"(");
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
