package ProcessoMaq;

import DAO.ProcessMaqDAO;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;

import java.io.File;
import java.net.InetAddress;
import java.util.List;

public class GetAllProcess {
    MaquinaDatas maquina = new MaquinaDatas();
    Looca looca = new Looca();
    Processador processador = looca.getProcessador();
    DiscosGroup discosGroup = new DiscosGroup();
    Memoria memoria = new Memoria();
    ProcessMaqDAO maqDAO = new ProcessMaqDAO();
    List<Volume> discos = discosGroup.getVolumes();

    public void memoriaTotal() {
        try {
            System.out.println("\nBuscando memória total da sua maquina...");
            maquina.setUs_ram_total(memoria.getTotal());
            System.out.println("\nDados de memória recuperados: "+ memoria.getTotal());
        } catch (Exception e) {
            System.out.println("Erro ao buscar memória" +e.getMessage());
        }
    }

//    public void usoMemoriaAtual() {
//        maquina.setUs_memoria_atual(memoria.getEmUso().doubleValue());
//    }

//    public void memoriaDisponivel() {
//        Memoria memoria = new Memoria();
//        maquina.setUs_ram_disponivel(memoria.getTotal().doubleValue());
//        maquina.setUs_ram_disponivel(ramTotal.doubleValue());
//    }

    public void getDiscoTotal() {
        try {
            System.out.println("\nBuscando disco total da sua maquina...");
            maquina.setUs_disco_total(discosGroup.getTamanhoTotal());
            System.out.println("\nAtribuindo dados de disco: " + discosGroup.getTamanhoTotal()/1024/1024/1024);
            for (Volume disco : discos) {
                Long discoTotal = disco.getTotal() /1024/1024/1024;
                Long discoDisponivel = disco.getDisponivel() /1024/1024/1024;
                Long utilizado = (discoTotal - discoDisponivel);

                System.out.println("\nTamanho do disco utilizado: " + utilizado);
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar disco"+e.getMessage());
        }
    }

    public void getCpuNome() {
        try {
            System.out.println("\nBuscando nome do processador da sua maquina...");
            maquina.setUs_cpu_nome(processador.getNome());
            System.out.println("\nAtribuindo dados de nome de Cpu(processador): " + processador.getNome());
        } catch (Exception e) {
            System.out.println("Erro ao buscar nome do processador="+e.getMessage());
        }
    }

    public void getNamePc() {
        try {
            System.out.println("\nBuscando o nome da sua maquina...");
            maquina.setUs_name_pc(InetAddress.getLocalHost().getHostName());
            System.out.println("\nAtribuindo nome da maquina: " + InetAddress.getLocalHost().getHostName());
        } catch (Exception e){
            System.out.println("Exception caught ="+e.getMessage());
        }
    }

    public void insertDatesMaquina() {
        try {
            maqDAO.maquinaProcess(maquina);
            System.out.println("\nInserindo dados de Maquina " + maquina.toString());
        } catch (Exception e){
            System.out.println("Erro ao mandar para o banco"+e.getMessage());
        }
    }

}
