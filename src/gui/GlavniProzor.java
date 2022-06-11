package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import projekatObjektno.Biblioteka;
import projekatObjektno.Bibliotekar;
import projekatObjektno.IzdavanjeKnjige;
import projekatObjektno.Zaposleni;
import gui.formeZaPrikaz.AdministratorProzor;
import gui.formeZaPrikaz.BibliotekarProzor;
//import gui.formeZaPrikaz.BibliotekarPrzor;
import gui.formeZaPrikaz.ClanBibliotekeProzor;
import gui.formeZaPrikaz.IzdavanjeknjigeProzor;
import gui.formeZaPrikaz.KnjigeProzor;
import gui.formeZaPrikaz.PrimerakKnjigeProzor;
import gui.formeZaPrikaz.TipClanarineProzor;
import gui.formeZaPrikaz.ZanrKnjigeProzor;
import projekatObjektno.Bibliotekar;
import projekatObjektno.Biblioteka;
//import gui.formeZaPrikaz.KnjigeProzor;
//import gui.formeZaPrikaz.KompozicijeProzor;
//import gui.formeZaPrikaz.ProdavciProzor;
//import osobe.Prodavac;
//import prodavnica.Prodavnica;

public class GlavniProzor extends JFrame{
	private JMenuBar mainMenu = new JMenuBar();
	private JMenu artikliMenu = new JMenu("Clanovi");
	private JMenu sveKnjigeMenu = new JMenu("Artikli");
	private JMenuItem diskoviItem = new JMenuItem("ClanBiblioteke");
	private JMenuItem knjigeItem = new JMenuItem("Knjige");
	private JMenuItem kompozicijeItem = new JMenuItem("PrimerakKnjige");
	private JMenuItem zanrKnjigeItem = new JMenuItem("ZanrKnjige");
	private JMenuItem tipClanarinejeItem = new JMenuItem("TipClanarine");
	private JMenuItem izdavanjeKnjigeItem = new JMenuItem("IzdavanjeKnjige");
	private JMenu prodavciMenu = new JMenu("Zaposleni");
	private JMenuItem bibliotekarItem = new JMenuItem("Bibliotekar");
	private JMenuItem administratorItem = new JMenuItem("Administartor");
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniKorisnik;
	private boolean jeliAdmin;
	
	public GlavniProzor(Biblioteka biblioteka, Zaposleni prijavljeniKorisnik,boolean jeliAdmin) {
		this.biblioteka = biblioteka;
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		this.jeliAdmin = jeliAdmin;
		setTitle("Zaposleni: " + prijavljeniKorisnik.getKorisnickoIme());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
	}
	
//	private void initMenu() {
//		setJMenuBar(mainMenu);
//		mainMenu.add(PrimerciItem);
//		mainMenu.add(KnjigeItem);
//		mainMenu.add(ClanoviItem);
//		mainMenu.add(ZanrItem);
//		mainMenu.add(TipClanarineItem);
//
//		if(isAdmin) {
//			mainMenu.add(AdministratoriItem);
//			mainMenu.add(BibliotekariItem);
//		}	
//		}
	
	private void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(artikliMenu);
		artikliMenu.add(diskoviItem);
		mainMenu.add(sveKnjigeMenu);
		sveKnjigeMenu.add(knjigeItem);
		sveKnjigeMenu.add(kompozicijeItem);
		sveKnjigeMenu.add(zanrKnjigeItem);
		sveKnjigeMenu.add(izdavanjeKnjigeItem);
		artikliMenu.add(tipClanarinejeItem);
		if(jeliAdmin) {
			mainMenu.add(prodavciMenu);
			prodavciMenu.add(bibliotekarItem);
			prodavciMenu.add(administratorItem);
		}
	}
	
	private void initActions() {
		bibliotekarItem.addActionListener(new ActionListener() { /*Bibliotekar*/
			@Override
			public void actionPerformed(ActionEvent e) {
				BibliotekarProzor pp = new BibliotekarProzor(biblioteka,prijavljeniKorisnik);
				pp.setVisible(true);
			}
		});
		izdavanjeKnjigeItem.addActionListener(new ActionListener() { /*Bibliotekar*/
			@Override
			public void actionPerformed(ActionEvent e) {
				IzdavanjeknjigeProzor pp = new IzdavanjeknjigeProzor(biblioteka,prijavljeniKorisnik);
				pp.setVisible(true);
			}
		});
		
		tipClanarinejeItem.addActionListener(new ActionListener() { /*TipClanarine*/
			@Override
			public void actionPerformed(ActionEvent e) {
				TipClanarineProzor pp = new TipClanarineProzor(biblioteka,prijavljeniKorisnik);
				pp.setVisible(true);
			}
		});
		
		administratorItem.addActionListener(new ActionListener() { /*Administratori*/
			@Override
			public void actionPerformed(ActionEvent e) {
				AdministratorProzor pp = new AdministratorProzor(biblioteka,prijavljeniKorisnik);
				pp.setVisible(true);
			}
		});
		
		kompozicijeItem.addActionListener(new ActionListener() { /*PrimerakKnjige*/
			@Override
			public void actionPerformed(ActionEvent e) {
				PrimerakKnjigeProzor kp = new PrimerakKnjigeProzor(biblioteka,prijavljeniKorisnik);
				kp.setVisible(true);
			}
		});
		
		diskoviItem.addActionListener(new ActionListener() { /*ClanBiblioteke*/
			@Override
			public void actionPerformed(ActionEvent e) {
				ClanBibliotekeProzor dp = new ClanBibliotekeProzor(biblioteka,prijavljeniKorisnik);
				dp.setVisible(true);
			}
		});
		
		knjigeItem.addActionListener(new ActionListener() { /*Knjige*/
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjigeProzor kp = new KnjigeProzor(biblioteka,prijavljeniKorisnik);
				kp.setVisible(true);
			}
		});
		
		zanrKnjigeItem.addActionListener(new ActionListener() { /*ZanrKnjige*/
			@Override
			public void actionPerformed(ActionEvent e) {
				ZanrKnjigeProzor kp = new ZanrKnjigeProzor(biblioteka,prijavljeniKorisnik);
				kp.setVisible(true);
			}
		});
	}
}
