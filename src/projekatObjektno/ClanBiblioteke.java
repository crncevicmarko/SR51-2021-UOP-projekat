package projekatObjektno;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClanBiblioteke extends Osoba{
	protected String brClankarte;/*String umesto int*/
    protected LocalDate datumPoslednjeUplate;
    protected int brojMeseciClanarine;
    protected boolean aktivan;
    protected TipClanarine tipClanarine;
    
    
	
	public ClanBiblioteke(String id, String ime, String prezime, String jMBG, String adresa, EmnumPol pol,
			String brClankarte, LocalDate datumPoslednjeUplate, int brojMeseciClanarine, boolean aktivan,
			TipClanarine tipClanarine) {
		super(id, ime, prezime, jMBG, adresa, pol);
		this.brClankarte = brClankarte;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojMeseciClanarine = brojMeseciClanarine;
		this.aktivan = aktivan;
		this.tipClanarine = tipClanarine;
	}
	
	public ClanBiblioteke() {
		super();
		this.brClankarte = "";
		this.datumPoslednjeUplate = null;
		this.brojMeseciClanarine = 0;
		this.aktivan = false;
		this.tipClanarine = null;
		
	}
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
	public boolean isAktivan() {
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
	
	public ArrayList<ClanBiblioteke> citajclanove(String fajlClanovi)throws IOException{
		ArrayList<ClanBiblioteke> clanovi = new ArrayList<ClanBiblioteke>();
		File claoviFile = new File(fajlClanovi);
		BufferedReader citanje = new BufferedReader(new FileReader(claoviFile));
		String line = null;
		while((line = citanje.readLine())!= null);{
			String[]nizClanova = line.split(",");
			String IDclana = nizClanova[0];
			String imeClana = nizClanova[1];
			String prezimeClana = nizClanova[2];
			String JMBGClana = nizClanova[3];
			String adresaClana = nizClanova[4];
			String polClana = nizClanova[5];
			EmnumPol defpol = EmnumPol.MUSKI;
			for(EmnumPol pol:EmnumPol.values()) {
				if(pol.name().equalsIgnoreCase(polClana)) {
					defpol = pol;
				}
			}
			int brClankarte  = Integer.parseInt(nizClanova[6]);
			LocalDate datumPoslednjeUplate = LocalDate.parse(nizClanova[7]);
			int brojMeseciClanarine = Integer.parseInt(nizClanova[8]);
			boolean aktivan = Boolean.parseBoolean(nizClanova[9]);
//			TipClanarine tipClanarine = new TipClanarine(nizClanova[10],Double.parseDouble(adresaClana));
//			ClanBiblioteke clan = new ClanBiblioteke(brClankarte,datumPoslednjeUplate,brojMeseciClanarine,aktivan, tipClanarine);
//			clanovi.add(clan);
			
		}
		citanje.close();
		return clanovi;
		
	}
	
	
	@Override
	public String toString() {
		return brClankarte + "," + datumPoslednjeUplate+ "," + brojMeseciClanarine + "," + aktivan + ","+ tipClanarine;
	}
    
    
    
	

}
