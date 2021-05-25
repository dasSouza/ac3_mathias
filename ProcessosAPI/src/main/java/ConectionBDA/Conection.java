package ConectionBDA;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conection {
    private BasicDataSource dataSource;

       public Conection() {
            this.dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://127.0.0.1:3306");
            dataSource.setUsername("root");
            dataSource.setPassword("admin");
        }


        public BasicDataSource getDataSource() {
            return dataSource;
        }

    }
