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
import java.util.Iterator;
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
	protected ArrayList<ClanBiblioteke> clanbiblioteke;
	protected ArrayList<TipClanarine> tipClanarine;
	
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
		this.knjige = null;
		try {
			this.tipClanarine = citajClanarine("src/projekatObjektno/tipclanarine.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			this.zanrovi = citajZanroveIzFajla("src/projekatObjektno/zanrovi.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Biblioteka() {
		this.naziv = "";
		this.adresa = "";
		this.telefon = "";
		this.otvaranje = null;
		this.zatvaranje = null;
		this.id = "";
		this.knjige = null;
		this.zanrovi = null;
		this.tipClanarine = null;
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
	
	public void obrisiKnjigu(String id) throws IOException {
//		ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
		File fajl = new File("src/projekatObjektno/knjige.txt");
		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
		String line = null;
		ArrayList<String> lista = new ArrayList<>();
		while((line = citaj.readLine())!= null) {
			String[] niz = line.split(";");
			System.out.println(niz[6]);
			System.out.println(id);
			if(!(id.equals(niz[6]))) {
				lista.add(line);
				}			
		}
		citaj.close();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fajl));
		for(String l: lista) {
			writer.write(l);
			writer.newLine();
		}
		writer.close();
	}
	
	public void azurirajKnjigu(String id) throws IOException {
//		ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
		File fajl = new File("src/projekatObjektno/knjige.txt");
		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
		String line = null;
		ArrayList<String> lista = new ArrayList<>();
		while((line = citaj.readLine())!= null) {
			String[] niz = line.split(";");
			System.out.println(niz[6]);
			System.out.println(id);
			if(!(id.equals(niz[6]))) {
				lista.add(line);
				}	
			else {
				lista.add("promenjeno");
			}
		}
		citaj.close();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fajl));
		for(String l: lista) {
			writer.write(l);
			writer.newLine();
		}
		writer.close();
	}
	
	public ArrayList<Knjiga> citajFajl(String imeFajla) throws IOException{
		ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
		File fajl = new File(imeFajla);
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
			ZanrKnjige zanr = zanrovi.get(1);
			Knjiga knjiga = new Knjiga( id, naslovKnjige,originalsniNaslovKnjige,pisac,godinaObjavljanjaKnjige,jezikOriginala,opisKnjige,zanr);
			knjige.add(knjiga);
		}
		citaj.close();
		return knjige;
	}
	public void upisiFajl(Knjiga k) throws IOException{
//		ArrayList<Knjiga> knjige = kjnigeUpis;
		File file = new File("src/projekatObjektno/knjige.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
//		for (Knjiga k: knjige) {
			String sb = k.getNaslovKnjige() +";"+ k.getOpisKnjige() + ";"+k.getPisac()+ ";"+k.getOriginalsniNaslovKnjige() +";"+ k.getGodinaObjavljanjaKnjige()+ ";" +k.getJezikOriginala() +";"+k.getId()+";"+k.getZanr();
			writer.write(sb);
			writer.newLine();
//		}
		writer.close();
		
	}
	/*ZanrKnjigeArrayLista-------------------------------------------------------------------------------------------------------------------------------*/
	
	public ArrayList<ZanrKnjige> citajZanroveIzFajla(String imeFajla) throws IOException{
		ArrayList<ZanrKnjige> zanrknjige = new ArrayList<ZanrKnjige>();
		File fajl = new File(imeFajla);
		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
		String line = null;
		while((line = citaj.readLine())!= null) {
			String [] niz = line.split(",");
			String oznaka = niz[0];
			String opis = niz[1];
			ZanrKnjige zanr = new ZanrKnjige(oznaka,opis);
			zanrknjige.add(zanr);
		}
		citaj.close();
		return zanrknjige;	
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
	/*napisati citanje i pisati u fajl*/
	
	
	/*AdministartorArrayLista----------------------------------------------------------------------------------------------------------------------------*/
	public ArrayList<Administrator> citajAdministratora(String imeFajla) throws IOException{
		ArrayList<Administrator> administartor = new ArrayList<Administrator>();
		File fajl = new File(imeFajla);
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
			Administrator admin = new Administrator(id,ime,prezime,JMBG,adresa,defpol,korisnickaSifra,korisnickoIme);
			administartor.add(admin);
			}
		citaj.close();
		return administartor;	
	}
	public void upisiFajlAdministartor(Administrator a) throws IOException{
//		ArrayList<Knjiga> knjige = kjnigeUpis;
		File file = new File("src/projekatObjektno/administartor.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
//		for (Knjiga k: knjige) {
			String sb = a.getId() +";"+ a.getIme() + ";"+a.getPrezime()+ ";"+a.getJMBG() +";"+ a.getAdresa()+ ";" +a.getPol() +";"+a.getKorisnickaSifra()+";"+a.getKorisnickoIme();
			writer.write(sb);
			writer.newLine();
//		}
		writer.close();
	}
	/*BibliotekarArrayLista--------------------------------------------------------------------------------------------------------------------------------*/
	public ArrayList<Bibliotekar> citajBibliotekara(String imeFajla) throws IOException{
		ArrayList<Bibliotekar> bibliotekar = new ArrayList<Bibliotekar>();
		File fajl = new File(imeFajla);
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
			Bibliotekar bibl = new Bibliotekar(id,ime,prezime,JMBG,adresa,defpol,korisnickaSifra,korisnickoIme);
			bibliotekar.add(bibl);
			}
		citaj.close();
		return bibliotekar;	
	}
	public void upisiFajlBibliotekar(Bibliotekar b) throws IOException{
//		ArrayList<Knjiga> knjige = kjnigeUpis;
		File file = new File("src/projekatObjektno/bibliotekar.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
//		for (Knjiga k: knjige) {
			String sb = b.getId() +";"+ b.getIme() + ";"+b.getPrezime()+ ";"+b.getJMBG() +";"+ b.getAdresa()+ ";" +b.getPol() +";"+b.getKorisnickaSifra()+";"+b.getKorisnickoIme();
			writer.write(sb);
			writer.newLine();
//		}
		writer.close();
	}
	
	/*ClanBibliotekeArrayLista-------------------------------------------------------------------------------------------------------------------------------*/
	public ArrayList<ClanBiblioteke> citajclanove(String fajlClanovi)throws IOException{
		ArrayList<ClanBiblioteke> clanovi = new ArrayList<ClanBiblioteke>();
		File claoviFile = new File(fajlClanovi);
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
			ArrayList<TipClanarine> tip = citajClanarine("src/projekatObjektno/tipclanarine.txt");
			TipClanarine tip1 = null;
			for (TipClanarine t : tip) {
				System.out.println(nizClanova[10]);
				System.out.println(t.getId());
				if(t.getId().equals(nizClanova[10])) {
					
					tip1 = t;
				}
			}
			ClanBiblioteke clan = new ClanBiblioteke(id,ime,prezime,JMBG,adresa,defpol,brClankarte,datumPoslednjeUplate,brojMeseciClanarine,aktivan,tip1);
			clanovi.add(clan);
		}
		citanje.close();
		return clanovi;
	}
	public void upisiFajlClanBiblioteke(ClanBiblioteke c) throws IOException{
//	ArrayList<Knjiga> knjige = kjnigeUpis;
	File file = new File("src/projekatObjektno/clanbiblioteke.txt");
	BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
//	for (Knjiga k: knjige) {
		String sb = c.getId() +";"+ c.getIme() + ";"+c.getPrezime()+ ";"+c.getJMBG() +";"+ c.getAdresa()+ ";" +c.getPol() +";"+c.getBrClankarte()+";"+c.getDatumPoslednjeUplate()+";"+c.getBrojMeseciClanarine()+ ";"+c.getAktivan()+";"+c.getTipClanarine();
		writer.write(sb);
		writer.newLine();
//	}
	writer.close();
}
	/*TipClanarineArrayLista-----------------------------------------------------------------------------------------------------------------------------*/
	public static ArrayList<TipClanarine> citajClanarine(String fajlClanovi) throws IOException{
		ArrayList<TipClanarine> tipClanarine = new ArrayList<TipClanarine>();
		File file = new File(fajlClanovi);
		BufferedReader citanje = new BufferedReader(new FileReader(file));
		String line1 = null;
		while((line1 = citanje.readLine())!= null) {
			String[]nizClanova = line1.split(";");
			String id = nizClanova[0];
			String naziv = nizClanova[1];
			double cena = Double.parseDouble(nizClanova[2]);
			TipClanarine tip = new TipClanarine(id,naziv,cena);
			tipClanarine.add(tip);
		}
		citanje.close();
		return tipClanarine;
		
	}
	public void upisiTipClanarine(TipClanarine t) throws IOException{
//		ArrayList<TipClanarine> tip = tipUpis;
		File file = new File("src/projekatObjektno/tipclanarine.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
//		for(TipClanarine t:tip) {
			String sb = t.getNaziv()+ ";"+ t.getId()+ ";"+t.getCena();
			writer.write(sb);
			writer.newLine();;
// 		}
		writer.close();
	}
	
	
	/**/
	
}


