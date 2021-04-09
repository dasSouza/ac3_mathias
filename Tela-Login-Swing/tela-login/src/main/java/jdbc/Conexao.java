package jdbc;

import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import tabelas.TbUsDados;

/**
 *
 * @author mathias.de.carvalho
 */
public class Conexao {

    private BasicDataSource banco;

    public Conexao() {
        this.banco = new BasicDataSource();
        this.banco = new BasicDataSource();
        banco.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        banco.setUrl("jdbc:sqlserver://grupo-8.database.windows.net;databaseName=kcode;");
        banco.setUsername("grupo-8");
        banco.setPassword("#Gfkcode8");
    }

    public BasicDataSource getBanco() {
        return banco;
    }

    public List<TbUsDados> query(String select__from_tb_us_dados_WHERE_us_login__, BeanPropertyRowMapper<TbUsDados> beanPropertyRowMapper, String string, String lj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
