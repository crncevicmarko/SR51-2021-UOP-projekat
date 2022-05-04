package projekatObjektno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TipClanarine {
	protected int id;
    protected String naziv;
    protected double cena;
    
    
	public TipClanarine(int id, String naziv, double cena) {
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
	}
	
	public TipClanarine() {
		this.id = 0;
		this.naziv = "";
		this.cena = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	@Override
	public String toString() {
		return id + "," + naziv + "," + cena;
	}
	
	public static ArrayList<TipClanarine>  citajClanarine(String fajlClanovi) throws IOException{
		ArrayList<TipClanarine> tipClanarine = new ArrayList<TipClanarine>();
		File file = new File(fajlClanovi);
		BufferedReader citanje = new BufferedReader(new FileReader(file));
		String line1 = null;
		while((line1 = citanje.readLine())!= null) {
			String[]nizClanova = line1.split(",");
			int id = Integer.parseInt(nizClanova[0]);
			String naziv = nizClanova[1];
			double cena = Double.parseDouble(nizClanova[2]);
			TipClanarine tip = new TipClanarine(id,naziv,cena);
			tipClanarine.add(tip);
		}
		citanje.close();
		return null;
		
	}
	public static void upisiFajl(ArrayList<TipClanarine> tipUpis, String imeFajla) throws IOException{
		ArrayList<TipClanarine> tip = tipUpis;
		File file = new File(imeFajla);
		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
		for(TipClanarine t:tip) {
			String sb = t.getNaziv()+ ";"+ t.getId()+ ";"+t.getCena();
			writer.write(sb);
			writer.newLine();;
 		}
		writer.close();
		
	}
    
}
