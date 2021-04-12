package AppKeepCode;

import DAO.CompanyDAO;
import DAO.UsuariosDAO;
import ProcessoMaq.GetAllProcess;
import ProcessosIDE.ProcessIDE;

public class KeepCodeAPI {
    public static void main(String[] args) {
        GetAllProcess getAllDatesProcess = new GetAllProcess();
        ProcessIDE processosIDE = new ProcessIDE();
        UsuariosDAO usuariosDAO = new UsuariosDAO();

        getAllDatesProcess.getNamePc();
        getAllDatesProcess.getDiscoTotal();
        getAllDatesProcess.getCpuNome();
        getAllDatesProcess.memoriaTotal();

        getAllDatesProcess.insertDatesMaquina();

//        processosIDE.putAllNameIde();
//        processosIDE.getIdeName();
//        processosIDE.getIdeCpu();
//        processosIDE.getIdeRam();
//        processosIDE. getIdeDisco();
//
//        processosIDE.showAll();

//        processosIDE.insertIntoValues();

//        usuariosDAO.usuarioLogin();
//        usuariosDAO.usuarioSenha();

    }
}

