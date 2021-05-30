package AppKeepCode;

import DAO.CompanyDAO;
import DAO.UsuariosDAO;
import ProcessoMaq.GetAllProcess;
import ProcessosIDE.ProcessIDE;
import com.github.britooo.looca.api.group.sistema.Sistema;
import oshi.SystemInfo;
import oshi.util.FormatUtil;

import java.lang.management.ManagementFactory;
import java.util.Timer;
import java.util.TimerTask;


public class KeepCodeAPI {
    public static void main(String[] args) {
        GetAllProcess getAllDatesProcess = new GetAllProcess();
        Sistema  sistema = new Sistema();

//        getAllDatesProcess.getNamePc();
//        getAllDatesProcess.getDiscoTotal();
//        getAllDatesProcess.getCpuNome();
//        getAllDatesProcess.memoriaTotal();
//        getAllDatesProcess.insertDatesMaquina();
        System.out.println("dados do pc:");


//        int delay = 1000;   // tempo de espera antes da 1ª execução da tarefa.
//        int interval = 7000;  // intervalo no qual a tarefa será executada.
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            public void run() {
//                ProcessIDE processosIDE = new ProcessIDE();
//                processosIDE.putAllNameIde();
//                processosIDE.getIdeName();
//                processosIDE.getIdeCpu();
//                processosIDE.getIdeRam();
//                processosIDE.getIdeDisco();
//
//                processosIDE.showAll();
//
//                processosIDE.insertIntoValues();
//            }
//        }, delay, interval);
    }
}

