package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mainwindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton btnInfo;
	private JButton btnEinstellungen;
	
	public Mainwindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
		setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		setResizable(false);
		setSize(new Dimension(388, 265));
		setTitle("Willkommen");
		getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("Warme Gerichte");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Warmrezepte WaRe = new Warmrezepte(Mainwindow.this);				
				WaRe.setVisible(true);
				Mainwindow.this.setState(JFrame.ICONIFIED);
				}
		});
		btnNewButton.setBounds(34, 66, 127, 32);
		getContentPane().add(btnNewButton);
		
		JLabel lblBitteWhlenSie = new JLabel("Bitte w\u00E4hlen Sie ihre gew\u00FCnschte Kategorie aus.");
		lblBitteWhlenSie.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBitteWhlenSie.setBounds(12, 12, 361, 23);
		getContentPane().add(lblBitteWhlenSie);
		
		JButton btnSalate = new JButton("Salate");
		btnSalate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Salatewindow Salat = new Salatewindow(Mainwindow.this);
				Salat.setVisible(true);
				Mainwindow.this.setState(JFrame.ICONIFIED);
			}
		});
		btnSalate.setBounds(215, 66, 127, 32);
		getContentPane().add(btnSalate);
		
		JButton btnSoenDips = new JButton("So\u00DFen/ Dips");
		btnSoenDips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SoDiChoose SoDivote = new SoDiChoose(Mainwindow.this);
				SoDivote.setVisible(true);
			}
		});
		btnSoenDips.setBounds(34, 121, 127, 32);
		getContentPane().add(btnSoenDips);
		
		JButton btnDesserts = new JButton("Desserts");
		btnDesserts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dessertwindow dessert = new Dessertwindow(Mainwindow.this);
				dessert.setVisible(true);
				Mainwindow.this.setState(JFrame.ICONIFIED);
			}
		});
		btnDesserts.setBounds(215, 121, 128, 32);
		getContentPane().add(btnDesserts);
		
		JButton btnCocktails = new JButton("Cocktails");
		btnCocktails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CoChoose Covote = new CoChoose();
				Covote.setVisible(true);
			}
		});
		btnCocktails.setBounds(34, 176, 127, 32);
		getContentPane().add(btnCocktails);
		
		btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Info inf = new Info();
				inf.setVisible(true);
			}
		});
		btnInfo.setFont(new Font("Dialog", Font.BOLD, 8));
		btnInfo.setBounds(333, 217, 49, 19);
		getContentPane().add(btnInfo);
		
		btnEinstellungen = new JButton("Einstellungen");
		btnEinstellungen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEinstellungen.setBounds(215, 176, 127, 32);
		getContentPane().add(btnEinstellungen);
	}
}
