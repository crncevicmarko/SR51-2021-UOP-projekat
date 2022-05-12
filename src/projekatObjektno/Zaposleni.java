package projekatObjektno;

public abstract class Zaposleni extends Osoba{
	protected String korisnickoIme;
    protected String korisnickaSifra;
    protected double plata;
    

	public Zaposleni() {
		super();
		this.korisnickaSifra = "";
		this.korisnickoIme = "";
		this.plata = 0;
		
		
	}
	public Zaposleni(String id, String ime, String prezime, String jMBG, String adresa, EmnumPol pol,String korisnickaSifra,String korisnickoIme,double plata) {
		super(id, ime, prezime, jMBG, adresa, pol);
		this.korisnickaSifra = korisnickaSifra;
		this.korisnickoIme = korisnickoIme;
		this.plata = plata;
	
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getKorisnickaSifra() {
		return korisnickaSifra;
	}
	public void setKorisnickaSifra(String korisnickaSifra) {
		this.korisnickaSifra = korisnickaSifra;
	}
	
	public double getPlata() {
		return plata;
	}
	public void setPlata(double plata) {
		this.plata = plata;
	}
	@Override
	public String toString() {
		return id+ ";" + ime + ";" + prezime + ";" + JMBG + ";" + adresa + ";" + pol+";"+korisnickoIme + ";" + korisnickaSifra + ";" + plata ;
	}
	public void DodatiNoveClanove() {
		
	}
    
    

}
