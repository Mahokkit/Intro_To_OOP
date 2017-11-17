
public class Walrus extends Species
{
	private double lat;
	private double longit;
	private String gender;
	private double weight;
	private String DenHealth;
	@Override
	public double Latitude() 
	{
		// TODO Auto-generated method stub
		return lat;
	}

	@Override
	public double Longitude() 
	{
		// TODO Auto-generated method stub
		return longit;
	}

	@Override
	public String Gender() 
	{
		// TODO Auto-generated method stub
		return gender;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}
	
	public void setLongit(double longit)
	{
		this.longit = longit;
	}
	
	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getDenHealth() {
		return DenHealth;
	}

	public void setDenHealth(String denHealth) {
		DenHealth = denHealth;
	}

	@Override
	public double Weight() {
		// TODO Auto-generated method stub
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
