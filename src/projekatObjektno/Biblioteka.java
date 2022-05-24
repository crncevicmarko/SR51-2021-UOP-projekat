package projekatObjektno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
//import java.util.ArrayList;


public class Biblioteka {
	protected String naziv;
	protected String adresa;
	protected String telefon;
	protected LocalDate otvaranje;
	protected LocalDate zatvaranje;
	protected String id;
	protected ArrayList<Knjiga> knjige;
	protected ArrayList<ZanrKnjige> zanrovi; 
	protected ArrayList<Administrator> admin;
	protected ArrayList<Zaposleni> zaoposleni;
	protected ArrayList<ClanBiblioteke> clanbiblioteke;
	protected ArrayList<IzdavanjeKnjige> izdavanjeKnjige;
	protected ArrayList<Bibliotekar> bibliotekar;
	protected ArrayList<TipClanarine> tipClanarine;
	protected ArrayList<PrimerakKnjige> primerak;
	
	/*proveri za kasnije sta treba da se jos doda*/
	
	public Biblioteka(String naziv, String adresa, String telefon, LocalDate otvaranje, LocalDate zatvaranje,
			String id) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.otvaranje = otvaranje;
		this.zatvaranje = zatvaranje;
		this.id = id;
		this.admin = new ArrayList<Administrator>();
		this.knjige = new ArrayList<Knjiga>();
		this.zanrovi = new ArrayList<ZanrKnjige>();
		this.clanbiblioteke = new ArrayList<ClanBiblioteke>();
		this.izdavanjeKnjige = new ArrayList<IzdavanjeKnjige>();
		this.tipClanarine = new ArrayList<TipClanarine>();
		this.primerak = new ArrayList<PrimerakKnjige>();
		this.bibliotekar = new ArrayList<Bibliotekar>();
		

	}
	public Biblioteka() {
		this.naziv = "";
		this.adresa = "";
		this.telefon = "";
		this.otvaranje = null;
		this.zatvaranje = null;
		this.id = "";
		this.admin = new ArrayList<Administrator>();
		this.knjige = new ArrayList<Knjiga>();
		this.zanrovi = new ArrayList<ZanrKnjige>();
		this.clanbiblioteke = new ArrayList<ClanBiblioteke>();
		this.izdavanjeKnjige = new ArrayList<IzdavanjeKnjige>();
		this.tipClanarine = new ArrayList<TipClanarine>();
		this.primerak = new ArrayList<PrimerakKnjige>();
		this.bibliotekar = new ArrayList<Bibliotekar>();
	}
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public LocalDate getOtvaranje() {
		return otvaranje;
	}
	public void setOtvaranje(LocalDate otvaranje) {
		this.otvaranje = otvaranje;
	}
	public LocalDate getZatvaranje() {
		return zatvaranje;
	}
	public void setZatvaranje(LocalDate zatvaranje) {
		this.zatvaranje = zatvaranje;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Knjiga> getKnjige() {
		return knjige;
	}
	public void setKnjige(ArrayList<Knjiga> knjige) {
		this.knjige = knjige;
	}
	public ArrayList<ZanrKnjige> getZanrovi() {
		return zanrovi;
	}
	public void setZanrovi(ArrayList<ZanrKnjige> zanrovi) {
		this.zanrovi = zanrovi;
	}
	public ArrayList<Administrator> getAdmin() {
		return admin;
	}
	public void setAdmin(ArrayList<Administrator> admin) {
		this.admin = admin;
	}
	public ArrayList<ClanBiblioteke> getClanbiblioteke() {
		return clanbiblioteke;
	}
	public void setClanbiblioteke(ArrayList<ClanBiblioteke> clanbiblioteke) {
		this.clanbiblioteke = clanbiblioteke;
	}
	public ArrayList<TipClanarine> getTipClanarine() {
		return tipClanarine;
	}
	public void setTipClanarine(ArrayList<TipClanarine> tipClanarine) {
		this.tipClanarine = tipClanarine;
	}
	public ArrayList<Zaposleni> getZaoposleni() {
		return zaoposleni;
	}
	public void setZaoposleni(ArrayList<Zaposleni> zaoposleni) {
		this.zaoposleni = zaoposleni;
	}
	
	public ArrayList<IzdavanjeKnjige> getIzdavanjeKnjige() {
		return izdavanjeKnjige;
	}
	public void setIzdavanjeKnjige(ArrayList<IzdavanjeKnjige> izdavanjeKnjige) {
		this.izdavanjeKnjige = izdavanjeKnjige;
	}
	public ArrayList<Bibliotekar> getBibliotekar() {
		return bibliotekar;
	}
	public void setBibliotekar(ArrayList<Bibliotekar> bibliotekar) {
		this.bibliotekar = bibliotekar;
	}
	
	/*Knjiga CRUD------------------------------------------------------------------------------------------------------------------------------------*/
	
	public void obrisiKnjigu(String id) throws IOException {
		Knjiga knjiga = null;
		for (Knjiga k : this.knjige) {
			if(k.getId().equals(id)) {
				knjiga = k;
			}
		}
		knjiga.setJeObrisana(true);
	}
	
	
	public void azurirajKnjigu(String id,HashMap<String,String> parametri) throws IOException {
		Knjiga knjiga = null;
		for (Knjiga k : this.knjige) {
			if(k.getId().equals(id)) {
				knjiga = k;
			}
		}
		Set<String> kljucevi = parametri.keySet();
		for (String kljuc:kljucevi) {
			switch (kljuc) {
			case "pisac": 
				knjiga.setPisac(parametri.get(kljuc));
				break;
			case "godinaObjavljanjaKnjige":
				knjiga.setGodinaObjavljanjaKnjige(Integer.parseInt(parametri.get(kljuc)));
				break;
			case "naslovKnjige":
				knjiga.setNaslovKnjige(parametri.get(kljuc));
				break;
			case "originalsniNaslovKnjige":
				knjiga.setOriginalsniNaslovKnjige(parametri.get(kljuc));
				break;
			case "jezikOriginala":
				knjiga.setJezikOriginala(Jezik.valueOf(parametri.get(kljuc)));
				break;
			case "jeObrisana":
				knjiga.setJeObrisana(Boolean.parseBoolean(parametri.get(kljuc)));
				break;
			case "opisKnjige":
				knjiga.setOpisKnjige(parametri.get(kljuc));
				break;
			case "zanr": 
				ZanrKnjige zanr = null;
				for (ZanrKnjige z : this.zanrovi) {
					if(z.getId().equals(parametri.get(kljuc))) {
						zanr = z;
					}
				}
				knjiga.setZanr(zanr);
				break;
		}
		}
	}
	
	public void praviKnjigu(String id, String naslovKnjige, String originalsniNaslovKnjige, String pisac,
			int godinaObjavljanjaKnjige, Jezik jezikOriginala, String opisKnjige, ZanrKnjige zanr, boolean jeObrisana) throws IOException {
		this.citajKnjige();
		Knjiga knjiga = new Knjiga(id,naslovKnjige,originalsniNaslovKnjige,pisac,godinaObjavljanjaKnjige,jezikOriginala,opisKnjige,zanr,false);
		this.knjige.add(knjiga);
		this.upisiFajl(knjige);		
	}
	
	/*Knjiga CRUD -----------------------------------------------------------------------------------------------------------------------------*/
	
//	public ArrayList<Knjiga> citajKnjige(String imeFajla) throws IOException{
	public void citajKnjige() throws IOException{
		this.knjige = new ArrayList<Knjiga>();/*svaki put kad zapocne metoda on ce da isprazni listu i da je naravi opet*/
		File fajl = new File("src/projekatObjektno/knjige.txt"); /*promeni za svaku klasu*/
		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
		String line = null;
		while((line = citaj.readLine())!= null) {
			String [] niz = line.split(";");
			String id  = niz[6];
			String naslovKnjige = niz[0];
			String originalsniNaslovKnjige = niz[3];
			String pisac = niz[2];
			int godinaObjavljanjaKnjige = Integer.parseInt(niz[4]);
			String jezikOroginala = niz[5];
			Jezik jezikOriginala = Jezik.ENGLESKI;
			for (Jezik j: Jezik.values()) {
				if(j.name().equalsIgnoreCase(jezikOroginala)){
					jezikOriginala = j;
				}
			}
			String opisKnjige = niz[1];
			boolean jeObrisana = Boolean.parseBoolean(niz[8]);
//			ArrayList<ZanrKnjige> zanrovi = citajZanroveIzFajla("src/projekatObjektno/zanrovi.txt");
			ZanrKnjige zanr1 = null;
			for (ZanrKnjige z : this.zanrovi) {
				if(z.getId().equals(niz[7])) {
					zanr1 = z;
				}
			}
			Knjiga knjiga = new Knjiga( id, naslovKnjige,originalsniNaslovKnjige,pisac,godinaObjavljanjaKnjige,jezikOriginala,opisKnjige,zanr1,jeObrisana);
			this.knjige.add(knjiga);
		}
		citaj.close();
//		return knjige;
	}
	public void upisiFajl(ArrayList<Knjiga>knjige) throws IOException{
//		ArrayList<Knjiga> knjige = kjnigeUpis;
		File file = new File("src/projekatObjektno/knjige.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (Knjiga k: knjige) {
			String sb = k.getNaslovKnjige() +";"+ k.getOpisKnjige() + ";"+k.getPisac()+ ";"+k.getOriginalsniNaslovKnjige() +";"+ k.getGodinaObjavljanjaKnjige()+ ";" +k.getJezikOriginala() +";"+k.getId()+";"+k.getZanr().getId()+";"+k.isJeObrisana();
			writer.write(sb);
			writer.newLine();
		}
		writer.close();
		
	}
	/*ZanrKnjigeArrayLista-------------------------------------------------------------------------------------------------------------------------------*/
	public void  citajZanroveIzFajla() throws IOException{
//	public ArrayList<ZanrKnjige> citajZanroveIzFajla(String imeFajla) throws IOException{
//		ArrayList<ZanrKnjige> zanrknjige = new ArrayList<ZanrKnjige>();
		this.zanrovi = new ArrayList<ZanrKnjige>();
		File fajl = new File("src/projekatObjektno/zanrovi.txt");
		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
		String line = null;
		while((line = citaj.readLine())!= null) {
			String [] niz = line.split(";");
			String id = niz[0];
			String oznaka = niz[1];
			String opis = niz[2];
			ZanrKnjige zanr = new ZanrKnjige(id,oznaka,opis);
			this.zanrovi.add(zanr);
		}
		citaj.close();
		
//		return zanrknjige;	
	}
	public void upisiZanrKnjig (ArrayList<ZanrKnjige>zanrovi) throws IOException{ /*jeObrisan fali*/
		File file = new File("src/projekatObjektno/zanrovi.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (ZanrKnjige z: zanrovi) {
			String sb = z.getId() + ";"+ z.getOznaka() + ";"+ z.getOpis();
			writer.write(sb);
			writer.newLine();
		}
		writer.close();
	}
	/*------------------------------------------------------------------------------------------------------------------------------------------------------*/
	public void upisiFajl(Biblioteka k ) throws IOException{
//		ArrayList<Biblioteka> biblioteka = biblUpis;
		File file = new File("src/projekatObjektno/biblioteka.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
//		for (Biblioteka k: biblioteka) {
			String sb = k.getAdresa() +";"+ k.getId() +";"+ k.getNaziv() + ";"+k.getTelefon()+ ";"+k.getOtvaranje() +";" +k.getZatvaranje();
			writer.write(sb);
			writer.newLine();
//		}
		writer.close();
		
	}

	/*AdministartorArrayLista----------------------------------------------------------------------------------------------------------------------------*/
//	public ArrayList<Administrator> citajAdministratora(String imeFajla) throws IOException{
	public void citajAdministratora() throws IOException{
//		ArrayList<Administrator> administartor = new ArrayList<Administrator>()
		this.admin = new ArrayList<Administrator>();
		File fajl = new File("src/projekatObjektno/administartor.txt");
		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
		String line = null;
		while((line = citaj.readLine())!= null) {
			String [] niz = line.split(";");
			String id = niz[0];
			String ime = niz[1];
			String prezime = niz[2];
			String JMBG = niz[3];
			String adresa = niz[4];
			String defpol1 = niz[5];
			EmnumPol defpol = EmnumPol.MUSKI;
			for(EmnumPol p:EmnumPol.values()) {
				if(p.name().equalsIgnoreCase(defpol1)){
					defpol = p;
				}
			}
			String korisnickaSifra = niz[6];
			String korisnickoIme = niz[7];
			Double plata = Double.parseDouble(niz[8]);
			Administrator admin = new Administrator(id,ime,prezime,JMBG,adresa,defpol,korisnickaSifra,korisnickoIme,plata);
			this.admin.add(admin);
			}
		citaj.close();
//		return administartor;	
	}
	public void upisiFajlAdministartor(ArrayList<Administrator>administartori) throws IOException{ /*jeObrisan fali*/
//		ArrayList<Knjiga> knjige = kjnigeUpis;
		File file = new File("src/projekatObjektno/administartor.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (Administrator a: administartori) {
			String sb = a.getId() +";"+ a.getIme() + ";"+a.getPrezime()+ ";"+a.getJMBG() +";"+ a.getAdresa()+ ";" +a.getPol() +";"+a.getKorisnickaSifra()+";"+a.getKorisnickoIme() +";"+a.getPlata();
			writer.write(sb);
			writer.newLine();
		}
		writer.close();
	}
	/*BibliotekarArrayLista--------------------------------------------------------------------------------------------------------------------------------*/
//	public ArrayList<Bibliotekar> citajBibliotekara(String imeFajla) throws IOException{
	public void citajBibliotekara() throws IOException{
//		ArrayList<Bibliotekar> bibliotekar = new ArrayList<Bibliotekar>();
		this.bibliotekar = new ArrayList<Bibliotekar>();
		File fajl = new File("src/projekatObjektno/bibliotekar.txt");
		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
		String line = null;
		while((line = citaj.readLine())!= null) {
			String [] niz = line.split(";");
			String id = niz[0];
			String ime = niz[1];
			String prezime = niz[2];
			String JMBG = niz[3];
			String adresa = niz[4];
			String defpol1 = niz[5];
			EmnumPol defpol = EmnumPol.MUSKI;
			for(EmnumPol p:EmnumPol.values()) {
				if(p.name().equalsIgnoreCase(defpol1)){
					defpol = p;
				}
			}
			String korisnickaSifra = niz[6];
			String korisnickoIme = niz[7];
			Double plata = Double.parseDouble(niz[8]);
			Bibliotekar bibl = new Bibliotekar(id,ime,prezime,JMBG,adresa,defpol,korisnickaSifra,korisnickoIme,plata);
			this.bibliotekar.add(bibl);
			}
		citaj.close();
//		return bibliotekar;	
	}
	public void upisiFajlBibliotekar(ArrayList<Bibliotekar>bibliotekari) throws IOException{ /*jeObrisan fali*/
//		ArrayList<Knjiga> knjige = kjnigeUpis;
		File file = new File("src/projekatObjektno/bibliotekar.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (Bibliotekar b: bibliotekari) {
			String sb = b.getId() +";"+ b.getIme() + ";"+b.getPrezime()+ ";"+b.getJMBG() +";"+ b.getAdresa()+ ";" +b.getPol() +";"+b.getKorisnickaSifra()+";"+b.getKorisnickoIme()+";"+b.getPlata();
			writer.write(sb);
			writer.newLine();
		}
		writer.close();
	}
	
	/*ClanBibliotekeArrayLista-------------------------------------------------------------------------------------------------------------------------------*/
//	public static ArrayList<ClanBiblioteke> citajClanove(String fajlClanovi)throws IOException{
		public void citajClanove()throws IOException{
//		ArrayList<ClanBiblioteke> clanovi = new ArrayList<ClanBiblioteke>();
		this.clanbiblioteke = new ArrayList<ClanBiblioteke>();
		File claoviFile = new File("src/projekatObjektno/clanbiblioteke.txt");
		BufferedReader citanje = new BufferedReader(new FileReader(claoviFile));
		String line1 = null;
		while((line1 = citanje.readLine())!= null) {
			String[]nizClanova = line1.split(";");
			String id = nizClanova[0];
			String ime = nizClanova[1];
			String prezime = nizClanova[2];
			String JMBG = nizClanova[3];
			String adresa = nizClanova[4];
			String polClana = nizClanova[5];
			EmnumPol defpol = EmnumPol.MUSKI;
			for(EmnumPol pol:EmnumPol.values()) {
				if(pol.name().equalsIgnoreCase(polClana)) {
					defpol = pol;
				}
			}
			String brClankarte  = nizClanova[6];
			LocalDate datumPoslednjeUplate = LocalDate.parse(nizClanova[7]);
			int brojMeseciClanarine = Integer.parseInt(nizClanova[8]);
			boolean aktivan = Boolean.parseBoolean(nizClanova[9]);
//			ArrayList<TipClanarine> tip = citajClanarine("src/projekatObjektno/tipclanarine.txt");
			TipClanarine tip1 = null;
			for (TipClanarine t : this.tipClanarine) {
				if(t.getId().equals(nizClanova[10])) {
					tip1 = t;
				}
			}
			ClanBiblioteke clan = new ClanBiblioteke(id,ime,prezime,JMBG,adresa,defpol,brClankarte,datumPoslednjeUplate,brojMeseciClanarine,aktivan,tip1);
			this.clanbiblioteke.add(clan);
		}
		citanje.close();
//		return clanovi;
	}
	public void upisiFajlClanBiblioteke(ArrayList<ClanBiblioteke>clanovi) throws IOException{ /*jeObrisan fali*/
//	ArrayList<Knjiga> knjige = kjnigeUpis;
	File file = new File("src/projekatObjektno/clanbiblioteke.txt");
	BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	for (ClanBiblioteke c: clanovi) {
		String sb = c.getId() +";"+ c.getIme() + ";"+c.getPrezime()+ ";"+c.getJMBG() +";"+ c.getAdresa()+ ";" +c.getPol() +";"+c.getBrClankarte()+";"+c.getDatumPoslednjeUplate()+";"+c.getBrojMeseciClanarine()+ ";"+c.getAktivan()+";"+c.getTipClanarine();
		writer.write(sb);
		writer.newLine();
	}
	writer.close();
}
	/*TipClanarineArrayLista-----------------------------------------------------------------------------------------------------------------------------*/
//	public static ArrayList<TipClanarine> citajClanarine(String fajlClanovi) throws IOException{
	public void  citajClanarine() throws IOException{
//		ArrayList<TipClanarine> tipClanarine = new ArrayList<TipClanarine>();
		this.tipClanarine = new ArrayList<TipClanarine>();
		File file = new File("src/projekatObjektno/tipclanarine.txt");
		BufferedReader citanje = new BufferedReader(new FileReader(file));
		String line1 = null;
		while((line1 = citanje.readLine())!= null) {
			String[]nizClanova = line1.split(";");
			String id = nizClanova[0];
			String naziv = nizClanova[1];
			double cena = Double.parseDouble(nizClanova[2]);
			TipClanarine tip = new TipClanarine(id,naziv,cena);
			this.tipClanarine.add(tip);
		}
		citanje.close();
//		return tipClanarine;
		
	}
	public void upisiTipClanarine(ArrayList<TipClanarine>tipoviclanarine) throws IOException{ /*jeObrisan fali*/
//		ArrayList<TipClanarine> tip = tipUpis;
		File file = new File("src/projekatObjektno/tipclanarine.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for(TipClanarine t:tipoviclanarine) {
			String sb = t.getNaziv()+ ";"+ t.getId()+ ";"+t.getCena();
			writer.write(sb);
			writer.newLine();;
 		}
		writer.close();
	}
	
	
	/*IzdavanjeKnjigeArrayLista------------------------------------------------------------------------------------------------------------------------------*/
//	public ArrayList<IzdavanjeKnjige> citajIzdavanjeKnjige(String imeFajla) throws IOException{
	public void citajIzdavanjeKnjige() throws IOException{
//		ArrayList<IzdavanjeKnjige> izdknjige = new ArrayList<IzdavanjeKnjige>();
		this.izdavanjeKnjige = new ArrayList<IzdavanjeKnjige>();
		File fajl = new File("src/projekatObjektno/izdavanjeKnjige.txt");
		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
		String line = null;
		while((line = citaj.readLine())!= null) {
			String [] niz = line.split(";");
			LocalDate datumIznajmljivanja = LocalDate.parse(niz[0]);
			LocalDate datumVracanja = LocalDate.parse(niz[1]);
//			ArrayList<ClanBiblioteke> clanovi = citajClanove("src/projekatObjektno/clanbiblioteke.txt");
			ClanBiblioteke clan1 = null;
			for (ClanBiblioteke t : this.clanbiblioteke) {
				if(t.getId().equals(niz[3])) {
					clan1 = t;
				}
			}
//			ArrayList<Bibliotekar> bibliotekari = citajBibliotekara("src/projekatObjektno/bibliotekar.txt");
			Zaposleni zaposleni = null;
			for (Bibliotekar t : this.bibliotekar) {
				if(t.getId().equals(niz[2])) {
					zaposleni = t;
				}
			}
			if(zaposleni == null) { /*ako nje nasao bibliotekara provera da li ima administrator sa id*/
//				ArrayList<Administrator> administartor = citajAdministratora("src/projekatObjektno/administrator.txt");
				for (Administrator t : this.admin) {
					if(t.getId().equals(niz[2])) {
						zaposleni = t;
					}
				}
			}
//			ArrayList<PrimerakKnjige> primerciKnjige = citajPrimerke("src/projekatObjektno/primerakKnjige.txt");
			PrimerakKnjige primerKnjige = null;
			for (PrimerakKnjige t : this.primerak) {
				if(t.getId().equals(niz[4])) {
					primerKnjige = t;
				}
			}
			IzdavanjeKnjige izdavanje = new IzdavanjeKnjige(datumIznajmljivanja,datumVracanja,zaposleni,clan1,primerKnjige);
			this.izdavanjeKnjige.add(izdavanje);
		}
		citaj.close();
//		return izdknjige;
		
	}
	
	public void upisiIzdavanjeKnjige(ArrayList<IzdavanjeKnjige>izdavanjaKnjige) throws IOException{ /*jeObrisan fali*/
//		ArrayList<TipClanarine> tip = tipUpis;
		File file = new File("src/projekatObjektno/izdavanjeKnjige.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for(IzdavanjeKnjige t:izdavanjaKnjige) {
			String sb = t.getDatumIznajmljivanja()+ ";"+ t.getDatumVracanja()+ ";"+t.getZaposleni().getId()+ ";"+ t.getClan().getId()+ ";"+ t.getPrimerak().getId();
			writer.write(sb);
			writer.newLine();;
 		}
		writer.close();
	}
	
	
	
	/*PrimerakKnjigeArrayLista---------------------------------------------------------------------------------------------------------------------------------*/
//	public ArrayList<PrimerakKnjige> citajPrimerke(String imeFajla) throws IOException{
	public void citajPrimerke() throws IOException{
//		ArrayList<PrimerakKnjige> primerakKnjige = new ArrayList<PrimerakKnjige>();
		this.primerak = new ArrayList<PrimerakKnjige>();
		File fajl = new File("src/projekatObjektno/primerakKnjige.txt");
		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
		String line = null;
		while((line = citaj.readLine())!= null) {
			String [] niz = line.split(";");
			String id  = niz[0];
			int brStrana = Integer.parseInt(niz[1]);
			boolean tipPoveza= Boolean.parseBoolean(niz[2]);
			int godinaStampanja = Integer.parseInt(niz[3]);
			boolean jeliIznajmljena = Boolean.parseBoolean(niz[4]);
//			ArrayList<Knjiga> knjiga = citajKnjige("src/projekatObjektno/knjige.txt");
			Knjiga knjiga1 = null;
			for (Knjiga k: this.knjige) {
				if(k.getId().equals(niz[5])) {
					knjiga1 = k;
				}
			}
			PrimerakKnjige primerak = new PrimerakKnjige(id,brStrana,tipPoveza,godinaStampanja,jeliIznajmljena,knjiga1);
			this.primerak.add(primerak);	
		}
		citaj.close();
//		return primerakKnjige;
	}
	public void upisiPrimerakKnjige(ArrayList<PrimerakKnjige>primerciKnjige) throws IOException{ /*jeObrisan fali*/
//		ArrayList<PrimerakKnjige> primerak = tipUpis;
		File file = new File("src/projekatObjektno/primerakKnjige.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for(PrimerakKnjige p: primerciKnjige) {
			String pr = p.getId()+ ";"+ p.getBrStrana()+";"+p.isTipPoveza()+";"+p.getGodinaStampanja()+";"+p.isJeliIznajmljena()+";"+p.getKnjiga().getId();
			writer.write(pr);
			writer.newLine();
 		}
		writer.close();
	}
	
	
	
}


