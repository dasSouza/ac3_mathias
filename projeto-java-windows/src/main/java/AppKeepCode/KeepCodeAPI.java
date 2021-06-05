package AppKeepCode;

import DAO.CompanyDAO;
//import DAO.UsuariosDAO;
import ProcessoMaq.GetAllProcess;
import ProcessosIDE.ProcessIDE;
import Usuario.UsuarioDatas;
import java.io.IOException;
import log.GerandoLog;

public class KeepCodeAPI {
    
    public KeepCodeAPI(UsuarioDatas user) {
    }
    
    public void chamandoProcessos(Usuario.UsuarioDatas usuario) throws IOException {
        
        GerandoLog gerarLog = new GerandoLog();
        try {
            gerarLog.gravarLog("\n chamando todos os processos");
            
        } catch (IOException e) {
            gerarLog.gravarLog(String.format("\n %s", e));
            
        }
        
        GetAllProcess getAllDatesProcess = new GetAllProcess();
        ProcessIDE processosIDE = new ProcessIDE();
        
        getAllDatesProcess.getNamePc();
        getAllDatesProcess.getDiscoTotal();
        getAllDatesProcess.getCpuNome();
        getAllDatesProcess.memoriaTotal();
        
        getAllDatesProcess.insertDatesMaquina(usuario);
//        processosIDE.getFkIdMaquina(usuario);
        processosIDE.zovo(usuario);
        
        processosIDE.putAllNameIde();
        processosIDE.getIdeName();
        processosIDE.getIdeCpu();
        processosIDE.getIdeRam();
        processosIDE.getIdeDisco();
        processosIDE.insertIntoValues();

//        processosIDE.showAll();
    }
    
}
