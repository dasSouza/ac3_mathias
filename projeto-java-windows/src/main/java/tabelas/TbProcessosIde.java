package tabelas;

/**
 *
 * @author DOM
 */
public class TbProcessosIde {

    private Integer id_processos;
    private String us_dt_hr_start_IDE;
    private String us_dt_hr_end_IDE;
    private String us_ide_nome_processo;
    private Integer us_ide_ram;
    private Integer us_ide_cpu;
    private Integer us_ide_disco;
    private Long fk_id_maquina;

    public Integer getId_processos() {
        return id_processos;
    }

    public void setId_processos(Integer id_processos) {
        this.id_processos = id_processos;
    }

    public String getUs_dt_hr_start_IDE() {
        return us_dt_hr_start_IDE;
    }

    public void setUs_dt_hr_start_IDE(String us_dt_hr_start_IDE) {
        this.us_dt_hr_start_IDE = us_dt_hr_start_IDE;
    }

    public String getUs_dt_hr_end_IDE() {
        return us_dt_hr_end_IDE;
    }

    public void setUs_dt_hr_end_IDE(String us_dt_hr_end_IDE) {
        this.us_dt_hr_end_IDE = us_dt_hr_end_IDE;
    }

    public String getUs_ide_nome_processo() {
        return us_ide_nome_processo;
    }

    public void setUs_ide_nome_processo(String us_ide_nome_processo) {
        this.us_ide_nome_processo = us_ide_nome_processo;
    }

    public Integer getUs_ide_ram() {
        return us_ide_ram;
    }

    public void setUs_ide_ram(Integer us_ide_ram) {
        this.us_ide_ram = us_ide_ram;
    }

    public Integer getUs_ide_cpu() {
        return us_ide_cpu;
    }

    public void setUs_ide_cpu(Integer us_ide_cpu) {
        this.us_ide_cpu = us_ide_cpu;
    }

    public Integer getUs_ide_disco() {
        return us_ide_disco;
    }

    public void setUs_ide_disco(Integer us_ide_disco) {
        this.us_ide_disco = us_ide_disco;
    }

    public Long getFk_id_maquina() {
        return fk_id_maquina;
    }

    public void setFk_id_maquina(Long fk_id_maquina) {
        this.fk_id_maquina = fk_id_maquina;
    }

    @Override
    public String toString() {
        return " TbProcessosIde{ \n"
                + "id_processos : " + id_processos
                + "\n us_dt_hr_start_IDE : " + us_dt_hr_start_IDE
                + "\n us_dt_hr_end_IDE : " + us_dt_hr_end_IDE
                + "\n us_ide_nome_processo : " + us_ide_nome_processo
                + "\n us_ide_ram : " + us_ide_ram
                + "\n us_ide_cpu : " + us_ide_cpu
                + "\n us_ide_disco : " + us_ide_disco
                + "\n fk_id_maquina : " + fk_id_maquina + '}';
    }

}
