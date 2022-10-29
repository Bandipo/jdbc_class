package com.baog.util;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public enum DatabaseConnection {

    INSTANCE;

    public DataSource getDatasource(){

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl("jdbc:mysql://localhost/my_shop?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");


        return dataSource;

    }

    public boolean isConnectionValid(){

        try(Connection connection = getDatasource().getConnection()){

            return connection.isValid(0);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

      return false;
    }
}
