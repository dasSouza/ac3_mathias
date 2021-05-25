package DAO;

import ConectionBDA.Conection;
import ProcessosIDE.ProcessDatas;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProcessIdeDAO {
    Conection conection = new Conection();
    JdbcTemplate template = new JdbcTemplate(conection.getDataSource());


    public void insertIdeProcess(ProcessDatas allIdeDates) {
        for (int i = 0; i < allIdeDates.getValoresNomeIDE().size(); i++) {
            Long disco = allIdeDates.getValoresDiscoIDE().get(i);
            String nomeIDE = allIdeDates.getValoresNomeIDE().get(i);
            Double ram = allIdeDates.getValoresRamIDE().get(i);
            Float cpu = allIdeDates.getValoresCpuIDE().get(i);

            String insertProcessValues = "INSERT INTO tb_processos_ide (us_dt_hr_start_IDE, us_dt_hr_end_IDE, us_ide_nome_processo, us_ide_ram, us_ide_cpu, us_ide_disco, fk_id_maquina) VALUES (GETDATE(), GETDATE(), ? , ? , ?, ?, 2)";
            template.update(insertProcessValues, nomeIDE,ram, cpu, disco);
            System.out.println("inserindo no banco: " + "nome da IDE: " + nomeIDE + "\nRam: " + ram + "\nCPU:" + cpu + "\nDisco: " + disco);
        }
    }

    public void getRamIde (ProcessDatas processRam) {
        List<ProcessDatas> usoRam = template.query( "SELECT us_ide_ram, us_ide_nome_processo " +
                "FROM tb_processos_ide AS processo " +
                "JOIN tb_us_maquina AS maq ON maq.id_maquina = processo.fk_id_maquina " +
                "AND fk_id_funcionario = 2578386005 " +
                "ORDER BY us_dt_hr_start_IDE", new BeanPropertyRowMapper(ProcessDatas.class));
        for(ProcessDatas usoDaVez: usoRam) {
            System.out.println("Nome Ide: " + usoDaVez.getUs_ide_nome_processo());
            System.out.println("Uso de Ram: " + usoDaVez.getUs_ide_ram());
        }

    }

    public void insertDiscoIde (ProcessDatas processDisco) {
        


    }

}
