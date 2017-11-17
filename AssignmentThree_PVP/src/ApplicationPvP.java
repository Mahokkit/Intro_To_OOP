import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.Vector;


public class ApplicationPvP extends JFrame 
{

	/**
	 * 
	 */
	
	Vector<String> comboBoxItems=new Vector<String>();
	final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(comboBoxItems);
	
	private static final long serialVersionUID = 7087309035309570291L;
	private JPanel contentPane;
	private JPanel fightPanel;
	private JPanel equipPanel;
	private JRadioButton rdbtnMonk;
	private JRadioButton rdbtnWarriorClass;
	private JRadioButton rdbtnAssassin;
	private JLabel lblWarEquip;
	private JComboBox<String>  comBoxWarArm;
	private JLabel lblWarriorWeapon;
	private JComboBox<String>  comBoxWarWep;
	
	private JLabel lblAssassinArmor; 
	private JComboBox<String>  comBoxAssArm;
	private JLabel lblAssassinWeapon;
	private JComboBox<String>  comBoxAssWep; 
	
	private JLabel lblMonkArmor;
	private JComboBox<String>  comBoxMnkArm;
	private JLabel lblMonkWeapon;
	private JComboBox<String>  comBoxMnkWep;
	
	private JLabel lblnewStr;
	private JLabel lblNewcon;
	private JLabel lblNewdex;
	
	private JLabel lblNewhealth;
	private JLabel lblNewattack;
	private JLabel lblNewdef;
	
	private JLabel lblClassDesc;
	private JLabel lblClassPic;
	
	private JLabel lblYourHp;
	private JLabel lblYourAtk;
	private JLabel lblNpcHp;
	private JLabel lblNpcAtk;
	
	private JButton lblRollThatStats;
	private JButton btnClickToStart;
	
	private JButton btnShowFight;
	private JTextArea lblFightDisplay;
	
	private JLabel lblNumgold;
	private JLabel lblequipNumGold;
	
	private JButton btnWarThrWepGold;
	private JButton btnWarThrArmGold;
	
//	private JScrollPane sp = new JScrollPane(lblFightDisplay);
	
	warrior war = new warrior();
	assassin ass = new assassin();
	monk mnk = new monk();
	
	warEquip equipWar = new warEquip();
	assEquip equipAss = new assEquip();
	mnkEquip equipMnk = new mnkEquip();
	
	playerStats stats = new playerStats();
	Validate val = new Validate();
	
	private final int ANIMATION_DELAY = 1000;//300ms
	private Timer timer = new Timer(ANIMATION_DELAY,new TimerHandler());
	private final String[] picsNames = {
			"warrior.jpg",
			"assassin.jpg",
			"monk.jpg"};
	private Icon[] classIcons = {
			new ImageIcon(getClass().getResource(picsNames[0])),	
			new ImageIcon(getClass().getResource(picsNames[1])),
			new ImageIcon(getClass().getResource(picsNames[2]))}; 
	private JTextField playerName;
	private JLabel lblUnlockedEquipment;
	
	private JLabel lblClaymore;
	private JLabel lblTwoHandAxe;
	
	private JLabel lblChainmail;
	private JLabel lblSteelPlate;
	
	private JLabel lblSteelDaggers;
	private JLabel lblObsidianDaggers;
	
	private JLabel lblHardenLeather;
	private JLabel lblChainmail2;
	
	private JLabel lblBrassKnuckles;
	private JLabel lblIronFist;
	
	private JLabel lblPajamas;
	private JLabel lblYellowTrackSuit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ApplicationPvP frame = new ApplicationPvP();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ApplicationPvP() 
	{
//		warrior war = new warrior();
//		assassin ass = new assassin();
//		monk mnk = new monk();
//		
//		warEquip equipWar = new warEquip();
//		assEquip equipAss = new assEquip();
//		mnkEquip equipMnk = new mnkEquip();
//		
//		playerStats stats = new playerStats();
		
//		Classes cla = new Classes();
//		randInt rand = new randInt();
	

		setTitle("Edward's P vs P");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fightPanel = new JPanel();
		fightPanel.setBackground(Color.PINK);
		fightPanel.setBounds(459, 11, 315, 553);
		contentPane.add(fightPanel);
		fightPanel.setLayout(null);
		fightPanel.setVisible(false);
		
		JLabel lblFight = new JLabel("FIGHT!");
		lblFight.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFight.setBounds(10, 11, 179, 19);
		fightPanel.add(lblFight);
		
		lblFightDisplay = new JTextArea("");
		lblFightDisplay.setEditable(false);
		lblFightDisplay.setLineWrap(true);
		lblFightDisplay.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFightDisplay.setBounds(10, 41, 295, 330);
		fightPanel.add(lblFightDisplay);
		
				btnClickToStart = new JButton("Click to Start");
				btnClickToStart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						stats.setfightHealth();
						stats.setnpcFightHP();
						if(timer.isRunning())
						{
							timer.stop();
						}
						else
						{
							timer.start();
						}
					}
				});
				btnClickToStart.setBounds(10, 519, 131, 23);
				fightPanel.add(btnClickToStart);
				
				JLabel lblYourHealth = new JLabel("Your Health:");
				lblYourHealth.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblYourHealth.setBounds(7, 382, 87, 14);
				fightPanel.add(lblYourHealth);
				
				JLabel lblNpcHealth = new JLabel("NPC Health:");
				lblNpcHealth.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNpcHealth.setBounds(10, 440, 84, 14);
				fightPanel.add(lblNpcHealth);
				
				lblYourHp = new JLabel("Your HP");
				lblYourHp.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblYourHp.setBounds(104, 382, 60, 14);
				fightPanel.add(lblYourHp);
				
				lblNpcHp = new JLabel("NPC HP");
				lblNpcHp.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNpcHp.setBounds(104, 440, 60, 14);
				fightPanel.add(lblNpcHp);
				
				JLabel lblNpcAttack = new JLabel("NPC Attack:");
				lblNpcAttack.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNpcAttack.setBounds(10, 465, 84, 14);
				fightPanel.add(lblNpcAttack);
				
				lblNpcAtk = new JLabel("NPC ATK");
				lblNpcAtk.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNpcAtk.setBounds(104, 465, 60, 14);
				fightPanel.add(lblNpcAtk);
				
				JLabel lblYourAttack = new JLabel("Your Attack:");
				lblYourAttack.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblYourAttack.setBounds(7, 407, 87, 14);
				fightPanel.add(lblYourAttack);
				
				lblYourAtk = new JLabel("Your ATK");
				lblYourAtk.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblYourAtk.setBounds(104, 407, 60, 14);
				fightPanel.add(lblYourAtk);
				
				JLabel lblTotalGold = new JLabel("Total Gold:");
				lblTotalGold.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTotalGold.setBounds(151, 519, 75, 14);
				fightPanel.add(lblTotalGold);
				
				lblNumgold = new JLabel("");
				lblNumgold.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNumgold.setBounds(229, 519, 60, 14);
				fightPanel.add(lblNumgold);
		
		equipPanel = new JPanel();
		equipPanel.setBackground(Color.PINK);
		equipPanel.setBounds(459, 11, 315, 553);
		contentPane.add(equipPanel);
		equipPanel.setLayout(null);
		equipPanel.setVisible(false);
		
		lblWarEquip = new JLabel("Warrior Armor");
		lblWarEquip.setEnabled(false);
		lblWarEquip.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWarEquip.setBounds(33, 39, 100, 20);
		equipPanel.add(lblWarEquip);
		
		JLabel lblTheArmory = new JLabel("The Armory");
		lblTheArmory.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTheArmory.setBounds(10, 11, 162, 19);
		equipPanel.add(lblTheArmory);
		
		comBoxWarArm = new JComboBox<String>(model);
		comBoxWarArm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = comBoxWarArm.getSelectedIndex();
				if (select == 0)
				{
					stats.setDefense((equipWar.defaultArmMod())+(war.newDefense()));
					lblNewdef.setText(Integer.toString(stats.getDefense()));
				}
				else if (select == 1)
				{
					stats.setDefense((equipWar.secondArmMod())+(war.newDefense()));
					lblNewdef.setText(Integer.toString(stats.getDefense()));
				}
				else
				{
					stats.setDefense((equipWar.thirdArmMod())+(war.newDefense()));
					lblNewdef.setText(Integer.toString(stats.getDefense()));
				}
			}
		});
		comBoxWarArm.setEnabled(false);
		comBoxWarArm.setModel(new DefaultComboBoxModel<String>(new String[] {"Harden Leather"}));
		comBoxWarArm.setBounds(156, 40, 123, 20);
		equipPanel.add(comBoxWarArm);
		
		
		lblWarriorWeapon = new JLabel("Warrior Weapon");
		lblWarriorWeapon.setEnabled(false);
		lblWarriorWeapon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWarriorWeapon.setBounds(20, 70, 113, 19);
		equipPanel.add(lblWarriorWeapon);
		
		comBoxWarWep = new JComboBox<String>(model);
		comBoxWarWep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = comBoxWarWep.getSelectedIndex();
				if (select == 0)
				{
					stats.setAttack((equipWar.defaultWepMod())+(war.newAttack()));
					lblNewattack.setText(Integer.toString(stats.getAttack()));
				}
				else if (select == 1)
				{
					stats.setAttack((equipWar.secondArmMod())+(war.newAttack()));
					lblNewattack.setText(Integer.toString(stats.getAttack()));
				}
				else
				{
					stats.setAttack((equipWar.thirdArmMod())+(war.newAttack()));
					lblNewattack.setText(Integer.toString(stats.getAttack()));
				}
			}
		});
		comBoxWarWep.setEnabled(false);
		comBoxWarWep.setModel(new DefaultComboBoxModel<String>(new String[] {"Sword & Shield"}));
		comBoxWarWep.setBounds(156, 71, 123, 20);
		equipPanel.add(comBoxWarWep);
		
		lblAssassinArmor = new JLabel("Assassin Armor");
		lblAssassinArmor.setEnabled(false);
		lblAssassinArmor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAssassinArmor.setBounds(24, 113, 109, 19);
		equipPanel.add(lblAssassinArmor);
		
		lblAssassinWeapon = new JLabel("Assassin Weapon");
		lblAssassinWeapon.setEnabled(false);
		lblAssassinWeapon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAssassinWeapon.setBounds(10, 143, 123, 19);
		equipPanel.add(lblAssassinWeapon);
		
		comBoxAssArm = new JComboBox<String>(model);
		comBoxAssArm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = comBoxAssArm.getSelectedIndex();
				if (select == 0)
				{
					stats.setDefense((equipAss.defaultArmMod())+(ass.newDefense()));
					lblNewdef.setText(Integer.toString(stats.getDefense()));
				}
				else if (select == 1)
				{
					stats.setDefense((equipAss.secondArmMod())+(ass.newDefense()));
					lblNewdef.setText(Integer.toString(stats.getDefense()));
				}
				else
				{
					stats.setDefense((equipAss.thirdArmMod())+(ass.newDefense()));
					lblNewdef.setText(Integer.toString(stats.getDefense()));
				}
			}
		});
		comBoxAssArm.setEnabled(false);
		comBoxAssArm.setModel(new DefaultComboBoxModel<String>(new String[] {"Light Leather"}));
		comBoxAssArm.setBounds(156, 111, 123, 20);
		equipPanel.add(comBoxAssArm);
		
		comBoxAssWep = new JComboBox<String>(model);
		comBoxAssWep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = comBoxAssWep.getSelectedIndex();
				if (select == 0)
				{
					stats.setAttack((equipAss.defaultWepMod())+(ass.newAttack()));
					lblNewattack.setText(Integer.toString(stats.getAttack()));
				}
				else if (select == 1)
				{
					stats.setAttack((equipAss.secondArmMod())+(ass.newAttack()));
					lblNewattack.setText(Integer.toString(stats.getAttack()));
				}
				else
				{
					stats.setAttack((equipAss.thirdArmMod())+(ass.newAttack()));
					lblNewattack.setText(Integer.toString(stats.getAttack()));
				}
			}
		});
		comBoxAssWep.setEnabled(false);
		comBoxAssWep.setModel(new DefaultComboBoxModel<String>(new String[] {"Iron Daggers"}));
		comBoxAssWep.setBounds(156, 142, 123, 20);
		equipPanel.add(comBoxAssWep);
		
		lblMonkArmor = new JLabel("Monk Armor");
		lblMonkArmor.setEnabled(false);
		lblMonkArmor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMonkArmor.setBounds(47, 184, 109, 19);
		equipPanel.add(lblMonkArmor);
		
		lblMonkWeapon = new JLabel("Monk Weapon");
		lblMonkWeapon.setEnabled(false);
		lblMonkWeapon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMonkWeapon.setBounds(34, 214, 99, 19);
		equipPanel.add(lblMonkWeapon);
		
		comBoxMnkArm = new JComboBox<String>(model);
		comBoxMnkArm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = comBoxMnkArm.getSelectedIndex();
				if (select == 0)
				{
					stats.setDefense((equipMnk.defaultArmMod())+(mnk.newDefense()));
					lblNewdef.setText(Integer.toString(stats.getDefense()));
				}
				else if (select == 1)
				{
					stats.setDefense((equipMnk.secondArmMod())+(mnk.newDefense()));
					lblNewdef.setText(Integer.toString(stats.getDefense()));
				}
				else
				{
					stats.setDefense((equipMnk.thirdArmMod())+(mnk.newDefense()));
					lblNewdef.setText(Integer.toString(stats.getDefense()));
				}
			}
		});
		comBoxMnkArm.setEnabled(false);
		comBoxMnkArm.setModel(new DefaultComboBoxModel<String>(new String[] {"Robe"}));
		comBoxMnkArm.setBounds(156, 184, 123, 20);
		equipPanel.add(comBoxMnkArm);
		
		comBoxMnkWep = new JComboBox<String>(model);
		comBoxMnkWep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = comBoxMnkWep.getSelectedIndex();
				if (select == 0)
				{
					stats.setAttack((equipMnk.defaultWepMod())+(mnk.newAttack()));
					lblNewattack.setText(Integer.toString(stats.getAttack()));
				}
				else if (select == 1)
				{
					stats.setAttack((equipMnk.secondArmMod())+(mnk.newAttack()));
					lblNewattack.setText(Integer.toString(stats.getAttack()));
				}
				else
				{
					stats.setAttack((equipMnk.thirdArmMod())+(mnk.newAttack()));
					lblNewattack.setText(Integer.toString(stats.getAttack()));
				}
			}
		});
		comBoxMnkWep.setEnabled(false);
		comBoxMnkWep.setModel(new DefaultComboBoxModel<String>(new String[] {"Fist"}));
		comBoxMnkWep.setBounds(156, 215, 123, 20);
		equipPanel.add(comBoxMnkWep);
		
		lblUnlockedEquipment = new JLabel("Unlock New Equipment!");
		lblUnlockedEquipment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUnlockedEquipment.setBounds(33, 258, 194, 20);
		equipPanel.add(lblUnlockedEquipment);
		
		lblSteelDaggers = new JLabel("Steel Daggers");
		lblSteelDaggers.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSteelDaggers.setBounds(20, 294, 113, 20);
		equipPanel.add(lblSteelDaggers);
		
		lblBrassKnuckles = new JLabel("Brass Knuckles");
		lblBrassKnuckles.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBrassKnuckles.setBounds(20, 294, 113, 20);
		equipPanel.add(lblBrassKnuckles);
		
		
		lblTwoHandAxe = new JLabel("Two Hand Axe");
		lblTwoHandAxe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTwoHandAxe.setBounds(24, 325, 109, 20);
		equipPanel.add(lblTwoHandAxe);
		
		lblObsidianDaggers = new JLabel("Obsidian Daggers");
		lblObsidianDaggers.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblObsidianDaggers.setBounds(1, 325, 132, 20);
		equipPanel.add(lblObsidianDaggers);
		
		lblIronFist = new JLabel("Iron Fist");
		lblIronFist.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIronFist.setBounds(69, 325, 64, 20);
		equipPanel.add(lblIronFist);
		
		JButton btnWarSecWepGold = new JButton("100 Gold");
		btnWarSecWepGold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stats.getTotalGold() > 100)
				{
				comBoxWarWep.addItem("Claymore");
				comBoxAssWep.addItem("Steel Daggers");
				comBoxMnkWep.addItem("Brass Knuckles");
				stats.buyEquip(100);
				lblequipNumGold.setText(Integer.toString(stats.getTotalGold()));
				btnWarSecWepGold.setEnabled(false);
				btnWarThrWepGold.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Insufficient Funds");
				}
			}
		});
		btnWarSecWepGold.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnWarSecWepGold.setBounds(156, 294, 123, 20);
		equipPanel.add(btnWarSecWepGold);
		
		btnWarThrWepGold = new JButton("200 Gold");
		btnWarThrWepGold.setVisible(false);
		btnWarThrWepGold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stats.getTotalGold() > 200)
				{
				comBoxWarWep.addItem("Two Hand Axe");
				comBoxAssWep.addItem("Obsidian Daggers");
				comBoxMnkWep.addItem("Iron Fist");
				stats.buyEquip(200);
				lblequipNumGold.setText(Integer.toString(stats.getTotalGold()));
				btnWarThrWepGold.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Insufficient Funds");
				}
			}
		});
		btnWarThrWepGold.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnWarThrWepGold.setBounds(156, 325, 123, 20);
		equipPanel.add(btnWarThrWepGold);
		
		lblChainmail = new JLabel("Chainmail");
		lblChainmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChainmail.setBounds(57, 380, 76, 20);
		equipPanel.add(lblChainmail);
		
		lblHardenLeather = new JLabel("Harden Leather");
		lblHardenLeather.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHardenLeather.setBounds(17, 380, 116, 20);
		equipPanel.add(lblHardenLeather);
		
		lblPajamas = new JLabel("Pajamas");
		lblPajamas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPajamas.setBounds(69, 380, 64, 20);
		equipPanel.add(lblPajamas);
		
		JButton btnWarSecArmGold = new JButton("100 Gold");
		btnWarSecArmGold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stats.getTotalGold() > 100)
				{
					comBoxWarArm.addItem("Chainmail");
					comBoxAssArm.addItem("Harden Leather");
					comBoxMnkArm.addItem("Pajamas");
					stats.buyEquip(100);
					lblequipNumGold.setText(Integer.toString(stats.getTotalGold()));
					btnWarSecArmGold.setEnabled(false);
					btnWarThrArmGold.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Insufficient Funds");
				}
			}
		});
		btnWarSecArmGold.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnWarSecArmGold.setBounds(156, 380, 123, 20);
		equipPanel.add(btnWarSecArmGold);
		
		lblSteelPlate = new JLabel("Steel Plate");
		lblSteelPlate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSteelPlate.setBounds(51, 411, 82, 20);
		equipPanel.add(lblSteelPlate);
		
		lblYellowTrackSuit = new JLabel("Yellow Track Suit");
		lblYellowTrackSuit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYellowTrackSuit.setBounds(1, 411, 132, 20);
		equipPanel.add(lblYellowTrackSuit);
		
		lblChainmail2 = new JLabel("Chain Mail");
		lblChainmail2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChainmail2.setBounds(54, 411, 79, 20);
		equipPanel.add(lblChainmail2);
		
		btnWarThrArmGold = new JButton("200 Gold");
		btnWarThrArmGold.setVisible(false);
		btnWarThrArmGold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stats.getTotalGold() > 200)
				{
					comBoxWarArm.addItem("Steel Plate");
					comBoxAssArm.addItem("Chainmail");
					comBoxMnkArm.addItem("Yellow Track Suit");
					stats.buyEquip(200);
					lblequipNumGold.setText(Integer.toString(stats.getTotalGold()));
					btnWarThrArmGold.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Insufficient Funds");
				}
			}
		});
		btnWarThrArmGold.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnWarThrArmGold.setBounds(156, 411, 123, 20);
		equipPanel.add(btnWarThrArmGold);
		
		JLabel lblequipTotalGold = new JLabel("Total Gold:");
		lblequipTotalGold.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblequipTotalGold.setBounds(167, 528, 75, 14);
		equipPanel.add(lblequipTotalGold);
		
		lblequipNumGold = new JLabel("");
		lblequipNumGold.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblequipNumGold.setBounds(245, 528, 60, 14);
		equipPanel.add(lblequipNumGold);
		
		lblClaymore = new JLabel("Claymore");
		
				lblClaymore.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblClaymore.setBounds(57, 294, 76, 20);
				equipPanel.add(lblClaymore);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.PINK);
		mainPanel.setBounds(10, 11, 764, 553);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblClassSelector = new JLabel("Class Selector");
		lblClassSelector.setForeground(Color.BLACK);
		lblClassSelector.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClassSelector.setBounds(10, 55, 168, 23);
		mainPanel.add(lblClassSelector);
		
		rdbtnWarriorClass = new JRadioButton("Warrior");
		rdbtnWarriorClass.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (rdbtnWarriorClass.isSelected())
				{
					rdbtnAssassin.setSelected(false);
					rdbtnAssassin.setEnabled(false);
					
					rdbtnMonk.setSelected(false);
					rdbtnMonk.setEnabled(false);
					
					lblWarEquip.setEnabled(true);
					comBoxWarArm.setEnabled(true);
					lblWarriorWeapon.setEnabled(true);
					comBoxWarWep.setEnabled(true);
					
					lblAssassinArmor.setEnabled(false);
					comBoxAssArm.setEnabled(false);
					lblAssassinWeapon.setEnabled(false);
					comBoxAssWep.setEnabled(false);
					
					lblMonkArmor.setEnabled(false);
					comBoxMnkArm.setEnabled(false);
					lblMonkWeapon.setEnabled(false);
					comBoxMnkWep.setEnabled(false);
					

					lblSteelDaggers.setVisible(false);
					lblBrassKnuckles.setVisible(false);
					

					lblObsidianDaggers.setVisible(false);
					lblIronFist.setVisible(false);
					

					lblHardenLeather.setVisible(false);
					lblPajamas.setVisible(false);
					

					lblChainmail2.setVisible(false);
					lblYellowTrackSuit.setVisible(false);
					
					stats.setAtkType(war.atkType());
				}
				
				lblClassDesc.setText(
						"<html>"
						+ "<body>"
						+ "The Warrior is your basic grunt, strong and full of health, but not very fast or smart."
						+ "<br>They like to yell 'I GO AND SMASH NOW' a lot.<br>"
						+ "<br>Pro: Bonus +3 Strength and Constitution"
						+ "<br>Con: -2 Dexterity</body>"
						+ "</html>"
						);
				lblClassPic.setIcon(classIcons[0]);
			}
		});
		rdbtnWarriorClass.setFont(new Font("Tahoma", Font.BOLD, 25));
		rdbtnWarriorClass.setBounds(10, 81, 168, 40);
		mainPanel.add(rdbtnWarriorClass);
		
				rdbtnAssassin = new JRadioButton("Assassin");
				rdbtnAssassin.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						if (rdbtnAssassin.isSelected())
						{
							rdbtnWarriorClass.setSelected(false);
							rdbtnWarriorClass.setEnabled(false);
							
							rdbtnMonk.setSelected(false);
							rdbtnMonk.setEnabled(false);
							
							lblWarEquip.setEnabled(false);
							comBoxWarArm.setEnabled(false);
							lblWarriorWeapon.setEnabled(false);
							comBoxWarWep.setEnabled(false);
							
							lblAssassinArmor.setEnabled(true);
							comBoxAssArm.setEnabled(true);
							lblAssassinWeapon.setEnabled(true);
							comBoxAssWep.setEnabled(true);
							
							lblMonkArmor.setEnabled(false);
							comBoxMnkArm.setEnabled(false);
							lblMonkWeapon.setEnabled(false);
							comBoxMnkWep.setEnabled(false);
							
							lblClaymore.setVisible(false);
							lblBrassKnuckles.setVisible(false);
							
							lblTwoHandAxe.setVisible(false);
							lblIronFist.setVisible(false);
							
							lblChainmail.setVisible(false);
							lblPajamas.setVisible(false);
							
							lblSteelPlate.setVisible(false);
							lblYellowTrackSuit.setVisible(false);
							
							stats.setAtkType(ass.atkType());
						}
						
						lblClassDesc.setText(
								"<html>"
								+ "<body>"
								+ "Always sneaking about, and lurking in the shadows. <br>"
								+ "They would come up behind you and cut your carotid artery with their dual daggers.<br>"
								+ "Sneak off smiling, while your blood gushes out like a geyser."
								+ "<br>Pro: Bonus +3 Strength and Dexterity"
								+ "<br>Con: -2 Constitution</body>"
								+ "</html>"
								);
						lblClassPic.setIcon(classIcons[1]);
					}
				});
				rdbtnAssassin.setFont(new Font("Tahoma", Font.BOLD, 25));
				rdbtnAssassin.setBounds(10, 124, 168, 40);
				mainPanel.add(rdbtnAssassin);
				
				rdbtnMonk = new JRadioButton("Monk");
				rdbtnMonk.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						if (rdbtnMonk.isSelected())
						{
							rdbtnWarriorClass.setSelected(false);
							rdbtnWarriorClass.setEnabled(false);
							
							rdbtnAssassin.setSelected(false);
							rdbtnAssassin.setEnabled(false);
							
							lblWarEquip.setEnabled(false);
							comBoxWarArm.setEnabled(false);
							lblWarriorWeapon.setEnabled(false);
							comBoxWarWep.setEnabled(false);
							
							lblAssassinArmor.setEnabled(false);
							comBoxAssArm.setEnabled(false);
							lblAssassinWeapon.setEnabled(false);
							comBoxAssWep.setEnabled(false);
							
							lblMonkArmor.setEnabled(true);
							comBoxMnkArm.setEnabled(true);
							lblMonkWeapon.setEnabled(true);
							comBoxMnkWep.setEnabled(true);
							
							lblClaymore.setVisible(false);
							lblSteelDaggers.setVisible(false);
							
							lblTwoHandAxe.setVisible(false);
							lblObsidianDaggers.setVisible(false);
							
							lblChainmail.setVisible(false);
							lblHardenLeather.setVisible(false);

							lblSteelPlate.setVisible(false);
							lblChainmail2.setVisible(false);

							stats.setAtkType(mnk.atkType());
						}
						
						lblClassDesc.setText(
								"<html>"
								+ "<body>"
								+ "They hide in their mountain temples doing Lord knows what, prefer to wear funny looking pajamas or yellow track suits.<br>"
								+ "Might look harmless and peaceful, but if you make them mad, they will yell like angry monkeys and punch you to death"
								+ "</body>"
								+ "</html>"
								);
						lblClassPic.setIcon(classIcons[2]);
					}
				});
				rdbtnMonk.setFont(new Font("Tahoma", Font.BOLD, 25));
				rdbtnMonk.setBounds(10, 167, 168, 40);
				mainPanel.add(rdbtnMonk);
				
				btnShowFight = new JButton("Ready to Fight!");
				btnShowFight.setEnabled(false);
				btnShowFight.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						int reply = JOptionPane.showConfirmDialog(null, "Are You sure?!", "WARNING", JOptionPane.YES_NO_OPTION);
						if (reply == JOptionPane.YES_OPTION)
						{
							if (val.isFullname(playerName.getText()) == true)
							{
							stats.setPlayerName(playerName.getText());
							fightPanel.setVisible(true);
							equipPanel.setVisible(false);
							
							if (rdbtnWarriorClass.isSelected())
							{
								lblWarEquip.setEnabled(true);
								comBoxWarArm.setEnabled(true);
								lblWarriorWeapon.setEnabled(true);
								comBoxWarWep.setEnabled(true);
							}
							
							if (rdbtnAssassin.isSelected())
							{
								lblAssassinArmor.setEnabled(true);
								comBoxAssArm.setEnabled(true);
								lblAssassinWeapon.setEnabled(true);
								comBoxAssWep.setEnabled(true);
							}
							
							if (rdbtnMonk.isSelected())
							{
								lblMonkArmor.setEnabled(true);
								comBoxMnkArm.setEnabled(true);
								lblMonkWeapon.setEnabled(true);
								comBoxMnkWep.setEnabled(true);
							}
							
							rdbtnAssassin.setSelected(false);
							rdbtnAssassin.setEnabled(false);
							
							rdbtnMonk.setSelected(false);
							rdbtnMonk.setEnabled(false);
							
							rdbtnWarriorClass.setSelected(false);
							rdbtnWarriorClass.setEnabled(false);
							
							lblRollThatStats.setEnabled(false);
							btnShowFight.setEnabled(false);

							lblYourHp.setText(Integer.toString(stats.getHealth()));
							lblYourAtk.setText(Integer.toString(stats.getAttack()));
							
							stats.setnpcFightHP();
							stats.setnpcFightAtk();
							
							lblNpcHp.setText(Integer.toString(stats.getnpcFightHP()));
							lblNpcAtk.setText(Integer.toString(stats.getnpcFightAtk()));
							
							playerName.setEnabled(false);
							
							lblNumgold.setText(Integer.toString(stats.getTotalGold()));
							
							btnClickToStart.setEnabled(true);
							lblFightDisplay.setText("Let's FIGHT!\n\n");
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Invalid Character Name Input!\nMust be Alphabet only!\nTry Again!");
								playerName.setText("");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Go Get Ready!", "OK!", reply);
						}
					}
				});
				btnShowFight.setBounds(200, 519, 160, 23);
				mainPanel.add(btnShowFight);
				
				JButton btnShowEquip = new JButton("Set You Equipment!");
				btnShowEquip.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						lblequipNumGold.setText(Integer.toString(stats.getTotalGold()));
						equipPanel.setVisible(true);
						fightPanel.setVisible(false);
						
//						if (rdbtnWarriorClass.isSelected())
//						{
//							lblWarEquip.setEnabled(true);
//							comBoxWarArm.setEnabled(true);
//							lblWarriorWeapon.setEnabled(true);
//							comBoxWarWep.setEnabled(true);
//						}
//						
//						if (rdbtnAssassin.isSelected())
//						{
//							lblAssassinArmor.setEnabled(true);
//							comBoxAssArm.setEnabled(true);
//							lblAssassinWeapon.setEnabled(true);
//							comBoxAssWep.setEnabled(true);
//						}
//						
//						if (rdbtnMonk.isSelected())
//						{
//							lblMonkArmor.setEnabled(true);
//							comBoxMnkArm.setEnabled(true);
//							lblMonkWeapon.setEnabled(true);
//							comBoxMnkWep.setEnabled(true);
//						}
					}
				});
				btnShowEquip.setBounds(33, 519, 160, 23);
				mainPanel.add(btnShowEquip);
				
				JLabel lblClassdescTitle = new JLabel("Class Description");
				lblClassdescTitle.setForeground(Color.BLACK);
				lblClassdescTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblClassdescTitle.setBounds(190, 55, 250, 23);
				mainPanel.add(lblClassdescTitle);
				
				lblClassDesc = new JLabel("");
				lblClassDesc.setBorder(new LineBorder(new Color(0, 0, 0)));
				lblClassDesc.setBounds(190, 81, 250, 126);
				mainPanel.add(lblClassDesc);
				
				lblRollThatStats = new JButton("Roll That Stats!");
				lblRollThatStats.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{			
						btnShowFight.setEnabled(true);
						comBoxWarArm.setSelectedIndex(0);
						comBoxWarWep.setSelectedIndex(0);
						
						comBoxAssArm.setSelectedIndex(0);
						comBoxAssWep.setSelectedIndex(0);
						
						comBoxMnkArm.setSelectedIndex(0);
						comBoxMnkWep.setSelectedIndex(0);
						if (rdbtnWarriorClass.isSelected())
						{
							lblnewStr.setText(Integer.toString(war.newStr()));
							lblNewcon.setText(Integer.toString(war.newCon()));
							lblNewdex.setText(Integer.toString(war.newDex()));
							
							stats.setHealth(war.newHealth());
							stats.setAttack(((equipWar.defaultWepMod())+(war.newAttack())));
							
							lblNewhealth.setText(Integer.toString((war.newHealth())));
							lblNewattack.setText(Integer.toString(stats.getAttack()));
							lblNewdef.setText(Integer.toString(((equipWar.defaultArmMod())+(war.newDefense()))));
						}
												
						if (rdbtnAssassin.isSelected())
						{
							lblnewStr.setText(Integer.toString(ass.newStr()));
							lblNewcon.setText(Integer.toString(ass.newCon()));
							lblNewdex.setText(Integer.toString(ass.newDex()));
							
							stats.setHealth(ass.newHealth());
							stats.setAttack(((equipAss.defaultWepMod())+(ass.newAttack())));
							
							lblNewhealth.setText(Integer.toString(ass.newHealth()));
							lblNewattack.setText(Integer.toString((equipAss.defaultWepMod())+(ass.newAttack())));
							lblNewdef.setText(Integer.toString((equipAss.defaultArmMod())+(ass.newDefense())));
						}
						
						if (rdbtnMonk.isSelected())
						{
							lblnewStr.setText(Integer.toString(mnk.newStr()));
							lblNewcon.setText(Integer.toString(mnk.newCon()));
							lblNewdex.setText(Integer.toString(mnk.newDex()));
							
							stats.setHealth(mnk.newHealth());
							stats.setAttack(((equipMnk.defaultWepMod())+(mnk.newAttack())));
							
							lblNewhealth.setText(Integer.toString(mnk.newHealth()));
							lblNewattack.setText(Integer.toString((equipMnk.defaultWepMod())+(mnk.newAttack())));
							lblNewdef.setText(Integer.toString((equipMnk.defaultArmMod())+(mnk.newDefense())));
						}						
					}
				});
				lblRollThatStats.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblRollThatStats.setBounds(10, 237, 168, 23);
				mainPanel.add(lblRollThatStats);
				
				JLabel lblStrength = new JLabel("Strength :");
				lblStrength.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblStrength.setBounds(33, 271, 72, 23);
				mainPanel.add(lblStrength);
				
				JLabel lblConstitution = new JLabel("Constitution :");
				lblConstitution.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblConstitution.setBounds(10, 305, 95, 23);
				mainPanel.add(lblConstitution);
				
				JLabel lblDexterity = new JLabel("Dexterity :");
				lblDexterity.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblDexterity.setBounds(33, 339, 72, 23);
				mainPanel.add(lblDexterity);
				
				lblnewStr = new JLabel("");
				lblnewStr.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
				lblnewStr.setBounds(115, 271, 54, 23);
				mainPanel.add(lblnewStr);
				
				lblNewcon = new JLabel("");
				lblNewcon.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
				lblNewcon.setBounds(115, 305, 54, 23);
				mainPanel.add(lblNewcon);
				
				lblNewdex = new JLabel("");
				lblNewdex.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
				lblNewdex.setBounds(115, 339, 54, 23);
				mainPanel.add(lblNewdex);
				
				lblClassPic = new JLabel("");
				lblClassPic.setBorder(new LineBorder(new Color(0, 0, 0)));
				lblClassPic.setBounds(190, 218, 250, 290);
				mainPanel.add(lblClassPic);
				
				JLabel lblCharacterInfo = new JLabel("Character Info");
				lblCharacterInfo.setForeground(Color.BLACK);
				lblCharacterInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblCharacterInfo.setBounds(10, 383, 168, 23);
				mainPanel.add(lblCharacterInfo);
				
				JLabel lblHealth = new JLabel("Health :");
				lblHealth.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblHealth.setBounds(20, 417, 54, 23);
				mainPanel.add(lblHealth);
								
				lblNewhealth = new JLabel("");
				lblNewhealth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
				lblNewhealth.setBounds(84, 417, 94, 23);
				mainPanel.add(lblNewhealth);
				
				JLabel lblAttack = new JLabel("Attack :");
				lblAttack.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblAttack.setBounds(20, 451, 54, 23);
				mainPanel.add(lblAttack);
				
				lblNewattack = new JLabel("");
				lblNewattack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
				lblNewattack.setBounds(84, 451, 94, 23);
				mainPanel.add(lblNewattack);
				
				JLabel lblDefense = new JLabel("Defense :");
				lblDefense.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblDefense.setBounds(10, 485, 64, 23);
				mainPanel.add(lblDefense);
				
				lblNewdef = new JLabel("");
				lblNewdef.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
				lblNewdef.setBounds(84, 485, 94, 23);
				mainPanel.add(lblNewdef);
				
				JLabel lblCharacterName = new JLabel("Character Name:");
				lblCharacterName.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblCharacterName.setBounds(10, 21, 170, 23);
				mainPanel.add(lblCharacterName);
				
				playerName = new JTextField();
				playerName.setBounds(190, 21, 250, 23);
				mainPanel.add(playerName);
				playerName.setColumns(10);
	} //end ApplicationPvP
	private void doTick()
	{		
		stats.playerAtkRoll();
		lblNpcHp.setText(Integer.toString(stats.getnpcFightHP()));
		lblFightDisplay.append(stats.getPlayerName()+" "+stats.atkType+" the NPC, and dealt "+stats.dmg+" damage!\n\n");
		if (stats.npcFightHP <= 0)
		{
			lblFightDisplay.append(stats.getPlayerName()+" is the Winner!\n\n");
			timer.stop();
			stats.setGold();
			stats.setTotalGold();
			lblNumgold.setText(Integer.toString(stats.getTotalGold()));
			lblFightDisplay.append(stats.getPlayerName()+" have earned "+stats.getGold()+" golds!");
			btnClickToStart.setEnabled(false);
			btnShowFight.setEnabled(true);
			return;
		}

		stats.playerDefRoll();
		lblYourHp.setText(Integer.toString(stats.getfightHealth()));
		
		lblFightDisplay.append("NPC attacked "+stats.getPlayerName()+", and caused "+stats.npcDmg+" damage!\n\n");
		if (stats.fightHealth <= 0)
		{
			lblFightDisplay.append("NPC WON! BOO I SAY BOO!\n\n");
			timer.stop();
			btnClickToStart.setEnabled(false);
			btnShowFight.setEnabled(true);
			return;
		}

		
	}//end doTick
	
	private class TimerHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			doTick();
		}
		
	}//end named inner class TimerHandler
} // end class
