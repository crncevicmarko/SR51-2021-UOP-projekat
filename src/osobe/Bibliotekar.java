package osobe;

public class Bibliotekar extends Zaposleni{
	public Bibliotekar() {
		super();
	}
	
	public Bibliotekar(String id, String ime, String prezime, String adresa, String JMBG, int plata,
			String korisnickoIme, String lozinka, Pol pol, boolean obrisan) {
		super(id, ime, prezime, adresa, JMBG, plata, korisnickoIme, lozinka, pol, obrisan);
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "\n\nBibliotekar: "+"\nId: " + id+"\nIme: " + ime+ "\nPrezime: " + prezime+ "\nAdresa: " + adresa+ "\nJMBG: " + JMBG+ "\nPlata: " + plata+ "\nKorisnicko ime: " + korisnickoIme+ "\nLozinka: " + lozinka+ "\nPol: " + pol+ "\nObrisan: " + obrisan;
			
		
	}
}
