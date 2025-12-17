/* 1. Datu-basean Santurtzin eraiki berri duten biltegiko informazioa sartu behar duzue (biltegiko kokalekua zehaztu baita ere). */
INSERT INTO BILTEGI(ID, IZENA) VALUES ((SELECT MAX(ID) + 1 FROM BILTEGI), 'Santurtzi');

/* 2. Printzipioz, Santurtziko biltegian, “Bombay”ko biltegian dauden produktu berdinak egongo dira eta kopuru bera ere bai. */

/* 3. Produktu hauetaz aparte, biltegian “Seagate ST2000DX002” izeneko 150 disko gogor daude. */

/* 4. “Singapore”en dagoen kokalekuaren helbidea aldatu (helbidea: 270 Orchard Rd; posta kodea: 238857) */

/* 5. “Video Card” kategoriako produktu guztien salneurria %10a igo. */

/* 6. Bezero guztien izen eta abizenak eguneratu letra larriz gordeta gera daitezen. */

/* 7. “Harriet Ferguson” langilearen lanpostua aldatu, bere lanpostu berria “Purchasing Clerk” izango da eta bere nagusi berria “Ella Wallace”. */

/* 8. 102 identifikadorea duen eskariaren eskaera-data aldatu 2016ko abenduaren 10a izan daiten. */

/* 9. 5 identifikadorea duen eskaria eta bere eskari lerroak ezabatu. */

/* 10. Produkturik gabeko katerogiak ezabatu */

/* 11. ‘Lucy Crawford’ langilea ezabatu */

/* 12. ‘Grace Ellis’ langilea ezabatu */
