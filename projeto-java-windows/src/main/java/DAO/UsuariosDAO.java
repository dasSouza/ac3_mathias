//package DAO;
//
//import ConectionBDA.Conection;
//import ProcessoMaq.UsuarioDatas;
//import java.io.IOException;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.util.List;
//import java.util.Scanner;
//import jdbc.Conexao;
//import log.GerandoLog;
//
//public class UsuariosDAO extends UsuarioDatas{
//    Conection conection = new Conection();
//    Conexao con = new Conexao();
//    JdbcTemplate template = new JdbcTemplate(con.getBanco());
//    UsuarioDatas usuarioDatas = new UsuarioDatas();
//
//    Scanner texto = new Scanner(System.in);
//    String textos = texto.next();
//  
//    CLASSE NAO SENDO UTILIZADA
// 
//    public void usuarioLogin() throws IOException {
//        List<UsuarioDatas> usersLogin = template.query("SELECT us_login,us_senha FROM tb_us_dados where id_cpf = '?' ", new BeanPropertyRowMapper(UsuarioDatas.class), super.getId_cpf());
//        
//        for (UsuarioDatas usuario : usersLogin) {
//            usuarioDatas.setUs_login(usuario.toString());
//            System.out.println(usuarioDatas.getUs_login());
//        }
//        
//        GerandoLog gerarLog = new GerandoLog();
//        try {
//            gerarLog.gravarLog("\n selecionando ");
//
//        } catch (IOException e) {
//            
//            gerarLog.gravarLog(String.format("%s", e));
//
//        }
//    }
//
//}
