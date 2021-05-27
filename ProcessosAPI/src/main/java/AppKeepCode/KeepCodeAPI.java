package AppKeepCode;

import DAO.CompanyDAO;
import DAO.UsuariosDAO;
import ProcessoMaq.GetAllProcess;
import ProcessosIDE.ProcessIDE;

import java.util.Timer;
import java.util.TimerTask;

public class KeepCodeAPI {
    public static void main(String[] args) {
        GetAllProcess getAllDatesProcess = new GetAllProcess();

        getAllDatesProcess.getNamePc();
        getAllDatesProcess.getDiscoTotal();
        getAllDatesProcess.getCpuNome();
        getAllDatesProcess.memoriaTotal();
        getAllDatesProcess.insertDatesMaquina();

        int delay = 1000;   // tempo de espera antes da 1ª execução da tarefa.
        int interval = 7000;  // intervalo no qual a tarefa será executada.
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                ProcessIDE processosIDE = new ProcessIDE();
                processosIDE.putAllNameIde();
                processosIDE.getIdeName();
                processosIDE.getIdeCpu();
                processosIDE.getIdeRam();
                processosIDE.getIdeDisco();

                processosIDE.showAll();

                processosIDE.insertIntoValues();
            }
        }, delay, interval);
    }
}

