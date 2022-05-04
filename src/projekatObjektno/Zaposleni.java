package projekatObjektno;

public abstract class Zaposleni extends Osoba{
	protected String korisnickoIme;
    protected String korisnickaSifra;
    
    public Zaposleni() {
		super();
		this.korisnickaSifra = "";
		this.korisnickoIme = "";
	}
	public Zaposleni(String korisnickoIme, String korisnickaSifra) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.korisnickaSifra = korisnickaSifra;
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

	@Override
	public String toString() {
		return "Zaposleni [korisnickoIme=" + korisnickoIme + ", korisnickaSifra=" + korisnickaSifra + "]";
//	vrati se treba ju ti elementi iz Osoba da se upisu u toString
	}
	
	
    
    

}
