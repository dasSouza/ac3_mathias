package DAO;

//import ConectionBDA.Conection;
import ProcessoMaq.MaquinaDatas;
import SlackConnection.Slack;
import java.io.IOException;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import jdbc.Conexao;
import log.GerandoLog;

public class ProcessMaqDAO extends Usuario.UsuarioDatas {

//    Conection conection = new Conection();
    Conexao con = new Conexao();
    JdbcTemplate template = new JdbcTemplate(con.getBanco());

    public ProcessMaqDAO() {
    }

    public void maquinaProcess(MaquinaDatas maquinaDatas) throws IOException {
        GerandoLog gerarLog = new GerandoLog();

        String insertProcessValues = " IF NOT EXISTS (SELECT * from tb_us_maquina where fk_id_funcionario = ?) \n"
                + "insert into tb_us_maquina values (?, ?, ?, ?, ?)";
        template.update(insertProcessValues, super.getId_cpf(), maquinaDatas.getUs_name_pc(), maquinaDatas.getUs_ram_total().toString(), maquinaDatas.getUs_disco_total().toString(), maquinaDatas.getUs_cpu_nome(), super.getId_cpf());
        System.out.println("Inserindo dados no banco de dados: " + maquinaDatas.toString());

//        Parte do SLACK
//        Integer us_cpu = 15;
//
//        if(us_cpu != 90.0){
//            Slack slack = new Slack();
//            JSONObject json = new JSONObject();
//
//            json.put("text", "------Alerta Vermelho------" +"Uso CPU:" +us_cpu + "\n Data: " + LocalDate.now() + "\n Hora: "+ LocalTime.now());
//
//            try {
//                slack.sendMessage(json);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        try {
            gerarLog.gravarLog("\n inserindo dados de maquina");

        } catch (IOException e) {
            gerarLog.gravarLog(String.format("%s", e));

        }
    }
}
