package datuBaseKonexioa.alters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import datuBaseKonexioa.Konexioa;

public class EremuaGehitu {

	private static final String SOLDATA_EREMUA_EZABATU = "ALTER TABLE LANGILE DROP COLUMN SOLDATA";
	private static final String SOLDATA_EREMUA_GEHITU = "ALTER TABLE LANGILE ADD SOLDATA INT";

	public EremuaGehitu() {

	}

	public void sortuSoldataEremua() {
		Konexioa db = new Konexioa();
		Connection konexioa = null;
		PreparedStatement stmt = null;

		try {
			konexioa = db.konexioaBd();
			stmt = konexioa.prepareStatement(SOLDATA_EREMUA_EZABATU);
			stmt.executeUpdate();
			stmt = konexioa.prepareStatement(SOLDATA_EREMUA_GEHITU);
			stmt.executeUpdate();
			System.out.println("SOLDATA eremua gehitu da.");

			stmt.close();
			konexioa.close();

		} catch (SQLException e) {
			System.out.println("ERROREA: " + e);
			System.out.println("ERROREA: " + e.getCause());
		}

	}

}
