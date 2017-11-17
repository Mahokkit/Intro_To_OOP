import java.awt.*;
import java.util.Random;

public class Square extends Shape
{
	Random rand = new Random();
	private int speedX;
	private int speedY;
	private int corX;
	private int corY;
	private int width;
	private int height;
	
	private Color color;
	Color cArray[] = {
			Color.RED, 
			Color.BLUE, 
			Color.GREEN,
			Color.MAGENTA,
			Color.ORANGE,
			Color.YELLOW,
			Color.WHITE
			};
	
	public Square(int corX, int corY, int width, int height, int speedX, int speedY)
	{
		super();
		this.corX = corX;
		this.corY = corY;
		this.width = width;
		this.height = height;
		this.speedX = speedX;
		this.speedY = speedY;
	}
	
	@Override
	void draw2D(Graphics2D g2) 
	{
		
		GradientPaint gradient = new GradientPaint(10,10,cArray[rand.nextInt(6)],30,30,cArray[rand.nextInt(6)],true);
		g2.setPaint(gradient);
//		g2.setXORMode(color);
		g2.fillRect(corX, corY, width, height);
		
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