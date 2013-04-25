package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CoChoose extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblWelcherArtIst;
	private JCheckBox chckbxMitAlkohol;
	private JCheckBox chckbxOhneAlkohol;
	private JButton btnNewButton;
	private JButton btnAbbrechen;

	public CoChoose() {
		initGUI();
		setLocationRelativeTo(null);
	}

	private void initGUI() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Auwahl");
		setSize(new Dimension(230, 155));
		getContentPane().setLayout(null);

		lblWelcherArtIst = new JLabel("Welcher Art ist Gew\u00FCnscht?");
		lblWelcherArtIst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWelcherArtIst.setBounds(28, 13, 168, 17);
		getContentPane().add(lblWelcherArtIst);

		chckbxMitAlkohol = new JCheckBox("Mit Alkohol");
		chckbxMitAlkohol.setBounds(10, 41, 97, 23);
		getContentPane().add(chckbxMitAlkohol);

		chckbxOhneAlkohol = new JCheckBox("Ohne Alkohol");
		chckbxOhneAlkohol.setBounds(104, 40, 100, 24);
		getContentPane().add(chckbxOhneAlkohol);

		btnNewButton = new JButton("OK");
		btnNewButton.setBounds(123, 95, 89, 26);
		getContentPane().add(btnNewButton);

		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CoChoose.this.setVisible(false);
			}
		});
		btnAbbrechen.setBounds(10, 95, 96, 26);
		getContentPane().add(btnAbbrechen);
	}

}
