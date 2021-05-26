package DAO;

import ConectionBDA.Conection;
import ConectionBDA.Conexao;
import ProcessoMaq.MaquinaDatas;
import org.springframework.jdbc.core.JdbcTemplate;


public class ProcessMaqDAO {
    Conection conection = new Conection();
    Conexao conection2 = new Conexao();
    JdbcTemplate template = new JdbcTemplate(conection.getDataSource());
    JdbcTemplate template2 = new JdbcTemplate(conection2.getDatasource());

    public void maquinaProcess(MaquinaDatas maquinaDatas) {
        String insertProcessValuesSqlServer = "IF NOT EXISTS\n"
                + "(SELECT us_nome_maquina FROM tb_us_maquina WHERE fk_id_funcionario = 78806212028)\n"
                + "INSERT INTO tb_us_maquina(us_nome_maquina, us_vl_ram_total, us_vl_disco_total ,us_vl_cpu_total, fk_id_funcionario) VALUES (?, ?, ?, ?, 78806212028)";
        template.update(insertProcessValuesSqlServer, maquinaDatas.getUs_name_pc(), maquinaDatas.getUs_ram_total().toString(), maquinaDatas.getUs_disco_total().toString(), maquinaDatas.getUs_cpu_nome());
        System.out.println("Inserindo dados no banco de dados: " + maquinaDatas.toString());
        String insertProcessValuesSql = "IF NOT EXISTS\n"
                + "(SELECT * FROM tb_us_maquina WHERE )\n"
                + "INSERT INTO tb_us_maquina(us_nome_maquina, us_vl_ram_total, us_vl_disco_total ,us_vl_cpu_total) VALUES (?, ?, ?, ?)";
        template2.update(insertProcessValuesSql, maquinaDatas.getUs_name_pc(), maquinaDatas.getUs_ram_total().toString(), maquinaDatas.getUs_disco_total().toString(), maquinaDatas.getUs_cpu_nome());
    }
}
