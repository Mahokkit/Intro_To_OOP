import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DisplayPan extends JPanel
{
	/**
	 * 
	 */
	Ball b = new Ball(0, 0, 30, 30, 30, Color.pink, 1, 1);
	Circle cir = new Circle(50, 1, 20, -1, 1);
	ThreeD thD = new ThreeD(2, 80, 35, 35, true, Color.PINK, 1, -1);
	Square squ = new Square(95, 3, 40, 40, -1, -1);
	private static final long serialVersionUID = 1L;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	private Timer animationTimer = new Timer(5, new TimerHandler());
	
	public void shapeAdd(Shape s)
	{
		this.shapes.add(s);
		animationTimer.start();
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		b.draw2D((Graphics2D) g);
		b.move(this.getWidth(), this.getHeight());
		
		cir.draw2D((Graphics2D) g);
		cir.move(this.getWidth(), this.getHeight());
		
		thD.draw2D((Graphics2D) g);
		thD.move(this.getWidth(), this.getHeight());
		
		squ.draw2D((Graphics2D) g);
		squ.move(this.getWidth(), this.getHeight());
		for (Shape s: shapes)
		{
			s.draw2D((Graphics2D) g);
			s.move(this.getWidth(), this.getHeight());
		}
	}


	private class TimerHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			repaint();
		}
	}
}
