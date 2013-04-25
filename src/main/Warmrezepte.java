package main;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JScrollPane;



public class Warmrezepte extends JFrame {
	private static final long serialVersionUID = 6266890549153338997L;
	
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JList<String> Warme_rezepte;
	private JMenuItem btnHinzufgen;
	
	private Mainwindow own;
	private JMenuItem btnLsschen;
	
	ArrayList<String> warmarray = new ArrayList<>();
	private JPanel panel;
	private JTextField txtSuchen;
	private JScrollPane scrollPane;
	
	public Warmrezepte(Mainwindow win) {
		setTitle("Die Rezepte f\u00FCr warme Gerichte");
		own = win;
		
		initGUI();
		setLocationRelativeTo(null);	
		
		addWindowListener(new WindowListener() {						
			
			@Override
			public void windowOpened(WindowEvent e) {
				// nothing
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				own.setState(JFrame.NORMAL);
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// nothing
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// nothing
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				own.setState(JFrame.NORMAL);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// nothing
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// nothing
			}
		});
	}

	private void initGUI() {
		setResizable(false);
		setSize(new Dimension(732, 413));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnNewMenu = new JMenu("Rezept");
		menuBar.add(mnNewMenu);

		btnHinzufgen = new JMenuItem("Hinzuf\u00FCgen");
		btnHinzufgen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Warmhinzu Hinzu = new Warmhinzu(Warmrezepte.this);
				Hinzu.setVisible(true);
				
			}
		});
		mnNewMenu.add(btnHinzufgen);
		
		btnLsschen = new JMenuItem("L\u00F6sschen");
		btnLsschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectwert;
				selectwert = Warme_rezepte.getSelectedIndex();
				warmarray.remove(selectwert);
				((DefaultListModel<String>) Warme_rezepte.getModel()).removeElementAt(selectwert);
			}
		});
		
		btnLsschen.setMaximumSize(new Dimension(100, 26));
		mnNewMenu.add(btnLsschen);
		DefaultListModel<String> dlm = new DefaultListModel<>();
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		txtSuchen = new JTextField(10);
		txtSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListModel<String> model = Warme_rezepte.getModel();
				String suchtext = txtSuchen.getText().trim();
				if(suchtext == null || suchtext.equals("")){
					Warme_rezepte.setSelectedIndex(-1);
					return;
				}
				int size = model.getSize();
				Warme_rezepte.clearSelection();
				for(int i = 0; i < size; i++){
					String o = model.getElementAt(i);
					if(o.toLowerCase().contains(suchtext.toLowerCase())){
						Warme_rezepte.addSelectionInterval(i, i);
						//return;
					}
				}
				
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 2));
		txtSuchen.setText("Suchen...");
		txtSuchen.setToolTipText("");
		panel.add(txtSuchen);
		txtSuchen.setColumns(10);
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
				Warme_rezepte = new JList<>();
				scrollPane.setViewportView(Warme_rezepte);
				Warme_rezepte.setToolTipText("");
				Warme_rezepte.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount() == 2){
							File Datei = new File(warmarray.get(Warme_rezepte.getSelectedIndex()));
							try {
								Desktop.getDesktop().open(Datei);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
					});
				Warme_rezepte.setModel(dlm);

	}
	
	public void onAddRezept(String rezname, String path) {
		((DefaultListModel<String>)Warme_rezepte.getModel()).addElement(rezname);
		warmarray.add(path);
	}
}
