/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koding;

/**
 *
 * @author Al-Habib
 */
public class Ortu {
    String NamaA,NamaI,PkerA,PkerI;
    int JmlS,JmlT,Listrik,Air,PBB,PjkK,GajiA,GajiI;
    boolean aaa;
    public Ortu(String namaA,String namaI,String PkerA,String PkerI,int s,int t,int ga,int gi,int l,int a,int pb,int pk){
        this.Air = a;
        this.JmlS = s;
        this.JmlT = t;
        this.Listrik = l;
        this.NamaA = namaA;
        this.NamaI = namaI;
        this.PBB = pb;
        this.GajiA = ga;
        this.PjkK = pk;
        this.PkerA = PkerA;
        this.PkerI = PkerI;
        this.GajiI = gi;
    }

    public int getAir() {
        return Air;
    }

    public int getJmlS() {
        return JmlS;
    }

    public int getJmlT() {
        return JmlT;
    }

    public int getListrik() {
        return Listrik;
    }

    public String getNamaA() {
        return NamaA;
    }

    public String getNamaI() {
        return NamaI;
    }


    public int getPBB() {
        return PBB;
    }

    public int getPjkK() {
        return PjkK;
    }

    public String getPkerA() {
        return PkerA;
    }

    public String getPkerI() {
        return PkerI;
    }

    public void setGajiI(int GajiI) {
        this.GajiI = GajiI;
    }

    public void setGajiA(int GajiA) {
        this.GajiA = GajiA;
    }

    public int getGajiI() {
        return GajiI;
    }

    public int getGajiA() {
        return GajiA;
    }

    public void setAir(int Air) {
        this.Air = Air;
    }

    public void setJmlS(int JmlS) {
        this.JmlS = JmlS;
    }

    public void setJmlT(int JmlT) {
        this.JmlT = JmlT;
    }

    public void setListrik(int Listrik) {
        this.Listrik = Listrik;
    }

    public void setNamaA(String NamaA) {
        this.NamaA = NamaA;
    }

    public void setNamaI(String NamaI) {
        this.NamaI = NamaI;
    }

    public void setPBB(int PBB) {
        this.PBB = PBB;
    }

    public void setPjkK(int PjkK) {
        this.PjkK = PjkK;
    }

    public void setPkerA(String PkerA) {
        this.PkerA = PkerA;
    }

    public void setPkerI(String PkerI) {
        this.PkerI = PkerI;
    }

    
    
    public void print(){
        System.out.println("Nama Ayah\t:\t"+getNamaA());
        System.out.println("Nama Ibu\t:\t"+getNamaI());
        System.out.println("Pekerjaan Ayah\t:\t"+getPkerA());
        System.out.println("Pekerjaan Ibu\t:\t"+getPkerI());
        System.out.println("Jumlah Saudara\t:\t"+getJmlS());
        System.out.println("Jumlah Tanggungan\t:\t"+getJmlT());
        System.out.println("Biaya Listrik (/ bulan)\t:\t"+getListrik());
        System.out.println("Biaya Air (/ bulan)\t:\t"+getAir());
        System.out.println("Pajak Bumi Bangunan\t:\t"+getPBB());
        System.out.println("Pajak Kendaraan\t:\t"+getPjkK());
        System.out.println("Gaji Ayah\t:\t"+getGajiA());
        System.out.println("Gaji Ibu\t:\t"+getGajiI());
    }
}
