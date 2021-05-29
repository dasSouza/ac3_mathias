package DAO;

import ConectionBDA.Conection;
import ProcessoMaq.MaquinaDatas;
import SlackConnection.Slack;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import jdbc.Conexao;


public class ProcessMaqDAO extends Usuario.UsuarioDatas{
    Conection conection = new Conection();
    Conexao con = new Conexao();
    JdbcTemplate template = new JdbcTemplate(con.getBanco());

    public ProcessMaqDAO() {
    }

    
    

    public void maquinaProcess(MaquinaDatas maquinaDatas) {
        String insertProcessValues = "INSERT INTO tb_us_maquina(us_nome_maquina, us_vl_ram_total, us_vl_disco_total ,us_vl_cpu_total, fk_id_funcionario) VALUES (?, ?, ?, ?, ?)";
       template.update(insertProcessValues,maquinaDatas.getUs_name_pc(), maquinaDatas.getUs_ram_total().toString(), maquinaDatas.getUs_disco_total().toString(), maquinaDatas.getUs_cpu_nome(), super.getId_cpf());
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
        }
    }

