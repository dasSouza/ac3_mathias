package tabelas;

/**
 *
 * @author mathias.de.carvalho
 */
public class TbUsMaquina {

    private Long id_maquina;
    private String us_nome_maquina;
    private Float us_vl_ram_total;
    private Float us_vl_disco_total;
    private String us_vl_cpu_total;
    private Long fk_id_funcionario;

    public Long getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(Long id_maquina) {
        this.id_maquina = id_maquina;
    }

    public String getUs_nome_maquina() {
        return us_nome_maquina;
    }

    public void setUs_nome_maquina(String us_nome_maquina) {
        this.us_nome_maquina = us_nome_maquina;
    }

    public Float getUs_vl_ram_total() {
        return us_vl_ram_total;
    }

    public void setUs_vl_ram_total(Float us_vl_ram_total) {
        this.us_vl_ram_total = us_vl_ram_total;
    }

    public Float getUs_vl_disco_total() {
        return us_vl_disco_total;
    }

    public void setUs_vl_disco_total(Float us_vl_disco_total) {
        this.us_vl_disco_total = us_vl_disco_total;
    }

    public String getUs_vl_cpu_total() {
        return us_vl_cpu_total;
    }

    public void setUs_vl_cpu_total(String us_vl_cpu_total) {
        this.us_vl_cpu_total = us_vl_cpu_total;
    }

    public Long getFk_id_funcionario() {
        return fk_id_funcionario;
    }

    public void setFk_id_funcionario(Long fk_id_funcionario) {
        this.fk_id_funcionario = fk_id_funcionario;
    }

    @Override
    public String toString() {
        return String.format("TbUsMaquina: \n"
                + "id_maquina: %x \n "
                + "us_nome_maquina: %s \n"
                + "us_vl_ram_total: %f"
                + "us_vl_disco_total: %s"
                + "us_vl_cpu_total: %s"
                + "fk_id_funcionario: %x", id_maquina, us_nome_maquina, us_vl_ram_total, us_vl_disco_total, us_vl_cpu_total, fk_id_funcionario);

//        return "TbUsMaquina{" + "id_maquina=" + id_maquina + ", us_nome_maquina=" + us_nome_maquina + ", us_vl_ram_total=" + us_vl_ram_total + ", us_vl_disco_total=" + us_vl_disco_total + ", us_vl_cpu_total=" + us_vl_cpu_total + ", fk_id_funcionario=" + fk_id_funcionario + '}';
    }

}
