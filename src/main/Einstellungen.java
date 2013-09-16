package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class Einstellungen extends JFrame {
	public Einstellungen() {
		setSize(new Dimension(445, 248));
		setResizable(false);
		initGUI();
		setLocationRelativeTo(null);
	}
	private void initGUI() {
		setTitle("Einstellungen");
		getContentPane().setLayout(null);
		
		lblSpeicherortDerDatenbanken = new JLabel("Speicherort der Datenbanken");
		lblSpeicherortDerDatenbanken.setBounds(12, 23, 177, 27);
		getContentPane().add(lblSpeicherortDerDatenbanken);
		
		textDatenbankpfad = new JTextField();
		textDatenbankpfad.setBounds(12, 56, 417, 20);
		getContentPane().add(textDatenbankpfad);
		textDatenbankpfad.setColumns(10);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				settingsOK();
			}
		});
		btnOk.setBounds(331, 181, 98, 26);
		getContentPane().add(btnOk);
		
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAbbrechen.setBounds(208, 181, 98, 26);
		getContentPane().add(btnAbbrechen);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblSpeicherortDerDatenbanken;
	private JTextField textDatenbankpfad;
	private JButton btnOk;
	private JButton btnAbbrechen;
	private String datenbankpfad;
	
	private void settingsOK()
	{
		datenbankpfad = textDatenbankpfad.getText();
		setVisible(false);
	}
	public String getDatenbankpfad()
	{
		return datenbankpfad;
	}
	
}
