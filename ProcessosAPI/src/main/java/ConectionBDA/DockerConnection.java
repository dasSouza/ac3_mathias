/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConectionBDA;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author DOM
 */
public class DockerConnection {

    private BasicDataSource bancoSql;

    public DockerConnection() {

        this.bancoSql = new BasicDataSource();
        bancoSql.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bancoSql.setUrl("jdbc:mysql://BancoKeepCode:3306/BancoKeepCode");
        bancoSql.setUsername("root");
        bancoSql.setPassword("urubu100");
    }

    public BasicDataSource getBanco() {
        return bancoSql;
    }
}
