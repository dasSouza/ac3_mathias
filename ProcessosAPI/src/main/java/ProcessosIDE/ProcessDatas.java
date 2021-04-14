package ProcessosIDE;
import java.util.Date;

public class ProcessDatas {
    private Date us_dt_hr_processo;
    private Date us_dt_start;
    private Date us_dt_end;
    private String us_ide_nome_processo;
    private Float us_ide_cpu;
    private long us_ide_disco;
    private Double us_ide_ram;

    public Date getUs_dt_hr_processo() {
        return us_dt_hr_processo;
    }

    public void setUs_dt_hr_processo(Date us_dt_hr_processo) {
        this.us_dt_hr_processo = us_dt_hr_processo;
    }

    public Date getUs_dt_start() {
        return us_dt_start;
    }

    public void setUs_dt_start(Date us_dt_start) {
        this.us_dt_start = us_dt_start;
    }

    public Date getUs_dt_end() {
        return us_dt_end;
    }

    public void setUs_dt_end(Date us_dt_end) {
        this.us_dt_end = us_dt_end;
    }

    public String getUs_ide_nome_processo() {
        return us_ide_nome_processo;
    }

    public void setUs_ide_nome_processo(String us_ide_nome_processo) {
        this.us_ide_nome_processo = us_ide_nome_processo;
    }

    public Float getUs_ide_cpu() {
        return us_ide_cpu;
    }

    public void setUs_ide_cpu(Float us_ide_cpu) {
        this.us_ide_cpu = us_ide_cpu;
    }

    public long getUs_ide_disco() {
        return us_ide_disco;
    }

    public void setUs_ide_disco(long us_ide_disco) {
        this.us_ide_disco = us_ide_disco;
    }

    public Double getUs_ide_ram() {
        return us_ide_ram;
    }

    public void setUs_ide_ram(Double us_ide_ram) {
        this.us_ide_ram = us_ide_ram;
    }


    @Override
    public String toString() {
        return String.format("Nome da Ide: %s " +
                "CPU: %.2f " +
                "RAM: %.2f " +
                "DISCO: %.2f ",
                getUs_ide_nome_processo(),
                getUs_ide_cpu(),
                getUs_ide_ram(),
                getUs_ide_disco());
    }
}
