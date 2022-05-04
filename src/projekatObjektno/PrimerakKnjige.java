package projekatObjektno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PrimerakKnjige {
	protected int id;
    protected int brStrana;
    protected boolean tipPoveza;
    protected int godinaStampanja;
    protected boolean jeliIznajmljena;
    protected Knjiga knjiga;
    
    
	public PrimerakKnjige(int id, int brStrana, boolean tipPoveza, int godinaStampanja, boolean jeliIznajmljena,
			Knjiga knjiga) {
		this.id = id;
		this.brStrana = brStrana;
		this.tipPoveza = tipPoveza;
		this.godinaStampanja = godinaStampanja;
		this.jeliIznajmljena = jeliIznajmljena;
		this.knjiga = knjiga;
	}
	
	public PrimerakKnjige() {
		this.id = 0;
		this.brStrana = 0;
		this.tipPoveza = false;
		this.godinaStampanja = 0;
		this.jeliIznajmljena = false;
		this.knjiga = new Knjiga();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBrStrana() {
		return brStrana;
	}
	public void setBrStrana(int brStrana) {
		this.brStrana = brStrana;
	}
	public boolean isTipPoveza() {
		return tipPoveza;
	}
	public void setTipPoveza(boolean tipPoveza) {
		this.tipPoveza = tipPoveza;
	}
	public int getGodinaStampanja() {
		return godinaStampanja;
	}
	public void setGodinaStampanja(int godinaStampanja) {
		this.godinaStampanja = godinaStampanja;
	}
	public boolean isJeliIznajmljena() {
		return jeliIznajmljena;
	}
	public void setJeliIznajmljena(boolean jeliIznajmljena) {
		this.jeliIznajmljena = jeliIznajmljena;
	}
	public Knjiga getKnjiga() {
		return knjiga;
	}
	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	@Override
	public String toString() {
		return "PrimerakKnjige [id=" + id + ", brStrana=" + brStrana + ", tipPoveza=" + tipPoveza + ", godinaStampanja="
				+ godinaStampanja + ", jeliIznajmljena=" + jeliIznajmljena+ "]";
	}
	
	public ArrayList<PrimerakKnjige> citajFajl(String imeFajla) throws IOException{
		ArrayList<PrimerakKnjige> knjige = new ArrayList<PrimerakKnjige>();
		File fajl = new File(imeFajla);
		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
		String line = null;
		while((line = citaj.readLine())!= null) {
			String [] niz = line.split(",");
			int id  = Integer.parseInt(niz[0]);
			int brStrana = Integer.parseInt(niz[1]);
			boolean tipPoveza= Boolean.parseBoolean(niz[2]);
			int godinaStampanja = Integer.parseInt(niz[3]);
			boolean jeliIznajmljena = Boolean.parseBoolean(niz[4]);
//			Knjiga knjiga = new Knjiga(opis,niz[5]);
			PrimerakKnjige primerak = new PrimerakKnjige(id,brStrana,tipPoveza,godinaStampanja,jeliIznajmljena,knjiga);
			knjige.add(primerak);	
		}
		citaj.close();
		return null;
    
	
	}
	public static void upisiFajl(ArrayList<PrimerakKnjige> tipUpis, String imeFajla) throws IOException{
		ArrayList<PrimerakKnjige> primerak = tipUpis;
		File file = new File(imeFajla);
		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
		for(PrimerakKnjige p: primerak) {
			String pr = p.getBrStrana()+ ";"+ p.getGodinaStampanja()+";"+p.getId()+";"+p.getKnjiga();
			writer.write(pr);
			writer.newLine();;
 		}
		writer.close();
	
	}
}
