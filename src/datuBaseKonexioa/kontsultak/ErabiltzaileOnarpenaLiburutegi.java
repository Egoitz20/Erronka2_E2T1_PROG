package datuBaseKonexioa.kontsultak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datuBaseKonexioa.Konexioa;

public class ErabiltzaileOnarpenaLiburutegi {

	private static final String LOGIN_BALIDATU = "SELECT izena FROM erabiltzaileak WHERE izena = ? AND pasahitza = ?";

	public ErabiltzaileOnarpenaLiburutegi() {
	}

	public boolean erabiltzaileOnarpena(String izena, String pasahitza) {

		Konexioa db = new Konexioa(); //Datu Base objektua deitzen da, baina momentuz ez du ezer egiten. 
		Connection konexioa = null; //Datu Base konexioa deklaratzen da, baina oraindik ez dago deitzen datu basera
		PreparedStatement stmt = null; //Kontsulta egiteko erabiltzen da, baina oraindik bakarrik deklaratzen da.
		ResultSet rs = null; //Datu Basearen emaitzen gordetzen du, baina oraindik bakarrik deklaratzen da.
		boolean emaitza = false; //Segurtasunagaitik, itzultzean edozein gauza, beti false izando da

		try {

			konexioa = db.konexioaBd();
			//Zenbat ilara itzultzen du.
			stmt = konexioa.prepareStatement(LOGIN_BALIDATU);

			stmt.setString(1, izena); //Lehenengo interrogantean erabiltzailearen ipinitutako izena ipiniko da kontsultan
			stmt.setString(2, pasahitza); //Bigarren interrogantean erabiltzailearen ipinitutako pasahitza ipiniko da kontsultan

			rs = stmt.executeQuery(); // Kontsultako ilara GUZTIAK LORTZEN ditu

			//".next()" irukurtzen du taula osoa
			if (rs.next()) {
				emaitza = true;
			}

			stmt.close();
			rs.close();
			konexioa.close();

		} catch (SQLException e) {
			System.out.println("ERROREA: " + e);
			System.out.println("ERROREA: " + e.getCause());
		}
		return emaitza;

	}
}
