package projekatObjektno;

import java.io.IOException;
import java.time.LocalDate;

public class BibliotekaMain {

	public static void main(String[] args) throws IOException{
		Biblioteka biblioteka = new Biblioteka("a","b","c",LocalDate.parse("2007-02-03"),LocalDate.parse("2008-05-05"),"d");
//		try {
//			biblioteka.upisiFajl(biblioteka);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		ZanrKnjige zanr = new ZanrKnjige("1","hthtrh","rghtrhb");
//		System.out.println(biblioteka.zanrovi);
		Knjiga knjiga = new Knjiga("1","p","z","n",1,Jezik.ENGLESKI,"m",zanr);
//		Knjiga knjiga1 = new Knjiga("2","p","z","n",1,Jezik.ENGLESKI,"m",biblioteka.zanrovi.get(0));
//		Knjiga knjiga2 = new Knjiga("3","p","z","n",1,Jezik.ENGLESKI,"m",biblioteka.zanrovi.get(0));
//		try {
			biblioteka.upisiFajl(knjiga);
////			biblioteka.upisiFajl(knjiga1);
////			biblioteka.upisiFajl(knjiga2);
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		biblioteka.azurirajKnjigu("2");
//		
//		Administrator admin = new Administrator("1","Zika","Zikic","8658568568568","ZikeZikica",EmnumPol.ZENSKI,"ZikaCAr123","ZikaZ");
////		biblioteka.upisiFajlAdministartor(admin);
////		System.out.println(biblioteka.citajFajl("src/projekatObjektno/knjige.txt"));
//		TipClanarine tip = new TipClanarine("nvjvr","nvjnvje",0);
////		biblioteka.upisiTipClanarine(tip);
//		ClanBiblioteke clan = new ClanBiblioteke("1","Mika","Mikic","8658568568568","ZikeZikica",EmnumPol.ZENSKI,"vyvbi",LocalDate.parse("2009-02-03"),6,true,tip);
////		biblioteka.upisiFajlClanBiblioteke(clan);
//		PrimerakKnjige primerak = new PrimerakKnjige("1", 2, true, 1990, false,knjiga);
////		biblioteka.upisiPrimerakKnjige(primerak);
//		IzdavanjeKnjige izdavanje = new IzdavanjeKnjige(LocalDate.parse("2007-02-03"),LocalDate.parse("2007-02-03"),admin,clan,primerak);
//		biblioteka.upisiIzdavanjeKnjige(izdavanje);
//		System.out.println(biblioteka.citajclanove("src/projekatObjektno/clanbiblioteke.txt"));
//		System.out.println(biblioteka.citajclanove("src/projekatObjektno/clanbiblioteke.txt"));
//		System.out.println(biblioteka.citajAdministratora("src/projekatObjektno/administartor.txt"));
	}
}
