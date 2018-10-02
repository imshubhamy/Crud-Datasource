/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud.datasource;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.servlet.*;
import javax.sql.DataSource;

/**
 *
 * @author Admin
 */


@Startup
@Singleton
public class StartupService {
     
    @Resource(lookup="jdbc/__derby")
    private DataSource dataSource;
 
    @PostConstruct
    public void init() {
        try (Connection connection = dataSource.getConnection()) {
            out.println(
                connection.getMetaData().getDatabaseProductName() + "-" +
                connection.getCatalog()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
}

