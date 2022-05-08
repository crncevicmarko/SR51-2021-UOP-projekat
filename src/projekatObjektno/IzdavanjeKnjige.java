package projekatObjektno;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class IzdavanjeKnjige {
	 protected LocalDate datumIznajmljivanja;
	 protected LocalDate datumVracanja;
	 protected Zaposleni zaposleni;
	 protected ClanBiblioteke clan;
	 protected PrimerakKnjige primerak;
	 
	 
	public IzdavanjeKnjige(LocalDate datumIznajmljivanja, LocalDate datumVracanja, Zaposleni zaposleni,
			ClanBiblioteke clan, PrimerakKnjige primerak) {
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.primerak = primerak;
	}
	public IzdavanjeKnjige() {
		this.datumIznajmljivanja = null;
		this.datumVracanja= null;
		this.zaposleni = null; 
		this.clan = new ClanBiblioteke();
		this.primerak = new PrimerakKnjige();
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
	public PrimerakKnjige getPrimerak() {
		return primerak;
	}
	public void setPrimerak(PrimerakKnjige primerak) {
		this.primerak = primerak;
	}
	@Override
	public String toString() {
		return "IzdavanjeKnjige [datumIznajmljivanja=" + datumIznajmljivanja + ", datumVracanja=" + datumVracanja
				+ ", zaposleni=" + zaposleni + ", clan=" + clan + ", primerak=" + primerak + "]";
	}
	
	public ArrayList<IzdavanjeKnjige> citajFajl(String imeFajla) throws IOException{
		ArrayList<IzdavanjeKnjige> izdknjige = new ArrayList<IzdavanjeKnjige>();
		File fajl = new File(imeFajla);
		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
		String line = null;
		while((line = citaj.readLine())!= null) {
			String [] niz = line.split(",");
			LocalDate datumIznajmljivanja = LocalDate.parse(niz[0]);
			LocalDate datumVracanja = LocalDate.parse(niz[1]);
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
			
		}
		citaj.close();
		return izdknjige;
		
	}
	
	 
	 
}
