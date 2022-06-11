package projekatObjektno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class Administrator extends Zaposleni {
//	protected ArrayList<Administrator> admin;
//	protected Biblioteka biblioteka;
	
//	public Administrator() {
//		super();
//	}
//
//	public Administrator(String id, String ime, String prezime, String jMBG, String adresa, EmnumPol pol,
//			String korisnickaSifra, String korisnickoIme,String plata,boolean jeObrisan) {
//		super(id, ime, prezime, jMBG, adresa, pol, korisnickaSifra,korisnickoIme, plata,jeObrisan);
//	}
	
	public Administrator() {
		super();
	}

	public Administrator(String id, String ime, String prezime, String jMBG, String adresa, EmnumPol pol,
			String korisnickaSifra, String korisnickoIme, String plata, boolean jeObrisan) {
		super(id, ime, prezime, jMBG, adresa, pol, korisnickaSifra, korisnickoIme, plata, jeObrisan);
	}
	

	@Override
	public String toString() {
		return  id+ ";" + ime + ";" + prezime + ";" + JMBG + ";" + adresa + ";" + pol+ ";" + korisnickaSifra + ";" + korisnickoIme + ";"+ plata+";"+jeObrisan;
	}
	
	
//	String adresa, String id, String naziv, String telefon, LocalDate otvaranje, LocalDate zatvaranje
	
	
	
//	public ArrayList<Administrator> citajAdministratora(String imeFajla) throws IOException{
//		ArrayList<Administrator> administartor = new ArrayList<Administrator>();
//		File fajl = new File(imeFajla);
//		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
//		String line = null;
//		while((line = citaj.readLine())!= null) {
//			String [] niz = line.split(";");
//			String id = niz[0];
//			String ime = niz[1];
//			String prezime = niz[2];
//			String JMBG = niz[3];
//			String adresa = niz[4];
//			String defpol1 = niz[5];
//			EmnumPol defpol = EmnumPol.MUSKI;
//			for(EmnumPol p:EmnumPol.values()) {
//				if(p.name().equalsIgnoreCase(defpol1)){
//					defpol = p;
//				}
//			}
//			String korisnickaSifra = niz[6];
//			String korisnickoIme = niz[7];
//			Administrator admin = new Administrator(id,ime,prezime,JMBG,adresa,defpol,korisnickaSifra,korisnickoIme);
//			administartor.add(admin);
//			}
//		citaj.close();
//		return administartor;	
//	}
//	public void upisiFajlAdministartor(Administrator a) throws IOException{
////		ArrayList<Knjiga> knjige = kjnigeUpis;
//		File file = new File("src/projekatObjektno/administartor.txt");
//		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
////		for (Knjiga k: knjige) {
//			String sb = a.getId() +";"+ a.getIme() + ";"+a.getPrezime()+ ";"+a.getJMBG() +";"+ a.getAdresa()+ ";" +a.getPol() +";"+a.getKorisnickaSifra()+";"+a.getKorisnickoIme();
//			writer.write(sb);
//			writer.newLine();
////		}
//		writer.close();
//		
//	}
	
}


