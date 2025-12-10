/*1 Biltegi guztien IDa eta izena*/ 
SELECT ID, IZENA FROM BILTEGI;

/*2 “CPU” kategoriako produktu guztien izena, deskribapena eta irabazi-marjina, produktuaren izenaren arabera ordenatuta*/ 
SELECT IZENA, DESKRIBAPENA, (SALNEURRIA - BALIOA) AS IRABAZI_MARJINA FROM PRODUKTU WHERE ID_KATEGORIA = 1 ORDER BY IZENA;

/*3 13, 17 edo 18 lanpostu id-a duten bulegarien zerrenda (izena, abizena, emaila eta lanpostuaren deskribapena)*/
SELECT LANGILE.IZENA, LANGILE.ABIZENA, LANGILE.EMAILA, LANPOSTU.DESKRIBAPENA 
FROM LANGILE
INNER JOIN BULEGARI ON LANGILE.ID = BULEGARI.ID
INNER JOIN LANPOSTU ON BULEGARI.ID_LANPOSTU = LANPOSTU.ID
WHERE BULEGARI.ID_LANPOSTU = 13 OR 14 OR 18;

/*4 20€ edo gutxiago balio duten produktuen izena*/
SELECT IZENA FROM PRODUKTU WHERE BALIOA <= 20;

/*5 "A" letraz hasten den izena duten langileak*/
SELECT IZENA FROM LANGILE WHERE IZENA LIKE 'A%';

/*6 2016ko urtarrilean kontrataturiko langileen izen abizenak, kontratazio dataren arabera ordenatuta*/
SELECT IZENA, ABIZENA FROM LANGILE WHERE YEAR(KONTRATAZIO_DATA)='2016' AND MONTH(KONTRATAZIO_DATA) = '01' ORDER BY KONTRATAZIO_DATA;
SELECT IZENA, ABIZENA FROM LANGILE WHERE DATE_FORMAT(KONTRATAZIO_DATA, '%Y-%m') = '2016-01';

/*7 Kategoria bakoitzaren izena eta produktu kopurua*/
SELECT KATEGORIA.IZENA, COUNT(PRODUKTU.IZENA) AS PRODUKTU_KOPURU FROM KATEGORIA
INNER JOIN PRODUKTU ON KATEGORIA.ID = PRODUKTU.ID_KATEGORIA
GROUP BY KATEGORIA.IZENA;

/*8 Saltzailerik gabeko eskari kopurua*/
SELECT COUNT(ID) AS ESKARI_SALTZAILERIK_GABE FROM ESKARI WHERE ID_SALTZAILE IS NULL;

/*9 “Toronto” izeneko biltegian dauden produktu kopuru totala*/
SELECT SUM(INBENTARIO.KOPURUA) AS KOPURU_TOTALA FROM BILTEGI 
INNER JOIN INBENTARIO ON BILTEGI.ID = INBENTARIO.ID_BILTEGI
WHERE BILTEGI.IZENA = 'Toronto';

/*10 Biltegi bakoitzean dagoen produktu kopuru totala*/
SELECT BILTEGI.IZENA, SUM(INBENTARIO.KOPURUA) AS KOPURU_TOTALA FROM BILTEGI
INNER JOIN INBENTARIO ON BILTEGI.ID = INBENTARIO.ID_BILTEGI
GROUP BY BILTEGI.IZENA;

/*11 Produktu bakoitzaren batazbesteko salneurria*/
SELECT IZENA, AVG(SALNEURRIA) AS BATAZBESTEKO FROM PRODUKTU GROUP BY IZENA;

/*12 “Lily Fisher” izeneko saltzaileak saldutako produktuen izena, deskribapena, balioa, salneurria eta kategoriaren izena*/
SELECT PRODUKTU.IZENA AS PRODUKTU_IZENA, PRODUKTU.DESKRIBAPENA, PRODUKTU.BALIOA, PRODUKTU.SALNEURRIA, KATEGORIA.IZENA AS KATEGORIA_IZENA FROM PRODUKTU
INNER JOIN KATEGORIA ON PRODUKTU.ID_KATEGORIA = KATEGORIA.ID
INNER JOIN ESKARI_LERRO ON PRODUKTU.ID = ESKARI_LERRO.ID_PRODUKTU
INNER JOIN ESKARI ON ESKARI_LERRO.ID_ESKARI = ESKARI.ID
INNER JOIN LANGILE ON ESKARI.ID_SALTZAILE = LANGILE.ID 
WHERE LANGILE.IZENA = 'Lily' AND LANGILE.ABIZENA = 'Fisher';

/*13 Produktu garestienen izen, deskribapen eta salneurria*/
SELECT IZENA, DESKRIBAPENA, SALNEURRIA FROM PRODUKTU 
ORDER BY SALNEURRIA DESC LIMIT 10;

/*14 Bost eskari baino gehiago burutu dituzten saltzaileen izen, abizen eta eskari kopurua (eskari kopuruaren arabera ordenatuta, beheranzko ordenan)*/
SELECT LANGILE.IZENA, LANGILE.ABIZENA, COUNT(ESKARI.ID) AS ESKARI_KOPURUA FROM LANGILE
INNER JOIN ESKARI ON LANGILE.ID = ESKARI.ID_SALTZAILE
GROUP BY LANGILE.IZENA, LANGILE.ABIZENA
HAVING COUNT(ESKARI.ID) > 5
ORDER BY ESKARI_KOPURUA DESC;

/*15 Zazpi urteko antzinatasuna baino gehiago duten langileen zerrenda (izena, abizena, kontratatze-data eta erabiltzailea), kontratatze datagaitik ordenatuta*/



/*16 2016 urtean egindako eskarien zerrenda (eskariaren id-a, egoera eta eskaera-data, bezeroa (izena eta abizena zutabe bakar batean) eta saltzailea  (izena eta abizena zutabe bakar batean))*/

/*17 Eskaririk burutu ez duten saltzaileen izen eta abizenak*/

/*18 Saltzaile guztien zerrenda (izena, abizena, burututako eskari kopurua) izen, abizenagaitik ordenatuta*/

/*19 Gehien saldu diren 10 produktuen izena eta saldutatuko unitateak, beheranzko ordenean*/

/*20 Produktu merkeenaren eta garestienaren izena eta salneurria*/