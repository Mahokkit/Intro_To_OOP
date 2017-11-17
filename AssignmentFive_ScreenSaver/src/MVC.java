import java.awt.Color;
import java.awt.event.*;
import java.util.*;


import javax.swing.*;

public class MVC extends MouseAdapter implements MouseListener
{
	Color cArray[] = {
			Color.RED, 
			Color.BLUE, 
			Color.GREEN,
			Color.MAGENTA,
			Color.ORANGE,
			Color.YELLOW,
			Color.WHITE
			};
	
	private Random rand = new Random();
	private DisplayPan pan;
	private int x;
	private int y;
	private int speedX;
	private int speedY;
	private int randNum;
	
	public  MVC(DisplayPan pan)
	{
		super();
		this.pan = pan;
	}
	

	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (SwingUtilities.isLeftMouseButton(e))
		{
			int sNUM = rand.nextInt(4);
			randNum = rand.nextInt(100)+30;
			speedX = rand.nextInt(3)-1; //will give -1, 0, or 1
			speedY = rand.nextInt(3)-1;
			x = e.getX();
			y = e.getY();
			
			if (speedX == 0)
			{
				speedX = 1;
			}
			
			if (speedY == 0)
			{
				speedY = 1;
			}
//			System.out.println("sNUM is: "+sNUM+"\nSpeedX and Y is: "+speedX+" "+speedY);
//			System.out.println(randNum);
			int cNUM = rand.nextInt(6);
			switch (sNUM)
			{
			case 0:
				pan.shapeAdd(new Ball(x-12, y-12, randNum, randNum, randNum, cArray[cNUM], speedX, speedY));
				break;
			case 1:
				pan.shapeAdd(new Square(x-12, y-12, randNum, randNum, speedX, speedY));
				break;
			case 2:
				pan.shapeAdd(new ThreeD(x-12, y-12, randNum, randNum, true, cArray[cNUM], speedX, speedY));
				break;
			case 3:
				pan.shapeAdd(new Circle(x-12, y-12, randNum, speedX, speedY));
			}
		}
	}
}
