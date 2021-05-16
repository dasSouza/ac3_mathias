package log;

    import java.io.FileWriter ;
    import java.io.IOException ;
    import java.io.PrintWriter ;
    import java.util.Scanner ;

public class GerandoLog {
    
    public void gravarLog(String textoLog) throws IOException{
        FileWriter arq = new FileWriter("C:\\Users\\mathias.de.carvalho\\Desktop\\Git\\KeepCode-Grupo-08\\log.txt");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.println(textoLog);
        
        arq.close();
    
    }

}
