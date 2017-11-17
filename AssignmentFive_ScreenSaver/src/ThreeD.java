import java.awt.*;
import java.util.Random;

public class ThreeD extends Shape
{
	Random rand = new Random();
	private int speedX;
	private int speedY;
	private int corX;
	private int corY;
	private int width;
	private int height;
	private boolean bool;
	private Color color;
	private double rotation;
	private double dRo = rand.nextDouble()/20;
	
	
	public ThreeD(int corX, int corY, int width, int height, boolean bool, Color color, int speedX, int speedY)
	{
		super();
		this.corX = corX;
		this.corY = corY;
		this.width = width;
		this.height = height;
		this.color = color;
		this.bool = bool;
		this.speedX = speedX;
		this.speedY = speedY;
	}
	
	@Override
	void draw2D(Graphics2D g2) 
	{
		double xOff = width * rotation;
		double yOff = height * rotation;
		
		int topRight = (int) (corX + xOff);
		int botRight = (int) (corY + yOff);
		int botLeft = (int)(corY + height - xOff);
		int topLeft = (int) (corY + height - yOff);
		
		g2.drawLine(topRight, corY, corX+width, botRight);
		g2.drawLine(corX + width, botRight, botLeft, corY+height);
		g2.drawLine(botLeft, corY + height, corX, topLeft);
		g2.drawLine(corX, topLeft, topRight, corY);
		
//		g2.setColor(color);
		g2.setBackground(color);
//		g2.fill3DRect(corX, corY, width, height, bool);
	}
	
	public void update()
	{
		rotation += dRo;
		if (rotation > 1)
		{
			rotation = rotation - 1;
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
		else if( corX > x - width)
		{
			speedX= -speedX;
		}
			
		if(corY < 0)
		{
			speedY = -speedY;
		}
		else if (corY > y - height)
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
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public Color getColor()
	{
		return color;
	}
}
