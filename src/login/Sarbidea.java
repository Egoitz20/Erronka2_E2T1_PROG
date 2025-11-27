package login;

import java.util.Scanner;

import pantailaPrintzipala.MenuPrintzipala;

public class Sarbidea {

	private boolean baDago(String[] iturria, String txekeatu) {
		for (int i = 0; i < iturria.length; ++i)
			if (iturria[i].equals(txekeatu))
				return true;
		return false;
	}

	public Sarbidea() {

		login();

	}

	private void login() {

		Scanner sc = new Scanner(System.in);

		String[] erabiltzailea = { "egoitz", "ane", "imanol", "zunbeltz" };
		String[] pasahitza = { "egoitz", "ane", "imanol", "zunbeltz" };

		String saiakeraErantzuna = "";
		int loginSaiakerak = 4;

		do {
			System.out.println("Erabiltzailea: ");
			String sartuErabiltzaile = sc.nextLine();
			sartuErabiltzaile = sartuErabiltzaile.toLowerCase();

			System.out.println("Pasahitza: ");
			String sartuPasahitza = sc.nextLine();
			sartuPasahitza = sartuPasahitza.toLowerCase();

			if (baDago(erabiltzailea, sartuErabiltzaile) && baDago(pasahitza, sartuPasahitza)) {
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
