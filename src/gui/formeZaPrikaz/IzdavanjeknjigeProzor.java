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

import gui.formeZaDodavanje.DijalogDodajClana;
import gui.formeZaDodavanje.DijalogDodajIzdavanje;
import gui.formeZaIzmenu.DijalogIzmeniClana;
import gui.formeZaIzmenu.DijalogIzmeniIznajmljivanje;
import projekatObjektno.Administrator;
import projekatObjektno.Biblioteka;
import projekatObjektno.ClanBiblioteke;
import projekatObjektno.IzdavanjeKnjige;
import projekatObjektno.PrimerakKnjige;
import projekatObjektno.Zaposleni;

public class IzdavanjeknjigeProzor extends JFrame{
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	private Zaposleni zaposleni;
	
	private DefaultTableModel tableModel;
	private JTable izdavanjeknjigaTabela;
	
	private Biblioteka biblioteka;
	private IzdavanjeKnjige izdavanje;

	public IzdavanjeknjigeProzor(Biblioteka biblioteka,Zaposleni zaposleni) {
		this.biblioteka = biblioteka;
		this.zaposleni = zaposleni;
		setTitle("Izdavanja:");
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

//		LocalDate datumIznajmljivanja, LocalDate datumVracanja, Zaposleni zaposleni,
//		ClanBiblioteke clan, ArrayList<PrimerakKnjige> primerak,boolean jeObrisan
		
		
		String[] zaglavlja = new String[] {"ID","DatumIznajmljivanja", "DatumVracanja", "Zaposleni", "Clanovi", "Primerci"};
		Object[][] sadrzaj = new Object[biblioteka.svaNeobrisanaIzdavanja().size()][zaglavlja.length];
//		System.out.println(biblioteka.svaNeobrisanaIzdavanja());
		for(int i=0; i<biblioteka.svaNeobrisanaIzdavanja().size(); i++) {
			IzdavanjeKnjige clan = biblioteka.svaNeobrisanaIzdavanja().get(i);
//			Knjiga knjiga = biblioteka.pronadjiDisk(clan);
			sadrzaj[i][0] = clan.getId();
			sadrzaj[i][1] = clan.getDatumIznajmljivanja();
			sadrzaj[i][2] = clan.getDatumVracanja();
			sadrzaj[i][3] = clan.getZaposleni().getKorisnickoIme();
			sadrzaj[i][4] = clan.getClan().getIme();
			sadrzaj[i][5] = clan.getPrimerak().getId();
			
//			sadrzaj[i][2] = disk == null ? "--" : disk.getNaziv();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		izdavanjeknjigaTabela = new JTable(tableModel);
		
		izdavanjeknjigaTabela.setRowSelectionAllowed(true);
		izdavanjeknjigaTabela.setColumnSelectionAllowed(false);
		izdavanjeknjigaTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		izdavanjeknjigaTabela.setDefaultEditor(Object.class, null);
		izdavanjeknjigaTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(izdavanjeknjigaTabela);
		add(scrollPane, BorderLayout.CENTER);

	}

	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = izdavanjeknjigaTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.","Greska",JOptionPane.WARNING_MESSAGE);
				}
				else {
					int id = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					String naziv = tableModel.getValueAt(red, 1).toString();
					
					int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete clana?",naziv + "- Potvrda brisanja",JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_NO_OPTION) {
						IzdavanjeKnjige c = biblioteka.getIzdavanjeKnjige().get(id);
						c.setJeObrisan(true);
						System.out.println(biblioteka.getIzdavanjeKnjige().toString());
						try {
							biblioteka.sacuvajIzdavanje();
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
				DijalogDodajIzdavanje da = new DijalogDodajIzdavanje(biblioteka);
				da.setVisible(true);
				IzdavanjeknjigeProzor.this.dispose();
				IzdavanjeknjigeProzor.this.setVisible(false);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = izdavanjeknjigaTabela.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null, "Morate da izberete red koji zelite da promenite","Greska",JOptionPane.WARNING_MESSAGE);
				}
				else {
				String id = tableModel.getValueAt(row, 0).toString();
				IzdavanjeKnjige izdavanje = biblioteka.pronadjiIzdavanje(id);
				DijalogIzmeniIznajmljivanje edit = new DijalogIzmeniIznajmljivanje(biblioteka, izdavanje);
				edit.setVisible(true);
				}
			}
		});
	}
}
