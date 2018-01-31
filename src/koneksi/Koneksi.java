/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Al-Habib
 */
//public class konek {
//    private static Connection koneksi;
//    
//    public static Connection GetConnection()throws SQLException{
//        if(koneksi==null){
//            new Driver();
//            
//            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbukt","root","");
//        }return koneksi;
//    }
 
/**
 *
 * @author www.kangsunu.web.id
 */
public class Koneksi {
    private Connection connection;
 
    public Connection getConnection() {
        return connection;
    }
 
    public void dbConnection() { //<-- untuk koneksi ke database
        // Cek Driver
        try {
            Class.forName("com.mysql.jdbc.Driver"); //<-- nama driver untuk koneksi ke MySQL
 
            // Cek Database
            try {
                String url, user, password;
                url = "jdbc:mysql://localhost:3306/dbukt"; //alamat DB
                user = "root";
                password = "";
                connection = DriverManager.getConnection(url, user, password);
 
                System.out.println("Koneksi Sukses");
            } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal! " + se);
                System.exit(0);
            }
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!" + cnfe);
            System.exit(0);
        }
    }
 
    public static void main(String[] kon) {
        new Koneksi().dbConnection();
    }
}
