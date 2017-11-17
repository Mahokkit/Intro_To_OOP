import java.awt.*;
import javax.swing.*;


public class ApplicationIO
{
	private JFrame f;
	
	public void start() 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ApplicationIO window = new ApplicationIO();
					window.f.setVisible(true);
					window.f.setTitle("Scream Saver");
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public ApplicationIO()
	{
		initalize();
	}
	
	public void initalize()
	{
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 1024, 768);
		DisplayPan pan = new DisplayPan();
		f.setContentPane(pan);
		pan.addMouseListener(new MVC(pan));
		pan.setBackground(Color.black);
	}
}

