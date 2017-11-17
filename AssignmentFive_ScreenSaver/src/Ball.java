import java.awt.*;
import java.util.Random;

public class Ball extends Shape
{
	Random rand = new Random();
	private int speedX;
	private int speedY;
	private int corX;
	private int corY;
	private int radius;
	private int width;
	private int height;
	private int maxRad = 50;
	private int minRad = 15;
	private double deSize;
	private Color color;
	
	
	public Ball(int corX, int corY, int width, int height,  int radius, Color color, int speedX, int speedY) 
	{
		super();
		this.corX = corX;
		this.corY = corY;
		this.width = width;
		this.height = height;
		this.radius = radius;
		this.color = color;
		this.speedX = speedX;
		this.speedY = speedY;
	}
	
	@Override
	void draw2D(Graphics2D g2) 
	{
	    for (int i = 1; i <= 10; i++) 
	    {
	        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, i * 0.1f));
			g2.setColor(color);
			g2.fillArc(corX, corY, width, height, ((radius*i)/10)*speedX, ((radius*i)/10)*speedY);
//			g2.fillOval(corX, corY, (radius*i)/10, (radius*i)/10);
	    }
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

	public int getRadius() 
	{
		return radius;
	}
	
	public Color getColor()
	{
		return color;
	}
}
