package com.tikfind.abstraction;

import com.tikfind.encapsulation.Laporan;
import com.tikfind.storage.InMemoryLaporanRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LaporanService implements PengelolaLaporan {
    private final InMemoryLaporanRepository repository;

    public LaporanService(InMemoryLaporanRepository repository) {
        this.repository = repository;
    }

    @Override
    public Laporan simpanLaporan(Laporan laporan) {
        return repository.save(laporan);
    }

    @Override
    public List<Laporan> getSemuaLaporan() {
        return repository.findAll();
    }

    @Override
    public Laporan cariById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Laporan> cariByNama(String namaBarang) {
        return repository.findByNama(namaBarang);
    }

    @Override
    public void hapusLaporan(long id) {
        repository.deleteById(id);
    }

    /**
     * Called by scheduled task to purge old reports.
     */
    public void purgeOldReports() {
        // 48 hours = 48 * 60 minutes = 2880 minutes = 48 hours later
        repository.purgeOlderThanHours(48);
    }
}
