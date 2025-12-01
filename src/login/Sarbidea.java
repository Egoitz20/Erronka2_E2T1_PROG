package login;

import java.util.Scanner;

import datuBaseKonexioa.kontsultak.ErabiltzaileOnarpenaLiburutegi;
import pantailaPrintzipala.MenuPrintzipala;

public class Sarbidea {

	public Sarbidea() {

		login();

	}

	private void login() {

		Scanner sc = new Scanner(System.in);

		String saiakeraErantzuna = "";
		int loginSaiakerak = 4;

		ErabiltzaileOnarpenaLiburutegi onarpena = new ErabiltzaileOnarpenaLiburutegi();

		do {
			System.out.println("Erabiltzailea: ");
			String sartuErabiltzaile = sc.nextLine();
			sartuErabiltzaile = sartuErabiltzaile.toLowerCase();

			System.out.println("Pasahitza: ");
			String sartuPasahitza = sc.nextLine();
			sartuPasahitza = sartuPasahitza.toLowerCase();

			if (onarpena.erabiltzaileOnarpena(sartuErabiltzaile, sartuPasahitza)) {
				new MenuPrintzipala();
			}

			else {
				loginSaiakerak--;
				if (loginSaiakerak == 0) {
					System.out.println("Saikereen muga heldu zara...");
					System.out.println("Programa ixten...");
					System.exit(0);
				} else {
					System.out.println("Oraindik geratzen zaizu: " + loginSaiakerak + " saikerak.");
					System.out.println("Berriro saiatu nahi duzu? Bai / Ez");
					saiakeraErantzuna = sc.nextLine();
					saiakeraErantzuna = saiakeraErantzuna.toUpperCase();
				}

			}
		} while (saiakeraErantzuna.equals("BAI"));

		sc.close();
	}

}
