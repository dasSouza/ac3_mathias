package ProcessosIDE;

import DAO.ProcessIdeDAO;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;

import java.util.ArrayList;
import java.util.List;

public class ProcessIDE {
    Looca looca = new Looca();
    ProcessIdeDAO processIdeDAO = new ProcessIdeDAO();
    ProcessDatas processDatas = new ProcessDatas();

    List<Processo> processoList = looca.getGrupoDeProcessos().getProcessos();
    List<String> nomesIde = new ArrayList<>();
    List<String> valoresNomeIDE = new ArrayList<>();
    List<Double> valoresRamIDE = new ArrayList<Double>();
    List<Float> valoresCpuIDE = new ArrayList<>();
    List<Long> valoresDiscoIDE = new ArrayList<Long>();

    public void putAllNameIde(){
        nomesIde.add("Code");
        nomesIde.add("netbeans64");
        nomesIde.add("pycharm64");
        nomesIde.add("Xcode");
        nomesIde.add("idea64");
        nomesIde.add("studio64");
        nomesIde.add("eclipse");
        nomesIde.add("devenv");
        nomesIde.add("phpstorm64");
        nomesIde.add("phpstorm32");
        nomesIde.add("webstorm64");
        nomesIde.add("webstorm32");
    }

    public void getIdeName() {
        for (Processo processo : processoList) {
            for (int i = 0; i < nomesIde.size(); i++) {
                if (processo.getNome().equals(nomesIde.get(i))) {
                    processDatas.setUs_ide_nome_processo(nomesIde.get(i));
                    valoresNomeIDE.add(processDatas.getUs_ide_nome_processo());
                }
            }
        }
    }

     public void getIdeCpu() {
        for (Processo processo : processoList) {
            for (int i = 0; i < nomesIde.size(); i++) {
                if (processo.getNome().equals(nomesIde.get(i))) {
                    processDatas.setUs_ide_cpu(processo.getUsoCpu().floatValue());
                    valoresCpuIDE.add(processDatas.getUs_ide_cpu());
                }
            }
        }
    }

    public void getIdeRam() {
        for (Processo processo : processoList) {
            for (int i = 0; i < nomesIde.size(); i++) {
                if (processo.getNome().equals(nomesIde.get(i))) {
                    processDatas.setUs_ide_ram(processo.getUsoMemoria());
                    valoresRamIDE.add(processDatas.getUs_ide_ram());
                }
            }
        }
    }
    public void getIdeDisco() {
        for (Processo processo : processoList) {
            for (int i = 0; i < nomesIde.size(); i++) {
                if (processo.getNome().equals(nomesIde.get(i))) {
                    processDatas.setUs_ide_disco(processo.getMemoriaVirtualUtilizada());
                    valoresDiscoIDE.add(processDatas.getUs_ide_disco());
                }
            }
        }
    }

    public void showAll() {
        System.out.println(valoresCpuIDE);
        System.out.println(valoresDiscoIDE);
        System.out.println(valoresNomeIDE);
        System.out.println(valoresRamIDE);
    }

    public void insertIntoValues() {
        processIdeDAO.insertIdeProcess(processDatas);
    }
}
