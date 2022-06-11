package gui.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import gui.formeZaDodavanje.DijalogDodajTip;
import gui.formeZaDodavanje.DijalogDodajZanr;
import gui.formeZaIzmenu.DijalogIzmeniAdmina;
import gui.formeZaIzmenu.DijalogIzmeniTip;
import projekatObjektno.Administrator;
import projekatObjektno.Biblioteka;
import projekatObjektno.ClanBiblioteke;
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
	private TipClanarine tipClanarine;

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
			sadrzaj[i][2] = clan.getCena();
//			sadrzaj[i][2] = disk == null ? "--" : disk.getNaziv();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		tipclanarineTabela = new JTable(tableModel);
		
		tipclanarineTabela.setRowSelectionAllowed(true);
		tipclanarineTabela.setColumnSelectionAllowed(false);
		tipclanarineTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tipclanarineTabela.setDefaultEditor(Object.class, null);
		tipclanarineTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(tipclanarineTabela);
		add(scrollPane, BorderLayout.CENTER);
		
	}

	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = tipclanarineTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.","Greska",JOptionPane.WARNING_MESSAGE);
				}
				else {
					int id = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					String naziv = tableModel.getValueAt(red, 1).toString();
					
					int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete clana?",naziv + "- Potvrda brisanja",JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_NO_OPTION) {
						TipClanarine c = biblioteka.getTipClanarine().get(id);
						c.setJeObrisan(true);
						System.out.println(biblioteka.getTipClanarine().toString());
						try {
							biblioteka.sacuvajTipClanarine();
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
				DijalogDodajTip da = new DijalogDodajTip(biblioteka);
				da.setVisible(true);
				TipClanarineProzor.this.dispose();
				TipClanarineProzor.this.setVisible(false);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = tipclanarineTabela.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null, "Morate da izaberete red koji zelite da promenite","Greska",JOptionPane.WARNING_MESSAGE);
				}
				else {
					String id = tableModel.getValueAt(row, 0).toString();
					TipClanarine tip = biblioteka.pronadjiTip(id);
					System.out.println(tip);
					DijalogIzmeniTip edit = new DijalogIzmeniTip(biblioteka,tip);
					edit.setVisible(true);
				}
			}
		});
		
	}
}
