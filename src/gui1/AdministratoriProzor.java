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
import guiFormeZaDodavanjeIIzmenu.AddAdministrator;
import osobe.Admin;


public class AdministratoriProzor extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable AdminiTabela;
	 
	private Biblioteka biblioteka;
	
	public AdministratoriProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Administratori");
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
		
		ArrayList<Admin>neobrisaniAdministratori=biblioteka.sviNeobrisaniAdmini();
		String[] zaglavlja = new String[] {"ID", "Korisnicko ime", "lozinka", "Pol"};
		Object[][] sadrzaj = new Object[neobrisaniAdministratori.size()][zaglavlja.length];
		for(int i=0; i<neobrisaniAdministratori.size(); i++) {
			
			Admin admin = neobrisaniAdministratori.get(i);		
			sadrzaj[i][0] = admin.getId();
			sadrzaj[i][1] = admin.getKorisnickoIme();
			sadrzaj[i][2] = admin.getLozinka();
			sadrzaj[i][3] = admin.getPol();

		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		AdminiTabela = new JTable(tableModel);
		
		AdminiTabela.setRowSelectionAllowed(true);
		AdminiTabela.setColumnSelectionAllowed(false);
		AdminiTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AdminiTabela.setDefaultEditor(Object.class, null);
		AdminiTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(AdminiTabela);
		add(scrollPane, BorderLayout.CENTER);
	
	}
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = AdminiTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					int id =Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					String naziv = tableModel.getValueAt(red, 1).toString();
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete administratora?", 
							naziv + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						Admin a =biblioteka.getAdministratori().get(id);
						a.setObrisan(true);
						System.out.println(biblioteka.getAdministratori().toString());
						try {
							biblioteka.sacuvajAdmine();;
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
				AddAdministrator addAdministrator = new AddAdministrator(biblioteka);
				addAdministrator.setVisible(true);
				AdministratoriProzor.this.dispose();
				AdministratoriProzor.this.setVisible(false);
			}
		});
	
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = AdminiTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = tableModel.getValueAt(red, 0).toString();
					Admin admin = biblioteka.pronadjiAdmina(id);
					AddAdministrator editAdmin = new AddAdministrator(biblioteka, admin);
					editAdmin.setVisible(true);
					AdministratoriProzor.this.dispose();
					AdministratoriProzor.this.setVisible(false);
				}
			}
		});
	}

}
