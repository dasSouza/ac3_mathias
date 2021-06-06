package tabelas;

/**
 *
 * @author mathias.de.carvalho
 */
public class TbUsDados {

    private Long id_cpf;
    private String us_nome_funcionario;
    private String us_cargo;
    private String us_login;
    private String us_senha;
    private String us_equipe;
    private String us_is_adm;
    private Integer fk_id_empresa;

    public Long getId_cpf() {
        return id_cpf;
    }

    public void setId_cpf(Long id_cpf) {
        this.id_cpf = id_cpf;
    }

    public String getUs_nome_funcionario() {
        return us_nome_funcionario;
    }

    public void setUs_nome_funcionario(String us_nome_funcionario) {
        this.us_nome_funcionario = us_nome_funcionario;
    }

    public String getUs_cargo() {
        return us_cargo;
    }

    public void setUs_cargo(String us_cargo) {
        this.us_cargo = us_cargo;
    }

    public String getUs_login() {
        return us_login;
    }

    public void setUs_login(String us_login) {
        this.us_login = us_login;
    }

    public String getUs_senha() {
        return us_senha;
    }

    public void setUs_senha(String us_senha) {
        this.us_senha = us_senha;
    }

    public String getUs_equipe() {
        return us_equipe;
    }

    public void setUs_equipe(String us_equipe) {
        this.us_equipe = us_equipe;
    }

    public String getUs_is_adm() {
        return us_is_adm;
    }

    public void setUs_is_adm(String us_is_adm) {
        this.us_is_adm = us_is_adm;
    }

    public Integer getFk_id_empresa() {
        return fk_id_empresa;
    }

    public void setFk_id_empresa(Integer fk_id_empresa) {
        this.fk_id_empresa = fk_id_empresa;
    }

    @Override
    public String toString() {
        return " TbUsDados{"
                + "\n id_cpf : " + id_cpf
                + "\n us_nome_funcionario : " + us_nome_funcionario
                + "\n us_cargo : " + us_cargo
                + "\n us_login :" + us_login
                + "\n us_senha : " + us_senha
                + "\n us_equipe : " + us_equipe
                + "\n us_is_adm : " + us_is_adm
                + "\n fk_id_empresa : " + fk_id_empresa + '}';
    }

}
