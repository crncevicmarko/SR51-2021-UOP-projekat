package projekatObjektno;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClanBiblioteke extends Osoba{
	protected String brClankarte;
    protected LocalDate datumPoslednjeUplate;
    protected int brojMeseciClanarine;
    protected boolean aktivan;
    protected TipClanarine tipClanarine;
    protected boolean jeObrisan;
   
	public ClanBiblioteke(String id, String ime, String prezime, String jMBG, String adresa, EmnumPol pol,
			String brClankarte, LocalDate datumPoslednjeUplate, int brojMeseciClanarine, boolean aktivan,
			TipClanarine tipClanarine,boolean jeObrisan) {
		super(id, ime, prezime, jMBG, adresa, pol);
		this.brClankarte = brClankarte;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojMeseciClanarine = brojMeseciClanarine;
		this.aktivan = aktivan;
		this.tipClanarine = tipClanarine;
		this.jeObrisan = jeObrisan;
	}
	
	public ClanBiblioteke() {
		super();
		this.brClankarte = "";
		this.datumPoslednjeUplate = null;
		this.brojMeseciClanarine = 0;
		this.aktivan = false;
		this.tipClanarine = null;
		this.jeObrisan = false;
	}
//	public ClanBiblioteke(String id, String ime, String prezime, String jMBG, String adresa, EmnumPol defpol,
//			int brClankarte2, LocalDate datumPoslednjeUplate2, int brojMeseciClanarine2, boolean aktivan2,
//			TipClanarine tip) {
//	}

	public String getBrClankarte() {
		return brClankarte;
	}
	public void setBrClankarte(String brClankarte) {
		this.brClankarte = brClankarte;
	}
	public LocalDate getDatumPoslednjeUplate() {
		return datumPoslednjeUplate;
	}
	public void setDatumPoslednjeUplate(LocalDate datumPoslednjeUplate) {
		this.datumPoslednjeUplate = datumPoslednjeUplate;
	}
	public int getBrojMeseciClanarine() {
		return brojMeseciClanarine;
	}
	public void setBrojMeseciClanarine(int brojMeseciClanarine) {
		this.brojMeseciClanarine = brojMeseciClanarine;
	}
	public boolean getAktivan() {
		return aktivan;
	}
	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
	public TipClanarine getTipClanarine() {
		return tipClanarine;
	}
	public void setTipClanarine(TipClanarine tipClanarine) {
		this.tipClanarine = tipClanarine;
	}
	public boolean isJeObrisan() {
		return jeObrisan;
	}
	public void setJeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}
	
//	public ArrayList<ClanBiblioteke> citajclanove(String fajlClanovi)throws IOException{
//		ArrayList<ClanBiblioteke> clanovi = new ArrayList<ClanBiblioteke>();
//		File claoviFile = new File(fajlClanovi);
//		BufferedReader citanje = new BufferedReader(new FileReader(claoviFile));
//		String line = null;
//		while((line = citanje.readLine())!= null);{
//			String[]nizClanova = line.split(",");
//			String id = nizClanova[0];
//			String ime = nizClanova[1];
//			String prezime = nizClanova[2];
//			String JMBG = nizClanova[3];
//			String adresa = nizClanova[4];
//			String polClana = nizClanova[5];
//			EmnumPol defpol = EmnumPol.MUSKI;
//			for(EmnumPol pol:EmnumPol.values()) {
//				if(pol.name().equalsIgnoreCase(polClana)) {
//					defpol = pol;
//				}
//			}
//			int brClankarte  = Integer.parseInt(nizClanova[6]);
//			LocalDate datumPoslednjeUplate = LocalDate.parse(nizClanova[7]);
//			int brojMeseciClanarine = Integer.parseInt(nizClanova[8]);
//			boolean aktivan = Boolean.parseBoolean(nizClanova[9]);
//			TipClanarine tip = tipClanarine.get(1);
//			ClanBiblioteke clan = new ClanBiblioteke(id,ime,prezime,JMBG,adresa,defpol,brClankarte,datumPoslednjeUplate,brojMeseciClanarine,aktivan,tip);
//			clanovi.add(clan);
//			
//		}
//		citanje.close();
//		return clanovi;
//	}
//	public void upisiFajlClanBiblioteke(ClanBiblioteke c) throws IOException{
////	ArrayList<Knjiga> knjige = kjnigeUpis;
//	File file = new File("src/projekatObjektno/administartor.txt");
//	BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
////	for (Knjiga k: knjige) {
//		String sb = c.getId() +";"+ c.getIme() + ";"+c.getPrezime()+ ";"+c.getJMBG() +";"+ c.getAdresa()+ ";" +c.getPol() +";"+c.getBrClankarte()+";"+c.getDatumPoslednjeUplate()+";"+c.getBrojMeseciClanarine()+";"+c.getTipClanarine()+ ";"+c.getAktivan()+";"+c.getTipClanarine();
//		writer.write(sb);
//		writer.newLine();
////	}
//	writer.close();
//	
//}

	@Override
	public String toString() {
		return id+";"+ime+";"+prezime+";"+JMBG+";"+adresa+";"+pol+";"+brClankarte+";"+datumPoslednjeUplate+";"+ brojMeseciClanarine+";"+aktivan+";"+tipClanarine+";"+jeObrisan;
	}
	


	
	
	

    
    
    
	

}
