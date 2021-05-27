package Usuario;

import DAO.UsuariosDAO;

public class UsuarioDatas {
    protected String us_nome_funcionario;
    protected String us_cargo;
    protected String us_login;
    protected String us_equipe;
    protected String us_senha;
    protected Boolean us_is_adm;
    protected Integer fk_id_empresa;

    public UsuarioDatas(String us_nome_funcionario, String us_cargo, String us_login, String us_equipe, String us_senha, Boolean us_is_adm, Integer fk_id_empresa) {
        this.us_nome_funcionario = us_nome_funcionario;
        this.us_cargo = us_cargo;
        this.us_login = us_login;
        this.us_equipe = us_equipe;
        this.us_senha = us_senha;
        this.us_is_adm = us_is_adm;
        this.fk_id_empresa = fk_id_empresa;
    }

    public UsuarioDatas() {

    }


    public String getUs_equipe() {
        return us_equipe;
    }

    public void setUs_equipe(String us_equipe) {
        this.us_equipe = us_equipe;
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

    public Boolean getUs_is_adm() {
        return us_is_adm;
    }

    public void setUs_is_adm(Boolean us_is_adm) {
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
        return "us_login='" + us_login + '\'' +
                ", us_senha='" + us_senha + '\'';
    }
}