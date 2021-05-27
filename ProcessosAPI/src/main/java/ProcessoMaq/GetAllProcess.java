package ProcessoMaq;

import DAO.ProcessMaqDAO;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;

import java.io.File;
import java.net.InetAddress;

public class GetAllProcess {
    MaquinaDatas maquina = new MaquinaDatas();
    Looca looca = new Looca();
    Processador processador = looca.getProcessador();
    DiscosGroup discosGroup = new DiscosGroup();
    Memoria memoria = new Memoria();
    ProcessMaqDAO maqDAO = new ProcessMaqDAO();



    public void memoriaTotal() {
        maquina.setUs_ram_total(memoria.getTotal());
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
        maquina.setUs_disco_total(discosGroup.getTamanhoTotal());
        System.out.println("Atribuindo dados de disco: " + discosGroup.getTamanhoTotal()/1024/1024/1024);
    }

    public void getCpuNome() {
        maquina.setUs_cpu_nome(processador.getNome());
        System.out.println("Atribuindo dados de nome de Cpu(processador): " + processador.getNome());
    }

    public void getNamePc() {
        try{
            maquina.setUs_name_pc(InetAddress.getLocalHost().getHostName());
            System.out.println("Atribuindo nome da maquina: " + InetAddress.getLocalHost().getHostName());
        } catch (Exception e){
            System.out.println("Exception caught ="+e.getMessage());
        }
//        maquina.setUs_name_pc(System.getProperty("user.name"));
//        System.out.println("Atribuindo nome da maquina: " + maquina.getUs_name_pc()); // perguntar pro prof sobre
    }

    public void insertDatesMaquina() {
        maqDAO.maquinaProcess(maquina);
        System.out.println("Inserindo dados de Maquina " + maquina.toString());
    }

}
