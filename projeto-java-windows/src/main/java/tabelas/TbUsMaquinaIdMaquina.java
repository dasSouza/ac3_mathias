package tabelas;

public class TbUsMaquinaIdMaquina {

    private Long tb_us_maquina_id_maquina;
    private Long tb_ide_maquina_id_ide;

    public Long getTb_us_maquina_id_maquina() {
        return tb_us_maquina_id_maquina;
    }

    public void setTb_us_maquina_id_maquina(Long tb_us_maquina_id_maquina) {
        this.tb_us_maquina_id_maquina = tb_us_maquina_id_maquina;
    }

    public Long getTb_ide_maquina_id_ide() {
        return tb_ide_maquina_id_ide;
    }

    public void setTb_ide_maquina_id_ide(Long tb_ide_maquina_id_ide) {
        this.tb_ide_maquina_id_ide = tb_ide_maquina_id_ide;
    }

    @Override
    public String toString() {
        return "TbUsMaquinaIdMaquina: " + "tb_us_maquina_id_maquina = " + tb_us_maquina_id_maquina + ", tb_ide_maquina_id_ide = " + tb_ide_maquina_id_ide;
    }

}
