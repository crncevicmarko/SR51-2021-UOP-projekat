package gui.formeZaPrikaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import projekatObjektno.Biblioteka;
//import projekatObjektno.ClanBiblioteke;
import projekatObjektno.TipClanarine;
import projekatObjektno.Zaposleni;

public class TipClanarineProzor extends JFrame{
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	private Zaposleni zaposleni;
	private DefaultTableModel tableModel;
	private JTable tipclanarineTabela;
	
	private Biblioteka biblioteka;

	public TipClanarineProzor (Biblioteka biblioteka,Zaposleni zaposleni) {
		this.biblioteka = biblioteka;
		this.zaposleni = zaposleni;
		setTitle("TipoviClanarine");
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

//		String id, String naziv, double cena,boolean jeObrisan
		String[] zaglavlja = new String[] {"Id", "Naziv", "Cena"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniTipovi().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniTipovi().size(); i++) {
			TipClanarine clan = biblioteka.sviNeobrisaniTipovi().get(i);
//			Knjiga knjiga = biblioteka.pronadjiDisk(clan);
			sadrzaj[i][0] = clan.getId();
			sadrzaj[i][1] = clan.getNaziv();
			sadrzaj[i][2] = clan.getNaziv();
//			sadrzaj[i][2] = disk == null ? "--" : disk.getNaziv();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		JTable tipclanarineTabela = new JTable(tableModel);
		
		tipclanarineTabela.setRowSelectionAllowed(true);
		tipclanarineTabela.setColumnSelectionAllowed(false);
		tipclanarineTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tipclanarineTabela.setDefaultEditor(Object.class, null);
		tipclanarineTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(tipclanarineTabela);
		add(scrollPane, BorderLayout.CENTER);
		
	}

	private void initActions() {
		// TODO Auto-generated method stub
		
	}
}
