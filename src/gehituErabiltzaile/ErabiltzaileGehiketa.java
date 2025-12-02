package gehituErabiltzaile;

import java.util.Scanner;

import pantailaPrintzipala.MenuPrintzipala;

public class ErabiltzaileGehiketa {

	public ErabiltzaileGehiketa() {
		erabiltzaileBerriaSortu();
	}

	private void erabiltzaileBerriaSortu() {
		Scanner sc = new Scanner(System.in);
		String erabiltzaileBerria, pasahitzaSortu, pasahitzaKonfirmazioa;

		do {
			System.out.println("Sartu erabiltzaile berriaren izena:");
			erabiltzaileBerria = sc.nextLine();

			System.out.println("Sartu sortzeko erabiltzailearen pasahitza:");
			pasahitzaSortu = sc.nextLine();

			System.out.println("Berridatzi pasahitza:");
			pasahitzaKonfirmazioa = sc.nextLine();

			if (pasahitzaSortu.equals(pasahitzaKonfirmazioa)) {
				System.out.println("Zure erabiltzailea ondo sortu da!");
			} else {
				System.out.println("Ez duzu ondo idatzi pasahitzak, mesedez saiatu berriro.");
			}
		} while (!(pasahitzaSortu.contains(pasahitzaKonfirmazioa)));
		new MenuPrintzipala();

		sc.close();

	}

}
