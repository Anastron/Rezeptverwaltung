package main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Info extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblVAlpha;
	private JLabel lblVersion;
	private JLabel lblEntwickler;
	private JLabel lblBenzin;
	private JLabel lblDatum;
	private JLabel label;
	public Info() {
		initGUI();
		setLocationRelativeTo(null);
	}
	private void initGUI() {
		getContentPane().setSize(new Dimension(1, 1));
		setSize(new Dimension(205, 159));
		setResizable(false);
		setTitle("Info");
		setType(Type.UTILITY);
		getContentPane().setLayout(null);
		
		lblVAlpha = new JLabel("beta 0.4.0");
		lblVAlpha.setBounds(98, 12, 89, 16);
		getContentPane().add(lblVAlpha);
		
		lblVersion = new JLabel("Version:");
		lblVersion.setBounds(12, 12, 55, 16);
		getContentPane().add(lblVersion);
		
		lblEntwickler = new JLabel("Entwickler:");
		lblEntwickler.setBounds(12, 86, 68, 16);
		getContentPane().add(lblEntwickler);
		
		lblBenzin = new JLabel("Benzin");
		lblBenzin.setBounds(99, 86, 55, 16);
		getContentPane().add(lblBenzin);
		
		lblDatum = new JLabel("Datum:");
		lblDatum.setBounds(12, 47, 55, 16);
		getContentPane().add(lblDatum);
		
		label = new JLabel("24.04.2013");
		label.setBounds(99, 47, 68, 16);
		getContentPane().add(label);
	}
}
