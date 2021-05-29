package log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GerandoLog {

    public void gravarLog(String textoLog) throws IOException {
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
       //FileWriter arq = new FileWriter("C:\\Users\\mathias.de.carvalho\\Desktop\\Git\\KeepCode-Grupo-08\\log.txt", true);
       FileWriter arq = new FileWriter("C:\\Users\\DOM\\Documents\\Bandtec Grupo 8 KeepCode\\KeepCode-Grupo-08\\log.txt", true);
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.println(String.format("%s %s %s \n", data, hora, textoLog));

        arq.close();

    }

}
