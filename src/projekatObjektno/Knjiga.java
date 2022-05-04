package projekatObjektno;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.lang.reflect.Array;
import java.util.ArrayList;

public class Knjiga {
	protected int id;
    protected String naslovKnjige;
    protected String originalsniNaslovKnjige;
    protected String pisac;
    protected int godinaObjavljanjaKnjige;
    protected Jezik jezikOriginala;
    protected String opisKnjige;
    protected ZanrKnjige zanr;
    protected ArrayList<PrimerakKnjige> sviPrimerci;
    
    
	public Knjiga(int id, String naslovKnjige, String originalsniNaslovKnjige, String pisac,
			int godinaObjavljanjaKnjige, Jezik jezikOriginala, String opisKnjige, ZanrKnjige zanr,
			ArrayList<PrimerakKnjige> sviPrimerci) {
		this.id = id;
		this.naslovKnjige = naslovKnjige;
		this.originalsniNaslovKnjige = originalsniNaslovKnjige;
		this.pisac = pisac;
		this.godinaObjavljanjaKnjige = godinaObjavljanjaKnjige;
		this.jezikOriginala = jezikOriginala;
		this.opisKnjige = opisKnjige;
		this.zanr = zanr;
		this.sviPrimerci = sviPrimerci;
	}
	
	public Knjiga() {
		super();
		this.id = 0;
		this.naslovKnjige = "";
		this.originalsniNaslovKnjige = "";
		this.pisac = "";
		this.godinaObjavljanjaKnjige = 0;
		this.jezikOriginala = null;
		this.opisKnjige = "";
		this.zanr = new ZanrKnjige();
		this.sviPrimerci = new ArrayList<>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaslovKnjige() {
		return naslovKnjige;
	}
	public void setNaslovKnjige(String naslovKnjige) {
		this.naslovKnjige = naslovKnjige;
	}
	public String getOriginalsniNaslovKnjige() {
		return originalsniNaslovKnjige;
	}
	public void setOriginalsniNaslovKnjige(String originalsniNaslovKnjige) {
		this.originalsniNaslovKnjige = originalsniNaslovKnjige;
	}
	public String getPisac() {
		return pisac;
	}
	public void setPisac(String pisac) {
		this.pisac = pisac;
	}
	public int getGodinaObjavljanjaKnjige() {
		return godinaObjavljanjaKnjige;
	}
	public void setGodinaObjavljanjaKnjige(int godinaObjavljanjaKnjige) {
		this.godinaObjavljanjaKnjige = godinaObjavljanjaKnjige;
	}
	public Jezik getJezikOriginala() {
		return jezikOriginala;
	}
	public void setJezikOriginala(Jezik jezikOriginala) {
		this.jezikOriginala = jezikOriginala;
	}
	public String getOpisKnjige() {
		return opisKnjige;
	}
	public void setOpisKnjige(String opisKnjige) {
		this.opisKnjige = opisKnjige;
	}
	public ZanrKnjige getZanr() {
		return zanr;
	}
	public void setZanr(ZanrKnjige zanr) {
		this.zanr = zanr;
	}
	public ArrayList<PrimerakKnjige> getSviPrimerci() {
		return sviPrimerci;
	}
	public void setSviPrimerci(ArrayList<PrimerakKnjige> sviPrimerci) {
		this.sviPrimerci = sviPrimerci;
	}
	@Override
	public String toString() {
		return "Knjiga [id=" + id + ", naslovKnjige=" + naslovKnjige + ", originalsniNaslovKnjige="
				+ originalsniNaslovKnjige + ", pisac=" + pisac + ", godinaObjavljanjaKnjige=" + godinaObjavljanjaKnjige
				+ ", jezikOriginala=" + jezikOriginala + ", opisKnjige=" + opisKnjige + "]";
	}
    
	public ArrayList<Knjiga> citajFajl(String imeFajla) throws IOException{
		ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
		File fajl = new File(imeFajla);
		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
		String line = null;
		while((line = citaj.readLine())!= null) {
			String [] niz = line.split(",");
			String naslovKnjige = niz[0];
			String originalsniNaslovKnjige = niz[1];
			String pisac = niz[2];
			int godinaObjavljanjaKnjige = Integer.parseInt(niz[3]);
			String jezikOroginala = niz[4];
			Jezik jezikOriginala = Jezik.ENGLESKI;
			for (Jezik j: Jezik.values()) {
				if(j.name().equalsIgnoreCase(jezikOroginala)){
					jezikOriginala = j;
				}
			}
			String opis = niz[5];
			ZanrKnjige zanr = new ZanrKnjige(opis,niz[6]);
			Knjiga knjiga = new Knjiga( id, naslovKnjige,originalsniNaslovKnjige,pisac,godinaObjavljanjaKnjige,jezikOriginala, opisKnjige,zanr,sviPrimerci);
			knjige.add(knjiga);
			
		}
		citaj.close();
		return null;
		
	}
	public static void upisiFajl(ArrayList<Knjiga> kjnigeUpis, String imeFajla) throws IOException{
		ArrayList<Knjiga> knjige = kjnigeUpis;
		File file = new File(imeFajla);
		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
		for (Knjiga k: knjige) {
			String sb = k.getNaslovKnjige() +";"+ k.getGodinaObjavljanjaKnjige() +";"+ k.getOpisKnjige() + ";"+k.getPisac()+ ";"+k.getOriginalsniNaslovKnjige() +";" +k.getJezikOriginala() +";"+k.getSviPrimerci()+";"+k.getId()+";"+k.getZanr();
			writer.write(sb);
			writer.newLine();
		}
		writer.close();
		
	}
    

}
