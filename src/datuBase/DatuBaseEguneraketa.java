package datuBase;

import java.util.Scanner;

import datuBaseKonexioa.alters.EremuaGehitu;
import datuBaseKonexioa.update.TaulaEguneratu;

public class DatuBaseEguneraketa {

	public DatuBaseEguneraketa() {
		menuDatuBase();
	}

	private void menuDatuBase() {
		Scanner sc = new Scanner(System.in);
		int aukeratu;
		
		do {
			System.out.println("1. Eremua gehitu");
			System.out.println("2. Taula eguneratu");

			System.out.println("Non sartu nahi duzu?");

			aukeratu = sc.nextInt();

			if (aukeratu == 1) {
				sartuEremuaGehitu();
				break;
			} else if (aukeratu == 2) {
				sartuTaulaEguneratu();
				break;
			} else {
				System.out.println("Ez dago aukera hori, mesedez saiatu berriro");
			}
		} while (aukeratu != 1 || aukeratu != 2);

		sc.close();
	}

	private void sartuEremuaGehitu() {
		new EremuaGehitu().sortuSoldataEremua();
	}

	private void sartuTaulaEguneratu() {
		new TaulaEguneratu().bulegariSoldata();;
	}

}
