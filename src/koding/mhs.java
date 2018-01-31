/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koding;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import koneksi.Koneksi;
import penentu_ukt.InputUser;
/**
 *
 * @author Al-Habib
 */
public class mhs {
     private Koneksi db = new Koneksi();
    private Connection koneksi;
    private double pbo=0;
     double ukt = 0;
     String a,b,c,d,e,f,g,h,i,j,k,l;
     int ab,ba,ac,ca,ad,da,ae,ea;
     public Connection conn;
     private String username,pass;
   
     //data Seluruh Mhs
    HashMap <String,Mahasiswa> daftarMhs = new HashMap<>();
    
    //data Mhs dengan Ortu
    HashMap <String,Ortu> daftarOrtu = new HashMap<>();
    
    public mhs(){
        
    }
    
    public void loadUser(){
        db.dbConnection();
        try {
            String sql = "SELECT * FROM user WHERE username = '" + username + "' AND pass = '" + pass + "'";
            Statement st = db.getConnection().createStatement();
            ResultSet rsLogin = st.executeQuery(sql);
            while(rsLogin.next()){
                this.username = rsLogin.getNString("username");
                this.pass = rsLogin.getNString("pass");
            }
            
    }catch (SQLException e) {
        }
    }
    public void loadMhs(){
        conn = null;
        Statement stmt;
        try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/dbukt","root","");
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tmhs");
                while(rs.next()){
                    this.a = rs.getString("Nama");
                    this.b = rs.getString("Tmpt");
                    this.c = rs.getString("Tgl");
                    this.d = rs.getString("JK");
                    this.e = rs.getString("Alamat");
                    this.f = rs.getString("Provinsi");
                    this.g = rs.getString("AsalS");
                    this.h = rs.getString("Jurusan");
                    this.i = rs.getString("Bidik");
                    this.j = rs.getString("Mandiri");
                }
                Mahasiswa ab = new Mahasiswa(a, b, c, d, e, f, g, h,i,j);
                daftarMhs.put(username, ab);
            }
            catch(Exception p) {
                JOptionPane.showMessageDialog(null, p);
            }
    }
    public void loadOrtu(){
        conn = null;
        Statement stmt;
        try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/dbukt","root","");
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM tortu");
                while(rs.next()){
                    this.a = rs.getString("NamaA");
                    this.b = rs.getString("NamaI");
                    this.c = rs.getString("PkerA");
                    this.d = rs.getString("PkerI");
                    this.ab = rs.getInt("JmlS");
                    this.ba = rs.getInt("JmlT");
                    this.ae = rs.getInt("GajiA");
                    this.ea = rs.getInt("GajiI");
                    this.ac = rs.getInt("Listrik");
                    this.ca = rs.getInt("Air");
                    this.ad = rs.getInt("PBB");
                    this.da = rs.getInt("PjkK");
                   
                }
                Ortu abc = new Ortu(a, b, c, d, ab, ba, ae, ea, ac, ca, ad, da);
                daftarOrtu.put(username, abc);
            }
            catch(Exception p) {
                JOptionPane.showMessageDialog(null, p);
            }
    }
    public void printmhs(){
            for (Map.Entry<String, Mahasiswa> entry : daftarMhs.entrySet()) {
                String key = entry.getKey();
                Mahasiswa value = entry.getValue();
                value.print();
            }
            System.out.println();
        }
    public void printortu(){
            
            for (Map.Entry<String, Ortu> entry : daftarOrtu.entrySet()) {
                String key = entry.getKey();
                Ortu value = entry.getValue();
                value.print();
            }
            System.out.println();
        }
    public void HitungUkt(){
              for (Map.Entry<String, Mahasiswa> entry : daftarMhs.entrySet()) {
                  String key = entry.getKey();
                  Mahasiswa value = entry.getValue();
                  System.out.println("Nama\t\t:\t"+value.getName());
                  if(value.getBidik().equals("Iya")){
                      this.ukt = 0;
                      this.pbo = ukt;
                  }else if(value.getBidik().equals("Tidak")){
                      if(value.getMandiri().equals("Iya")){
                          if(value.getJurusan().equals("Teknik Informatika")){
                              this.ukt = 9000000;
                              this.pbo = ukt;
                          }else{
                              this.ukt = 9500000;
                              this.pbo = ukt;
                          }
                      }else if(value.getMandiri().equals("Tidak")){
                                int nilai = daftarOrtu.get(key).getGajiA()+daftarOrtu.get(key).getGajiI();
                                double tanggungan = (daftarOrtu.get(key).getGajiA()*0.2)*daftarOrtu.get(key).getJmlT();
                                int hitung = daftarOrtu.get(key).getAir()+daftarOrtu.get(key).getListrik()+daftarOrtu.get(key).getPBB()+daftarOrtu.get(key).getPjkK();
                                double sisa = nilai - ( tanggungan + hitung);
                                this.ukt = (sisa*0.5)*6;
                                
                      }
                  }
              }
               System.out.print("Biaya UKT\t:\t");
               if(this.ukt==0){
                    System.out.println("Rp. 0,-");
                  System.out.println("Bidikmisi");
               }
               if(this.ukt<=500000){
                   this.pbo = 500000;
                   System.out.println("Rp. 500.000,-");
                  System.out.println("Golongan\t:\t1");
              }else if(this.ukt<=1000000){
                  this.pbo = 1000000;
                   System.out.println("Rp. 1.000.000,-");
                  System.out.println("Golongan\t:\t2");
              }else if (this.ukt<=2000000) {
                  this.pbo = 2000000;
                   System.out.println("Rp. 2.000.000,-");
                  System.out.println("Golongan\t:\t3");
              }else if(this.ukt<=3500000){
                 this.pbo = 3500000;  
                  System.out.println("Rp. 3.500.000,-");
                  System.out.println("Golongan\t:\t4");
              }else if (this.ukt<=4500000) {
                  this.pbo = 4500000;
                   System.out.println("Rp. 4.500.000,-");
                  System.out.println("Golongan\t:\t5");
              }else if (this.ukt<=6000000) {
                  this.pbo = 6000000;
                  System.out.println("Rp. 6.000.000,-");
                  System.out.println("Golongan\t:\t6");
              }else if (this.ukt<=7500000) {
                  this.pbo = 7500000; 
                  System.out.println("Rp. 7.500.000,-");
                  System.out.println("Golongan\t:\t7");
              }else if (this.ukt<=9000000) {
                  this.pbo = 9000000;
                  System.out.println("Rp. 9.000.000,-");
                  System.out.println("Golongan\t:\t8");
              }else if (this.ukt<=9500000) {
                   System.out.println("Rp. 9.500.000,-");
                  System.out.println("Golongan\t:\t8");
              }
              System.out.println();
          }
    public void masukkanUKT(){
        String mhs="";
         conn = null;
        Statement stmt;
        for (Map.Entry<String, Mahasiswa> entry : daftarMhs.entrySet()) {
            String key = entry.getKey();
            Mahasiswa value = entry.getValue();
            mhs = daftarMhs.get(key).getName();
        }
         try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/dbukt","root","");
                stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO uktmhs VALUES('"+mhs+"', '"+pbo+"')");
                System.out.println("UKT Sudah ditambahkan ke Database!");
            }
            catch(Exception p) {
                JOptionPane.showMessageDialog(null, p);
            }
        System.out.println();
    }

    public static void main(String [] args){
        mhs a = new mhs();
        a.loadMhs();
        a.printmhs();
        a.loadOrtu();
        a.printortu();
        a.HitungUkt();
        a.masukkanUKT();
    }
}