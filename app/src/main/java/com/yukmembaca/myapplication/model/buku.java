package com.yukmembaca.myapplication.model;

public class buku {
    private String judul;
    private String pengarang;
    private String penerbit;
    private String tahunTerbit;
    private String deskripsi;
    private int gambarBuku;

    public buku() {

    }


    public buku(String judul, String pengarang, String penerbit, String tahunTerbit, String deskripsi, int gambarBuku) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.deskripsi = deskripsi;
        this.gambarBuku = gambarBuku;
    }

    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public String getPenerbit() { return penerbit; }

    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getGambarBuku() {
        return gambarBuku;
    }


    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setGambarBuku(int gambarBuku) { this.gambarBuku = gambarBuku; }
}
