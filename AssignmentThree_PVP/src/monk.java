
public class monk extends Classes
{

	protected int str;
	protected int con;
	protected int dex;
	randInt rand = new randInt();
	@Override
	protected int newHealth() 
	{
		int hp = con*5;
		return hp;
	}

	@Override
	protected int newAttack() 
	{
		int atk = str*5;
		return atk;
	}

	@Override
	protected int newDefense() 
	{
		int def = dex*5;
		return def;
	}

	@Override
	protected int newStr() 
	{
		str = rand.rand(5, 10);
		return str;
	}

	@Override
	protected int newCon() 
	{
		con = rand.rand(5, 10);
		return con;
	}

	@Override
	protected int newDex() 
	{
		dex = rand.rand(5, 10);
		return dex;
	}

	@Override
	protected String atkType() {

		return "Punch";
	}
}
