package gui.formeZaDodavanje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import projekatObjektno.Biblioteka;
import projekatObjektno.ClanBiblioteke;
import projekatObjektno.EmnumPol;
import projekatObjektno.IzdavanjeKnjige;
import projekatObjektno.PrimerakKnjige;
import projekatObjektno.TipClanarine;
import projekatObjektno.ZanrKnjige;
import projekatObjektno.Zaposleni;


public class DijalogDodajIzdavanje extends JDialog{
	private JLabel lblID = new JLabel("ID");
	private JTextField txtID = new JTextField(20);
	private JLabel lbldatumIznajmljivanja = new JLabel("DatumIznajmljivanja");
	private JTextField txtdatumIznajmljivanja = new JTextField(20);
	private JLabel lbldatumVracanja = new JLabel("DatumVracanja");
	private JTextField txtdatumVracanja = new JTextField(20);
	private JLabel lblZaposleni = new JLabel("Zaposleni");
	private JComboBox cmbxZaposleni = new JComboBox();
	private JLabel lblClan = new JLabel("Clan");
	private JComboBox cmbxClan = new JComboBox();
	private JLabel lblPrimerak = new JLabel("Primerak");
	private JComboBox cmbxPrimerak = new JComboBox();
	private JButton btnSave = new JButton("Save");
	private JButton btnCancel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	private IzdavanjeKnjige izdavanje;
	
	
	public DijalogDodajIzdavanje(Biblioteka biblioteka) {
		 this.biblioteka = biblioteka;
		 setTitle("Dodavanje novog bibliotekara");
		 setSize(400,500);
		 setResizable(false);
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 setLocationRelativeTo(null);
//		 cmbxEmnumPol.setModel(new DefaultComboBoxModel<EmnumPol>(EmnumPol.values()));
		 initGUI();
		 initActions();
		 pack();
	 }


	private void initActions() {
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DijalogDodajIzdavanje.this.dispose();
				DijalogDodajIzdavanje.this.setVisible(false);
			}
		});
		
		//String id,LocalDate datumIznajmljivanja, LocalDate datumVracanja, Zaposleni zaposleni,
		//ClanBiblioteke clan, /*ArrayList<PrimerakKnjige>*/ PrimerakKnjige primerak,boolean jeObrisan
		
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txtID.getText().trim();
				String datum = txtdatumIznajmljivanja.getText().trim();
				LocalDate datum2 = null;
				try {
					LocalDate datum1 = LocalDate.parse(datum);
					datum2 = datum1;
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1,"Greska",JOptionPane.WARNING_MESSAGE);
				}
				String datum11 = txtdatumVracanja.getText().trim();
				LocalDate datum22 = null;
				try {
					LocalDate datum12 = LocalDate.parse(datum);
					datum22 = datum12;
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1,"Greska",JOptionPane.WARNING_MESSAGE);
				}
				int zaposleniid = cmbxZaposleni.getSelectedIndex();
				Zaposleni zaposleni = biblioteka.sviNeobrisaniZaposleni().get(zaposleniid);
				
				int clanid = cmbxZaposleni.getSelectedIndex();
				ClanBiblioteke clan = biblioteka.sviNeobrisaniClanoviBiblioteke().get(clanid);
				
				int primerakid = cmbxZaposleni.getSelectedIndex();
				PrimerakKnjige primerak = biblioteka.sviNeobrisaniPrimerciKnjige().get(primerakid);
				
				if(id.equals("")||datum.equals("")||datum11.equals("")) {
					JOptionPane.showMessageDialog(null, "Moraju sva polja da budu popunjena","Greska",JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(izdavanje == null) {
						IzdavanjeKnjige Nizdavanje = new IzdavanjeKnjige(id,datum2,datum22,zaposleni,clan,primerak,false);
						biblioteka.getIzdavanjeKnjige().add(Nizdavanje);
					}
					else {
						izdavanje.setId(id);
						izdavanje.setDatumIznajmljivanja(datum2);
						izdavanje.setDatumVracanja(datum22);
						izdavanje.setZaposleni(zaposleni);
						izdavanje.setClan(clan);
						izdavanje.setPrimerak(primerak);
					}
					try {
						biblioteka.sacuvajIzdavanje();
						DijalogDodajIzdavanje.this.setVisible(false);
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
				}	
			}
		});
		
	}


	private void initGUI() {
//		ArrayList<Zaposleni> zaposleni=biblioteka.getZaoposleni();
//		for(Zaposleni zap : zaposleni) {
//			cmbxZaposleni.addItem(zap.getId());
//		}
		ArrayList<ClanBiblioteke> clan=biblioteka.getClanbiblioteke();
		for(ClanBiblioteke c : clan) {
			cmbxClan.addItem(c.getIme());
		}
		ArrayList<PrimerakKnjige> primerak=biblioteka.getPrimerak();
		for(PrimerakKnjige pri : primerak) {
			cmbxPrimerak.addItem(pri.getId());
		}
		MigLayout mig = new MigLayout("wrap 2","[][]","[]10[]10[]");
		setLayout(mig);
		
		add(lblID);
		add(txtID);
		add(lbldatumIznajmljivanja);
		add(txtdatumIznajmljivanja);
		add(lbldatumVracanja);
		add(txtdatumVracanja);
		add(lblZaposleni);
		add(cmbxZaposleni);
		add(lblClan);
		add(cmbxClan);
		add(lblPrimerak);
		add(cmbxPrimerak);
		add(btnSave);
		add(btnCancel);
		
		
	}
	
}
