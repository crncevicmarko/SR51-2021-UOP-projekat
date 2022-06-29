package main;

import java.io.IOException;
import java.util.ArrayList;

import biblioteka.Biblioteka;
import guiFormeZaDodavanjeIIzmenu.AddKnjige;
import guiLogIPocetnaStrana.Login;
import osobe.Bibliotekar;
import osobe.Admin;
import osobe.Clan;
import osobe.Pol;
import osobe.TipClanarine;

public class Main {
	public static void main(String[] args) throws IOException {
		Biblioteka biblioteka = new Biblioteka();
		biblioteka.citajBiblioteku();
		biblioteka.citajClanarine();
//		biblioteka.proveriAktivnost(PATH_TO_CLANOVI);
		biblioteka.citajClanove();
		biblioteka.citajAdministratora();
		biblioteka.citajBibliotekare();
		biblioteka.citajZanroveIzFajla();
		biblioteka.citajKnjige();
		biblioteka.citajPrimerke();
		biblioteka.citajIzdavanjeKnjige();
//		biblioteka.proveriAktivnost(PATH_TO_CLANOVI);
		Login loginProzor= new Login(biblioteka);
		loginProzor.setVisible(true);
//		addKnjige prozor=new addKnjige(biblioteka);
//		prozor.setVisible(true);
}

		
}
