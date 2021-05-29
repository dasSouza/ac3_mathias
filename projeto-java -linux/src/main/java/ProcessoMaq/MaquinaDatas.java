package ProcessoMaq;

import Usuario.UsuarioDatas;
import java.util.Iterator;
import java.util.List;
import jdbc.Conexao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MaquinaDatas {

    private Long us_ram_total;
    private Integer id_maquina;
    private String us_cpu_nome;
    private String us_name_pc;
    private Long us_disco_total;
    private Long fk_id_funcionario;

    public MaquinaDatas() {
        Usuario.UsuarioDatas usuarioDados = new Usuario.UsuarioDatas();
        this.fk_id_funcionario = usuarioDados.getId_cpf();
    }

    public String getUs_name_pc() {
        return us_name_pc;
    }

    public void setUs_name_pc(String us_name_pc) {
        this.us_name_pc = us_name_pc;
    }

    public Integer getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(Integer id_maquina) {
        this.id_maquina = id_maquina;
    }

    public Long getUs_ram_total() {
        return us_ram_total / 1000000000l;
    }

    public void setUs_ram_total(Long us_ram_total) {
        this.us_ram_total = us_ram_total;
    }

    public String getUs_cpu_nome() {
        return us_cpu_nome;
    }

    public void setUs_cpu_nome(String us_cpu_nome) {
        this.us_cpu_nome = us_cpu_nome;
    }

    public Long getUs_disco_total() {
        return us_disco_total / 1024l / 1024l / 1024l;
    }

    public void setUs_disco_total(Long us_disco_total) {
        this.us_disco_total = us_disco_total;
    }

    public Long getFk_id_funcionario() {
        return fk_id_funcionario;
    }

    public void setFk_id_funcionario(Long fk_id_funcionario) {
        this.fk_id_funcionario = fk_id_funcionario;
    }

    @Override
    public String toString() {
        return String.format("nome %s "
                + "ram = %d "
                + "cpu = %s "
                + "disco = %d",
                getUs_name_pc(),
                getUs_ram_total(),
                getUs_cpu_nome(),
                getUs_disco_total());
    }
}
