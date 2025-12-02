package datuBaseKonexioa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa {

	private String url;
	private String erabiltzaile;
	private String pasahitza;

	public Konexioa() {
		// Konexioaren datuak
		this.url = "jdbc:mysql://localhost:3306/e2t1dbaplikazioa?" + "useSSL=false&" + "serverTimezone=UTC&"
				+ "allowPublicKeyRetrieval=true"; // Datu Base URL-a
		this.erabiltzaile = "admin"; // Datu-Baseko erabiltzailea
		this.pasahitza = "admin"; // Datu-Baseko pasahitza
	}

	public Konexioa(String url, String erabiltzaile, String pasahitza) {
		this.url = url;
		this.erabiltzaile = erabiltzaile;
		this.pasahitza = pasahitza;
	}

	public Connection konexioaBd() {

		// Datu-basearekiko konexioa ezartzea (beti da berdina)

		Connection konexioa = null;
		try {
			konexioa = DriverManager.getConnection(url, erabiltzaile, pasahitza); // Konexioaren datuak hartzen dira.
			if (konexioa != null) {
				// System.out.println("✅ Konexioa eginda!");
			}
		} catch (SQLException e) {
			System.err.println("❌ Errorea konexioarekin: " + e.getMessage());
		}
		return konexioa;
	}
	
	/*public Connection konektatu() {
	 * Connection konekzioa = null;
	 * try {
	 * Class.forName("com.mysql.cj.jdbc.Driver");
	 * String url = "jdbc:mysql://localhost:3306/'datuBaseIzena'";
	 * String erabiltzaile = "root";
	 * String pasahitza = "root";
	 * 
	 * konekzioa = DriverManager.getConnection(url, erabiltzailea, pasahitza);
	 * } catch (Exception e) {
	 * e.printStackTrace();
	 * } return konekzioa
	 * 
	 * } */

}
