package com.inf3fm.elden.charityconnect.activity;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection conectar () {
        Connection conn = null;
        try {
            StrictMode.ThreadPolicy politica;
            politica = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);

            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://bd_CharityConnect_INF3FM.mssql.somee.com;databaseName=bd_CharityConnect_INF3FM;user=gustavo;password=41943419;");
        }catch (SQLException e) {
           e.getMessage();
        }catch (ClassNotFoundException e){
           e.printStackTrace();
        }
        return conn;
    }
}
