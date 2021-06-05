package ProcessoMaq;

public class IdeMaq {

    Integer id_ide;
    String us_nome_ide;

    public IdeMaq() {
    }

    public Integer getId_ide() {
        return id_ide;
    }

    public void setId_ide(Integer id_ide) {
        this.id_ide = id_ide;
    }

    public String getUs_nome_ide() {
        return us_nome_ide;
    }

    public void setUs_nome_ide(String us_nome_ide) {
        this.us_nome_ide = us_nome_ide;
    }

    @Override
    public String toString() {
        return "\n IdeMaq: "
                + "id_ide: " + id_ide
                + ", us_nome_ide: " + us_nome_ide;
    }

}
