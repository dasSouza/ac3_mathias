package AppKeepCode;

//import DAO.UsuariosDAO;
import ProcessoMaq.GetAllProcess;
import ProcessosIDE.ProcessIDE;
import Usuario.UsuarioDatas;
import java.io.IOException;
import log.GerandoLog;

public class KeepCodeAPI {

    public KeepCodeAPI(UsuarioDatas user) {

    }

    public void chamandoProcessos(UsuarioDatas usuario) throws IOException {

        GerandoLog gerarLog = new GerandoLog();
        try {
            gerarLog.gravarLog("\n Chamando todos os processos");
        } catch (IOException e) {
            gerarLog.gravarLog(String.format("\n %s", e));
        }

        GetAllProcess getAllDatesProcess = new GetAllProcess();
        ProcessIDE processosIDE = new ProcessIDE();

        getAllDatesProcess.dadosGeraisDoComputador();
        getAllDatesProcess.inserirDadosMaquina(usuario);
        getAllDatesProcess.buscandoMaquina(usuario);

        processosIDE.getFkIdMaquina(usuario);
        processosIDE.putAllNameIde();
        processosIDE.getIdeCpu();
        processosIDE.getIdeRam();
        processosIDE.getIdeDisco();
        processosIDE.getIdeName();
        processosIDE.getFkIdMaquina(usuario);
        processosIDE.inserirDadosDeIde();

        processosIDE.mostrarTodosDadosRecebidos();
    }

}
