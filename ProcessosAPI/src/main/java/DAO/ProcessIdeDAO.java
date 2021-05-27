package DAO;

import ConectionBDA.Conection;
import ConectionBDA.ConectionMySql;
import ProcessosIDE.ProcessDatas;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProcessIdeDAO {
    Conection conection = new Conection();
    ConectionMySql conection2 = new ConectionMySql();
    JdbcTemplate template = new JdbcTemplate(conection.getDataSource());
    JdbcTemplate template2 = new JdbcTemplate(conection2.getDatasource());


    public void insertIdeProcess(ProcessDatas allIdeDates) {
        for (int i = 0; i < allIdeDates.getValoresNomeIDE().size(); i++) {
            Long disco = allIdeDates.getValoresDiscoIDE().get(i);
            String nomeIDE = allIdeDates.getValoresNomeIDE().get(i);
            Double ram = allIdeDates.getValoresRamIDE().get(i);
            Float cpu = allIdeDates.getValoresCpuIDE().get(i);

            String insertProcessValues = "INSERT INTO tb_processos_ide (us_dt_hr_start_IDE, us_dt_hr_end_IDE, us_ide_nome_processo, us_ide_ram, us_ide_cpu, us_ide_disco, fk_id_maquina) VALUES (GETDATE(), GETDATE(), ? , ? , ?, ?, 1)";
            String insertProcessValues2 = "INSERT INTO tb_processos_ide (us_dt_hr_start_IDE, us_dt_hr_end_IDE, us_ide_nome_processo, us_ide_ram, us_ide_cpu, us_ide_disco) VALUES (NOW(), NOW(), ? , ? , ?, ?)";
            template.update(insertProcessValues, nomeIDE,ram, cpu, disco);
            template2.update(insertProcessValues2, nomeIDE,ram, cpu, disco);
            System.out.println("inserindo no banco: " + "nome da IDE: " + nomeIDE + "\nRam: " + ram + "\nCPU:" + cpu + "\nDisco: " + disco);
        }
    }
    
    public void createTable() {
        template2.execute(
                "USE IF NOT EXISTS banco1;\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS tb_us_maquina (\n" +
                "  id_maquina BIGINT NOT NULL auto_increment primary key,\n" +
                "  us_nome_maquina VARCHAR(100) NOT NULL,\n" +
                "  us_vl_ram_total FLOAT NULL,\n" +
                "  us_vl_disco_total FLOAT NULL,\n" +
                "  us_vl_cpu_total VARCHAR(50) NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS tb_processos_ide (\n" +
                "  id_processos BIGINT NOT NULL auto_increment primary key,\n" +
                "  us_dt_hr_start_IDE DATETIME NULL,\n" +
                "  us_dt_hr_end_IDE DATETIME NULL,\n" +
                "  us_ide_nome_processo VARCHAR(255) NOT NULL,\n" +
                "  us_ide_ram FLOAT NOT NULL,\n" +
                "  us_ide_cpu FLOAT NOT NULL,\n" +
                "  us_ide_disco FLOAT NOT NULL\n" +
                ");");
    }
}
