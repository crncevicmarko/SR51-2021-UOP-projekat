package gui.formeZaDodavanje;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.formeZaPrikaz.AdministratorProzor;
import net.miginfocom.swing.MigLayout;
import projekatObjektno.Administrator;
import projekatObjektno.Biblioteka;
import projekatObjektno.Bibliotekar;
import projekatObjektno.EmnumPol;
import projekatObjektno.Zaposleni;

public class DijalogDodajAdmine extends JDialog{
	 private Biblioteka biblioteka;
	 private Administrator administrator;
//	 int index;
	 
	 private JLabel lblID = new JLabel("ID");
	 private JTextField txtID = new JTextField(20);
	 private JLabel lblIme = new JLabel("Ime");
	 private JTextField txtIme = new JTextField(20);
	 private JLabel lblPrezime = new JLabel("Prezime");
	 private JTextField txtPrezime = new JTextField(20);
	 private JLabel lblJMBG = new JLabel("JMBG");
	 private JTextField txtJMBG = new JTextField(20);
	 private JLabel lblAdresa = new JLabel("Adresa");
	 private JTextField txtAdresa = new JTextField(20);
	 private EmnumPol[] pol = EmnumPol.values();
	 private JLabel lblEmnumPol = new JLabel("Pol");
	 private JComboBox cmbxEmnumPol = new JComboBox(pol);
	 private JLabel lblKorisnickoIme = new JLabel("Korisnicko Ime");
	 private JTextField txtKorisnickoIme = new JTextField(20);
	 private JLabel lblKorisnickaSifra = new JLabel("Korisnicka Sifra");
	 private JTextField txtKorisnickaSifra = new JTextField(20);
	 private JLabel lblPlata = new JLabel("Plata");
	 private JTextField txtPlata = new JTextField(20);
	 private JButton btnSave = new JButton("Save");
	 private JButton btnCancel = new JButton("Cancel");
	 
	 public DijalogDodajAdmine(Biblioteka biblioteka, Administrator administrator) {
		 this.biblioteka = biblioteka;
		 this.administrator = administrator;
		 setTitle("Dodavanje novog administratora");
		 setSize(500,500);
		 setResizable(false);
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 setLocationRelativeTo(null);
		 initGUI();
		 initActions();
	 }

	private void initGUI() {
		MigLayout mig = new MigLayout("wrap 2","[][]","[]10[]10[]");
		setLayout(mig);
		
		add(lblID);
		add(txtID);
//		txtID.setEditable(false);
//		txtJMBG.setEditable(false);
		add(lblIme);
		add(txtIme);
		add(lblPrezime);
		add(txtPrezime);
		add(lblJMBG);
		add(txtJMBG);
		add(lblAdresa);
		add(txtAdresa);
		add(lblEmnumPol);
		add(cmbxEmnumPol);
		add(lblKorisnickoIme);
		add(txtKorisnickoIme);
		add(lblKorisnickaSifra);
		add(txtKorisnickaSifra);
		add(lblPlata);
		add(txtPlata);
		add(btnSave);
		add(btnCancel);
	}

	private void initActions() {
		 
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DijalogDodajAdmine.this.dispose();
				DijalogDodajAdmine.this.setVisible(false);
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txtID.getText().trim();
				String ime = txtIme.getText().trim();
				String prezime = txtPrezime.getText().trim();
				String JMBG = txtJMBG.getText().trim();
				String adresa = txtAdresa.getText().trim();
				String polString=cmbxEmnumPol.getSelectedItem().toString();
				EmnumPol pol= EmnumPol.valueOf(polString);
				String sifra = txtKorisnickaSifra.getText().trim();
				String koriskickoIme = txtKorisnickoIme.getText().trim();
				String plata = txtPlata.getText().trim();
				
				if(id.equals("")||ime.equals("")||prezime.equals("")||JMBG.equals("")||adresa.equals("")||sifra.equals("")||koriskickoIme.equals("")||plata.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke za dodavanje.", "Greska", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(administrator == null) {
						if(biblioteka.pronadjiAminaPoKorisnickomImenu(koriskickoIme)!= null) {
							JOptionPane.showMessageDialog(null, "Korisnicko ime vec postoji!", "Greska",JOptionPane.WARNING_MESSAGE);	
						}
						Administrator noviadmin= new Administrator(id,ime,prezime,JMBG,adresa,pol,sifra,koriskickoIme,plata,false);
						biblioteka.getAdmin().add(noviadmin);
					}
					else {
						administrator.setId(id);
						administrator.setIme(ime);
						administrator.setPrezime(prezime);
						administrator.setJMBG(JMBG);
						administrator.setAdresa(adresa);
						administrator.setPol(pol);
						administrator.setKorisnickaSifra(sifra);
						administrator.setKorisnickoIme(koriskickoIme);
						administrator.setPlata(plata);
					}
					try {
						biblioteka.sacuvajAdministatore();
						DijalogDodajAdmine.this.setVisible(false);
					}catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
	}
}
