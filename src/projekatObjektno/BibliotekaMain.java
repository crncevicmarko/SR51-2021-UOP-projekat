package projekatObjektno;

import java.io.IOException;
import java.time.LocalDate;

public class BibliotekaMain {

	public static void main(String[] args) throws IOException{
		Biblioteka biblioteka = new Biblioteka("a","b","c",LocalDate.parse("2007-02-03"),LocalDate.parse("2008-05-05"),"d");
//		try {
//			biblioteka.upisiFajl(biblioteka);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(biblioteka.zanrovi);
		Knjiga knjiga = new Knjiga("n","p","z","n",1,Jezik.ENGLESKI,"m",biblioteka.zanrovi.get(0));
//		try {
//			biblioteka.upisiKnjigeUFajl(knjiga);
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		System.out.println(biblioteka.citajFajl("src/projekatObjektno/knjige.txt"));
	}
}
