package DAO;

import ConectionBDA.Conection;
import ConectionBDA.DockerConnection;
import ProcessoMaq.MaquinaDatas;
import SlackConnection.Slack;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.LocalTime;

public class ProcessMaqDAO {

    Conection conection = new Conection();
    JdbcTemplate template = new JdbcTemplate(conection.getDataSource());
    DockerConnection conDocker = new DockerConnection();
    JdbcTemplate template2 = new JdbcTemplate(conDocker.getBanco());

    public void maquinaProcess(MaquinaDatas maquinaDatas) {
        String insertProcessValues = "INSERT INTO tb_us_maquina(us_nome_maquina, us_vl_ram_total, us_vl_disco_total ,us_vl_cpu_total, fk_id_funcionario) VALUES (?, ?, ?, ?)";
        template.update(insertProcessValues, maquinaDatas.getUs_name_pc(), maquinaDatas.getUs_ram_total().toString(), maquinaDatas.getUs_disco_total().toString(), maquinaDatas.getUs_cpu_nome());
        System.out.println("Inserindo dados no banco de dados: " + maquinaDatas.toString());

        String insertProcessValues2 = "INSERT INTO tb_us_maquina(us_nome_maquina, us_vl_ram_total, us_vl_disco_total ,us_vl_cpu_total) VALUES (?, ?, ?, ?)";
        template2.update(insertProcessValues2, maquinaDatas.getUs_name_pc(), maquinaDatas.getUs_ram_total().toString(), maquinaDatas.getUs_disco_total().toString(), maquinaDatas.getUs_cpu_nome());
        System.out.println("Inserindo dados no banco de dados: " + maquinaDatas.toString());
    }

}
