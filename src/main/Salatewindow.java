package main;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.FlowLayout;
import javax.swing.JScrollPane;

public class Salatewindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmHinzuf;
	private JMenuItem mntmLschen;
	private JList<String> Salat_list;
	
	private Mainwindow own;
	
	ArrayList<String> salatarray = new ArrayList<>();
	private JPanel panel;
	private JTextField txtSuchen;
	private JScrollPane scrollPane;
	
	public Salatewindow(Mainwindow win) {
		setTitle("Salatgerichte");
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
		
		
		
	}	private void initGUI() {
		setSize(new Dimension(732, 413));
		setResizable(false);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Rezept");
		menuBar.add(mnNewMenu);
		
		mntmHinzuf = new JMenuItem("Hinzuf\u00FCgen");
		mntmHinzuf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salathinzu SalathinzuVa = new Salathinzu(Salatewindow.this);
				SalathinzuVa.setVisible(true);
			}
		});
		mnNewMenu.add(mntmHinzuf);
		
		mntmLschen = new JMenuItem("L\u00F6schen");
		mntmLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectwert;
				selectwert = Salat_list.getSelectedIndex();
				salatarray.remove(selectwert);
				
				((DefaultListModel<String>) Salat_list.getModel()).removeElementAt(selectwert);
			}
		});
		mnNewMenu.add(mntmLschen);
		
		DefaultListModel<String> dlm = new DefaultListModel<>();
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		txtSuchen = new JTextField();
		txtSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onSearch(txtSuchen.getText().trim());
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 2));
		txtSuchen.setText("Suchen...");
		panel.add(txtSuchen);
		txtSuchen.setColumns(10);
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		Salat_list = new JList<>();
		scrollPane.setViewportView(Salat_list);
		Salat_list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if (e.getClickCount() == 2){
					File Datei = new File(salatarray.get(Salat_list.getSelectedIndex()));
					try {
						Desktop.getDesktop().open(Datei);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			
		});
		Salat_list.setModel(dlm);
	}

	
	public void onAddRezept(String rezname, String path) {
		((DefaultListModel<String>)(Salat_list.getModel())).addElement(rezname);
		salatarray.add(path);
	}
	private void onSearch(String searchname){
		ListModel<String> model = Salat_list.getModel();
		if(searchname == null || searchname.equals("")){
			Salat_list.setSelectedIndex(-1);
			return;
		}
		int size = model.getSize();
		Salat_list.clearSelection();
		for(int i = 0; i < size; i++){
			String o = model.getElementAt(i);
			if(o.toLowerCase().contains(searchname.toLowerCase())){
				Salat_list.addSelectionInterval(i, i);
			}
		}
	}
}

