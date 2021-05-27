package DAO;

import ConectionBDA.Conection;
import ProcessoMaq.MaquinaDatas;
import org.springframework.jdbc.core.JdbcTemplate;


public class ProcessMaqDAO {

    Conection conection = new Conection();
    JdbcTemplate template = new JdbcTemplate(conection.getDataSource());

    public void maquinaProcess(MaquinaDatas maquinaDatas) {
        String insertProcessValues = "IF NOT EXISTS\n"
                + "(SELECT us_nome_maquina FROM tb_us_maquina WHERE fk_id_funcionario = 95275655029)\n"
                + "INSERT INTO tb_us_maquina(us_nome_maquina, us_vl_ram_total, us_vl_disco_total ,us_vl_cpu_total, fk_id_funcionario) VALUES (?, ?, ?, ?, 95275655029)";
        template.update(insertProcessValues, maquinaDatas.getUs_name_pc(), maquinaDatas.getUs_ram_total().toString(), maquinaDatas.getUs_disco_total().toString(), maquinaDatas.getUs_cpu_nome());
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
