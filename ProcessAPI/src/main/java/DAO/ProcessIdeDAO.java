package DAO;

import ConectionBDA.Conection;
import ProcessosIDE.ProcessDatas;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProcessIdeDAO {
    Conection conection = new Conection();
    JdbcTemplate template = new JdbcTemplate(conection.getDataSource());


    public void insertIdeProcess(ProcessDatas allIdeDates) {
        String insertProcessValues = "INSERT INTO tb_processos_ide (us_dt_hr_processo, us_ide_nome_processo, us_ide_ram, us_ide_cpu, us_ide_disco) VALUES ( GETDATE() , ? , ? , ?, ?)";
        template.update(insertProcessValues, allIdeDates.getUs_ide_nome_processo(),allIdeDates.getUs_ide_ram(), allIdeDates.getUs_ide_cpu(), allIdeDates.getUs_ide_disco());
        System.out.println("Inserindo no banco: " + allIdeDates.getUs_ide_nome_processo());
        System.out.println(allIdeDates.getUs_ide_ram());
        System.out.println(allIdeDates.getUs_ide_cpu());
        System.out.println(allIdeDates.getUs_ide_disco());
    }


}
