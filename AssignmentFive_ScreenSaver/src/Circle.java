import java.awt.*;
import java.util.Random;

public class Circle extends Shape
{
	private int speedX;
	private int speedY;
	private int corX;
	private int corY;
	private int radius;
	private int maxRad = 50;
	private int minRad = 15;
	private double deSize;
	private Color color;
	Random rand = new Random();
	Color cArray[] = {
			Color.RED, 
			Color.BLUE, 
			Color.GREEN,
			Color.MAGENTA,
			Color.ORANGE,
			Color.YELLOW,
			Color.WHITE
			};
	
	public Circle(int corX, int corY, int radius, int speedX, int speedY) 
	{
		super();
		this.corX = corX;
		this.corY = corY;
		this.radius = radius;
		this.speedX = speedX;
		this.speedY = speedY;
		this.deSize = rand.nextDouble();
	}
	
	@Override
	void draw2D(Graphics2D g2) 
	{
		g2.setColor(cArray[rand.nextInt(6)]);
		g2.fillOval(corX, corY, radius, radius);

//		g2.fillArc(corX, corY, 50, 50, 90, 45);
//		g2.fillPolygon(xPoints, yPoints, nPoints);
	}
	
	public void update()
	{
		this.radius += deSize;
		if (this.radius > maxRad)
		{
			this.radius = maxRad;
			deSize = -deSize;
		}
		
		if (this.radius < minRad)
		{
			this.radius = minRad;
			deSize = -deSize;
		}
	}

	@Override
	void move(int x, int y) 
	{

		corX = corX + speedX;
		corY = corY + speedY;
		
		if(corX< 0) 
		{
			speedX= -speedX;
		}
		else if( corX > x - radius)
		{
			speedX= -speedX;
		}
			
		if(corY < 0)
		{
			speedY = -speedY;
		}
		else if (corY > y - radius)
		{
			speedY = -speedY;
		}
		
	}

	public int getCorX() 
	{
		return corX;
	}
	
	public int getCorY() 
	{
		return corY;
	}

	public int getWidth() 
	{
		return radius;
	}
	
	public int getHeight()
	{
		return radius;
	}
	
	public Color getColor()
	{
		return color;
	}
}