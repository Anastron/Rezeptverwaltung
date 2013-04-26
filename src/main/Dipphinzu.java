package main;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Dipphinzu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblName;
	private JTextField textField;
	private JLabel lblDateipfad;
	private JTextField textField_1;
	private JButton btnBrowse;
	private JButton btnHinzufgen;
	private JButton btnAbbrechen;
	private JCheckBox chckbxS;
	private JCheckBox chckbxSauer;
	private JCheckBox chckbxSalat;
	private JCheckBox chckbxBarbecue;
	
	public Dipphinzu() {
		setTitle("So\u00DFe & Dipp Hinzuf\u00FCgen");
		initGUI();
		setLocationRelativeTo(null);
	}
	private void initGUI() {	
		setSize(new Dimension(370, 260));
		setResizable(false);
		getContentPane().setLayout(null);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(10, 11, 55, 16);
		getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(10, 38, 185, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblDateipfad = new JLabel("Dateipfad:");
		lblDateipfad.setBounds(8, 78, 57, 16);
		getContentPane().add(lblDateipfad);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 105, 236, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnBrowse = new JButton("Browse...");
		btnBrowse.setBounds(256, 102, 98, 26);
		getContentPane().add(btnBrowse);
		
		btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.setBounds(256, 192, 98, 26);
		getContentPane().add(btnHinzufgen);
		
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(148, 192, 98, 26);
		getContentPane().add(btnAbbrechen);
		
		chckbxS = new JCheckBox("S\u00FC\u00DF");
		chckbxS.setBounds(10, 148, 55, 24);
		getContentPane().add(chckbxS);
		
		chckbxSauer = new JCheckBox("Sauer");
		chckbxSauer.setBounds(89, 148, 65, 24);
		getContentPane().add(chckbxSauer);
		
		chckbxSalat = new JCheckBox("Salat");
		chckbxSalat.setBounds(174, 148, 65, 24);
		getContentPane().add(chckbxSalat);
		
		chckbxBarbecue = new JCheckBox("Barbecue");
		chckbxBarbecue.setBounds(263, 148, 80, 24);
		getContentPane().add(chckbxBarbecue);
	}

}
