import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;


public class ApplicationIO 
{
	private final String[] picsNames = 
		{
			"penguin.jpg",
			"Sea_lion.jpg",
			"walrus.jpg",
			"antarctica.jpg"
			};
	private Icon[] classIcons = 
		{
			new ImageIcon(getClass().getResource(picsNames[0])),	
			new ImageIcon(getClass().getResource(picsNames[1])),
			new ImageIcon(getClass().getResource(picsNames[2])),
			new ImageIcon(getClass().getResource(picsNames[3]))
			}; 
	private JFrame frmAntarcticWildlifeResearch;
	private JLabel lblAnimalpics;
	private JTextField txtLat;
	private JTextField txtLong;
	private JTextField txtSys;
	private JTextField txtDia;
	private JPanel panelPen;
	private JPanel panelWal;
	private JPanel panelSea;
	private JTextField txtSpots;
	private JCheckBox chckbxLatValid;
	private JCheckBox chckbxLongValid;
	private JCheckBox chckbxSpotValid;
	private JCheckBox chckbxSysValid;
	private JCheckBox chckbxDiaValid;
	private JComboBox CBDentalHealth;
	private JTextArea txtrOutput;
	private JCheckBox chckbxWeightValid;
	private JRadioButton btnPenguins;
	private JRadioButton btnSeaLions;
	private JRadioButton btnWalrus;

	Penguin pen = new Penguin();
	SeaLions sea = new SeaLions();
	Walrus wal = new Walrus();
	Validate val = new Validate();
	PrintWriter writer;
	IOReader read = new IOReader();
	private JTextField txtWeight;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public void start() 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ApplicationIO window = new ApplicationIO();
					window.frmAntarcticWildlifeResearch.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public ApplicationIO() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */

	private void initialize()
	{
		//default setting
		pen.setGender("Male");
		sea.setGender("Male");
		wal.setGender("Male");
		wal.setDenHealth("Good");
		
		frmAntarcticWildlifeResearch = new JFrame();
		frmAntarcticWildlifeResearch.setTitle("Antarctic Wildlife Research Application");
		frmAntarcticWildlifeResearch.getContentPane().setName("null.ContentPen");
		frmAntarcticWildlifeResearch.getContentPane().setBackground(new Color(102, 205, 170));
		frmAntarcticWildlifeResearch.setBounds(100, 100, 900, 450);
		frmAntarcticWildlifeResearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAntarcticWildlifeResearch.getContentPane().setLayout(null);
		
		btnWalrus = new JRadioButton("Walrus");
		btnWalrus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				btnPenguins.setSelected(false);
				btnSeaLions.setSelected(false);
				btnWalrus.setSelected(true);
				
				panelPen.setVisible(false);
				panelSea.setVisible(false);
				panelWal.setVisible(true);
				
				lblAnimalpics.setIcon(classIcons[2]);
			}
		});
		
		panelWal = new JPanel();
		panelWal.setBounds(246, 212, 350, 145);
		frmAntarcticWildlifeResearch.getContentPane().add(panelWal);
		panelWal.setBackground(new Color(102, 205, 170));
		panelWal.setVisible(false);
		panelWal.setLayout(null);
		
		JLabel lblDenHealth = new JLabel("Dental Health");
		lblDenHealth.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDenHealth.setBounds(10, 11, 138, 25);
		panelWal.add(lblDenHealth);
		
		CBDentalHealth = new JComboBox();
		CBDentalHealth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int DenSelect = CBDentalHealth.getSelectedIndex();
				if (DenSelect == 0)
				{
					wal.setDenHealth("Good");
				}
				else if (DenSelect == 1)
				{
					wal.setDenHealth("Average");
				}
				else if (DenSelect == 2)
				{
					wal.setDenHealth("Poor");
				}
			}
		});
		CBDentalHealth.setModel(new DefaultComboBoxModel(new String[] {"Good", "Average", "Poor"}));
		CBDentalHealth.setFont(new Font("Tahoma", Font.PLAIN, 19));
		CBDentalHealth.setBounds(158, 11, 100, 25);
		panelWal.add(CBDentalHealth);
		btnWalrus.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnWalrus.setBounds(59, 171, 155, 30);
		frmAntarcticWildlifeResearch.getContentPane().add(btnWalrus);
		
		panelSea = new JPanel();
		panelSea.setBounds(246, 212, 350, 145);
		frmAntarcticWildlifeResearch.getContentPane().add(panelSea);
		panelSea.setBackground(new Color(102, 205, 170));
		panelSea.setVisible(false);
		panelSea.setLayout(null);
		
		JLabel lblSpots = new JLabel("# of Spots");
		lblSpots.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSpots.setBounds(10, 11, 104, 25);
		panelSea.add(lblSpots);
		
		txtSpots = new JTextField();
		txtSpots.setText("0");
		txtSpots.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSpots.setBounds(124, 11, 75, 25);
		panelSea.add(txtSpots);
		txtSpots.setColumns(10);
		
		chckbxSpotValid = new JCheckBox("Valid");
		chckbxSpotValid.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxSpotValid.setBackground(new Color(102, 205, 170));
		chckbxSpotValid.setBounds(205, 11, 63, 25);
		panelSea.add(chckbxSpotValid);
		
		panelPen = new JPanel();
		panelPen.setBounds(246, 212, 350, 145);
		frmAntarcticWildlifeResearch.getContentPane().add(panelPen);
		panelPen.setBackground(new Color(102, 205, 170));
		panelPen.setVisible(false);
		panelPen.setLayout(null);
		
		JLabel lblSystolic = new JLabel("Systolic");
		lblSystolic.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSystolic.setBounds(18, 11, 78, 25);
		panelPen.add(lblSystolic);
		
		JLabel lblDiastolic = new JLabel("Diastolic");
		lblDiastolic.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDiastolic.setBounds(10, 47, 86, 25);
		panelPen.add(lblDiastolic);
		
		txtSys = new JTextField();
		txtSys.setText("0");
		txtSys.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSys.setBounds(106, 11, 93, 25);
		panelPen.add(txtSys);
		txtSys.setColumns(10);
		
		txtDia = new JTextField();
		txtDia.setText("0");
		txtDia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDia.setBounds(106, 51, 93, 25);
		panelPen.add(txtDia);
		txtDia.setColumns(10);
		
		chckbxSysValid = new JCheckBox("Valid");
		chckbxSysValid.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxSysValid.setBackground(new Color(102, 205, 170));
		chckbxSysValid.setBounds(205, 11, 63, 25);
		panelPen.add(chckbxSysValid);
		
		chckbxDiaValid = new JCheckBox("Valid");
		chckbxDiaValid.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxDiaValid.setBackground(new Color(102, 205, 170));
		chckbxDiaValid.setBounds(205, 49, 63, 25);
		panelPen.add(chckbxDiaValid);
		
		JLabel lblThePolyP = new JLabel("Antarctic Wildlife Research Application");
		lblThePolyP.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThePolyP.setBounds(190, 10, 503, 31);
		frmAntarcticWildlifeResearch.getContentPane().add(lblThePolyP);
		
		btnPenguins = new JRadioButton("Penguins");
		btnPenguins.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				btnPenguins.setSelected(true);
				btnSeaLions.setSelected(false);
				btnWalrus.setSelected(false);
				
				panelPen.setVisible(true);
				panelSea.setVisible(false);
				panelWal.setVisible(false);
				
				lblAnimalpics.setIcon(classIcons[0]);

			}
		}
		);
		btnPenguins.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPenguins.setBounds(59, 89, 155, 30);
		frmAntarcticWildlifeResearch.getContentPane().add(btnPenguins);
		
		btnSeaLions = new JRadioButton("Sea Lions");
		btnSeaLions.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				btnPenguins.setSelected(false);
				btnSeaLions.setSelected(true);
				btnWalrus.setSelected(false);
				
				panelPen.setVisible(false);
				panelSea.setVisible(true);
				panelWal.setVisible(false);
				
				lblAnimalpics.setIcon(classIcons[1]);

			}
		}
		);
		btnSeaLions.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSeaLions.setBounds(59, 130, 155, 30);
		frmAntarcticWildlifeResearch.getContentPane().add(btnSeaLions);
		
		JLabel lblSelectSpecies = new JLabel("Select Species");
		lblSelectSpecies.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSelectSpecies.setBounds(59, 52, 155, 30);
		frmAntarcticWildlifeResearch.getContentPane().add(lblSelectSpecies);
		
		lblAnimalpics = new JLabel();
		lblAnimalpics.setBounds(36, 212, 200, 188);
		frmAntarcticWildlifeResearch.getContentPane().add(lblAnimalpics);
		lblAnimalpics.setIcon(classIcons[3]);
		
		JButton btnSubmitData = new JButton("Submit Data");
		btnSubmitData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Writer writer = null;
				if(val.isLatitude(txtLat.getText()) == true)
				{
					pen.setLat(Double.parseDouble(txtLat.getText()));
					wal.setLat(Double.parseDouble(txtLat.getText()));
					sea.setLat(Double.parseDouble(txtLat.getText()));
					chckbxLatValid.setSelected(true);
					chckbxLatValid.setForeground(Color.green);
				}
				else
				{
					txtLat.setText(null);
					chckbxLatValid.setSelected(false);
					chckbxLatValid.setForeground(Color.red);
					JOptionPane.showMessageDialog(null, "Invalid Input for Latitude! ", "ERROR", JOptionPane.QUESTION_MESSAGE);
				}
				
				if(val.isLongitude(txtLong.getText()) == true)
				{
					pen.setLongit(Double.parseDouble(txtLong.getText()));
					wal.setLongit(Double.parseDouble(txtLong.getText()));
					sea.setLongit(Double.parseDouble(txtLong.getText()));
					chckbxLongValid.setSelected(true);
					chckbxLongValid.setForeground(Color.green);
				}
				else
				{
					txtLong.setText(null);
					chckbxLongValid.setSelected(false);
					chckbxLongValid.setForeground(Color.red);
					JOptionPane.showMessageDialog(null, "Invalid Input for Longitude! ", "ERROR", JOptionPane.QUESTION_MESSAGE);
				}
				
				if (val.isWeight(txtWeight.getText()) == true)
				{
					pen.setWeight(Double.parseDouble(txtWeight.getText()));
					wal.setLongit(Double.parseDouble(txtWeight.getText()));
					sea.setLongit(Double.parseDouble(txtWeight.getText()));
					chckbxWeightValid.setSelected(true);
					chckbxWeightValid.setForeground(Color.green);
				}
				else
				{
					txtWeight.setText(null);
					chckbxWeightValid.setSelected(false);
					chckbxWeightValid.setForeground(Color.red);
					JOptionPane.showMessageDialog(null, "Invalid Input for Weight! ", "ERROR", JOptionPane.QUESTION_MESSAGE);
				}
				
				if (btnPenguins.isSelected() == true)
				{
					if (val.isNumeric(txtSys.getText()) == true)
					{
						pen.setSys(Integer.parseInt(txtSys.getText()));
						chckbxSysValid.setSelected(true);
						chckbxSysValid.setForeground(Color.green);
					}
					else
					{
						txtSys.setText(null);
						chckbxSysValid.setSelected(false);
						chckbxSysValid.setForeground(Color.red);
						JOptionPane.showMessageDialog(null, "Invalid Input for Systolic! ", "ERROR", JOptionPane.QUESTION_MESSAGE);
					}

					if (val.isNumeric(txtDia.getText()) == true)
					{
						pen.setDia(Integer.parseInt(txtDia.getText()));
						chckbxDiaValid.setSelected(true);
						chckbxDiaValid.setForeground(Color.green);
					}
					else
					{
						txtDia.setText(null);
						chckbxDiaValid.setSelected(false);
						chckbxDiaValid.setForeground(Color.red);
						JOptionPane.showMessageDialog(null, "Invalid Input for Diastolic! ", "ERROR", JOptionPane.QUESTION_MESSAGE);
					}

					try {
					    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("penData.txt", true), "utf-8"));
					    writer.append("=========="+System.lineSeparator()
					    		+ "Penguin Data"+System.lineSeparator()
								+ "Location"+System.lineSeparator()
								+ "Latitude: "+pen.Latitude()+System.lineSeparator()
								+"Longitude: "+pen.Longitude()+System.lineSeparator()+System.lineSeparator()
								+"Gender: "+pen.Gender()+System.lineSeparator()
								+"Blood Pressure"+System.lineSeparator()
								+"Systolic: "+pen.getSys()+System.lineSeparator()
								+"Diastolic: "+pen.getDia()+System.lineSeparator()+System.lineSeparator());
					} 
					catch (IOException ex) 
					{
					  // report
					} 
					finally 
					{
					   try {writer.close();} catch (Exception ex) {/*ignore*/}
					}
					txtrOutput.setText("==========\nPenguin Data\n"
							+ "Location\n"
							+ "Latitude: "+pen.Latitude()
							+"\nLongitude: "+pen.Longitude()
							+"\n\nGender: "+pen.Gender()
							+"\nBlood Pressure"
							+"\nSystolic: "+pen.getSys()
							+"\nDiastolic: "+pen.getDia());
				}
				else if (btnSeaLions.isSelected() == true)
				{
					if (val.isNumeric(txtSpots.getText()) == true)
					{
						sea.setSpot(Integer.parseInt(txtSpots.getText()));
						chckbxSpotValid.setSelected(true);
						chckbxSpotValid.setForeground(Color.green);
					}
					else
					{
						txtSpots.setText(null);
						chckbxSpotValid.setSelected(false);
						chckbxSpotValid.setForeground(Color.red);
						JOptionPane.showMessageDialog(null, "Invalid Input for # of Spots! ", "ERROR", JOptionPane.QUESTION_MESSAGE);
					}

					try {
					    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("seaData.txt", true), "utf-8"));
					    writer.append("=========="+System.lineSeparator()
					    		+ "Sea Lion Data"+System.lineSeparator()
								+ "Location"+System.lineSeparator()
								+ "Latitude: "+sea.Latitude()+System.lineSeparator()+System.lineSeparator()
								+ "Longitude: "+sea.Longitude()+System.lineSeparator()
								+ "Gender: "+sea.Gender()+System.lineSeparator()
								+ "Spots #: "+sea.getSpot()+System.lineSeparator()+System.lineSeparator());
					} catch (IOException ex) {
					  // report
					} finally {
					   try {writer.close();} catch (Exception ex) {/*ignore*/}
					}
					txtrOutput.setText("Sea Lion Data\n"
							+ "Location\n"
							+ "Latitude: "+sea.Latitude()
							+"\nLongitude: "+sea.Longitude()
							+"\n\nGender: "+sea.Gender()
							+"\nSpots #: "+sea.getSpot());
				}
				else if (btnWalrus.isSelected() == true)
				{
					try {
					    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("walData.txt", true), "utf-8"));
					    writer.append("=========="+System.lineSeparator()
					    		+ "Walrus Data"+System.lineSeparator()
								+ "Location"+System.lineSeparator()
								+ "Latitude: "+wal.Latitude()+System.lineSeparator()
								+"Longitude: "+wal.Longitude()+System.lineSeparator()+System.lineSeparator()
								+"Gender: "+wal.Gender()+System.lineSeparator()
								+"Dental Health: "+wal.getDenHealth()+"\n\n"+System.lineSeparator()+System.lineSeparator());
					} catch (IOException ex) {
					  // report
					} finally {
					   try {writer.close();} catch (Exception ex) {/*ignore*/}
					}
					txtrOutput.setText("Walrus Data\n"
							+ "Location\n"
							+ "Latitude: "+wal.Latitude()
							+"\nLongitude: "+wal.Longitude()
							+"\n\nGender: "+wal.Gender()
							+"\nDental Health: "+wal.getDenHealth());
				}
			}
		});
		btnSubmitData.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubmitData.setBounds(246, 370, 145, 30);
		frmAntarcticWildlifeResearch.getContentPane().add(btnSubmitData);
		
		JButton btnReadData = new JButton("Read Data");
		btnReadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox dataSelect = new JComboBox();
				dataSelect.setModel(new DefaultComboBoxModel(new String[] {"Penguins", "Sea Lions", "Walrus"}));
				dataSelect.setEditable(false);
				JOptionPane.showMessageDialog( null, dataSelect, "Select Data to Read", JOptionPane.QUESTION_MESSAGE);
				int select = dataSelect.getSelectedIndex();
				if (select == 0)
				{
					txtrOutput.setText(read.Reader("penData.txt")); //Penguin
				}
				else if (select == 1)
				{
					txtrOutput.setText(read.Reader("seaData.txt")); //Sea Lions
//					scroll
				}
				else if (select == 2)
				{
					txtrOutput.setText(read.Reader("walData.txt")); //Walrus
				}
			}
		});
		btnReadData.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReadData.setBounds(401, 370, 145, 30);
		frmAntarcticWildlifeResearch.getContentPane().add(btnReadData);
		
		JLabel lblLatitude = new JLabel("Latitude");
		lblLatitude.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLatitude.setBounds(264, 52, 83, 30);
		frmAntarcticWildlifeResearch.getContentPane().add(lblLatitude);
		
		txtLat = new JTextField();
		txtLat.setText("0.0");
		txtLat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLat.setColumns(10);
		txtLat.setBounds(357, 52, 155, 30);
		frmAntarcticWildlifeResearch.getContentPane().add(txtLat);
		
		txtLong = new JTextField();
		txtLong.setText("0.0");
		txtLong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLong.setColumns(10);
		txtLong.setBounds(357, 93, 155, 30);
		frmAntarcticWildlifeResearch.getContentPane().add(txtLong);
		
		JLabel lblLongitude = new JLabel("Longitude");
		lblLongitude.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLongitude.setBounds(246, 93, 101, 30);
		frmAntarcticWildlifeResearch.getContentPane().add(lblLongitude);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(273, 171, 74, 30);
		frmAntarcticWildlifeResearch.getContentPane().add(lblGender);
		
		JComboBox CBGender = new JComboBox();
		CBGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int gselect = CBGender.getSelectedIndex();
				if (gselect == 0)
				{
					pen.setGender("Male");
					wal.setGender("Male");
					sea.setGender("Male");
				}
				if (gselect == 1)
				{
					pen.setGender("Female");
					wal.setGender("Female");
					sea.setGender("Female");
				}
			}
		});
		CBGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		CBGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CBGender.setBounds(357, 171, 155, 30);
		frmAntarcticWildlifeResearch.getContentPane().add(CBGender);
		
		chckbxLatValid = new JCheckBox("Valid");
		chckbxLatValid.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxLatValid.setBackground(new Color(102, 205, 170));
		chckbxLatValid.setBounds(518, 52, 63, 30);
		frmAntarcticWildlifeResearch.getContentPane().add(chckbxLatValid);
		
		chckbxLongValid = new JCheckBox("Valid");
		chckbxLongValid.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxLongValid.setBackground(new Color(102, 205, 170));
		chckbxLongValid.setBounds(518, 93, 63, 30);
		frmAntarcticWildlifeResearch.getContentPane().add(chckbxLongValid);
		
		chckbxWeightValid = new JCheckBox("Valid");
		chckbxWeightValid.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxWeightValid.setBackground(new Color(102, 205, 170));
		chckbxWeightValid.setBounds(518, 130, 63, 30);
		frmAntarcticWildlifeResearch.getContentPane().add(chckbxWeightValid);
		
		txtWeight = new JTextField();
		txtWeight.setText("0.0");
		txtWeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtWeight.setColumns(10);
		txtWeight.setBounds(357, 130, 155, 30);
		frmAntarcticWildlifeResearch.getContentPane().add(txtWeight);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWeight.setBounds(273, 130, 74, 30);
		frmAntarcticWildlifeResearch.getContentPane().add(lblWeight);
		
		scrollPane = new JScrollPane(txtrOutput);
		scrollPane.setBounds(606, 52, 268, 348);
		frmAntarcticWildlifeResearch.getContentPane().add(scrollPane);
		
		txtrOutput = new JTextArea();
		txtrOutput.setFont(new Font("Monospaced", Font.BOLD, 15));
		scrollPane.setViewportView(txtrOutput);
		txtrOutput.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtrOutput.setBackground(new Color(102, 205, 170));
	}
}