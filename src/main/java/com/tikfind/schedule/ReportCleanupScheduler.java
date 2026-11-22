package com.tikfind.schedule;

import com.tikfind.abstraction.LaporanService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Runs every hour and removes laporan yang sudah lebih dari 48 jam.
 */
@Component
public class ReportCleanupScheduler {
    private final LaporanService laporanService;

    public ReportCleanupScheduler(LaporanService laporanService) {
        this.laporanService = laporanService;
    }

    // Every hour (3600000 ms)
    @Scheduled(fixedRate = 3600000)
    public void purgeOldReports() {
        laporanService.purgeOldReports();
    }
}
