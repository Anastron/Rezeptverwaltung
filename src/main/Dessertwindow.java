package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Dessertwindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnRezept;
	private JMenuItem mntmHinzufgen;
	private JMenuItem mntmLschen;
	private JPanel panel;
	private JTextField txtSuchen;
	private JScrollPane scrollPane;
	private JList<String> dessert_list;
	
	private Mainwindow own;	
	
	ArrayList<String> desserts = new ArrayList<>();

	public Dessertwindow(Mainwindow win) {
		own = win;
		
		initGUI();
		
		setLocationRelativeTo(null);
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				own.setState(NORMAL);
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				own.setState(NORMAL);
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnRezept = new JMenu("Rezept");
		menuBar.add(mnRezept);
		
		mntmHinzufgen = new JMenuItem("Hinzuf\u00FCgen");
		mntmHinzufgen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDessert();
			}
		});
		
		DefaultListModel<String> dlm = new DefaultListModel<>();
		
		mnRezept.add(mntmHinzufgen);
		
		mntmLschen = new JMenuItem("L\u00F6schen");
		mntmLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delrezept();
			}
		});
		mnRezept.add(mntmLschen);
		
		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		flowLayout.setVgap(2);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		txtSuchen = new JTextField();
		txtSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchdessert();
			}
		});
		txtSuchen.setText("Suchen...");
		panel.add(txtSuchen);
		txtSuchen.setColumns(10);
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		dessert_list = new JList<String>();
		scrollPane.setViewportView(dessert_list);
		dessert_list.setModel(dlm);
	}
	private void initGUI() {
		setSize(new Dimension(732, 413));
		setResizable(false);
	}
	
	private void addDessert(){
		Desserthinzu dessert = new Desserthinzu(Dessertwindow.this);
		dessert.setVisible(true);
	}
	private void delrezept(){
		int selectwert;
		selectwert = dessert_list.getSelectedIndex();
		desserts.remove(selectwert);
		((DefaultListModel<String>) dessert_list.getModel()).removeElementAt(selectwert);
	}
	private void searchdessert(){
		ListModel<String> model = dessert_list.getModel();
		String suchtext = txtSuchen.getText().trim();
		if(suchtext == null || suchtext.equals("")){
			dessert_list.setSelectedIndex(-1);
			return;
		}
		int size = model.getSize();
		dessert_list.clearSelection();
		for(int i = 0; i < size; i++){
			String o = model.getElementAt(i);
			if(o.toLowerCase().contains(suchtext.toLowerCase())){
				dessert_list.addSelectionInterval(i, i);
			}
		}
	}
	
	public void onAddRezept(String rezname, String path) {
		((DefaultListModel<String>)(dessert_list.getModel())).addElement(rezname);
		desserts.add(path);
	}
}
