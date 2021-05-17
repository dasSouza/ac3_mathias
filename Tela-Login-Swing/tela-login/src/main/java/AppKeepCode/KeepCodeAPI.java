package AppKeepCode;

import DAO.CompanyDAO;
import DAO.UsuariosDAO;
import ProcessoMaq.GetAllProcess;
import ProcessosIDE.ProcessIDE;

public class KeepCodeAPI {

    public void chamandoProcessos() {
        GetAllProcess getAllDatesProcess = new GetAllProcess();
        ProcessIDE processosIDE = new ProcessIDE();

        getAllDatesProcess.getNamePc();
        getAllDatesProcess.getDiscoTotal();
        getAllDatesProcess.getCpuNome();
        getAllDatesProcess.memoriaTotal();

        getAllDatesProcess.insertDatesMaquina();

        processosIDE.putAllNameIde();
        processosIDE.getIdeName();
        processosIDE.getIdeCpu();
        processosIDE.getIdeRam();
        processosIDE.getIdeDisco();

//        processosIDE.showAll();
        processosIDE.insertIntoValues();

    }
}
