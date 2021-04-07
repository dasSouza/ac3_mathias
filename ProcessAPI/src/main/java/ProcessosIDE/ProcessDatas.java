package ProcessosIDE;
import java.util.Date;

public class ProcessDatas {

    private Date us_dt_start;
    private Date us_dt_end;
    private String us_ide_nome_processo;
    private Double us_ide_disco;
    private Double us_ide_ram;

    public Date getUs_dt_end() {
        return us_dt_end;
    }

    public void setUs_dt_end(Date us_dt_end) {
        this.us_dt_end = us_dt_end;
    }

    public Double getUs_ide_ram() {
        return us_ide_ram;
    }

    public void setUs_ide_ram(Double us_ide_ram) {
        this.us_ide_ram = us_ide_ram;
    }

    public Double getGet_ide_cpu() {
        return get_ide_cpu;
    }

    public void setGet_ide_cpu(Double get_ide_cpu) {
        this.get_ide_cpu = get_ide_cpu;
    }

    private Double get_ide_cpu;

    public Date getUs_dt_start() {
        return us_dt_start;
    }

    public void setUs_dt_start(Date us_dt_start) {
        this.us_dt_start = us_dt_start;
    }

    public String getUs_ide_nome_processo() {
        return this.us_ide_nome_processo;
    }

    public void setUs_ide_nome_processo(String us_ide_nome_processos) {
        this.us_ide_nome_processo = us_ide_nome_processos;
    }

    public Double getUs_ide_disco() {
        return us_ide_disco;
    }

    public void setUs_ide_disco(Double us_ide_disco) {
        this.us_ide_disco = us_ide_disco;
    }
}
