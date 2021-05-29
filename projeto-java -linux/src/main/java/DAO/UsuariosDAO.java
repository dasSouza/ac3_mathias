package DAO;

import ConectionBDA.Conection;
import Usuario.UsuarioDatas;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Scanner;
import jdbc.Conexao;

public class UsuariosDAO {
    Conection conection = new Conection();
    Conexao con = new Conexao();
    JdbcTemplate template = new JdbcTemplate(con.getBanco());
    UsuarioDatas usuarioDatas = new UsuarioDatas();

    Scanner texto = new Scanner(System.in);
    String textos = texto.next();


    public void usuarioLogin() {
        List<UsuarioDatas> usersLogin = template.query("SELECT us_login,us_senha FROM tb_us_dados where id_cpf = '49633264752'", new BeanPropertyRowMapper(UsuarioDatas.class));
        for (UsuarioDatas usuario : usersLogin) {
            usuarioDatas.setUs_login(usuario.toString());
            System.out.println(usuarioDatas.getUs_login());
        }
    }

}
