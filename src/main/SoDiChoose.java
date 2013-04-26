package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SoDiChoose extends JFrame {
	private static final long serialVersionUID = 1L;
	private JCheckBox rdbtnS;
	private JCheckBox rdbtnSauer;
	private JCheckBox rdbtnSalat;
	private JLabel lblWelcheArtIst;
	private JLabel lblMehrereEingabenMglich;
	private JButton btnOk;
	private JButton btnAbbrechen;
	private JCheckBox chckbxNewCheckBox;
	
	private Mainwindow own;
	
	public SoDiChoose(Mainwindow win) {
		initGUI();
		setLocationRelativeTo(null);
		
		own = win;
	}
	private void initGUI() {
		setTitle("Auswahl");
		setResizable(false);
		setType(Type.UTILITY);
		setSize(new Dimension(234, 193));
		getContentPane().setLayout(null);
		
		
		
		rdbtnS = new JCheckBox("S\u00FC\u00DF");
		rdbtnS.setBounds(21, 62, 109, 23);
		getContentPane().add(rdbtnS);
		
		rdbtnSauer = new JCheckBox("Sauer");
		rdbtnSauer.setBounds(144, 62, 109, 23);
		getContentPane().add(rdbtnSauer);
		
		rdbtnSalat = new JCheckBox("Salat");
		rdbtnSalat.setBounds(21, 88, 109, 23);
		getContentPane().add(rdbtnSalat);
		
		lblWelcheArtIst = new JLabel("Welche Art ist gew\u00FCnscht?");
		lblWelcheArtIst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWelcheArtIst.setBounds(21, 11, 162, 17);
		getContentPane().add(lblWelcheArtIst);
		
		lblMehrereEingabenMglich = new JLabel("Mehrere Eingaben m\u00F6glich");
		lblMehrereEingabenMglich.setBounds(21, 28, 151, 16);
		getContentPane().add(lblMehrereEingabenMglich);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openDipp();
			}
		});
		btnOk.setBounds(117, 135, 99, 26);
		getContentPane().add(btnOk);
		
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SoDiChoose.this.setVisible(false);
			}
		});
		btnAbbrechen.setBounds(15, 135, 96, 26);
		getContentPane().add(btnAbbrechen);
		
		chckbxNewCheckBox = new JCheckBox("Barbecue");
		chckbxNewCheckBox.setBounds(143, 88, 97, 23);
		getContentPane().add(chckbxNewCheckBox);
	}
	private void openDipp(){
		Dippwindow dipp = new Dippwindow();
		dipp.setVisible(true);
		setVisible(false);
		own.setState(JFrame.ICONIFIED);
		
	}
}
