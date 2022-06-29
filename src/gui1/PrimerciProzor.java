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

import biblioteka.Knjiga;
import biblioteka.Primerak;
import guiFormeZaDodavanjeIIzmenu.AddPrimerak;
import biblioteka.Biblioteka;
import main.Main;

public class PrimerciProzor extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable primerciTabela;
	 
	private Biblioteka biblioteka;
	
	public PrimerciProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Primerci");
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
		
		ArrayList<Primerak>neobrisaniPrimerci=biblioteka.sviNeobrisaniPrimerci();
		String[] zaglavlja = new String[] {"Id", "Naziv", "Jezik"};
		Object[][] sadrzaj = new Object[neobrisaniPrimerci.size()][zaglavlja.length];
		for(int i=0; i<neobrisaniPrimerci.size(); i++) {
			
			Primerak primerak = neobrisaniPrimerci.get(i);		
			sadrzaj[i][0] = primerak.getId();
			sadrzaj[i][1] = primerak.getKnjiga().getNaslov();
			sadrzaj[i][2] = primerak.getJezikk();
			
		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		primerciTabela = new JTable(tableModel);
		
		primerciTabela.setRowSelectionAllowed(true);
		primerciTabela.setColumnSelectionAllowed(false);
		primerciTabela.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		primerciTabela.setDefaultEditor(Object.class, null);
		primerciTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(primerciTabela);
		add(scrollPane, BorderLayout.CENTER);
	
	}
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = primerciTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					int id =Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					String naziv = tableModel.getValueAt(red, 1).toString();
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete primerak?", 
							naziv + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						Primerak p =biblioteka.getPrimerci().get(id);
						p.setObrisan(true);
						System.out.println(biblioteka.getPrimerci().toString());
						try {
							biblioteka.sacuvajPrimerke();
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
				AddPrimerak addPrimerak = new AddPrimerak(biblioteka);
				addPrimerak.setVisible(true);
				PrimerciProzor.this.dispose();
				PrimerciProzor.this.setVisible(false);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = primerciTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = tableModel.getValueAt(red, 0).toString();
					Primerak primerak = biblioteka.pronadjiPrimerak(id);
					AddPrimerak editPrimerka = new AddPrimerak(biblioteka, primerak);
					editPrimerka.setVisible(true);
					PrimerciProzor.this.dispose();
					PrimerciProzor.this.setVisible(false);
				}
			}
		});
	}

}
