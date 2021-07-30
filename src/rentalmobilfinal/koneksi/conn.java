package rentalmobilfinal.koneksi;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kalingga Padel
 */
public class conn {
    private Connection conn;
    public  Connection conn(){
        try {
            String url = "jdbc:mysql://localhost/rental";
            conn =  (Connection) DriverManager.getConnection(url, "root", "");
            System.out.println("koneksi berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(conn.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("koneksi gagal");
        }
        return conn;
    }
}
