package ProcessoMaq;

public class MaquinaDatas {
    private Long us_vl_ram_total;
    private String us_nome_maquina;
    private String us_vl_cpu_total;
    private Long us_vl_disco_total;

 
    

    public Long getUs_vl_ram_total() {
        return us_vl_ram_total;
    }

    public void setUs_vl_ram_total(Long us_vl_ram_total) {
        this.us_vl_ram_total = us_vl_ram_total;
    }

    public String getUs_nome_maquina() {
        return us_nome_maquina;
    }

    public void setUs_nome_maquina(String us_nome_maquina) {
        this.us_nome_maquina = us_nome_maquina;
    }

    public String getUs_vl_cpu_total() {
        return us_vl_cpu_total;
    }

    public void setUs_vl_cpu_total(String us_vl_cpu_total) {
        this.us_vl_cpu_total = us_vl_cpu_total;
    }

    public Long getUs_vl_disco_total() {
        return us_vl_disco_total;
    }

    public void setUs_vl_disco_total(Long us_vl_disco_total) {
        this.us_vl_disco_total = us_vl_disco_total;
    }

    

    @Override
    public String toString() {
        return String.format("nome %s " +
                "ram = %d " +
                "cpu = %s " +
                "disco = %d",
                getUs_nome_maquina(),
                getUs_vl_cpu_total(),
                getUs_vl_disco_total(),
                getUs_vl_ram_total());
    }
}
