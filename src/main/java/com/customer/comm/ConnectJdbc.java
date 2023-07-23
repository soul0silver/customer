package com.customer.comm;

import com.customer.common.Common;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectJdbc {

    public static Connection con(){
        Connection connection;
        try {
             connection= DriverManager.getConnection(Common.MY_SQL_URL,Common.USERNAME_MYSQL,Common.PASSWORD_MYSQL);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
