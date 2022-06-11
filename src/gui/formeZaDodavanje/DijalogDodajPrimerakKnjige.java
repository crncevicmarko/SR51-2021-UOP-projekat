package gui.formeZaDodavanje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import projekatObjektno.Biblioteka;
import projekatObjektno.EmnumPol;
import projekatObjektno.Knjiga;
import projekatObjektno.PrimerakKnjige;
import projekatObjektno.TipClanarine;
import projekatObjektno.ZanrKnjige;
import projekatObjektno.Zaposleni;

public class DijalogDodajPrimerakKnjige extends JDialog{
//	String id, int brStrana, boolean tipPoveza, int godinaStampanja, boolean jeliIznajmljena,
//	Knjiga knjiga,boolean jeObrisan
	 private Biblioteka biblioteka;
	 private PrimerakKnjige primerak;
	 
	 
	 private JLabel lblID = new JLabel("ID");
	 private JTextField txtID = new JTextField(20);
	 private JLabel lblBrStrana = new JLabel("Broj Strana");
	 private JTextField txtBrStrana = new JTextField(20);
	 private JLabel lblTipPoveza = new JLabel("Tvrd povez");
	 private JCheckBox txtTipPoveza = new JCheckBox();
	 private JLabel lblGodinaSt = new JLabel("Godina Stampanja");
	 private JTextField txtGodinaSt = new JTextField(20);
	 private JLabel lbljeliIznajmljena = new JLabel("jeliIznajmljena");
	 private JCheckBox txtjeliIznajmljena = new JCheckBox();
	 private JLabel lblKnjiga = new JLabel("Knjiga");
	 private JComboBox cmbxKnjiga = new JComboBox();
	 private JButton btnSave = new JButton("Save");
	 private JButton btnCancel = new JButton("Cancel");
	 
	 public DijalogDodajPrimerakKnjige(Biblioteka biblioteka, PrimerakKnjige primerak) {
		 this.biblioteka = biblioteka;
		 this.primerak = primerak;
		 setTitle("Dodavanje novog administratora");
		 setSize(500,500);
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 setLocationRelativeTo(null);
		 initGUI();
		 initActions();
		 pack();
	 }

	private void initActions() {
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DijalogDodajPrimerakKnjige.this.dispose();
				DijalogDodajPrimerakKnjige.this.setVisible(false);
			}
		});
		btnSave.addActionListener(new ActionListener() {
//			String id, int brStrana, boolean tipPoveza, int godinaStampanja, boolean jeliIznajmljena,
//			Knjiga knjiga,boolean jeObrisan
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txtID.getText().trim();
				String brStrana = txtBrStrana.getText().trim();
				int brStrana1 = 0;
				try {
					int brStrana2 = Integer.parseInt(brStrana);
					brStrana1 = brStrana2;
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Mora biti numericka vrednost upisana","Greska",JOptionPane.WARNING_MESSAGE);
				}
				boolean tipPoveza = txtTipPoveza.isSelected();
				String godinaStampanja = txtGodinaSt.getText().trim();
				int godinaStampanja1 = 0;
				try {
					int godinaStampanja2 = Integer.parseInt(godinaStampanja);
					godinaStampanja1 = godinaStampanja2;
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Mora biti numericka vrednost upisana","Greska",JOptionPane.WARNING_MESSAGE);
				}
				boolean isAktivan = txtjeliIznajmljena.isSelected();
				int knjigaid = cmbxKnjiga.getSelectedIndex();
				Knjiga knjiga = biblioteka.sveNeobrisaneKnjige().get(knjigaid);
				
				if(id.equals("")||brStrana.equals("")||godinaStampanja.equals("")) {
					JOptionPane.showMessageDialog(null, "Moraju sva polja da budu popunjena","Greska",JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(primerak == null) {
						PrimerakKnjige primerak = new PrimerakKnjige(id,brStrana1,tipPoveza,godinaStampanja1,isAktivan,knjiga,false);
						biblioteka.getPrimerak().add(primerak);
					}
					else {
						primerak.setId(id);
						primerak.setBrStrana(brStrana1);
						primerak.setTipPoveza(tipPoveza);
						primerak.setGodinaStampanja(godinaStampanja1);
						primerak.setJeliIznajmljena(isAktivan);
						primerak.setKnjiga(knjiga);
					}
					try {
						biblioteka.sacuvajPrimerke();
						DijalogDodajPrimerakKnjige.this.setVisible(false);
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}

	private void initGUI() {
		ArrayList<Knjiga> knjige = biblioteka.sveNeobrisaneKnjige();
		for(Knjiga knjiga : knjige) {
			cmbxKnjiga.addItem(knjiga.getOpisKnjige());
		}
		
		MigLayout mig = new MigLayout("wrap 2","[][]","[]10[]10[]");
		setLayout(mig);
		
		add(lblID);
		add(txtID);
		add(lblBrStrana);
		add(txtBrStrana);
		add(lblTipPoveza);
		add(txtTipPoveza);
		add(lblGodinaSt);
		add(txtGodinaSt);
		add(lbljeliIznajmljena);
		add(txtjeliIznajmljena);
		add(lblKnjiga);
		add(cmbxKnjiga);
		add(new JLabel());
		add(btnSave,"split 2");
		add(btnSave);
		add(btnCancel);
		
		
		
	}
	
	
}
