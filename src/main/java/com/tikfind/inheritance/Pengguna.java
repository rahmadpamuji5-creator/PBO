package com.tikfind.inheritance;

public abstract class Pengguna {
    protected String nama;
    protected String kontak;

    public Pengguna(String nama, String kontak) {
        this.nama = nama;
        this.kontak = kontak;
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getKontak() { return kontak; }
    public void setKontak(String kontak) { this.kontak = kontak; }

    // Polymorphic method to be overridden
    public abstract String getRoleDescription();
}
