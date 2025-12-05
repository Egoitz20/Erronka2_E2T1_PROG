package datuBaseKonexioa.kontsultak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import datuBase.TaulaErabiltzaile;
import datuBaseKonexioa.Konexioa;

public class DatuakBistaratu {

	private static final String ERABILTZAILE_TAULA_BISTARATU = "SELECT * FROM ERABILTZAILEAK";

	public DatuakBistaratu() {

	}

	public ArrayList<TaulaErabiltzaile> taulaBistaratu() {

		Konexioa db = new Konexioa();
		Connection konexioa = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		TaulaErabiltzaile erregistro;
		ArrayList<TaulaErabiltzaile> taulaErabiltzaile = new ArrayList<TaulaErabiltzaile>();

		try {

			konexioa = db.konexioaBd();
			stmt = konexioa.prepareStatement(ERABILTZAILE_TAULA_BISTARATU);

			rs = stmt.executeQuery();

			while (rs.next()) {
				erregistro = new TaulaErabiltzaile();

				erregistro.setId(rs.getInt("ID"));
				erregistro.setIzena(rs.getString("IZENA"));
				erregistro.setPasahitza(rs.getString("PASAHITZA"));

				taulaErabiltzaile.add(erregistro);

			}

			rs.close();
			stmt.close();
			konexioa.close();

		} catch (SQLException e) {
			System.out.println("Errorea: " + e);
			System.out.println("Errorea: " + e.getCause());

		}

		return taulaErabiltzaile;

	}

}
