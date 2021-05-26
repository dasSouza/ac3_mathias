package AppKeepCode;

import DAO.UsuariosDAO;
import ProcessoMaq.GetAllProcess;
import ProcessosIDE.ProcessIDE;

import java.util.Scanner;


public class KeepCodeAPI {

    public static void main(String[] args) {
        GetAllProcess getAllDatesProcess = new GetAllProcess();
        ProcessIDE processosIDE = new ProcessIDE();
        Scanner scanner = new Scanner(System.in);
        UsuariosDAO user = new UsuariosDAO();

        processosIDE.criarTabela();
        System.out.println("Seja bem vindo ao KeepCode");
        System.out.println("Vamos fazer seu login :)");
        System.out.println("--------------------------");
        System.out.println("Insira seu login: ");
        String login = scanner.nextLine();
        System.out.println("Insira sua senha: ");
        String senha = scanner.nextLine();
        user.usuarioLogin(login,senha);
        System.out.println("Olá Senhor(a), Seja bem vindo!!");
        System.out.println("Vamos começar buscando os hardwares do seu computador...");
        getAllDatesProcess.getNamePc();
        getAllDatesProcess.getDiscoTotal();
        getAllDatesProcess.getCpuNome();
        getAllDatesProcess.memoriaTotal();
        getAllDatesProcess.insertDatesMaquina();;
        System.out.println("Agora estamos procurando suas IDES, utilizadas");
        processosIDE.putAllNameIde();
        processosIDE.getIdeName();
        processosIDE.getIdeCpu();
        processosIDE.getIdeRam();
        processosIDE.getIdeDisco();
        System.out.println("Adicionando valores de RAM da sua IDE:");
        processosIDE.getRamValues();
        processosIDE.insertIntoValues();
    }
}
