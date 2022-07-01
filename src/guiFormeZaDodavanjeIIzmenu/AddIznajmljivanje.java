package guiFormeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import biblioteka.Iznajmljivanje;
import biblioteka.Primerak;
import net.miginfocom.swing.MigLayout;
import osobe.Clan;
import osobe.Zaposleni;

public class AddIznajmljivanje  extends JFrame{

	private JLabel lblDatumIznajmljivanja=new JLabel("Datum iznajmljivanja: ");
	private JTextField txtDatumIznajmljivanja=new JTextField(20);
	private JLabel lblDatumVracanja=new JLabel("Datum vracanja: ");
	private JTextField txtDatumVracanja=new JTextField(20);
	private JLabel lblIzdao=new JLabel("Izdao: ");
	private JTextField txtIzdao=new JTextField();
	private JLabel lblIznajmio=new JLabel("Iznajmio: ");
	private JComboBox cbIznajmio=new JComboBox();
	private JLabel lblPrimerak=new JLabel("Primerak: ");
	private JComboBox cbPrimerak=new JComboBox(); /*mora da se zakomentarise za zadn9*/
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	private Biblioteka biblioteka;
	private Iznajmljivanje iznajmljivanje;
	private Zaposleni prijavljeni;
	
//	DefaultListModel model = new DefaultListModel();  /*zadatak 9*/
//	private JList listPrimerak = new JList(model);
//	ArrayList<Primerak> primerakA = new ArrayList<Primerak>();
	
	
	public AddIznajmljivanje(Biblioteka biblioteka,Zaposleni prijavljeni) {
		this.biblioteka=biblioteka;
		this.prijavljeni=prijavljeni;
		setSize(500,1000);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		pack();
	}
	public AddIznajmljivanje(Biblioteka biblioteka,Zaposleni prijavljeni, Iznajmljivanje iznajmljivanje) {
		this.biblioteka=biblioteka;	
		this.prijavljeni=prijavljeni;
		this.iznajmljivanje=iznajmljivanje;
		setTitle("Dodavanje");
		setSize(500,1000);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		pack();
	}
	public void initGUI() {
		ArrayList<Clan> clanovi=biblioteka.sviNeobrisaniClanovi();
		for(Clan clan:clanovi) {
			cbIznajmio.addItem(clan.getBrojClanskeKarte());
		}
		ArrayList<Primerak> primerci=biblioteka.sviNeobrisaniPrimerci();
		for(Primerak primerak:primerci) {
			cbPrimerak.addItem(primerak.getId());
		}
		txtIzdao.setText(prijavljeni.getKorisnickoIme());
		
		
//		ArrayList<Primerak> primerci=biblioteka.sviNeobrisaniPrimerci(); /*zadatak 9*/
//		for(Primerak primerak:primerci) {
//			model.addElement(primerak.getId());
//		}
//		txtIzdao.setText(prijavljeni.getKorisnickoIme());
	
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		
		
		add(lblPrimerak);
		add(cbPrimerak); /*mora da se zakomentarise za zadn9*/
//		add(listPrimerak); /*zadatak 9*/
		add(lblIzdao);
		add(txtIzdao);
		add(lblIznajmio);
		add(cbIznajmio);
		add(lblDatumIznajmljivanja);
		add(txtDatumIznajmljivanja);
		add(lblDatumVracanja);
		add(txtDatumVracanja);
		add(btnOk);
		add(btnCancel);
		
		txtIzdao.setText(prijavljeni.getKorisnickoIme());
		if(iznajmljivanje!=null) {
			cbPrimerak.setSelectedItem(iznajmljivanje.getPrimerak().getId()); /*mora da se zakomentarise za zadn9*/
			cbIznajmio.setSelectedItem(iznajmljivanje.getClan().getBrojClanskeKarte());
			String datumIznajmljivanja =iznajmljivanje.getDatumIznajmljivanja().toString();
			txtDatumIznajmljivanja.setText(datumIznajmljivanja);
			String datumVracanja =iznajmljivanje.getDatumVracanja().toString();
			txtDatumVracanja.setText(datumVracanja);
			txtIzdao.setText(iznajmljivanje.getZaposleni().getKorisnickoIme());
		}
		txtIzdao.setEnabled(false);
	}
	public void initActions() {
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddIznajmljivanje.this.dispose();
				AddIznajmljivanje.this.setVisible(false);
			}
		});
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				int[] indeks = listPrimerak.getSelectedIndices();   *zadatak 9*/
//				for (int i:indeks) {
//					primerakA.add(biblioteka.sviNeobrisaniPrimerci().get(i));
//				}
//				System.out.println(primerakA);
//				Primerak primerak = primerakA.get(0);
				
				int primerakId=cbPrimerak.getSelectedIndex(); /*mora da se zakomentarise za zadn9*/
				Primerak primerak=biblioteka.sviNeobrisaniPrimerci().get(primerakId); /*mora da se zakomentarise za zadn9*/
//				ArrayList<Primerak>primerci=new ArrayList<Primerak>();
//				int [] odabraniPrimerci=
				int iznajmioId=cbIznajmio.getSelectedIndex();
				Clan clan=biblioteka.sviNeobrisaniClanovi().get(iznajmioId);
				DateTimeFormatter dateFormatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String datumIznajmljivanjaString=txtDatumIznajmljivanja.getText().trim();
				LocalDate datumIznajmljivanja=LocalDate.parse(datumIznajmljivanjaString);
				String datumVracanjaString=txtDatumVracanja.getText().trim();
				LocalDate datumVracanja=LocalDate.parse(datumVracanjaString);

				if(datumIznajmljivanja.equals("") || datumVracanja.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke za dodavanje.", "Greska", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(iznajmljivanje==null) {
						String id= Integer.toString(biblioteka.getIznajmljivanja().size());	
						Iznajmljivanje novoIznajmljivanje=new Iznajmljivanje(id,primerak,clan,datumIznajmljivanja,datumVracanja,prijavljeni,false);
						biblioteka.getIznajmljivanja().add(novoIznajmljivanje);	
						}
					else {
						iznajmljivanje.setClan(clan);
						iznajmljivanje.setDatumIznajmljivanja(datumIznajmljivanja);
						iznajmljivanje.setDatumVracanja(datumVracanja);
						iznajmljivanje.setPrimerak(primerak);
					}
					try {
						biblioteka.sacuvajIznajmljivanje();
						AddIznajmljivanje.this.setVisible(false);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}}
	
