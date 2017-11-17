/* Student: Edward Ma
 * Student ID: W0057568
 * OOP Assignment 1
 * Actual Application
 */
// import the library needed for this program
import java.util.*;
import javax.swing.*;
import java.util.Map.Entry;
public class AssignOneApp 
{
	// for some reason, I need to have a global variable for the numeric validation and conversion to int to work.
	private int item1;
	private int item2;
	private int item3;
	private int item4;
	
	public void start()
	{
		Validate validate = new Validate(); //validate both string and int
		ItemSale itemsale = new ItemSale(); // calculating total item sold 
		boolean bool = true;
		while (true) // start 1 while loop
		{
			// HashMap table that is needed to sort out Top salesmen and Most sold items.
			HashMap<String, Double> saleTable = new HashMap<String, Double>();
			HashMap<String, Integer> itemSaleTable = new HashMap<String, Integer>();
			// user input salesman name
			String name = JOptionPane.showInputDialog(null, "Enter Salesman Name", "Sale Calculator", 
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (validate.isFullname(name) == false) // the big if statement
			{	//if the name isn't string, it will go on a while loop... if not it will go to the else if section
				JOptionPane.showMessageDialog(null, "Invalid Input, try again!", 
						"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
			} 
			else if (name != null)
			{	/* user enter total of each item sold per salesman, if they didn't enter a integer. system will just 
				enter it as 0.  I want to make it a while loop like the name but couldn't do it. */
				String i1 = JOptionPane.showInputDialog(null, "How many Item #1 did "+name+" sold?", 
						"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
				if (i1 == null)
				{
					JOptionPane.showMessageDialog(null, "Thanks for using this program!", 
							"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
					break;
				}
				else if (validate.isNumeric(i1) == false)
				{
					while (bool)
					{
						JOptionPane.showMessageDialog(null, "Invalid Input. Try again", 
								"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
						String iOne = JOptionPane.showInputDialog(null, "How many Item #1 did "+name+" sold?",
								"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
						if (validate.isNumeric(iOne) == true)
						{
							this.item1 = Integer.parseInt(iOne);
							bool = false;
						}
					}
				}
				else
				{
					this.item1 = Integer.parseInt(i1);
				}
				String i2 = JOptionPane.showInputDialog(null, "How many Item #2 did "+name+" sold?", 
						"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
				if (i2 == null)
				{
					JOptionPane.showMessageDialog(null, "Thanks for using this program!", 
							"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
					break;
				}
				else if (validate.isNumeric(i2) == false) 
				{
					while (bool)
					{
						JOptionPane.showMessageDialog(null, "Invalid Input. Try again", 
								"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
						String iTwo = JOptionPane.showInputDialog(null, "How many Item #1 did "+name+" sold?", 
								"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
						if (validate.isNumeric(iTwo) == true)
						{
							this.item2 = Integer.parseInt(iTwo);
							bool = false;
						}
					}
				}
				else
				{
					this.item2 = Integer.parseInt(i2);
				}
				String i3 = JOptionPane.showInputDialog(null, "How many Item #3 did "+name+" sold?", 
						"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
				if (i3 == null)
				{
					JOptionPane.showMessageDialog(null, "Thanks for using this program!", 
							"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
					break;
				}
				else if (validate.isNumeric(i3) == false) 
				{
					while (bool)
					{
						JOptionPane.showMessageDialog(null, "Invalid Input. Try again", 
								"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
						String iThree = JOptionPane.showInputDialog(null, "How many Item #1 did "+name+" sold?", 
								"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
						if (validate.isNumeric(iThree) == true)
						{
							this.item3 = Integer.parseInt(iThree);
							bool = false;
						}
					}
				}
				else
				{
					this.item1 = Integer.parseInt(i3);
				}
				String i4 = JOptionPane.showInputDialog(null, "How many Item #4 did "+name+" sold?", 
						"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
				if (i4 == null)
				{
					JOptionPane.showMessageDialog(null, "Thanks for using this program!", 
							"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
					break;
				}
				else if (validate.isNumeric(i4) == false) 
				{
					while (bool)
					{
						JOptionPane.showMessageDialog(null, "Invalid Input. Try again");
						String iFour = JOptionPane.showInputDialog(null, "How many Item #1 did "+name+" sold?", 
								"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
						if (validate.isNumeric(iFour) == true)
						{
							this.item4 = Integer.parseInt(iFour);
							bool = false;
						}
					}
				}
				else
				{
					this.item4 = Integer.parseInt(i4);
				}
				// input each item sold to the itemsale table in the ItemSale Class
				itemsale.setItem1(item1);
				itemsale.setItem2(item2);
				itemsale.setItem3(item3);
				itemsale.setItem4(item4);
				// calculating weekly earning for the salesman
				double totalSalesmenSale = (item1*239.99)+(item2*129.75)+(item3*99.95)+(item4*350.89);
				double commission = totalSalesmenSale*0.09; // the sales man get a 9% of the sales as commission
				double pay = 200 + commission;
				
				// display for user how much earning this salesman earned.
				JOptionPane.showMessageDialog(null, 
						name+"'s total week earning is $"+String.format("%,.2f",pay));
				
				// input the data to total Salesmen sale for calculating top salesmen later.
				saleTable.put(name, totalSalesmenSale);
				
				// ask user if they want to enter another salesman
				String ans = JOptionPane.showInputDialog(null, "Add another salesman? Y/N", 
						"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
				/* if not, program will do the calculation to show which items have the most sales
				 * and which salesmen have the highest sales */
				if (ans == null)
				{
					{
						JOptionPane.showMessageDialog(null, "Thanks for using this program!", 
								"Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
						break;
					}
				}
				else if (!ans.equalsIgnoreCase("y"))
				{
					// calculate total number all items that was sold
					int totalItemSold = itemsale.getItem1()
							+itemsale.getItem2()
							+itemsale.getItem3()
							+itemsale.getItem4();
					// calculate the total sales
					double totalSale = (itemsale.getItem1()*239.99)
							+(itemsale.getItem2()*129.75)
							+(itemsale.getItem3()*99.95)
							+(itemsale.getItem4()*350.89);
					// founding the avg sale value
					double avgSale = totalSale/totalItemSold;
					
					// input total sum of each item being sold to it's own key.
					itemSaleTable.put("Item #1", itemsale.getSumItem1());
					itemSaleTable.put("Item #2", itemsale.getSumItem2());
					itemSaleTable.put("Item #3", itemsale.getSumItem3());
					itemSaleTable.put("Item #4", itemsale.getSumItem4());
					
					// sorting the HashMap table to figure out which item have the most sale.
					// Get a set of the entries
					Set<Entry<String, Integer>> set = itemSaleTable.entrySet(); //keeping each row of data or the set, together
				    
					set.iterator();
		     
					Entry<String,Integer> maxEntry = null; //create a row of data or a set as null

					for(Entry<String, Integer> entry : itemSaleTable.entrySet()) 
				    {
						if (maxEntry == null || entry.getValue() > maxEntry.getValue()) 
						{
							maxEntry = entry;
				        }
				    }
					
					// sorting salesmen table to figure out who have the most sales.
					// Get a set of the entries
					Set<Entry<String, Double>> set1 = saleTable.entrySet(); //keeping each row of data or the set, together
				    
					set1.iterator();

					Entry<String,Double> maxEntry1 = null; //create a row of data or a set as null

					for(Entry<String,Double> entry2 : saleTable.entrySet()) 
				    {
						if (maxEntry1 == null || entry2.getValue() > maxEntry1.getValue()) 
						{
							maxEntry1 = entry2;
				        }
				    }
					// display the report for user
					JOptionPane.showMessageDialog(null, 
							"Sum of all the sales are $"+String.format("%,.2f",totalSale)+"\n"
					+"Avg of all the sales are $"+String.format("%,.2f",avgSale)+"\n"
					+maxEntry.getKey()+" is the top item sold with a total of "
					+maxEntry.getValue()+"\n"
					+"The top Saleman is "+maxEntry1.getKey()
					+" with $"+String.format("%,.2f",(maxEntry1.getValue()))+"\n");
					JOptionPane.showMessageDialog(null, "Thanks for using this program!");
					break;
				} 

			}
			else
			{
				JOptionPane.showMessageDialog(null, "Thanks for using this program!", "Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
				break;
			} // end of the big if statement
		} // end 1 while loop
	} // end start
} // end class
