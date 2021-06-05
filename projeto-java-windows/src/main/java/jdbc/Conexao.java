package jdbc;

import com.mycompany.projeto.java.TelaLogin;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import log.GerandoLog;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author mathias.de.carvalho
 */
public class Conexao {

    private BasicDataSource banco;

    public Conexao() {

        GerandoLog gravandoLog = new GerandoLog();

        try {
            gravandoLog.gravarLog("conectando com o banco");

        } catch (IOException ex) {

            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

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
