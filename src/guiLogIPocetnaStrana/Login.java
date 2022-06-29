package guiLogIPocetnaStrana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import net.miginfocom.swing.MigLayout;
import osobe.Admin;
import osobe.Bibliotekar;
import osobe.Zaposleni;


public class Login extends JFrame {

	private JLabel lblGreeting = new JLabel("Dobrodosli. Molimo da se prijavite.");
	private JLabel lblUsername = new JLabel("Korisnicko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblPassword = new JLabel("Sifra");
	private JPasswordField pfPassword = new JPasswordField(20);
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	
	public Login(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Prijava");
		setSize(350,250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		pack();
	}
	
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		
		add(lblGreeting, "span 2");
		add(lblUsername);
		add(txtKorisnickoIme);
		add(lblPassword);
		add(pfPassword);
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
		
		
		txtKorisnickoIme.setText("petarp");
		pfPassword.setText("12345");
		getRootPane().setDefaultButton(btnOk);
	}
	
	public void initActions() {
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login.this.dispose();
				Login.this.setVisible(false);
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnikoIme = txtKorisnickoIme.getText().trim();
				String sifra = new String(pfPassword.getPassword()).trim();
				
				if(korisnikoIme.equals("") || sifra.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke za prijavu.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					Zaposleni prijavljeni = biblioteka.login(korisnikoIme, sifra);
					if(prijavljeni == null) {
						JOptionPane.showMessageDialog(null, "Pogresni login podaci.", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						Login.this.dispose();
						Login.this.setVisible(false);
						boolean isAdmin=prijavljeni instanceof Admin;
						GlavniProzor gp = new GlavniProzor(biblioteka, prijavljeni,isAdmin);
						gp.setVisible(true);
					}
				}
			}
		});
		
	}
}
