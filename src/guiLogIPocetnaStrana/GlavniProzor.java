package guiLogIPocetnaStrana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import biblioteka.Biblioteka;

import gui1.AdministratoriProzor;
import gui1.BibliotekaProzor;
import gui1.BibliotekariProzor;
import gui1.ClanoviProzor;
import gui1.IznajmljivanjeProzor;
import gui1.KnjigeProzor;
import gui1.PrimerciProzor;
import gui1.TipClanarineProzor;
import gui1.ZanrProzor;
import osobe.Admin;
import osobe.Zaposleni;

//import gui.formeZaPrikaz.DiskoviProzor;
//import gui.formeZaPrikaz.KnjigeProzor;
//import gui.formeZaPrikaz.KompozicijeProzor;
//import gui.formeZaPrikaz.ProdavciProzor;
//import osobe.Prodavac;
//import prodavnica.Prodavnica;

public class GlavniProzor extends JFrame {

	private JMenuBar mainMenu = new JMenuBar();
	private JMenu Meni1 = new JMenu("Clanovi");
	private JMenu Meni2 = new JMenu("Artikli");
	private JMenu Meni3 = new JMenu("Zaposleni");
	private JMenu Meni4 = new JMenu("Biblioteka");
	private JMenuItem KnjigeItem = new JMenuItem("Knjige");
	private JMenuItem PrimerciItem = new JMenuItem("Primerci");
	private JMenuItem ClanoviItem = new JMenuItem("Clanovi");
	private JMenuItem ZanrItem = new JMenuItem("Zanrovi");
	private JMenuItem AdministratoriItem=new JMenuItem("Administratori");
	private JMenuItem BibliotekariItem =new JMenuItem("Bibliotekari");
	private JMenuItem TipClanarineItem = new JMenuItem("Tipovi Clanarine");
	private JMenuItem IznajmljivanjeItem = new JMenuItem("Iznajmljivanje");
	private JMenuItem BibliotekaItem = new JMenuItem ("Biblioteka");
	
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeni;
	private boolean isAdmin;
	
	public GlavniProzor(Biblioteka biblioteka, Zaposleni prijavljeni,boolean isAdmin) {
		this.biblioteka = biblioteka;
		this.prijavljeni = prijavljeni;
		this.isAdmin=isAdmin;
		setTitle("Zaposleni: " + prijavljeni.getKorisnickoIme());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		InitActions();
	}
	private void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(Meni1);
		Meni1.add(ClanoviItem);
		Meni1.add(TipClanarineItem);
		mainMenu.add(Meni2);
		Meni2.add(KnjigeItem);
		Meni2.add(PrimerciItem);
		Meni2.add(ZanrItem);
		Meni2.add(IznajmljivanjeItem);
		mainMenu.add(Meni4);
		Meni4.add(BibliotekaItem);
		if(isAdmin) {
			mainMenu.add(Meni3);
			Meni3.add(AdministratoriItem);
			Meni3.add(BibliotekariItem);
		}

		
		}
	private void InitActions() {
		PrimerciItem.addActionListener(new ActionListener() { /*Primerci*/
			@Override
			public void actionPerformed(ActionEvent e) {
				PrimerciProzor pp = new PrimerciProzor(biblioteka);
				pp.setVisible(true);
			};
		});
		KnjigeItem.addActionListener(new ActionListener() {/*PrimerakKnjige*/
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjigeProzor pp = new KnjigeProzor(biblioteka);
				pp.setVisible(true);
			};
		});
		ClanoviItem.addActionListener(new ActionListener() { /*ClanBiblioteke*/
			@Override
			public void actionPerformed(ActionEvent e) {
				ClanoviProzor pp = new ClanoviProzor(biblioteka);
				pp.setVisible(true);
			};
		});
		
		ZanrItem.addActionListener(new ActionListener() { /*ZanrKnjige*/
			@Override
			public void actionPerformed(ActionEvent e) {
				ZanrProzor pp = new ZanrProzor(biblioteka);
				pp.setVisible(true);
			};
		});
		
		TipClanarineItem.addActionListener(new ActionListener() { /*TipClanarine*/
			@Override
			public void actionPerformed(ActionEvent e) {
				TipClanarineProzor pp = new TipClanarineProzor(biblioteka);
				pp.setVisible(true);
			};
		});
		
		AdministratoriItem.addActionListener(new ActionListener() { /*Administartor*/
			@Override
			public void actionPerformed(ActionEvent e) {
				AdministratoriProzor pp = new AdministratoriProzor(biblioteka);
				pp.setVisible(true);
			};
		});
	
		BibliotekariItem.addActionListener(new ActionListener() { /*Bibliotekar*/
			@Override
			public void actionPerformed(ActionEvent e) {
				BibliotekariProzor pp = new BibliotekariProzor(biblioteka);
				pp.setVisible(true);
			};
		});
		
		IznajmljivanjeItem.addActionListener(new ActionListener() { /*Iznajmljivanje*/
			@Override
			public void actionPerformed(ActionEvent e) {
				IznajmljivanjeProzor pp = new IznajmljivanjeProzor(biblioteka,prijavljeni);
				pp.setVisible(true);
			};
		});
	

		BibliotekaItem.addActionListener(new ActionListener() { /*Biblioteka*/
			@Override
			public void actionPerformed(ActionEvent e) {
				BibliotekaProzor pp = new BibliotekaProzor(biblioteka);
				pp.setVisible(true);
			};
		});
	
}}
