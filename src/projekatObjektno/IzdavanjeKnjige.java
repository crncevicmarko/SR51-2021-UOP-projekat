package projekatObjektno;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class IzdavanjeKnjige {
	 protected String id;
	 protected LocalDate datumIznajmljivanja;
	 protected LocalDate datumVracanja;
	 protected Zaposleni zaposleni;
	 protected ClanBiblioteke clan;
//	 protected ArrayList<PrimerakKnjige> primerak;
	 protected PrimerakKnjige primerak;
	 protected boolean jeObrisan;
	 
	 
	public IzdavanjeKnjige(String id,LocalDate datumIznajmljivanja, LocalDate datumVracanja, Zaposleni zaposleni,
			ClanBiblioteke clan, /*ArrayList<PrimerakKnjige>*/ PrimerakKnjige primerak,boolean jeObrisan) {
		this.id = id;
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.primerak = primerak;
		this.jeObrisan = jeObrisan;
	}
	public IzdavanjeKnjige() {
		this.id = "";
		this.datumIznajmljivanja = null;
		this.datumVracanja= null;
		this.zaposleni = null; 
		this.clan = null;
//		this.primerak = new ArrayList<PrimerakKnjige>();
		this.primerak = null;
		this.jeObrisan = false;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDate getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}
	public void setDatumIznajmljivanja(LocalDate datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}
	public LocalDate getDatumVracanja() {
		return datumVracanja;
	}
	public void setDatumVracanja(LocalDate datumVracanja) {
		this.datumVracanja = datumVracanja;
	}
	public Zaposleni getZaposleni() {
		return zaposleni;
	}
	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}
	public ClanBiblioteke getClan() {
		return clan;
	}
	public void setClan(ClanBiblioteke clan) {
		this.clan = clan;
	}
//	public ArrayList<PrimerakKnjige> getPrimerak() {
//		return primerak;
//	}
//	public void setPrimerak(ArrayList<PrimerakKnjige> primerak) {
//		this.primerak = primerak;
//	}
	
	public boolean isJeObrisan() {
		return jeObrisan;
	}
	public PrimerakKnjige getPrimerak() {
		return primerak;
	}
	public void setPrimerak(PrimerakKnjige primerak) {
		this.primerak = primerak;
	}
	public void setJeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}
	
	@Override
	public String toString() {
		return /*id+";"+*/datumIznajmljivanja + ";" + datumVracanja+ ";" + zaposleni + ";" + clan + ";" + primerak + ";" + jeObrisan;
	}
//	
//	public ArrayList<IzdavanjeKnjige> citajFajl(String imeFajla) throws IOException{
//		ArrayList<IzdavanjeKnjige> izdknjige = new ArrayList<IzdavanjeKnjige>();
//		File fajl = new File(imeFajla);
//		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
//		String line = null;
//		while((line = citaj.readLine())!= null) {
//			String [] niz = line.split(",");
//			LocalDate datumIznajmljivanja = LocalDate.parse(niz[0]);
//			LocalDate datumVracanja = LocalDate.parse(niz[1]);
//			String id = niz[0];
//			String ime = niz[1];
//			String prezime = niz[2];
//			String jMBG = niz[3];
//			String adresa = niz[4];
//			EmnumPol defpol = EmnumPol.MUSKI;
//			for(EmnumPol pol:EmnumPol.values()) {
//				if(pol.name().equalsIgnoreCase(polClana)) {
//					defpol = pol; 
//				}
//			Zaposleni zaposleni = new Zaposleni(id,ime,prezime,jMBG,adresa,pol,korisnickaSifra,korisnickoIme);
//			
//		}
//		citaj.close();
//		return izdknjige;
//		
//	}
	
	 
	 
}
