package ConectionBDA;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexao {
    private BasicDataSource datasource;

    public Conexao() {
        this.datasource = new BasicDataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/banco1");
        datasource.setUsername("root");
        datasource.setPassword("urubu100");

    }
    public BasicDataSource getDatasource() {
        return datasource;
    }
}
