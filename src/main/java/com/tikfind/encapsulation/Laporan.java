package com.tikfind.encapsulation;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class Laporan {
    private static final AtomicLong COUNTER = new AtomicLong(1);

    private final long id;
    private String namaBarang;
    private String deskripsi;
    private String lokasi;
    private LocalDateTime tanggalLaporan;
    private String kontak;
    private boolean hilang; // true if lost, false if found
    private final LocalDateTime createdAt;

    public Laporan() {
        this.id = COUNTER.getAndIncrement();
        this.createdAt = LocalDateTime.now();
    }

    public long getId() { return id; }
    public String getNamaBarang() { return namaBarang; }
    public void setNamaBarang(String namaBarang) { this.namaBarang = namaBarang; }
    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
    public String getLokasi() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }
    public LocalDateTime getTanggalLaporan() { return tanggalLaporan; }
    public void setTanggalLaporan(LocalDateTime tanggalLaporan) { this.tanggalLaporan = tanggalLaporan; }
    public String getKontak() { return kontak; }
    public void setKontak(String kontak) { this.kontak = kontak; }
    public boolean isHilang() { return hilang; }
    public void setHilang(boolean hilang) { this.hilang = hilang; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
