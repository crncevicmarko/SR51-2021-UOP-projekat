package projekatObjektno;

public abstract class Zaposleni extends Osoba{
	protected String korisnickoIme;
    protected String korisnickaSifra;
    protected String plata;
    protected boolean jeObrisan;
    protected Biblioteka biblioteka;

	public Zaposleni() {
		super();
		this.korisnickaSifra = "";
		this.korisnickoIme = "";
		this.plata = "";
		this.jeObrisan = false;
	}
	public Zaposleni(String id, String ime, String prezime, String jMBG, String adresa, EmnumPol pol,String korisnickaSifra,String korisnickoIme,String plata,boolean jeObrisan) {
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
	public String getPlata() {
		return plata;
	}
	public void setPlata(String plata) {
		this.plata = plata;
	}
	public boolean isJeObrisan() {
		return jeObrisan;
	}
	public void setJeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}
	public Biblioteka getBiblioteka() {
		return biblioteka;
	}
	public void setBiblioteka(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
	}
	@Override
	public String toString() {
		return id+ ";" + ime + ";" + prezime + ";" + JMBG + ";" + adresa + ";" + pol+";"+korisnickoIme + ";" + korisnickaSifra + ";" + plata + ";"+jeObrisan;
	}
	public void DodatiNoveClanove() {
//		Administrator administrator = new Administrator();
//		administrator.setIme(ime);
//		administrator.setPrezime(prezime);
//		administrator.setJMBG(jMBG);
//		administrator.setAdresa(adresa);
//		administrator.setPol(pol);
//		administrator.setKorisnickaSifra(korisnickaSifra);
//		administrator.setKorisnickoIme(korisnickoIme);
//		administrator.setPlata(plata);
//		administrator.setId(administrator.generisiIDAdmina());
//		administrator.setBiblioteka(biblioteka);
//		biblioteka.getAdmin().add(administrator);
//		biblioteka.upisiFajlAdministartor(biblioteka.getAdmin());
	}
    
    

}
