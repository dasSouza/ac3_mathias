package DAO;

import ConectionBDA.Conection;
import ProcessoMaq.MaquinaDatas;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProcessMaqDAO {
    Conection conection = new Conection();
    JdbcTemplate template = new JdbcTemplate(conection.getDataSource());

    public void maquinaProcess(MaquinaDatas maquinaDatas) {
        String insertProcessValues = "INSERT INTO tb_us_maquina(us_nome_maquina, us_vl_ram_total, us_vl_disco_total ,us_vl_cpu_total) VALUES (?, ?, ?, ?)";
        template.update(insertProcessValues,maquinaDatas.getUs_name_pc(), maquinaDatas.getUs_ram_total().toString(), maquinaDatas.getUs_disco_total().toString(), maquinaDatas.getUs_cpu_nome());
        System.out.println("Inserindo dados no banco de dados: " + maquinaDatas.toString());
    }
}
