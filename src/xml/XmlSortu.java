package xml;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import datuBaseKonexioa.Konexioa;

public class XmlSortu {

//	Web orrialdera igoko den informazioa zuzendu nahian bihurtu behar langileen taula XML-ra.
//  Ondorengo eremuak behar dira xml-rako: langile mota, id-a, izen-abizenak, e-maila, telefonoa, data, horren nagusia den 
//  informazioa eta langile mota bakoitzak duen informazio berezia, hala nola, lanpostua eta erabiltzailearen egiaztagiria.
//	Marka lengoaietan ikusitakoaren arabera erabakiko duzue zein den XML-aren etiketen egiturarik egokiena. 
//	Eremuek bete behar dituzte datu basetako baldintzak (Adib izena varchar 255)
//	Beraz, 2. aukera sakatzekotan automatikoki sortuko du xml fitxategi bat aurreko informazioarekin.

	private static final String LANGILE_TAULA = "SELECT ID, IZENA, ABIZENA, EMAILA, TELEFONOA, KONTRATAZIO_DATA FROM LANGILE";

	public XmlSortu() {

	}

	public String xml() {
		StringBuilder xml = new StringBuilder();
		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		xml.append("<langile>\n");
		Konexioa db = new Konexioa();
		Connection konexioa = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			konexioa = db.konexioaBd();

			stmt = konexioa.createStatement();
			rs = stmt.executeQuery(LANGILE_TAULA);

			while (rs.next()) {
				xml.append("<langile id=\"").append(rs.getInt("ID")).append("\">\n");
				xml.append("	<izena>").append(escapeXML(rs.getString("IZENA"))).append("</izena>\n");
				xml.append("	<abizena>").append(escapeXML(rs.getString("ABIZENA"))).append("</abizena>\n");
				xml.append("	<emaila>").append(rs.getString("EMAILA")).append("</emaila>\n");
				xml.append("	<telefonoa>").append(rs.getString("TELEFONOA")).append("</telefonoa>\n");
				xml.append("	<kontratazio_data>").append(rs.getDate("KONTRATAZIO_DATA")).append("</kontratazio_data>\n");
				xml.append("</langile>\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		xml.append("</langile>");
		return xml.toString();
	}

	private String escapeXML(String input) {
		if (input == null)
			return "";
		return input.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;")
				.replace("'", "&apos;");
	}
}
