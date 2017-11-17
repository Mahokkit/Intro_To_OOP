import java.io.*;

public class IOReader 
{
	public String Reader(String fileName)
	{
		String read ="";
		try
		{
			FileReader reader = new FileReader(fileName);
			BufferedReader buffereReader = new BufferedReader(reader);
			String reads;
	        while ((reads = buffereReader.readLine()) != null) 
	        {
	        	read = read + reads + "\n";
	       
	        }
	        reader.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e){ 
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return read; 
	}
}
