package projekatObjektno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Bibliotekar extends Zaposleni {

//	public Bibliotekar() {
//		super();
//	}
//	public Bibliotekar(String id, String ime, String prezime, String jMBG, String adresa, EmnumPol pol,
//			String korisnickaSifra, String korisnickoIme,double plata,boolean jeObrisan) {
//		super(id, ime, prezime, jMBG, adresa, pol, korisnickaSifra, korisnickoIme,plata,jeObrisan);
//	}
	
	public Bibliotekar() {
		super();
	}


	public Bibliotekar(String id, String ime, String prezime, String jMBG, String adresa, EmnumPol pol,
			String korisnickaSifra, String korisnickoIme, String plata, boolean jeObrisan) {
		super(id, ime, prezime, jMBG, adresa, pol, korisnickaSifra, korisnickoIme, plata, jeObrisan);
	}

	
//	public ArrayList<Bibliotekar> citajBibliotekara(String imeFajla) throws IOException{
//		ArrayList<Bibliotekar> bibliotekar = new ArrayList<Bibliotekar>();
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
//			Bibliotekar bibl = new Bibliotekar(id,ime,prezime,JMBG,adresa,defpol,korisnickaSifra,korisnickoIme);
//			bibliotekar.add(bibl);
//			}
//		citaj.close();
//		return bibliotekar;	
//	}
//	public void upisiFajlBibliotekar(Bibliotekar b) throws IOException{
////		ArrayList<Knjiga> knjige = kjnigeUpis;
//		File file = new File("src/projekatObjektno/administartor.txt");
//		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
////		for (Knjiga k: knjige) {
//			String sb = b.getId() +";"+ b.getIme() + ";"+b.getPrezime()+ ";"+b.getJMBG() +";"+ b.getAdresa()+ ";" +b.getPol() +";"+b.getKorisnickaSifra()+";"+b.getKorisnickoIme();
//			writer.write(sb);
//			writer.newLine();
////		}
//		writer.close();
//		
//	}
	
	@Override
	public String toString() {
		return  id+ ";" + ime + ";" + prezime + ";" + JMBG + ";" + adresa + ";" + pol+ ";" + korisnickaSifra + ";" + korisnickoIme + ";" + plata+";"+jeObrisan ;
	}


	public String generisiIDBibliotekara() {
		String idBibliotekara = "B-";
		for(int i=0;i<6;i++) {
			int broj = (int)Math.floor(Math.random()*9);
			idBibliotekara += Integer.toString(broj);
		}
		return idBibliotekara;
	}
	}
	

