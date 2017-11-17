public class playerStats 
{
	protected int attack;
	protected int defense;
	protected int health;
	
	protected int dmg;
	protected int npcDmg;
	
	protected int fightHealth;
	
	randInt rand = new randInt();
	protected int npcHealth;
	protected int npcAttack;
	
	protected int npcFightHP;
	protected int npcFightAtk;
	protected String atkType;
	private String playerName;
	
	private int gold;
	private int totalGold;
	
	public int getnpcFightAtk()
	{
		return npcFightAtk;
	}
	
	public void setnpcFightAtk()
	{
		npcAttack = rand.rand(25, 50);
		this.npcFightAtk = npcAttack;
	}
	
	public int getnpcFightHP()
	{
		return npcFightHP;
	}
	public void setnpcFightHP()
	{
		npcHealth = rand.rand(25, 50);
		this.npcFightHP = npcHealth;
	}
	public int getfightHealth()
	{
		return fightHealth;
	}
	
	public void setfightHealth()
	{
		this.fightHealth = health;
	}
	public String getAtkType()
	{
		return atkType;
	}
	
	public void setAtkType(String atkType)
	{
		this.atkType = atkType;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public void playerAtkRoll()
	{
		int atkRoll = rand.rand(1, 6);
		dmg = attack/atkRoll;
		npcFightHP = (npcFightHP - (attack/atkRoll));
	}
	
	public int dmg() {
		return dmg;
	}

	public void playerDefRoll()
	{
		int npcAtkRoll = rand.rand(1, 6);
		npcDmg = (npcFightAtk/defense)/npcAtkRoll;
		fightHealth = (fightHealth - npcDmg);
	}
	
	public int npcDmg()
	{
		return npcDmg;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	public int getGold() {
		return gold;
	}

	public void setGold() {
		this.gold = rand.rand(25, 100);
	}
	
	public int getTotalGold()
	{
		return totalGold;
	}
	
	public void setTotalGold()
	{
		this.totalGold = totalGold + gold;
	}
	
	public void buyEquip(int price)
	{
		this.totalGold = totalGold - price;
	}
}
