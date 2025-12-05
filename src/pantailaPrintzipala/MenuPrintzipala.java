package pantailaPrintzipala;

import java.util.ArrayList;
import java.util.Scanner;

import datuBase.DatuBaseEguneraketa;
import datuBase.TaulaErabiltzaile;
import datuBaseKonexioa.kontsultak.DatuakBistaratu;
import gehituErabiltzaile.ErabiltzaileGehiketa;
import login.Sarbidea;
import xml.XmlSortu;

public class MenuPrintzipala {

	public MenuPrintzipala() {
		menuAukeraketa();
	}

	private void menuAukeraketa() {

		Scanner sc = new Scanner(System.in);
		int zenbakiAukera;

		do {

			System.out.println("1. Erabiltzailea gehitu");
			System.out.println("2. XML-a sortu");
			System.out.println("3. Datu-basea eguneratu");
			System.out.println("4. Datuak erakutsi");
			System.out.println("5. Irten");
			System.out.println();

			System.out.println("Non sartu nahi duzu?");
			zenbakiAukera = sc.nextInt();

			if (zenbakiAukera == 1) {
				sartuErabiltzaileGehiketa();
				break;
			} else if (zenbakiAukera == 2) {
				sartuXmlEgiteko();
				break;
			} else if (zenbakiAukera == 3) {
				sartuDatuBaseKonfigurazioa();
				break;
			} else if (zenbakiAukera == 4) {
				sartuDatuakErakusteko();
				break;
			} else if (zenbakiAukera == 5) {
				atzeraJoan();
				break;
			} else {
				System.out.println("Ez duzu ondo aukeratu zenbakia...");
				System.out.println("Mesedez, aukeratu berriro zenbakia :)");
			}

		} while (zenbakiAukera != 1 || zenbakiAukera != 2 || zenbakiAukera != 3 || zenbakiAukera != 4
				|| zenbakiAukera != 5);

		sc.close();
	}

	private void sartuErabiltzaileGehiketa() {
		new ErabiltzaileGehiketa();
	}

	private void sartuXmlEgiteko() {
		new XmlSortu();
	}

	private void sartuDatuBaseKonfigurazioa() {
		new DatuBaseEguneraketa();
	}

	private void sartuDatuakErakusteko() {
		DatuakBistaratu taulaErakutsi = new DatuakBistaratu();
		ArrayList<TaulaErabiltzaile> arrayInformazioa = taulaErakutsi.taulaBistaratu();
		
		for (TaulaErabiltzaile erregistroa : arrayInformazioa) {
			System.out.println(erregistroa.getIzena() + " " + erregistroa.getPasahitza());
		}
		
		
	}

	private void atzeraJoan() {
		new Sarbidea();
	}

}
