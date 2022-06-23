package gui.formeZaPrikaz;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import gui.formeZaDodavanje.DijalogDodajAdmine;
import gui.formeZaDodavanje.DijalogDodajPrimerakKnjige;
import gui.formeZaIzmenu.DijalogIzmeniAdmina;
import gui.formeZaIzmenu.DijalogIzmeniPrimerak;
import projekatObjektno.Administrator;
import projekatObjektno.Biblioteka;
import projekatObjektno.ClanBiblioteke;
import projekatObjektno.PrimerakKnjige;
import projekatObjektno.Zaposleni;


public class PrimerakKnjigeProzor extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	private Zaposleni zaposleni;
	
	private DefaultTableModel tableModel;
	private JTable primerciKnjigaTabela;
	
	private Biblioteka biblioteka;
	private PrimerakKnjige primerak;

	public PrimerakKnjigeProzor (Biblioteka biblioteka, Zaposleni zaposleni) {
		this.biblioteka = biblioteka;
		this.zaposleni = zaposleni;
		setTitle("Kompozicije");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
	}

	private void initGUI() {
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
		btnAdd.setIcon(addIcon);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
		btnEdit.setIcon(editIcon);
		ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/slike/remove.gif"));
		btnDelete.setIcon(deleteIcon);
		
		mainToolbar.add(btnAdd);
		mainToolbar.add(btnEdit);
		mainToolbar.add(btnDelete);
		add(mainToolbar, BorderLayout.NORTH);
		
		String[] zaglavlja = new String[] {"Id", "Br.Strana", "TipPoveza", "GodinaStampanja", "Iznajmljena","Knjiga"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniPrimerciKnjige().size()][zaglavlja.length];
//		System.out.println(biblioteka.sviNeobrisaniPrimerciKnjige());
		for(int i=0; i<biblioteka.sviNeobrisaniPrimerciKnjige().size(); i++) {
			PrimerakKnjige primerak = biblioteka.sviNeobrisaniPrimerciKnjige().get(i);
			sadrzaj[i][0] = primerak.getId();
			sadrzaj[i][1] = primerak.getBrStrana();
			sadrzaj[i][2] = primerak.isTipPoveza();
			sadrzaj[i][3] = primerak.getGodinaStampanja();
			sadrzaj[i][4] = primerak.isJeliIznajmljena();
			sadrzaj[i][5] = primerak.getKnjiga().getId();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		primerciKnjigaTabela = new JTable(tableModel);
		
		primerciKnjigaTabela.setRowSelectionAllowed(true);
		primerciKnjigaTabela.setColumnSelectionAllowed(false);
		primerciKnjigaTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		primerciKnjigaTabela.setDefaultEditor(Object.class, null);
		primerciKnjigaTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(primerciKnjigaTabela);
		add(scrollPane, BorderLayout.CENTER);
		
	}

	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = primerciKnjigaTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.","Greska",JOptionPane.WARNING_MESSAGE);
				}
				else {
					int id = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					String naziv = tableModel.getValueAt(red, 1).toString();
					
					int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete clana?",naziv + "- Potvrda brisanja",JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_NO_OPTION) {
						PrimerakKnjige c = biblioteka.getPrimerak().get(id);
						c.setJeObrisan(true);
						System.out.println(biblioteka.getPrimerak().toString());
						try {
							biblioteka.sacuvajPrimerke();
						}
						catch(IOException e1) {
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
				DijalogDodajPrimerakKnjige da = new DijalogDodajPrimerakKnjige(biblioteka);
				da.setVisible(true);
				PrimerakKnjigeProzor.this.dispose();
				PrimerakKnjigeProzor.this.setVisible(false);
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = primerciKnjigaTabela.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null, "Morate da izaberete red koji zelite da promenite","Greska",JOptionPane.WARNING_MESSAGE);
				}
				else {
					String id = tableModel.getValueAt(row, 0).toString();
					PrimerakKnjige primerak = biblioteka.pronadjiPrimerak(id);
					DijalogIzmeniPrimerak edit = new DijalogIzmeniPrimerak(biblioteka,primerak);
					edit.setVisible(true);
				}
			}
		});
	}
}
