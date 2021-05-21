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

            String insertProcessValues = "INSERT INTO tb_processos_ide (us_dt_hr_start_IDE, us_dt_hr_end_IDE, us_ide_nome_processo, us_ide_ram, us_ide_cpu, us_ide_disco) VALUES (GETDATE(), GETDATE(), ? , ? , ?, ?)";
            template.update(insertProcessValues, nomeIDE,ram, cpu, disco);
            System.out.println("inserindo no banco: " + "nome da IDE: " + nomeIDE + "\nRam: " + ram + "\nCPU:" + cpu + "\nDisco: " + disco);
        }
    }
    
    public void pegandoUsuario(Usuario.UsuarioDatas usuario){
    
    }
}
