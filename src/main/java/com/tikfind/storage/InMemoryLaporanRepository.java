package com.tikfind.storage;

import com.tikfind.encapsulation.Laporan;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Simple in‑memory repository for Laporan objects.
 * Uses a thread‑safe list because Spring may access it from multiple threads
 * (web requests and the scheduled clean‑up task).
 */

import org.springframework.stereotype.Component;

@Component
public class InMemoryLaporanRepository {
    private final List<Laporan> laporanList = new CopyOnWriteArrayList<>();

    public Laporan save(Laporan laporan) {
        laporanList.add(laporan);
        return laporan;
    }

    public List<Laporan> findAll() {
        return new ArrayList<>(laporanList);
    }

    public Laporan findById(long id) {
        return laporanList.stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Laporan> findByNama(String namaBarang) {
        String lower = namaBarang.toLowerCase();
        List<Laporan> result = new ArrayList<>();
        for (Laporan l : laporanList) {
            if (l.getNamaBarang() != null && l.getNamaBarang().toLowerCase().contains(lower)) {
                result.add(l);
            }
        }
        return result;
    }

    public void deleteById(long id) {
        laporanList.removeIf(l -> l.getId() == id);
    }

    /**
     * Remove laporan yang lebih lama dari {@code hours} jam.
     */
    public void purgeOlderThanHours(long hours) {
        LocalDateTime cutoff = LocalDateTime.now().minusHours(hours);
        Iterator<Laporan> iterator = laporanList.iterator();
        while (iterator.hasNext()) {
            Laporan l = iterator.next();
            if (l.getCreatedAt().isBefore(cutoff)) {
                iterator.remove();
            }
        }
    }
}
