package AppKeepCode;

import DAO.CompanyDAO;
//import DAO.UsuariosDAO;
import ProcessoMaq.GetAllProcess;
import ProcessosIDE.ProcessIDE;
import Usuario.UsuarioDatas;

public class KeepCodeAPI {

    public KeepCodeAPI(UsuarioDatas user) {
    }

    public void chamandoProcessos(Usuario.UsuarioDatas usuario) {
        GetAllProcess getAllDatesProcess = new GetAllProcess();
        ProcessIDE processosIDE = new ProcessIDE();

        getAllDatesProcess.getNamePc();
        getAllDatesProcess.getDiscoTotal();
        getAllDatesProcess.getCpuNome();
        getAllDatesProcess.memoriaTotal();

        getAllDatesProcess.insertDatesMaquina(usuario);

        processosIDE.putAllNameIde();
        processosIDE.getIdeName();
        processosIDE.getIdeCpu();
        processosIDE.getIdeRam();
        processosIDE.getIdeDisco();
        processosIDE.getFkIdMaquina(usuario);

//        processosIDE.showAll();
        processosIDE.insertIntoValues();

    }


}
