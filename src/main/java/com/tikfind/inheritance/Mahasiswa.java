package com.tikfind.inheritance;

public class Mahasiswa extends Pengguna {
    private String nim;

    public Mahasiswa(String nama, String kontak, String nim) {
        super(nama, kontak);
        this.nim = nim;
    }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    @Override
    public String getRoleDescription() {
        return "Mahasiswa with NIM: " + nim;
    }
}
