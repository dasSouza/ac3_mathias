package ProcessosIDE;

import DAO.ProcessIdeDAO;
import SlackConnection.Slack;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import java.time.LocalDate;
import java.time.LocalTime;


import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ProcessIDE {
    Looca looca = new Looca();
    ProcessIdeDAO processIdeDAO = new ProcessIdeDAO();
    ProcessDatas processDatas = new ProcessDatas();

    List<Processo> processoList = looca.getGrupoDeProcessos().getProcessos();
    List<String> nomesIde = new ArrayList<>();


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
                    processDatas.valoresNomeIDE.add(processDatas.getUs_ide_nome_processo());
                }
            }
        }
    }

     public void getIdeCpu() {
        for (Processo processo : processoList) {
            for (int i = 0; i < nomesIde.size(); i++) {
                if (processo.getNome().equals(nomesIde.get(i))) {
                    processDatas.setUs_ide_cpu(processo.getUsoCpu().floatValue());
                    processDatas.valoresCpuIDE.add(processDatas.getUs_ide_cpu());
                    
                    Float us_cpu = processDatas.getUs_ide_cpu() / 1024 / 1024 / 1024;
                    Float disp_cpu = processDatas.getUs_ide_cpu() / 1024 / 1024 / 1024;
                    Float us_total_cpu = us_cpu - disp_cpu;
                    Float porc_us_cpu = (us_cpu / 100) * us_total_cpu;

                    //Parte do SLACK
                    if (porc_us_cpu >= 0) {
                        Slack slack = new Slack();
                        JSONObject json = new JSONObject();
                        Float cpu_total = us_cpu / 1024 / 1024 / 1024;
                        Float cpu_disponivel = disp_cpu / 1024 / 1024 / 1024;

                        json.put("text", "------ Alerta sua IDE est� consumindo 80% da sua CPU ------"
                                + "\n Total da sua CPU: " + cpu_total
                                + "\n Uso Disco: " + (cpu_total - cpu_disponivel)
                                + "\n Data: " + LocalDate.now()
                                + "\n Hora: " + LocalTime.now());
                        try {
                            slack.sendMessage(json);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    if (porc_us_cpu >= 0) {
                        Slack slack = new Slack();
                        JSONObject json = new JSONObject();
                        Float cpu_total = us_cpu / 1024 / 1024 / 1024;
                        Float cpu_disponivel = disp_cpu / 1024 / 1024 / 1024;

                        json.put("text", "------ Alerta amarelo uso de cpu maior que 60% ------"
                                + "\n Total da sua CPU: " + cpu_total
                                + "\n Uso CPU: " + (cpu_total - cpu_disponivel)
                                + "\n Data: " + LocalDate.now()
                                + "\n Hora: " + LocalTime.now());
                        try {
                            slack.sendMessage(json);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void getIdeRam() {
        for (Processo processo : processoList) {
            for (int i = 0; i < nomesIde.size(); i++) {
                if (processo.getNome().equals(nomesIde.get(i))) {
                    processDatas.setUs_ide_ram(processo.getUsoMemoria());
                    processDatas.valoresRamIDE.add(processDatas.getUs_ide_ram());

//                    System.out.println("Sua maquina tem armazenamento total de ram: " + processDatas.getUs_ide_ram() / 1024 / 1024 / 1024 + "GB de ram");
//                    System.out.println("Seu maquina tem : " + (processDatas.getUs_ide_ram() / 1024 / 1024 / 1024 )+ "Gb de ram disponivel");
                    Double us_ram = processDatas.getUs_ide_ram() / 1024 / 1024 / 1024;
                    Double disp_ram = processDatas.getUs_ide_ram() / 1024 / 1024 / 1024;
                    Double us_total_ram = us_ram - disp_ram;
                    Double porc_us_ram = (us_ram / 100) * us_total_ram;

                    //Parte do SLACK
                    if (porc_us_ram >= 1) {
                        Slack slack = new Slack();
                        JSONObject json = new JSONObject();
                        Double ram_total = processDatas.getUs_ide_ram() / 1024 / 1024 / 1024;
                        Double ram_disponivel = processDatas.getUs_ide_ram() / 1024 / 1024 / 1024;

                        json.put("text", "------ Alerta amarelo uso utilizando mais que 90% de ram ------"
                                + "\n Total de ram: " + ram_total + "gb"
                                + "\n Uso ram: " + (ram_total - ram_disponivel) + "gb"
                                + "\n Data: " + LocalDate.now()
                                + "\n Hora: " + LocalTime.now());
                        try {
                            slack.sendMessage(json);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    if (porc_us_ram >= 2) {
                        Slack slack = new Slack();
                        JSONObject json = new JSONObject();
                        Double ram_total = processDatas.getUs_ide_ram() / 1024 / 1024 / 1024;
                        Double ram_disponivel = processDatas.getUs_ide_ram() / 1024 / 1024 / 1024;

                        json.put("text", "------ Alerta amarelo uso de ram maior que 85% ------"
                                + "\n Total do seu disco: " + ram_total + "gb"
                                + "\n Uso Disco: " + (ram_total - ram_disponivel) + "gb"
                                + "\n Data: " + LocalDate.now()
                                + "\n Hora: " + LocalTime.now());
                        try {
                            slack.sendMessage(json);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void getIdeDisco() {
        for (Processo processo : processoList) {
            for (int i = 0; i < nomesIde.size(); i++) {
                if (processo.getNome().equals(nomesIde.get(i))) {
                    processDatas.setUs_ide_disco(processo.getMemoriaVirtualUtilizada());
                    processDatas.valoresDiscoIDE.add(processDatas.getUs_ide_disco());

//                    System.out.println("Seu disco tem um armazenamento total de: " + processDatas.getUs_ide_disco() / 1024 / 1024 / 1024 + "GB");
//                    System.out.println("Seu disco tem um armazenamento disponi�vel de: " + processDatas.getUs_ide_disco() / 1024 / 1024 / 1024 + "GB");
                    Long us_disk = processDatas.getUs_ide_disco() / 1024 / 1024 / 1024;
                    Long disp_disk = processDatas.getUs_ide_disco() / 1024 / 1024 / 1024;
                    Long us_total_disk = us_disk - disp_disk;
                    Long porc_us_disk = (us_disk / 100) * us_total_disk;

                    //Parte do SLACK
                    if (porc_us_disk >= 0) {
                        Slack slack = new Slack();
                        JSONObject json = new JSONObject();
                        long disk_total = us_disk / 1024 / 1024 / 1024;
                        long disk_disponivel = disp_disk / 1024 / 1024 / 1024;

                        json.put("text", "------ Alerta sua IDE esta com o consumo de: ------"
                                + "\n Total do seu disco: " + disk_total + "gb"
                                + "\n Uso Disco: " + (disk_total - disk_disponivel) + "gb"
                                + "\n Data: " + LocalDate.now()
                                + "\n Hora: " + LocalTime.now());
                        try {
                            slack.sendMessage(json);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    if (porc_us_disk >= 0) {
                        Slack slack = new Slack();
                        JSONObject json = new JSONObject();
                        long disk_total = us_disk / 1024 / 1024 / 1024;
                        long disk_disponivel = disp_disk / 1024 / 1024 / 1024;

                        json.put("text", "------Alerta amarelo uso disco maior que 85%------"
                                + "\n Total do seu disco: " + disk_total + "gb"
                                + "\n Uso Disco: " + (disk_total - disk_disponivel) + "gb"
                                + "\n Data: " + LocalDate.now()
                                + "\n Hora: " + LocalTime.now());
                        try {
                            slack.sendMessage(json);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void showAll() {
        System.out.println(processDatas.valoresCpuIDE);
        System.out.println(processDatas.valoresDiscoIDE);
        System.out.println(processDatas.valoresNomeIDE);
        System.out.println(processDatas.valoresRamIDE);
    }

    public void insertIntoValues() {
        processIdeDAO.insertIdeProcess(processDatas);
    }

    public void getRamValues () {
        processIdeDAO.getRamIde(processDatas);
    }
}
