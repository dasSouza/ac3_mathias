package ProcessoMaq;

public class MaquinaDatas {
    private Long us_ram_total;
    private String us_cpu_nome;
    private String us_name_pc;
    private Long us_disco_total;

    public String getUs_name_pc() {
        return us_name_pc;
    }

    public void setUs_name_pc(String us_name_pc) {
        this.us_name_pc = us_name_pc;
    }

    public Long getUs_ram_total() {
        return us_ram_total/1000000000l;
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
        return us_disco_total/1024l/1024l/1024l;
    }

    public void setUs_disco_total(Long us_disco_total) {
        this.us_disco_total = us_disco_total;
    }

    @Override
    public String toString() {
        return String.format("\nInformações da maquina\n" +
                        "\nNome da maquina: %s " +
                "\nRAM Total: %d " +
                "\nProcessador: %s " +
                "\nDisco Total: %d\n",
                getUs_name_pc(),
                getUs_ram_total(),
                getUs_cpu_nome(),
                getUs_disco_total());
    }
}
