package datuBaseKonexioa.kontsultak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datuBaseKonexioa.Konexioa;

public class ErabiltzaileGehiketaLiburutegia {

	private static final String ERABILTZAILE_GEHIKETA = "INSERT INTO ERABILTZAILEAK (ID, IZENA, PASAHITZA) VALUES (?, ?, ?)";

	public ErabiltzaileGehiketaLiburutegia() {

	}

	public void gehituErabiltzaile(String izena, String pasahitza) {
		Konexioa db = new Konexioa(); // Datu Base objektua deitzen da, baina momentuz ez du ezer egiten.
		Connection konexioa = null; // Datu Base konexioa deklaratzen da, baina oraindik ez dago deitzen datu basera
		PreparedStatement stmt = null; // Kontsulta egiteko erabiltzen da, baina oraindik bakarrik deklaratzen da.

		try {
			konexioa = db.konexioaBd();
			// Zenbat ilara itzultzen du.
			stmt = konexioa.prepareStatement(ERABILTZAILE_GEHIKETA);
			
			stmt.setString(2, izena); // Lehenengo interrogantean erabiltzailearen ipinitutako izena ipiniko da
										// kontsultan
			stmt.setString(3, pasahitza); // Bigarren interrogantean erabiltzailearen ipinitutako pasahitza ipiniko da
											// kontsultan

			int errenkadaKopurua = stmt.executeUpdate();

			System.out.println(errenkadaKopurua + " errenkada gehitu dira.");

			stmt.close();
			konexioa.close();

		} catch (SQLException e) {
			System.out.println("ERROREA: " + e);
			System.out.println("ERROREA: " + e.getCause());
		}
	}

}
