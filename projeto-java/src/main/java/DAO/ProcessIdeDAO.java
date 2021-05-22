package DAO;

import ConectionBDA.Conection;
import ProcessosIDE.ProcessDatas;
import java.util.List;
import jdbc.Conexao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import tabelas.TbUsMaquinaIdMaquina;
import ProcessoMaq.MaquinaDatas;
import Usuario.UsuarioDatas;
import java.math.BigInteger;

public class ProcessIdeDAO {

    Conection conection = new Conection();
    Conexao con = new Conexao();
    JdbcTemplate template = new JdbcTemplate(con.getBanco());

    public void insertIdeProcess(ProcessDatas allIdeDates) {
        for (int i = 0; i < allIdeDates.getValoresNomeIDE().size(); i++) {
            Long disco = allIdeDates.getValoresDiscoIDE().get(i);
            String nomeIDE = allIdeDates.getValoresNomeIDE().get(i);
            Double ram = allIdeDates.getValoresRamIDE().get(i);
            Float cpu = allIdeDates.getValoresCpuIDE().get(i);
            Integer fk = allIdeDates.getFk_id_maquina();

            System.out.println(String.format("\n Sendo o resto: \n"
                    + "nome da IDE: %s"
                    + "Ram: %s"
                    + "CPU: %s"
                    + "Disco: %s"
                    + "Fk id da maquina: %s", nomeIDE, ram, cpu, disco, fk));

            
            String insertProcessValues = "INSERT INTO tb_processos_ide (us_dt_hr_start_IDE, us_dt_hr_end_IDE, us_ide_nome_processo, us_ide_ram, us_ide_cpu, us_ide_disco, fk_id_maquina) VALUES (GETDATE(), GETDATE(), ? , ? , ?, ?, ?)";
            template.update(insertProcessValues, nomeIDE, ram, cpu, disco, fk);

            System.out.println(String.format("\n Inserindo no banco: \n"
                    + "nome da IDE: %s"
                    + "Ram: %s"
                    + "CPU: %s"
                    + "Disco: %s"
                    + "Fk id da maquina: %s", nomeIDE, ram, cpu, disco, fk));

        }
    }

    public void pegandoUsuario(Usuario.UsuarioDatas usuario) {

    }
}
