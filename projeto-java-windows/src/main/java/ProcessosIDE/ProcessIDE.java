package ProcessosIDE;

import AppKeepCode.KeepCodeAPI;
import ProcessoMaq.MaquinaDatas;
import ProcessoMaq.ProcessDatas;
import SlackConnection.Slack;
import Usuario.UsuarioDatas;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.mycompany.projeto.java.TelaLogin;
import jdbc.Conexao;
import log.GerandoLog;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.LocalDateTime;
import org.json.JSONObject;

public class ProcessIDE {

    Looca looca = new Looca();
    ProcessDatas processDatas = new ProcessDatas();
    Conexao con = new Conexao();
    JdbcTemplate template = new JdbcTemplate(con.getBanco());

    List<Processo> processoList = looca.getGrupoDeProcessos().getProcessos();
    List<String> nomesIde = new ArrayList<>();

    public void putAllNameIde() {
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

                    Float us_cpu = processDatas.getUs_ide_cpu();
                    Float disp_cpu = processDatas.getUs_ide_cpu();
                    Float us_total_cpu = us_cpu - disp_cpu;
                    Float porc_us_cpu = (us_cpu / 100) * us_total_cpu;

                    //Parte do SLACK
                    if (porc_us_cpu >= 2) {
                        Slack slack = new Slack();
                        JSONObject json = new JSONObject();
                        Float cpu_total = us_cpu;
                        Float cpu_disponivel = disp_cpu;

                        json.put("text", "------ Alerta sua IDE " + processo.getNome() + " esta consumindo 80% da sua CPU ------"
                                + "\n Total da sua CPU: " + cpu_total.floatValue()
                                + "\n Uso Disco: " + (cpu_total - cpu_disponivel)
                        );
                        try {
                            slack.sendMessage(json);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    if (porc_us_cpu >= 0) {
                        Slack slack = new Slack();
                        JSONObject json = new JSONObject();
                        Float cpu_total = us_cpu;
                        Float cpu_disponivel = disp_cpu;

                        json.put("text", "------ Alerta amarelo uso de cpu maior que 60% ------"
                                + "\n Total da sua CPU: " + cpu_total
                                + "\n Uso CPU: " + (cpu_total - cpu_disponivel)
                        );
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

                        json.put("text", "------ Alerta" + processo.getNome() + "amarelo uso utilizando mais que 90% de ram ------"
                                + "\n Total de ram: " + ram_total + "gb"
                                + "\n Uso ram: " + (ram_total - ram_disponivel) + "gb"
                        );
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
                        );
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
//                    System.out.println("Seu disco tem um armazenamento disponi­vel de: " + processDatas.getUs_ide_disco() / 1024 / 1024 / 1024 + "GB");
                    Long us_disk = processDatas.getUs_ide_disco() / 1024 / 1024 / 1024;
                    Long disp_disk = processDatas.getUs_ide_disco() / 1024 / 1024 / 1024;
                    Long us_total_disk = us_disk - disp_disk;
                    Long porc_us_disk = (us_disk / 100) * us_total_disk;

                    //Parte do SLACK
                    if (porc_us_disk >= 2) {
                        Slack slack = new Slack();
                        JSONObject json = new JSONObject();
                        long disk_total = us_disk / 1024 / 1024 / 1024;
                        long disk_disponivel = disp_disk / 1024 / 1024 / 1024;

                        json.put("text", "------ Alerta vermelho sua IDE " + processo.getNome() + " esta consumo de disco em 90%: ------"
                                + "\n Total do seu disco: " + disk_total + "gb"
                                + "\n Uso Disco: " + (disk_total - disk_disponivel) + "gb"
                        );
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
                        );
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

    public void mostrarTodosDadosRecebidos() {
        /**
         * Método perto do inútil, apenas para mostrar os dados que foram
         * capturados no processo acima
         */
        int delay = 1000;   // tempo de espera antes da 1ª execução da tarefa.
        int interval = 6000;  // intervalo no qual a tarefa será executada.
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(processDatas.valoresCpuIDE);
                System.out.println(processDatas.valoresDiscoIDE);
                System.out.println(processDatas.valoresNomeIDE);
                System.out.println(processDatas.valoresRamIDE);
            }
        }, delay, interval);
    }

    public void inserirDadosDeIde() throws IOException {
        inserirProcessosIDE(processDatas);
    }

    public void getFkIdMaquina(UsuarioDatas usuario) {
        /**
         * Buscando a maquina do usuário para poder inserir dados
         */

        List<MaquinaDatas> pegandoFkMaq = template.query("SELECT * "
                + "FROM tb_us_maquina "
                + "WHERE fk_id_funcionario = ?",
                new BeanPropertyRowMapper<>(MaquinaDatas.class), usuario.getId_cpf());

        for (MaquinaDatas maquinaDatas : pegandoFkMaq) {
            maquinaDatas.setId_maquina(maquinaDatas.getId_maquina());
            maquinaDatas.setFk_id_funcionario(maquinaDatas.getFk_id_funcionario());
            processDatas.setId_maquina(maquinaDatas.getId_maquina());
            processDatas.setFk_id_funcionario(maquinaDatas.getFk_id_funcionario());
        }
    }

    public void inserirProcessosIDE(ProcessDatas allIdeDates) throws IOException {
        /**
         * Insere processos a partir de um ARRAY de processos de IDE
         */

        GerandoLog gerarLog = new GerandoLog();

        for (int i = 0; i < allIdeDates.getValoresNomeIDE().size(); i++) {
            String nomeIDE = allIdeDates.getValoresNomeIDE().get(i);
            Double ram = allIdeDates.getValoresRamIDE().get(i);
            Float cpu = allIdeDates.getValoresCpuIDE().get(i);
            Long disco = allIdeDates.getValoresDiscoIDE().get(i);

            String insertProcessValues = "INSERT INTO tb_processos_ide ("
                    + "us_dt_hr_start_IDE, "
                    + "us_dt_hr_end_IDE, "
                    + "us_ide_nome_processo,"
                    + " us_ide_ram, "
                    + "us_ide_cpu, "
                    + "us_ide_disco, fk_id_maquina) "
                    + "VALUES (GETDATE(), GETDATE(), ? , ? , ?, ?, ?)";
            template.update(insertProcessValues, nomeIDE, ram, cpu, disco, processDatas.getId_maquina());

            String attDatas = "UPDATE tb_log_hardware SET us_dt_hr_log= GETDATE() WHERE fk_id_maq= ?";

            template.update(attDatas, processDatas.getId_maquina());

        }
        try {
            gerarLog.gravarLog("\n Inserindo dados de maquina");

        } catch (IOException e) {
            gerarLog.gravarLog(String.format("%s", e));
        }
    }

}
