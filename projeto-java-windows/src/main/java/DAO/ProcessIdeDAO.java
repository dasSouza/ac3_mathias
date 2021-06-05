package DAO;

//import ConectionBDA.Conection;
import ProcessoMaq.MaquinaDatas;
import ProcessosIDE.ProcessDatas;
import jdbc.Conexao;
import org.springframework.jdbc.core.JdbcTemplate;
import java.io.IOException;
import java.util.List;
import log.GerandoLog;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class ProcessIdeDAO {

    
    
//    Conection conection = new Conection();
    Conexao con = new Conexao();
    JdbcTemplate template = new JdbcTemplate(con.getBanco());

    public void getFkIdMaquina(Usuario.UsuarioDatas usuario) {

        List<MaquinaDatas> pegandoFkMaq = template.query("SELECT * FROM tb_us_maquina WHERE fk_id_funcionario = ?",
                new BeanPropertyRowMapper<>(MaquinaDatas.class), usuario.getId_cpf());

        for (MaquinaDatas maquinaDatas : pegandoFkMaq) {
            
            maquinaDatas.setId_maquina(maquinaDatas.getId_maquina());
            
        }

        System.out.println(pegandoFkMaq);

//        return pegandoFkMaq;
    }
    
    
    public void insertIdeProcess(ProcessDatas allIdeDates) throws IOException {
        GerandoLog gerarLog = new GerandoLog();
//            List<MaquinaDatas> fk = pro;
        
        for (int i = 0; i < allIdeDates.getValoresNomeIDE().size(); i++) {
            Long disco = allIdeDates.getValoresDiscoIDE().get(i);
            String nomeIDE = allIdeDates.getValoresNomeIDE().get(i);
            Double ram = allIdeDates.getValoresRamIDE().get(i);
            Float cpu = allIdeDates.getValoresCpuIDE().get(i);

//            System.out.println(String.format("\n Sabendo o resto: \n"
//                    + "nome da IDE: %s \n"
//                    + "Ram: %s \n"
//                    + "CPU: %s \n"
//                    + "Disco: %s \n"
//                    + "Fk id da maquina: %s", nomeIDE, ram, cpu, disco, allIdeDates.getFk_id_maquina()));

            String insertProcessValues = "INSERT INTO tb_processos_ide (us_dt_hr_start_IDE, us_dt_hr_end_IDE, us_ide_nome_processo, us_ide_ram, us_ide_cpu, us_ide_disco, fk_id_maquina) VALUES (GETDATE(), GETDATE(), ? , ? , ?, ?, ?)";
            template.update(insertProcessValues, nomeIDE, ram, cpu, disco);

            System.out.println(String.format("\n Inserindo no banco: \n"
                    + "nome da IDE: %s \n"
                    + "Ram: %s \n"
                    + "CPU: %s \n"
                    + "Disco: %s \n"
                    + "Fk id da maquina: %s", nomeIDE, ram, cpu, disco));

        }

        try {
            gerarLog.gravarLog("\n inserindo dados de maquina");

        } catch (IOException e) {
            gerarLog.gravarLog(String.format("%s", e));

        }
    }

    public void pegandoUsuario(Usuario.UsuarioDatas usuario) {

    }
}
