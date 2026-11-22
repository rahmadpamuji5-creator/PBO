package com.tikfind.abstraction;

import com.tikfind.encapsulation.Laporan;
import java.util.List;

public interface PengelolaLaporan {
    Laporan simpanLaporan(Laporan laporan);
    List<Laporan> getSemuaLaporan();
    Laporan cariById(long id);
    List<Laporan> cariByNama(String namaBarang);
    void hapusLaporan(long id);
}
