package main;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoChoose extends JFrame {
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
