package ProcessoMaq;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessDatas extends MaquinaDatas {

    public List<String> valoresNomeIDE = new ArrayList<>();
    public List<Double> valoresRamIDE = new ArrayList<>();
    public List<Double> valoresCpuIDE = new ArrayList<>();
    public List<Long> valoresDiscoIDE = new ArrayList<>();

    private Date us_dt_hr_processo;
    private Date us_dt_start;
    private Date us_dt_end;
    private String us_ide_nome_processo;
    private Double us_ide_cpu;
    private Long us_ide_disco;
    private Double us_ide_ram;
    private Integer fk_id_maquina;

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

    public Double getUs_ide_cpu() {
        return us_ide_cpu;
    }

    public void setUs_ide_cpu(Double us_ide_cpu) {
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

    public List<String> getValoresNomeIDE() {
        return valoresNomeIDE;
    }

    public void setValoresNomeIDE(List<String> valoresNomeIDE) {
        this.valoresNomeIDE = valoresNomeIDE;
    }

    public List<Double> getValoresRamIDE() {
        return valoresRamIDE;
    }

    public void setValoresRamIDE(List<Double> valoresRamIDE) {
        this.valoresRamIDE = valoresRamIDE;
    }

    public List<Double> getValoresCpuIDE() {
        return valoresCpuIDE;
    }

    public void setValoresCpuIDE(List<Double> valoresCpuIDE) {
        this.valoresCpuIDE = valoresCpuIDE;
    }

    public List<Long> getValoresDiscoIDE() {
        return valoresDiscoIDE;
    }

    public void setValoresDiscoIDE(List<Long> valoresDiscoIDE) {
        this.valoresDiscoIDE = valoresDiscoIDE;
    }


    public void setFk_id_maquina(Integer fk_id_maquina) {
        this.fk_id_maquina = fk_id_maquina;
    }

}
