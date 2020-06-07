package cache;
import java.util.*;
import java.lang.*;
public class fullyassociative  {

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
		System.out.println("NUMBER OF CACHE LINES ="+ " "+ CL);
		ArrayList<Integer> tagarray=new ArrayList<Integer>();
		Deque<Integer> q=new LinkedList<>();
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

				
				if(tagarray.contains(blockno) && tagarray.size()<CL)
				{
					System.out.println("Cache hit"+" "+"DATA FOUND ="+" "+dataarray[wordno]);
				}
				if(!tagarray.contains(blockno) && tagarray.size()<CL)
				{
					tagarray.add(blockno);
					q.add(blockno);
					q1.add(blockno);
					System.out.println("Cache miss"+", "+"Cache updated");
				}
				else if(tagarray.size()==CL && tagarray.contains(blockno))
				{	
					if(q1.contains(blockno))
					{
						q.remove(blockno);
						q.add(blockno);
					}
					System.out.println("Cache hit"+" "+" DATA FOUND ="+" "+dataarray[wordno]);
					
				}
				else if (!tagarray.contains(blockno) && tagarray.size()==CL )
				{
					int x=q.remove();
					q.add(blockno);
					q1.set(tagarray.indexOf(x), blockno);
					tagarray.set(tagarray.indexOf(x),blockno);
					System.out.println("Cache miss"+", "+"Cache updated");
				}
			
			}
			else if(i==2)
			{	
				System.out.println("Please enter the address and corresponding data :-");
				int wordno=s.nextInt();
				dataarray[wordno]=s.next();
				int blockno=wordno/B;
				if(!tagarray.contains(blockno) && tagarray.size()<CL)
				{
					tagarray.add(blockno);
					q.add(blockno);
					q1.add(blockno);
					
				}
				else if (!tagarray.contains(blockno) && tagarray.size()==CL )
				{
					int x=q.remove();
					q.add(blockno);
					q1.set(tagarray.indexOf(x), blockno);
					tagarray.set(tagarray.indexOf(x),blockno);
				}
			}
			else if(i==3)
			{	if(tagarray.size()<CL)
				{
					for(int j=0;j<tagarray.size();j++)
					{
						System.out.print("CACHE LINE="+" "+j+"  " + "BLOCK NO. ="+ " "+tagarray.get(j)+" "+"DATA = "+" "+ "("+dataarray[tagarray.get(j)*4]+" "+ dataarray[tagarray.get(j)*4+1]+" "+ dataarray[tagarray.get(j)*4+2]+" "+ dataarray[tagarray.get(j)*4+3]+")");
						System.out.println();
					}
					for(int j=tagarray.size();j<CL;j++)
					{
						System.out.print("CACHE LINE="+" "+j+ " " + "line empty");
						System.out.println();
					}
				}
				else 
				{
				for(int j=0;j<CL;j++)
				{
					System.out.print("CACHE LINE="+" "+j+"  " + "BLOCK NO. ="+ " "+tagarray.get(j)+" "+"DATA = "+" "+"("+ dataarray[tagarray.get(j)*4]+" "+ dataarray[tagarray.get(j)*4+1]+" "+ dataarray[tagarray.get(j)*4+2]+" "+ dataarray[tagarray.get(j)*4+3]+")");
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

