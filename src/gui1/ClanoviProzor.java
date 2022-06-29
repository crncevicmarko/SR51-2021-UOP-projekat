package gui1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import biblioteka.Biblioteka;
import biblioteka.Primerak;
import guiFormeZaDodavanjeIIzmenu.AddClanovi;
import osobe.Clan;

public class ClanoviProzor extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable clanoviTabela;
	 
	private Biblioteka biblioteka;
	
	public ClanoviProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Clanovi");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		try {
			biblioteka.proveriAktivnost();
		} catch (IOException e) {
			e.printStackTrace();
		}
		initGUI();
		initActions();
		
		}
	private void initGUI() {
		
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/pictures/add.gif"));
		btnAdd.setIcon(addIcon);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/pictures/edit.gif"));
		btnEdit.setIcon(editIcon);
		ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/pictures/remove.gif"));
		btnDelete.setIcon(deleteIcon);
		
		mainToolbar.add(btnAdd);
		mainToolbar.add(btnEdit);		 
		mainToolbar.add(btnDelete);		
		add(mainToolbar, BorderLayout.NORTH);
		
		ArrayList<Clan>neobrisaniClanovi=biblioteka.sviNeobrisaniClanovi();
		String[] zaglavlja = new String[] {"Broj clanske karte", "Ime", "Prezime", "Status"};
		Object[][] sadrzaj = new Object[neobrisaniClanovi.size()][zaglavlja.length];
		for(int i=0; i<neobrisaniClanovi.size(); i++) {
			
			Clan clan = neobrisaniClanovi.get(i);		
			sadrzaj[i][0] = clan.getBrojClanskeKarte();
			sadrzaj[i][1] = clan.getIme();
			sadrzaj[i][2] = clan.getPrezime();
			sadrzaj[i][3] = clan.getAktivnost();

		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		clanoviTabela = new JTable(tableModel);
		
		clanoviTabela.setRowSelectionAllowed(true);
		clanoviTabela.setColumnSelectionAllowed(false);
		clanoviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		clanoviTabela.setDefaultEditor(Object.class, null);
		clanoviTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(clanoviTabela);
		add(scrollPane, BorderLayout.CENTER);
	
	}
			
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = clanoviTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					int id =Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					String naziv = tableModel.getValueAt(red, 1).toString();
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete clana?", 
							naziv + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						Clan c =biblioteka.getClanovi().get(id);
						c.setObrisan(true);
						System.out.println(biblioteka.getClanovi().toString());
						try {
							biblioteka.sacuvajClanove();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						tableModel.removeRow(red);
						
						
					}
				}
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddClanovi addClanovi = new AddClanovi(biblioteka);
				addClanovi.setVisible(true);
				ClanoviProzor.this.dispose();
				ClanoviProzor.this.setVisible(false);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = clanoviTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = tableModel.getValueAt(red, 0).toString();
					Clan clan = biblioteka.pronadjiClana(id);
					AddClanovi editClanovi = new AddClanovi(biblioteka,clan );
					editClanovi.setVisible(true);
					ClanoviProzor.this.dispose();
					ClanoviProzor.this.setVisible(false);
				}
			}
		});
	}

}
