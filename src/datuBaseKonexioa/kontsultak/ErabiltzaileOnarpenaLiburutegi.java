package datuBaseKonexioa.kontsultak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import datuBaseKonexioa.Konexioa;

public class ErabiltzaileOnarpenaLiburutegi {

	public static final String FROGA = "SELECT izena FROM erabiltzaileak WHERE izena = ? AND pasahitza = ?";

	public ErabiltzaileOnarpenaLiburutegi() {
	}

	public boolean erabiltzaileOnarpena(String izena, String pasahitza) {
		Konexioa db = new Konexioa();
		Connection konexioa = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean emaitza = false;
		
		try {

			konexioa = db.konexioaBd();
			// zenbat ilara itzultzen du.
			stmt = konexioa.prepareStatement(FROGA, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, izena);
			stmt.setString(2, pasahitza);

			rs = stmt.executeQuery(); // Kontsultako ilara GUZTIAK LORTZEN ditu

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
