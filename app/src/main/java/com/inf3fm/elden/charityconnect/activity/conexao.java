package com.inf3fm.elden.charityconnect.activity;

import android.os.StrictMode;

import net.sourceforge.jtds.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    public static Connection conectar () {
        Connection conn = null;
        try {
            StrictMode.ThreadPolicy politica;
            politica = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);

            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://FI-122170600778" +
                   "databaseName=Banco_Android;user=sa;password=@ITB123456;");
        }catch (SQLException e) {
           e.getMessage();
        }catch (ClassNotFoundException e){
           e.printStackTrace();
        }
        return conn;
    }
}
