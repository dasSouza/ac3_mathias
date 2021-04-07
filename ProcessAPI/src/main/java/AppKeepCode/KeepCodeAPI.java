package AppKeepCode;

import ProcessoMaq.GetAllProcess;

public class KeepCodeAPI {
    public static void main(String[] args) {
        GetAllProcess getAllProcess = new GetAllProcess();

        getAllProcess.getNamePc();
        getAllProcess.getDiscoTotal();
        getAllProcess.getCpuNome();
        getAllProcess.memoriaTotal();

        getAllProcess.insertDatesMaquina();

    }
}

