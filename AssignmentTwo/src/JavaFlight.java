import javax.swing.*;
import java.util.*;

public class JavaFlight 
{
	private int cS1; //flight class selection;
	private int wiS1; //flight windows or isle selection

	public void start()
	{
		Validate validate = new Validate(); //validate both string and int
		Map<String, String> booking = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER); //booking table for later use
		// boolean 2D array...

		boolean flightSeat[][]={
				{false,false,false,false},
				{false,false,false,false},
				{false,false,false,false},
				{false,false,false,false}};

		String seatChart[][] = {
				{"|+|","{A}","{B}","{C}","{D}"},
				{"{1}","{0}","{0}","{0}","{0}"},
				{"{2}","{0}","{0}","{0}","{0}"},
				{"{3}","{0}","{0}","{0}","{0}"},
				{"{4}","{0}","{0}","{0}","{0}"}
				};
		
		int seatCount = 16;
		
//		boolean flightSeat[][]={
//			{true,true,true,true},
//			{true,true,true,true},
//			{true,true,true,true},				
//			{true,true,true,true}};
//		// visual display of what seat is available.
//		
//		String seatChart[][] = {
//				{"|+|","{A}","{B}","{C}","{D}"},
//				{"{1}","{X}","{X}","{X}","{X}"},
//				{"{2}","{X}","{X}","{X}","{X}"},
//				{"{3}","{X}","{X}","{X}","{X}"},
//				{"{4}","{X}","{X}","{X}","{X}"}
//				};
//		
//		booking.put("Charles", "Seat A Row 1");
//		booking.put("Edward", "Seat B Row 1");
//		booking.put("James", "Seat C Row 1");
//		booking.put("Samantha", "Seat D Row 1");		
//		booking.put("Bob", "Seat A Row 2");
//		booking.put("David", "Seat B Row 2");
//		booking.put("Todd", "Seat C Row 2");
//		booking.put("Bill", "Seat D Row 2");	
//		booking.put("Michael", "Seat A Row 3");
//		booking.put("Kit", "Seat B Row 3");
//		booking.put("Sara", "Seat C Row 3");
//		booking.put("Amy", "Seat D Row 3");
//		booking.put("Simon", "Seat A Row 4");
//		booking.put("Brandon", "Seat B Row 4");
//		booking.put("Irina", "Seat C Row 4");
//		booking.put("Zahraa", "Seat D Row 4");	
//					
//
//		int seatCount = 0;
		//int ans = JOptionPane.YES_NO_CANCEL_OPTION;

		while (true)
		{
			JOptionPane.showMessageDialog(null, "Welcome to Java Flight!", "Java Flight", JOptionPane.INFORMATION_MESSAGE);
						String output = "";
		    for (int r = 0; r < seatChart.length; r++) 
		    {
		        output += Arrays.toString(seatChart[r]).replace(",", "").replace("[", "").replace("]", "")+ "\n";
		    }
		    JOptionPane.showMessageDialog(null, seatCount+" Seats Available\n"+output, "Java Flight", 
		    		JOptionPane.INFORMATION_MESSAGE);
		    
			if (flightSeat[0][0] == true && flightSeat[0][1] == true && flightSeat[0][2] == true && flightSeat[0][3] == true &&
					 flightSeat[1][0] == true && flightSeat[1][1] == true && flightSeat[1][2] == true && flightSeat[1][3] == true &&
					 flightSeat[2][0] == true && flightSeat[2][1] == true && flightSeat[2][2] == true && flightSeat[2][3] == true &&
					 flightSeat[3][0] == true && flightSeat[3][1] == true && flightSeat[3][2] == true && flightSeat[3][3] == true)
			{
				JOptionPane.showMessageDialog(null, "Sorry, there's no seat available\nThank you for choosing Java Flight!\nThe Next Flight is leaving in 3 hours.",
						"Java Flight", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			

		    
			JOptionPane.showMessageDialog(null, "Hit Cancel at anytime to end the program", "Java Flight", JOptionPane.INFORMATION_MESSAGE);
			String name = JOptionPane.showInputDialog(null, "Please Enter Passenger Name", "Java Flight",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (validate.isFullname(name) == false) // the big if statement
			{	//if the name isn't string, it will go on a while loop... if not it will go to the else if section
				JOptionPane.showMessageDialog(null, "Invalid Input, try again!", 
						"Java Flight", JOptionPane.PLAIN_MESSAGE);
			} 
			else if (name == null)
			{
				JOptionPane.showMessageDialog(null, "Thanks for using this program!\n"
							+ "The Next Flight Leaves in 3 Hours!", "Java Flight", 
						JOptionPane.PLAIN_MESSAGE);
				break;
			} 
			else
			{ // visual display for clerk to see which seat is available with seat counter
			    
				String cS = JOptionPane.showInputDialog(null, "Enter 1 for First Class\nEnter 2 for Economy", 
							"Java Flight", JOptionPane.YES_NO_CANCEL_OPTION);
			
				if (cS == null)
				{
					JOptionPane.showMessageDialog(null, "Thanks for using this program!\n" + "The Next Flight Leaves in 3 Hours!",  "Java Flight", JOptionPane.YES_NO_CANCEL_OPTION);
					break;
				}
				else if (validate.isNumeric(cS) == false)
				{
					while (true)
					{
						JOptionPane.showMessageDialog(null, "Invalid Input. Try again", "Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
						String iOne = JOptionPane.showInputDialog(null, "Enter 1 for First Class\nEnter 2 for Economy", "Java Flight", JOptionPane.YES_NO_CANCEL_OPTION);
						if (validate.isNumeric(iOne) == true)
						{
							this.cS1 = Integer.parseInt(iOne);
							break;
						}
					}
				}
				else
				{
					this.cS1 = Integer.parseInt(cS);
				} // end class Selection if statement
					
				String wiS = JOptionPane.showInputDialog(null, "Enter 1 for window seat\nEnter 2 for aisle seat", 
					"Java Flight", JOptionPane.YES_NO_CANCEL_OPTION);
						
				if (wiS == null)				
				{
					JOptionPane.showMessageDialog(null, "Thanks for using this program!\nThe Next Flight Leaves in 3 Hours!", "Java Flight", JOptionPane.YES_NO_CANCEL_OPTION);
						break;
				}
				else if (validate.isNumeric(wiS) == false)
				{
					while (true)
					{
						JOptionPane.showMessageDialog(null, "Invalid Input. Try again", "Sale Calculator", JOptionPane.YES_NO_CANCEL_OPTION);
						String iOne = JOptionPane.showInputDialog(null, "Enter 1 for window seat\nEnter 2 for aisle seat", "Java Flight", JOptionPane.YES_NO_CANCEL_OPTION);
						if (validate.isNumeric(iOne) == true)
						{
							this.wiS1 = Integer.parseInt(iOne);
							break;
						}
					}
				}
				else
				{
					this.wiS1 = Integer.parseInt(wiS);
				} 
			}  // end class win isle Selection if statement
			// depends on class and seating selection, only selected while loop will run.  Seating goes from First Class Windows, to Isles, to Eco Windows and finally eco isles
			while (cS1 == 1 && wiS1 == 1)
			{
				if (flightSeat[0][0] == true && flightSeat[1][0] == true && flightSeat[0][3] == true && flightSeat[1][3] == true)
				{ //if it's full, it will ask if they want to have isle seat from the same class, unless it's a isle seat...then it will ask if they want a eco windows seat.
					int ans = JOptionPane.showConfirmDialog(null, 
							"All Windows Seat are taken, would you like a Isle Seat instead?", 
							"Confirmed", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (ans != JOptionPane.YES_OPTION)
					{
						JOptionPane.showMessageDialog(null, "Thanks for using this program!\nThe Next Flight Leaves in 3 Hours!",
								"Java Flight", JOptionPane.YES_NO_CANCEL_OPTION);
						break;
					}
					else
					{
						this.cS1 = 1;
						this.wiS1 = 2;
					}
				}
				
				if (flightSeat[0][0]==false)
				{
					flightSeat[0][0]=true; 
					seatChart[1][1] = "{X}"; // visual indication for clerk to see which seat is taken
					seatCount--; //automatically count down from 16
					JOptionPane.showMessageDialog(null, "Passenger: "+name+"\nSeating is at: Seat A Row 1\n"+seatCount+" remaining seat is available");
					booking.put(name, "Seat A Row 1"); // assign seating to booking table
					break;
				}
				else if (flightSeat[1][0]==false)
				{
					flightSeat[1][0]=true;
					seatChart[2][1] = "{X}";
					seatCount--;
					JOptionPane.showMessageDialog(null, "Passenger: "+name+"\nSeating is at: Seat A Row 2\n"+seatCount+" remaining seat is available");
					booking.put(name, "Seat A Row 2");
					break;
				}
				else if (flightSeat[0][3]==false)
				{
					flightSeat[0][3]=true;
					seatChart[1][4] = "{X}";
					seatCount--;
					JOptionPane.showMessageDialog(null, "Passenger: "+name+"\nSeating is at: Seat D Row 1\n"+seatCount+" remaining seat is available");
					booking.put(name, "Seat D Row 1");
					break;
				}
				else if (flightSeat[1][3]==false)
				{
					flightSeat[1][3]=true;
					seatChart[2][4] = "{X}";
					seatCount--;
					JOptionPane.showMessageDialog(null, "Passenger: "+name+"\nSeating is at: Seat D Row 2\n"+seatCount+" remaining seat is available");
					booking.put(name, "Seat D Row 2");
					break;
				}
			}//end first class windows loop
			while (cS1 == 1 && wiS1 == 2)
			{
				if (flightSeat[0][1] == true && flightSeat[1][1] == true && flightSeat[0][2] == true && flightSeat[1][2] == true)
				{
					int ans = JOptionPane.showConfirmDialog(null, 
							"All Isle Seat is taken, Is Economy Window Seat Ok?", 
							"Confirmed", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (ans != JOptionPane.YES_OPTION)
					{
						JOptionPane.showMessageDialog(null, "Thanks for using this program!\nThe Next Flight Leaves in 3 Hours!",
								"Java Flight", JOptionPane.YES_NO_CANCEL_OPTION);
						break;
					}
					else
					{
						this.cS1 = 2;
						this.wiS1 = 1;
					}
				}
				
				if (flightSeat[0][1]==false)
				{
					flightSeat[0][1]=true;
					seatChart[1][2] = "{X}"; 
					seatCount--; 
					JOptionPane.showMessageDialog(null, "Passenger: "+name+"\nSeating is at: seat B Row 1\n"+seatCount+" remaining seat is available");
					booking.put(name, "Seat B Row 1"); 
					break;
				}
				else if (flightSeat[1][1]==false)
				{
					flightSeat[1][1]=true;
					seatChart[2][2] = "{X}";
					seatCount--;
					JOptionPane.showMessageDialog(null, "Passenger: "+name+"\nSeating is at: Seat B Row 2\n"+seatCount+" remaining seat is available");
					booking.put(name, "Seat B Row 2");
					break;
				}
				else if (flightSeat[0][2]==false)
				{
					flightSeat[0][2]=true;
					seatChart[1][3] = "{X}";
					seatCount--;
					JOptionPane.showMessageDialog(null, "Passenger: "+name+"\nSeating is at: Seat C Row 1\n"+seatCount+" remaining seat is available");
					booking.put(name, "Seat C Row 1");
					
					break;
				}
				else if (flightSeat[1][2]==false)
				{
					flightSeat[1][2]=true;
					seatChart[2][3] = "{X}";
					seatCount--;
					JOptionPane.showMessageDialog(null, "Passenger: "+name+"\nSeating is at: seat C row 2\n"+seatCount+" remaining seat is available");
					booking.put(name, "Seat C Row 2");
					break;
				}
			} // end first class isle loop
			while (cS1 == 2 && wiS1 == 1)
			{
				if (flightSeat[2][0] == true && flightSeat[2][3] == true && flightSeat[3][0] == true && flightSeat[3][3] == true)
				{
					int ans = JOptionPane.showConfirmDialog(null, 
							"All Windows Seat are taken, would you like a Isle Seat instead?", 
							"Confirmed", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (ans != JOptionPane.YES_OPTION)
					{
						JOptionPane.showMessageDialog(null, "Thanks for using this program!\nThe Next Flight Leaves in 3 Hours!",
								"Java Flight", JOptionPane.YES_NO_CANCEL_OPTION);
						break;
					}
					else
					{
						this.cS1 = 2;
						this.wiS1 = 2;
					}
				}
				
				if (flightSeat[2][0]==false)
				{
					flightSeat[2][0]=true;
					seatChart[3][1] = "{X}";
					seatCount--;
					JOptionPane.showMessageDialog(null, "Passenger: "+name+"\nSeating is at: Seat A Row 3\n"+seatCount+" remaining seat is available");
					booking.put(name, "Seat A Row 3");
					break;
				}
				else if (flightSeat[3][0]==false)
				{
					flightSeat[3][0]=true;
					seatChart[4][1] = "{X}";
					seatCount--;
					JOptionPane.showMessageDialog(null, "Passenger: "+name+"\nSeating is at: Seat A Row 4\n"+seatCount+" remaining seat is available");
					booking.put(name, "Seat A Row 4");
					break;
				}
				else if (flightSeat[2][3]==false)
				{
					flightSeat[2][3]=true;
					seatChart[3][4] = "{X}";
					seatCount--;
					JOptionPane.showMessageDialog(null, "Passenger: "+name+"\nSeating is at: Seat D Row 3\n"+seatCount+" remaining seat is available");
					booking.put(name, "Seat D Row 3");
					break;
				}
				else if (flightSeat[3][3]==false)
				{
					flightSeat[3][3]=true;
					seatChart[4][4] = "{X}";
					seatCount--;
					JOptionPane.showMessageDialog(null, "Passenger: "+name+"\nSeating is at: Seat D Row 4\nThere's "+seatCount+" available seats left");
					booking.put(name, "Seat D Row 4");
					break;
				}
			} // end eco window loop
			while (cS1 == 2 && wiS1 == 2)
			{
				if (flightSeat[2][1]==false)
				{
					flightSeat[2][1]=true;
					seatChart[3][2] = "{X}";
					seatCount--;
					JOptionPane.showMessageDialog(null, "Passenger: "+name+"\nSeat is at seat B row 3\n"+seatCount+" remaining seat is available");
					booking.put(name, "Seat B Row 3");
					break;
				}
				else if (flightSeat[3][0]==false)
				{
					flightSeat[3][1]=true;
					seatChart[4][2] = "{X}";
					seatCount--;
					JOptionPane.showMessageDialog(null, "Passenger: "+name+"\nSeat is at seat B row 4\n"+seatCount+" remaining seat is available");
					booking.put(name, "Seat B Row 4");
					break;
				}
				else if (flightSeat[2][2]==false)
				{
					flightSeat[2][2]=true;
					seatChart[3][3] = "{X}";
					seatCount--;
					JOptionPane.showMessageDialog(null, "Passenger: "+name+"\nSeat is at seat C row 3\n"+seatCount+" remaining seat is available");
					booking.put(name, "Seat C Row 3");
					break;
				}
				else if (flightSeat[3][2]==false)
				{
					flightSeat[3][2]=true;
					seatChart[4][3] = "{X}";
					seatCount--;
					JOptionPane.showMessageDialog(null, "Passenger: "+name+"\nSeat is at seat C row 4\nThere's "+seatCount+" available seats left");
					booking.put(name, "Seat C Row 4");
					break;
				}
			} // end eco isle loop
		} // end while
		JOptionPane.showMessageDialog(null, "Generating Seating Chart....", "Java Flight", JOptionPane.INFORMATION_MESSAGE);
		//Map<String, String> bookingOutput = new TreeMap<String, String>(booking); //sort HashMap by key value in alphabetical orders
		JTable seatTable = new JTable(booking.size(),2);
		 int row=0;
		 for(Map.Entry<String,String> entry: booking.entrySet())
		 {
			 seatTable.setValueAt(entry.getKey(),row,0);
			 seatTable.setValueAt(entry.getValue(),row,1);
		     row++;
		 }
		 
		 JOptionPane.showMessageDialog(null, seatTable, "Seating Chart", JOptionPane.INFORMATION_MESSAGE); //out put HashMap Table
		 JOptionPane.showMessageDialog(null, "Thank you for Choosing Java Flight!\nHave a great day!","Java Flight", JOptionPane.INFORMATION_MESSAGE);
	} //end start
} //end class