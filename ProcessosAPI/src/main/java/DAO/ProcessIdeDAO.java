package DAO;

import ConectionBDA.Conection;
import ConectionBDA.Conexao;
import ProcessosIDE.ProcessDatas;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProcessIdeDAO {
    Conection conection = new Conection();
    Conexao conection2 = new Conexao();
    JdbcTemplate template = new JdbcTemplate(conection.getDataSource());
    JdbcTemplate template2 = new JdbcTemplate(conection2.getDatasource());

    public void createTable() {
        template2.execute("IF NOT EXISTS" +
                "CREATE DATABASE banco1;\n" +
                "USE banco1;\n" +
                "\n" +
                "CREATE TABLE tb_us_maquina (\n" +
                "  id_maquina BIGINT NOT NULL auto_increment primary key,\n" +
                "  us_nome_maquina VARCHAR(100) NOT NULL,\n" +
                "  us_vl_ram_total FLOAT NULL,\n" +
                "  us_vl_disco_total FLOAT NULL,\n" +
                "  us_vl_cpu_total VARCHAR(50) NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE tb_processos_ide (\n" +
                "  id_processos BIGINT NOT NULL auto_increment primary key,\n" +
                "  us_dt_hr_start_IDE DATETIME NULL,\n" +
                "  us_dt_hr_end_IDE DATETIME NULL,\n" +
                "  us_ide_nome_processo VARCHAR(255) NOT NULL,\n" +
                "  us_ide_ram FLOAT NOT NULL,\n" +
                "  us_ide_cpu FLOAT NOT NULL,\n" +
                "  us_ide_disco FLOAT NOT NULL\n" +
                ");");
    }


    public void insertIdeProcess(ProcessDatas allIdeDates) {
        for (int i = 0; i < allIdeDates.getValoresNomeIDE().size(); i++) {
            Long disco = allIdeDates.getValoresDiscoIDE().get(i);
            String nomeIDE = allIdeDates.getValoresNomeIDE().get(i);
            Double ram = allIdeDates.getValoresRamIDE().get(i);
            Float cpu = allIdeDates.getValoresCpuIDE().get(i);

            String insertProcessValues = "INSERT INTO tb_processos_ide (us_dt_hr_start_IDE, us_dt_hr_end_IDE, us_ide_nome_processo, us_ide_ram, us_ide_cpu, us_ide_disco, fk_id_maquina) VALUES (GETDATE(), GETDATE(), ? , ? , ?, ?, 1)";
            template.update(insertProcessValues, nomeIDE,ram, cpu, disco);
            template2.update(insertProcessValues, nomeIDE,ram, cpu, disco);
            System.out.println("inserindo no banco: " + "nome da IDE: " + nomeIDE + "\nRam: " + ram + "\nCPU:" + cpu + "\nDisco: " + disco);
        }
    }

    public void getRamIde (ProcessDatas processRam) {
        List<ProcessDatas> usoRam = template.query( "SELECT us_ide_ram, us_ide_nome_processo " +
                "FROM tb_processos_ide AS processo " +
                "JOIN tb_us_maquina AS maq ON maq.id_maquina = processo.fk_id_maquina " +
                "AND fk_id_funcionario = 78806212028 " +
                "ORDER BY us_dt_hr_start_IDE", new BeanPropertyRowMapper(ProcessDatas.class));
        for(ProcessDatas usoDaVez: usoRam) {
            System.out.println("Nome Ide: " + usoDaVez.getUs_ide_nome_processo());
            System.out.println("Uso de Ram: " + usoDaVez.getUs_ide_ram());
        }

    }

    public void insertDiscoIde (ProcessDatas processDisco) {
        


    }

}
