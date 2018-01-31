/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koding;
import koneksi.*;


/**
 *
 * @author Al-Habib
 */
public class Mahasiswa {
    // nim mahasiswa
    private String name,address,tmpt,tgl,jk,asalsekolah,jurusan,prov,mandiri,bidik;

    //Lengkapi
    //Constructor
    public Mahasiswa(String name, String tempat,String tanggal,String jk,String address,String prov,String asal,String jurusan,String bidik,String mandiri) {
        this.name = name;
        this.address = address;
        this.jk = jk;
        this.tmpt = tempat;
        this.tgl = tanggal;
        this.asalsekolah = asal;
        this.prov = prov;
        this.jurusan = jurusan;
        this.mandiri = mandiri;
        this.bidik = bidik;
    }

    //Lengkapi
    //Mendapatkan nama person
    public String getName() {
       return name;
    }

    //Lengkapi
    //Set nama person
    public void setName(String name) {
        this.name = name;
    }

    //Lengkapi 
    //Alamat person
    public String getAddress() {
       return address;
    }

    //Lengkapi
    //Set alamat person
    public void setAddress(String address) {
        this.address = address;
    }

    public String getBidik() {
        return bidik;
    }

    public String getMandiri() {
        return mandiri;
    }

    public void setBidik(String bidik) {
        this.bidik = bidik;
    }

    public void setMandiri(String mandiri) {
        this.mandiri = mandiri;
    }
    
    

    public String getAsalsekolah() {
        return asalsekolah;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }
    
    public String getJk() {
        return jk;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getTgl() {
        return tgl;
    }

    public String getTmpt() {
        return tmpt;
    }

    public void setAsalsekolah(String asalsekolah) {
        this.asalsekolah = asalsekolah;
    }

   

    public void setJk(String jk) {
        this.jk = jk;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }


    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public void setTmpt(String tmpt) {
        this.tmpt = tmpt;
    }
    
    public void print(){
        System.out.println("Nama\t\t: \t"+getName());
        System.out.println("Tempat Lahir\t: \t"+getTmpt());
        System.out.println("Tanggal Lahir\t: \t"+getTgl());
        System.out.println("Jenis Kelamin\t: \t"+getJk());
        System.out.println("Alamat\t\t: \t"+getAddress());
        System.out.println("Provinsi\t: \t"+getProv());
        System.out.println("Asal Sekolah\t: \t"+getAsalsekolah());
        System.out.println("Jurusan\t\t: \t"+getJurusan());
        
    }
    
    public static void main(String [] args){
    }
    
}
