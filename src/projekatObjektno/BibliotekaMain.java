package projekatObjektno;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

public class BibliotekaMain {

	public static void main(String[] args) throws IOException{
		Biblioteka biblioteka = new Biblioteka("a","b","c",LocalDate.parse("2007-02-03"),LocalDate.parse("2008-05-05"),"d");
		biblioteka.citajZanroveIzFajla();
		biblioteka.citajKnjige();
//		try {
//			biblioteka.upisiFajl(biblioteka);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		ZanrKnjige zanr = new ZanrKnjige("novi id","hthtrh","rghtrhb",false);
//		System.out.println(biblioteka.zanrovi);
		Knjiga knjiga = new Knjiga("1","p","z","n",1,Jezik.ENGLESKI,"m",zanr,false);
//		Knjiga knjiga1 = new Knjiga("2","g","jg","n",1,Jezik.ENGLESKI,"m",zanr,false);
//		Knjiga knjiga1 = new Knjiga("2","p","z","n",1,Jezik.ENGLESKI,"m",biblioteka.zanrovi.get(0));
//		Knjiga knjiga2 = new Knjiga("3","p","z","n",1,Jezik.ENGLESKI,"m",biblioteka.zanrovi.get(0));
//		System.out.println(biblioteka.citajKnjige("src/projekatObjektno/knjige.txt"));
//		try {
//			biblioteka.upisiFajl(knjiga);
//			biblioteka.upisiFajl(knjiga1);
////			biblioteka.upisiFajl(knjiga1);
////			biblioteka.upisiFajl(knjiga2);
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		biblioteka.azurirajKnjigu("2");
		
//		za azuriranje
//		biblioteka.citajZanroveIzFajla("src/projekatObjektno/zanrovi.txt");
		biblioteka.citajKnjige();
		biblioteka.citajKnjige();
		biblioteka.citajKnjige();
		biblioteka.citajKnjige();
		biblioteka.citajKnjige();
		HashMap<String,String> parametri = new HashMap<>();
		parametri.put("pisac", "Ivo Andric");
		parametri.put("godinaObjavljanjaKnjige", "1980");
		parametri.put("naslovKnjige", "Robinzon Kruso");
		parametri.put("originalsniNaslovKnjige", "RobinKrus");
		parametri.put("jezikOriginala", "ENGLESKI");
		parametri.put("opisKnjige", "Ovo je opis Knjige");
		parametri.put("jeObrisana", "false");
		parametri.put("zanr", "promena3"); /*za objekat*/
		biblioteka.azurirajKnjigu("1", parametri); /*da znamo koju knjigu da menjamo*/
		biblioteka.obrisiKnjigu("2");
		biblioteka.upisiFajl(biblioteka.getKnjige());
		biblioteka.praviKnjigu("idNova", "NaslovNova", "OGnaslovKnjige", "Aristotel", 1980, Jezik.ENGLESKI, "OpisKnjige", zanr, false);
		

		Administrator admin = new Administrator("1","Zika","Zikic","8658568568568","ZikeZikica",EmnumPol.ZENSKI,"ZikaCAr123","ZikaZ",1121,false);
////		biblioteka.upisiFajlAdministartor(admin);
////		System.out.println(biblioteka.citajFajl("src/projekatObjektno/knjige.txt"));
		TipClanarine tip = new TipClanarine("nvjvr","nvjnvje",0,false);
////		biblioteka.upisiTipClanarine(tip);
		ClanBiblioteke clan = new ClanBiblioteke("1","Mika","Mikic","8658568568568","ZikeZikica",EmnumPol.ZENSKI,"vyvbi",LocalDate.parse("2009-02-03"),6,true,tip,false);
////		biblioteka.upisiFajlClanBiblioteke(clan);
		PrimerakKnjige primerak = new PrimerakKnjige("1", 2, true, 1990, false,knjiga,false);
////		biblioteka.upisiPrimerakKnjige(primerak);
		IzdavanjeKnjige izdavanje = new IzdavanjeKnjige(LocalDate.parse("2007-02-03"),LocalDate.parse("2007-02-03"),admin,clan,primerak,false);
//		biblioteka.upisiIzdavanjeKnjige(izdavanje);
//		biblioteka.citajAdministratora("src/projekatObjektno/administartor.txt");
//		System.out.println(biblioteka.getAdmin().get(0));
//		System.out.println(biblioteka.citajclanove("src/projekatObjektno/clanbiblioteke.txt"));
//		System.out.println(biblioteka.citajclanove("src/projekatObjektno/clanbiblioteke.txt"));
//		System.out.println(biblioteka.citajAdministratora("src/projekatObjektno/administartor.txt"));
	}
}
