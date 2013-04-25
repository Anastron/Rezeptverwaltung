package main;

import javax.swing.JFrame;
import java.awt.Dimension;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Desserthinzu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JTextField Rezeptname;
	private JLabel lblDateipfad;
	private JTextField Dateipfad;
	private JButton btnBrowse;
	private JButton btnAbbrechen;
	private JButton btnHinzufgen;
	
	private Dessertwindow owner;

	public Desserthinzu(Dessertwindow owner) {
		this.owner = owner;
		initGUI();
		
		setLocationRelativeTo(null);
	}
	private void initGUI() {
		setTitle("Dessert Hinzuf\u00FCgen");
		setSize(new Dimension(370, 260));
		setResizable(false);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(10, 11, 55, 16);
		getContentPane().add(lblNewLabel);
		
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
		
		btnBrowse = new JButton("Browse...");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				browsedialog();
			}
		});
		btnBrowse.setBounds(256, 102, 98, 26);
		getContentPane().add(btnBrowse);
		
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closingdessert();
			}
		});
		btnAbbrechen.setBounds(148, 192, 98, 26);
		getContentPane().add(btnAbbrechen);
		
		btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDessert();
			}
		});
		btnHinzufgen.setBounds(256, 192, 98, 26);
		getContentPane().add(btnHinzufgen);
	}
	
	private void browsedialog(){
		JFileChooser chooser = new JFileChooser();
		
		if(chooser.showOpenDialog(Desserthinzu.this) == JFileChooser.APPROVE_OPTION){
			Dateipfad.setText(chooser.getSelectedFile().getAbsolutePath());		
		}
	}
	private void closingdessert(){
		setVisible(false);
	}
	private void addDessert(){
		owner.onAddRezept(Rezeptname.getText(), Dateipfad.getText());
		setVisible(false);
	}
}
