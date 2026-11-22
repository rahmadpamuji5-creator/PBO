package com.tikfind.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

public class LaporanForm {
    @NotBlank(message = "Nama barang wajib diisi")
    private String namaBarang;

    @Size(max = 500, message = "Deskripsi terlalu panjang")
    private String deskripsi;

    @NotBlank(message = "Lokasi wajib diisi")
    private String lokasi;

    @NotNull(message = "Tanggal laporan wajib diisi")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime tanggalLaporan;

    @NotBlank(message = "Kontak wajib diisi")
    private String kontak;

    // true = hilang, false = ditemukan
    private boolean hilang;

    // getters and setters
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
}
