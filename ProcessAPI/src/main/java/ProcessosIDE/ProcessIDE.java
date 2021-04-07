package ProcessosIDE;

import DAO.ProcessIdeDAO;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;

import java.util.List;

public class ProcessIDE {
    Looca looca = new Looca();
    ProcessIdeDAO processIdeDAO = new ProcessIdeDAO();
    ProcessDatas processDatas = new ProcessDatas();

    List<Processo> processoList = looca.getGrupoDeProcessos().getProcessos();

    public void getIdeName() {
        // busca por switch case os processos de IDE
        for (Processo processo : processoList) {
            String nomeIDE = processo.getNome();
            switch (processo.getNome()) {
                case "Code":
                    processDatas.setUs_ide_nome_processo(nomeIDE);
                    break;
                case "netbeans64":
                    processDatas.setUs_ide_nome_processo(nomeIDE);
                    break;
                case "pycharm64":
                    processDatas.setUs_ide_nome_processo(nomeIDE);
                    break;
                case "Xcode":
                    processDatas.setUs_ide_nome_processo(nomeIDE);
                    break;
                case "idea64":
                    processDatas.setUs_ide_nome_processo(nomeIDE);
                    break;
                case "studio64":
                    processDatas.setUs_ide_nome_processo(nomeIDE);
                    break;
                case "eclipse":
                    processDatas.setUs_ide_nome_processo(nomeIDE);
                    break;
                case "devenv":
                    processDatas.setUs_ide_nome_processo(nomeIDE);
                    break;
                case "phpstorm64":
                    processDatas.setUs_ide_nome_processo(nomeIDE);
                    break;
                case "phpstorm32":
                    processDatas.setUs_ide_nome_processo(nomeIDE);
                    break;
                case "webstorm64":
                    processDatas.setUs_ide_nome_processo(nomeIDE);
                    break;
                case "webstorm32":
                    processDatas.setUs_ide_nome_processo(nomeIDE);
                    break;
                default:
                    break;
            }
        }
    }

//     busca todos processos no computador
     public void getAllProcessName(){
        for (Processo processo : processoList) {
            System.out.println(processo.getNome());
        }
    }

    public void insertIntoValues() {
        processIdeDAO.insertIdeProcess(processDatas);
    }
}
