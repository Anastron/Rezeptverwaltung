package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Dippwindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnRezept;
	private JMenuItem mntmHinzufgen;
	private JMenuItem mntmLschen;
	private JPanel panel;
	private JTextField txtSuchen;
	private JScrollPane scrollPane;
	private JList<String> dipp_list;

	
	
	public Dippwindow() {
		initGUI();
		setLocationRelativeTo(null);
	}
	private void initGUI() {

		
		setResizable(false);
		setTitle("So\u00DFen und Dipps");
		setSize(new Dimension(732, 413));
		
	
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnRezept = new JMenu("Rezept");
		menuBar.add(mnRezept);
		
		mntmHinzufgen = new JMenuItem("Hinzuf\u00FCgen");
		mnRezept.add(mntmHinzufgen);
		
		mntmLschen = new JMenuItem("L\u00F6schen");
		mnRezept.add(mntmLschen);
		
		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(2);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		txtSuchen = new JTextField();
		txtSuchen.setText("Suchen...");
		panel.add(txtSuchen);
		txtSuchen.setColumns(10);
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		dipp_list = new JList<String>();
		scrollPane.setViewportView(dipp_list);
	}



}
