package projekatObjektno;

public abstract class Zaposleni extends Osoba{
	protected String korisnickoIme;
    protected String korisnickaSifra;
    protected double plata;
    protected boolean jeObrisan;
    

	public Zaposleni() {
		super();
		this.korisnickaSifra = "";
		this.korisnickoIme = "";
		this.plata = 0;
		this.jeObrisan = false;
		
		
	}
	public Zaposleni(String id, String ime, String prezime, String jMBG, String adresa, EmnumPol pol,String korisnickaSifra,String korisnickoIme,double plata,boolean jeObrisan) {
		super(id, ime, prezime, jMBG, adresa, pol);
		this.korisnickaSifra = korisnickaSifra;
		this.korisnickoIme = korisnickoIme;
		this.plata = plata;
		this.jeObrisan = jeObrisan;
	
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
	public boolean isJeObrisan() {
		return jeObrisan;
	}
	public void setJeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}
	@Override
	public String toString() {
		return id+ ";" + ime + ";" + prezime + ";" + JMBG + ";" + adresa + ";" + pol+";"+korisnickoIme + ";" + korisnickaSifra + ";" + plata + ";"+jeObrisan;
	}
	public void DodatiNoveClanove() {
		
	}
    
    

}
