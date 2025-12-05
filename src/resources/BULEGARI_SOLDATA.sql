SELECT * FROM langile;

/*Bi update hauek berdinak dira, 2º update obetoagoa da bakarrik aukeratzen du linea eskatzen duzuna, berriz, 1º update lehenengo eskatzen du taula osoa eta gero su eskatzen duzun linea*/
UPDATE LANGILE INNER JOIN BULEGARI ON LANGILE.ID = BULEGARI.ID  SET LANGILE.SOLDATA = 30000 WHERE LANGILE.ID = 1;
UPDATE LANGILE INNER JOIN BULEGARI ON LANGILE.ID = BULEGARI.ID  AND LANGILE.ID = 2 SET LANGILE.SOLDATA = 30000;