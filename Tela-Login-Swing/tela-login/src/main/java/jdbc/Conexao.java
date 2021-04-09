package jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

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
    
    

}
