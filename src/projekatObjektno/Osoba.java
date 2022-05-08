package projekatObjektno;

public abstract class Osoba {
	protected String id;
    protected String ime;
    protected String prezime;
    protected String JMBG;
    protected String adresa;
    protected EmnumPol pol;
    
    
	public Osoba(String id, String ime, String prezime, String jMBG, String adresa, EmnumPol pol) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		JMBG = jMBG;
		this.adresa = adresa;
		this.pol = pol;
	}
	public Osoba() {
		this.id = "" ;
		this.ime = "";
		this.prezime = "";
		this.JMBG = "";
		this.adresa = "";
		this.pol = null;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getJMBG() {
		return JMBG;
	}
	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public EmnumPol getPol() {
		return pol;
	}
	public void setPol(EmnumPol pol) {
		this.pol = pol;
	}
    
    
	
	
    
    
}
