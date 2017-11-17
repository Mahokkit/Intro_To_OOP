/* Student: Edward Ma
 * Student ID: W0057568
 * OOP Assignment 1
 * Item Sale calculation
 */
import java.util.ArrayList;
import java.util.List;

public class ItemSale 
{	// list needed to calculate the sum of each item sales.
	List<Integer> item1Sale = new ArrayList<Integer>();
	List<Integer> item2Sale = new ArrayList<Integer>();
	List<Integer> item3Sale = new ArrayList<Integer>();
	List<Integer> item4Sale = new ArrayList<Integer>();
	
	//property
	private int item1 = 0;
	private int item2 = 0;
	private int item3 = 0;
	private int item4 = 0;
	//method
	/*-----------------*/
	public int getItem1() 
	{
		return item1;
	}
	public void setItem1(int item1) 
	{
		this.item1 = item1;
		item1Sale.add(item1);
	}
	/*-----------------*/
	public int getItem2() 
	{
		return item2;
	}
	public void setItem2(int item2) 
	{
		this.item2 = item2;
		item2Sale.add(item2);
	}
	/*-----------------*/
	public int getItem3() 
	{
		return item3;
	}
	public void setItem3(int item3) 
	{
		this.item3 = item3;
		item3Sale.add(item3);
	}
	/*-----------------*/
	public int getItem4() 
	{
		return item4;
	}
	public void setItem4(int item4) 
	{
		this.item4 = item4;
		item4Sale.add(item4);
	}
	/* getting the total sum of each items */
	public int getSumItem1() 
	{
		Integer sumItem1 = (int)0;
		for (Integer i : item1Sale)
		{
			sumItem1 += i;
		} //end for loop
		return sumItem1;
	}
	
	public int getSumItem2() 
	{
		Integer sumItem2 = (int) 0;
		for (Integer i : item2Sale)
		{
			sumItem2 += i;
		} //end for loop
		return sumItem2;
	}
	
	public int getSumItem3() 
	{
		Integer sumItem3 = (int) 0;
		for (Integer i : item3Sale)
		{
			sumItem3 += i;
		} //end for loop
		return sumItem3;
	}
	
	public int getSumItem4() 
	{
		Integer sumItem4 = (int) 0;
		for (Integer i : item4Sale)
		{
			sumItem4 += i;
		} //end for loop
		return sumItem4;
	}
}
