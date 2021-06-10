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

    DockerConnection conDocker = new DockerConnection();
    JdbcTemplate template2 = new JdbcTemplate(conDocker.getBanco());

    public void maquinaProcess(MaquinaDatas maquinaDatas) {
        String insertProcessValues2 = "INSERT INTO tabela_docker_mysql(us_nome_maquina, us_vl_ram_total, us_vl_disco_total ,us_vl_cpu_total) VALUES (?, ?, ?, ?)";
        template2.update(insertProcessValues2, maquinaDatas.getUs_nome_maquina(), maquinaDatas.getUs_vl_ram_total().toString(), maquinaDatas.getUs_vl_disco_total().toString(), maquinaDatas.getUs_vl_cpu_total());
        System.out.println("Inserindo dados no banco de dados: " + maquinaDatas.toString());
    }

}
