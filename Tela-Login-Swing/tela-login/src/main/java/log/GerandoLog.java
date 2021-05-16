package log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GerandoLog {

    Date dataHoraAtual = new Date();
    String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
    String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

    public void gravarLog(String textoLog) throws IOException {
        FileWriter arq = new FileWriter("C:\\Users\\DOM\\Documents\\Bandtec Grupo 8 KeepCode\\KeepCode-Grupo-08\\log.txt", true);
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.println(textoLog);

        arq.close();

    }

}
