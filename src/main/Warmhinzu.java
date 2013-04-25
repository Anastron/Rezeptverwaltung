package main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
//import Warmrezept.Warmrezepte;

public class Warmhinzu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblName;
	private JTextField Rezeptname;
	private JLabel lblDateipfad;
	private JTextField Dateipfad;
	private JButton browse;
	private JButton btnHinzufgen;
	private JButton btnAbbrechen;
	
	private Warmrezepte owner;
	
	public Warmhinzu(Warmrezepte owner) {
		this.owner = owner;
		
		initGUI();
		setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		setResizable(false);
		setTitle("Warme Gerichte hinzuf\u00FCgen");
		setSize(new Dimension(370, 260));
		getContentPane().setLayout(null);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(10, 11, 55, 16);
		getContentPane().add(lblName);
		
		Rezeptname = new JTextField();
		Rezeptname.setBounds(10, 38, 185, 20);
		getContentPane().add(Rezeptname);
		Rezeptname.setColumns(10);
		
		lblDateipfad = new JLabel("Dateipfad:");
		lblDateipfad.setBounds(8, 78, 57, 16);
		getContentPane().add(lblDateipfad);
		
		Dateipfad = new JTextField();
		Dateipfad.setBounds(10, 105, 236, 20);
		getContentPane().add(Dateipfad);
		Dateipfad.setColumns(10);
		
		browse = new JButton("Browse...");
		browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   
				JFileChooser chooser = new JFileChooser();
				
				if(chooser.showOpenDialog(Warmhinzu.this) == JFileChooser.APPROVE_OPTION){
					Dateipfad.setText(chooser.getSelectedFile().getAbsolutePath());				
				}
			}
		});
		browse.setBounds(256, 102, 98, 26);
		getContentPane().add(browse);
		
		btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				owner.onAddRezept(Rezeptname.getText(), Dateipfad.getText());
				setVisible(false);
				
				 
			}
		});
		btnHinzufgen.setBounds(256, 192, 98, 26);
		getContentPane().add(btnHinzufgen);
		
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Warmhinzu.this.setVisible(false);
			}
		});
		btnAbbrechen.setBounds(148, 192, 98, 26);
		getContentPane().add(btnAbbrechen);
	}
}
