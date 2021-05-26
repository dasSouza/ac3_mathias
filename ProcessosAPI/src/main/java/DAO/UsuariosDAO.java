package DAO;

import ConectionBDA.Conection;
import ConectionBDA.Conexao;
import Usuario.UsuarioDatas;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UsuariosDAO  {
    Conection conection = new Conection();
    Conexao conection2 = new Conexao();
    JdbcTemplate template = new JdbcTemplate(conection.getDataSource());
    JdbcTemplate template2 = new JdbcTemplate(conection2.getDatasource());
    public UsuarioDatas usuario = new UsuarioDatas();

    public void usuarioLogin(String login, String senha) {
        System.out.println("\nBuscando dados de usuario:\n");
        List<UsuarioDatas> usersLogin = template.query("SELECT * FROM tb_us_dados WHERE us_login = ? AND us_senha = ?", new BeanPropertyRowMapper(UsuarioDatas.class),login,senha);
        for (UsuarioDatas usuarios : usersLogin) {
            usuarios.setUs_nome_funcionario(usuarios.getUs_nome_funcionario());
            usuario.setUs_login(usuarios.getUs_login());
            usuario.setUs_cargo(usuarios.getUs_cargo());
            usuario.setUs_equipe(usuarios.getUs_equipe());
            usuario.setFk_id_empresa(usuarios.getFk_id_empresa());
            usuario.setUs_senha(usuarios.getUs_senha());
            usuario.setUs_cargo(usuarios.getUs_cargo());
            usuario.setUs_is_adm(usuarios.getUs_is_adm());
            System.out.println(usuarios.toString());
        }
    }

}
