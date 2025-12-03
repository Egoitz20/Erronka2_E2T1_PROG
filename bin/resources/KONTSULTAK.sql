/*1 Biltegi guztien IDa eta izena*/ 
SELECT ID, IZENA FROM BILTEGI;
/*2 “CPU” kategoriako produktu guztien izena, deskribapena eta irabazi-marjina, produktuaren izenaren arabera ordenatuta*/ 
SELECT IZENA, DESKRIBAPENA, (SALNEURRIA - BALIOA) AS IRABAZI_MARJINA FROM PRODUKTU WHERE ID_KATEGORIA = 1 ORDER BY IZENA;
/*3 13, 17 edo 18 lanpostu id-a duten bulegarien zerrenda (izena, abizena, emaila eta lanpostuaren deskribapena)*/

/*4 20€ edo gutxiago balio duten produktuen izena*/

/*5 "A" letraz hasten den izena duten langileak*/

/*6 2016ko urtarrilean kontrataturiko langileen izen abizenak, kontratazio dataren arabera ordenatuta*/

/*7 Kategoria bakoitzaren izena eta produktu kopurua*/

/*8 Saltzailerik gabeko eskari kopurua*/

/*9 “Toronto” izeneko biltegian dauden produktu kopuru totala*/

/*10 Biltegi bakoitzean dagoen produktu kopuru totala*/

/*11 Produktu bakoitzaren batazbesteko salneurria*/

/*12 “Lily Fisher” izeneko saltzaileak saldutako produktuen izena, deskribapena, balioa, salneurria eta kategoriaren izena*/

/*13 Produktu garestienen izen, deskribapen eta salneurria*/

/*14 Bost eskari baino gehiago burutu dituzten saltzaileen izen, abizen eta eskari kopurua (eskari kopuruaren arabera ordenatuta, beheranzko ordenan)*/

/*15 Zazpi urteko antzinatasuna baino gehiago duten langileen zerrenda (izena, abizena, kontratatze-data eta erabiltzailea), kontratatze datagaitik ordenatuta*/

/*16 2016 urtean egindako eskarien zerrenda (eskariaren id-a, egoera eta eskaera-data, bezeroa (izena eta abizena zutabe bakar batean) eta saltzailea  (izena eta abizena zutabe bakar batean))*/

/*17 Eskaririk burutu ez duten saltzaileen izen eta abizenak*/

/*18 Saltzaile guztien zerrenda (izena, abizena, burututako eskari kopurua) izen, abizenagaitik ordenatuta*/

/*19 Gehien saldu diren 10 produktuen izena eta saldutatuko unitateak, beheranzko ordenean*/

/*20 Produktu merkeenaren eta garestienaren izena eta salneurria*/
