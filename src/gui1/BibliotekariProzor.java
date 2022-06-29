package gui1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
import guiFormeZaDodavanjeIIzmenu.AddBibliotekari;
import osobe.Admin;
import osobe.Bibliotekar;


public class BibliotekariProzor extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable BibliotekariTabela;
	 
	private Biblioteka biblioteka;
	
	public BibliotekariProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Bibliotekari");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
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
		
		ArrayList<Bibliotekar>neobrisaniBibliotekari=biblioteka.sviNeobrisaniBibliotekari();
		String[] zaglavlja = new String[] {"ID", "Korisnicko ime", "lozinka", "Pol"};
		Object[][] sadrzaj = new Object[neobrisaniBibliotekari.size()][zaglavlja.length];
		for(int i=0; i<neobrisaniBibliotekari.size(); i++) {
			
			Bibliotekar b = neobrisaniBibliotekari.get(i);		
			sadrzaj[i][0] = b.getId();
			sadrzaj[i][1] = b.getKorisnickoIme();
			sadrzaj[i][2] = b.getLozinka();
			sadrzaj[i][3] = b.getPol();

		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		BibliotekariTabela = new JTable(tableModel);
		
		BibliotekariTabela.setRowSelectionAllowed(true);
		BibliotekariTabela.setColumnSelectionAllowed(false);
		BibliotekariTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		BibliotekariTabela.setDefaultEditor(Object.class, null);
		BibliotekariTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(BibliotekariTabela);
		add(scrollPane, BorderLayout.CENTER);
	
	}
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = BibliotekariTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					int id =Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					String naziv = tableModel.getValueAt(red, 1).toString();
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete bibliotekara?", 
							naziv + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						Bibliotekar b =biblioteka.getBibliotekari().get(id);
						b.setObrisan(true);
						System.out.println(biblioteka.getBibliotekari().toString());
						try {
							biblioteka.sacuvajBibliotekare();
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
				AddBibliotekari addBibliotekari = new AddBibliotekari(biblioteka);
				addBibliotekari.setVisible(true);
				BibliotekariProzor.this.dispose();
				BibliotekariProzor.this.setVisible(false);
			}
		});
//		
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = BibliotekariTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = tableModel.getValueAt(red, 0).toString();
					Bibliotekar bibliotekar = biblioteka.pronadjiBibliotekara(id);
					AddBibliotekari editBibliotekar = new AddBibliotekari(biblioteka, bibliotekar);
					editBibliotekar.setVisible(true);
					BibliotekariProzor.this.dispose();
					BibliotekariProzor.this.setVisible(false);
				}
			}
		});
	}

}
