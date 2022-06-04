package gui.formeZaPrikaz;
import java.awt.BorderLayout;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import projekatObjektno.Biblioteka;
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
		
		for(int i=0; i<biblioteka.sviNeobrisaniPrimerciKnjige().size(); i++) {
			PrimerakKnjige primerak = biblioteka.sviNeobrisaniPrimerciKnjige().get(i);
//			Knjiga knjiga = biblioteka.pronadjiDisk(zanr);
			sadrzaj[i][0] = primerak.getId();
			sadrzaj[i][1] = primerak.getBrStrana();
			sadrzaj[i][2] = primerak.isTipPoveza();
			sadrzaj[i][3] = primerak.getGodinaStampanja();
			sadrzaj[i][4] = primerak.isJeliIznajmljena();
			sadrzaj[i][5] = primerak.getKnjiga().getId();
//			sadrzaj[i][2] = disk == null ? "--" : disk.getNaziv();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		JTable primerciKnjigaTabela = new JTable(tableModel);
		
		primerciKnjigaTabela.setRowSelectionAllowed(true);
		primerciKnjigaTabela.setColumnSelectionAllowed(false);
		primerciKnjigaTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		primerciKnjigaTabela.setDefaultEditor(Object.class, null);
		primerciKnjigaTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(primerciKnjigaTabela);
		add(scrollPane, BorderLayout.CENTER);
		
	}

	private void initActions() {
		// TODO Auto-generated method stub
		
	}
}
