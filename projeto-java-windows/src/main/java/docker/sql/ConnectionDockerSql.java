package docker.sql;

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
public class ConnectionDockerSql{

    private BasicDataSource bancoSql;

    public ConnectionDockerSql() {

      

        this.bancoSql = new BasicDataSource();
        bancoSql.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bancoSql.setUrl("jdbc:mysql://0.0.0.0:3306/KeepCodeBD?autoReconnect=true&useSSL=false");
        bancoSql.setUsername("root");
        bancoSql.setPassword("urubu100");
    }

    public BasicDataSource getBanco() {
        return bancoSql;
    }

}
