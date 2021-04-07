package DAO;

import ConectionBDA.Conection;
import ProcessoMaq.MaquinaDatas;
import ProcessosIDE.ProcessDatas;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProcessIdeDAO {
    Conection conection = new Conection();
    JdbcTemplate template = new JdbcTemplate(conection.getBanco());


    public void insertIdeProcess(ProcessDatas allIdeDates) {
        String insertProcessValues = "INSERT INTO tb_processos_ide(us_dt_hr_processo, us_ide_nome_processo, us_ide_ram, us_ide_cpu, us_ide_disco, fk_IDE) VALUES (GETDATE(), ?);";
//        template.update(insertProcessValues,"falta hora do processo", allIdeDates.getUs_ide_nome_processo(),);
    }


}
