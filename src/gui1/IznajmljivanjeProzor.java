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
import biblioteka.Iznajmljivanje;
import guiFormeZaDodavanjeIIzmenu.AddIznajmljivanje;
import osobe.Clan;
import osobe.Zaposleni;

public class IznajmljivanjeProzor extends JFrame{
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable iznajmljivanjeTabela;
	 
	private Biblioteka biblioteka;
	private Zaposleni prijavljeni;

	public IznajmljivanjeProzor(Biblioteka biblioteka,Zaposleni prijavljeni) {
		this.biblioteka = biblioteka;
		this.prijavljeni=prijavljeni;
		setTitle("Iznajmljivanje");
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
		
		ArrayList<Iznajmljivanje>neobrisanaIznajmljivanja=biblioteka.svaNeobrisanaIznajmljivanja();
		String[] zaglavlja = new String[] {"Id","Primerak", "Clan", "Iznajmljena od", "Iznajmljena do"};
		Object[][] sadrzaj = new Object[neobrisanaIznajmljivanja.size()][zaglavlja.length];
		for(int i=0; i<neobrisanaIznajmljivanja.size(); i++) {
			
			Iznajmljivanje iznajmljivanje = neobrisanaIznajmljivanja.get(i);
			sadrzaj[i][0] = iznajmljivanje.getId();
			sadrzaj[i][1] = iznajmljivanje.getPrimerak().getKnjiga().getNaslov();
			sadrzaj[i][2] = iznajmljivanje.getClan().getIme();
			sadrzaj[i][3] = iznajmljivanje.getDatumIznajmljivanja();
			sadrzaj[i][4] = iznajmljivanje.getDatumVracanja();

		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		iznajmljivanjeTabela = new JTable(tableModel);
		
		iznajmljivanjeTabela.setRowSelectionAllowed(true);
		iznajmljivanjeTabela.setColumnSelectionAllowed(false);
		iznajmljivanjeTabela.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		iznajmljivanjeTabela.setDefaultEditor(Object.class, null);
		iznajmljivanjeTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(iznajmljivanjeTabela);
		add(scrollPane, BorderLayout.CENTER);
	
	}
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = iznajmljivanjeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					int id =Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					String naziv = tableModel.getValueAt(red, 1).toString();
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete clana?", 
							naziv + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						Iznajmljivanje i=biblioteka.getIznajmljivanja().get(id);
						i.setObrisan(true);
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
				AddIznajmljivanje addIznajmljivanje = new AddIznajmljivanje(biblioteka,prijavljeni);
				addIznajmljivanje.setVisible(true);
				IznajmljivanjeProzor.this.dispose();
				IznajmljivanjeProzor.this.setVisible(false);
				
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = iznajmljivanjeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = tableModel.getValueAt(red, 0).toString();
					Iznajmljivanje iznajmljivanje = biblioteka.pronadjiIznajmljivanje(id);
					AddIznajmljivanje editIznajmljivanje = new AddIznajmljivanje(biblioteka,prijavljeni, iznajmljivanje);
					editIznajmljivanje.setVisible(true);
					IznajmljivanjeProzor.this.dispose();
					IznajmljivanjeProzor.this.setVisible(false);
				}
			}
		});
	}
}
