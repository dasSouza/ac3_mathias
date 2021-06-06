package ProcessoMaq;

public class MaquinaDatas {

    private Integer id_maquina;
    private Long us_vl_ram_total;
    private String us_vl_cpu_total;
    private String us_nome_maquina;
    private Long us_vl_disco_total;
    private Long fk_id_funcionario;

    public String getUs_name_pc() {
        return us_nome_maquina;
    }

    public void setUs_name_pc(String us_name_pc) {
        this.us_nome_maquina = us_name_pc;
    }

    public Integer getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(Integer id_maquina) {
        this.id_maquina = id_maquina;
    }

    public Long getUs_ram_total() {
        return us_vl_ram_total / 1000000000l;
    }

    public void setUs_ram_total(Long us_ram_total) {
        this.us_vl_ram_total = us_ram_total;
    }

    public String getUs_cpu_nome() {
        return us_vl_cpu_total;
    }

    public void setUs_cpu_nome(String us_cpu_nome) {
        this.us_vl_cpu_total = us_cpu_nome;
    }

    public Long getUs_disco_total() {
        return us_vl_disco_total / 1024l / 1024l / 1024l;
    }

    public void setUs_disco_total(Long us_disco_total) {
        this.us_vl_disco_total = us_disco_total;
    }

    public Long getFk_id_funcionario() {
        return fk_id_funcionario;
    }

    public void setFk_id_funcionario(Long fk_id_funcionario) {
        this.fk_id_funcionario = fk_id_funcionario;
    }

    @Override
    public String toString() {
        return "MaquinaDatas{"
                + "id_maquina=" + id_maquina
                + ", us_vl_ram_total=" + us_vl_ram_total
                + ", us_vl_cpu_total='" + us_vl_cpu_total + '\''
                + ", us_nome_maquina='" + us_nome_maquina + '\''
                + ", us_vl_disco_total=" + us_vl_disco_total
                + ", fk_id_funcionario=" + fk_id_funcionario
                + '}';
    }
}
