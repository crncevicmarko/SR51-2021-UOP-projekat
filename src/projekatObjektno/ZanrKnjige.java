package projekatObjektno;

//import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ZanrKnjige {
	protected String oznaka;
	protected String opis;

	public ZanrKnjige(String oznaka, String opis) {
		this.oznaka = oznaka;
		this.opis = opis;
	}
	
	public ZanrKnjige() {
		this.oznaka = "";
		this.opis = "";
	}
	public String getOznaka() {
		return oznaka;
	}
	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Override
	public String toString() {
		return oznaka + ";" + opis;
	}
	
//	public ArrayList<ZanrKnjige> citajFajl(String imeFajla) throws IOException{
//		ArrayList<ZanrKnjige> zanrknjige = new ArrayList<ZanrKnjige>();
//		File fajl = new File(imeFajla);
//		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
//		String line = null;
//		while((line = citaj.readLine())!= null) {
//			String [] niz = line.split(",");
//			String oznaka = niz[0];
//			String opis = niz[1];
//			ZanrKnjige zanr = new ZanrKnjige(oznaka,opis);
//			zanrknjige.add(zanr);
//			
//		}
//		citaj.close();
//		return zanrknjige;
//		
//	}
//	public static void upisiUZanr(ArrayList<ZanrKnjige> tipUpis, String imeFajla) throws IOException{
//		ArrayList<ZanrKnjige> zanr = tipUpis;
//		File file = new File(imeFajla);
//		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
//		for(ZanrKnjige z: zanr) {
//			String sb = z.getOpis()+ ";"+ z.getOznaka();
//			writer.write(sb);
//			writer.newLine();;
// 		}
//		writer.close();
//	
//	}
	
//	public void upisiUZanr(ZanrKnjige z) throws IOException{
////		ArrayList<ZanrKnjige> zanr = tipUpis;
//		File file = new File("src/projekatObjektno/zanrovi.txt");
//		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
////		for(ZanrKnjige z: zanr) {
//			String sb = z.getOpis()+ ";"+ z.getOznaka();
//			writer.write(sb);
//			writer.newLine();;
//// 		}
//		writer.close();
//	}
}
