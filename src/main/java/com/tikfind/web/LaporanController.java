package com.tikfind.web;

import com.tikfind.abstraction.PengelolaLaporan;
import com.tikfind.encapsulation.Laporan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/laporan")
public class LaporanController {
    private final PengelolaLaporan layanan;

    @Autowired
    public LaporanController(PengelolaLaporan layanan) {
        this.layanan = layanan;
    }

    @GetMapping("/")
    public String listAll(Model model) {
        List<Laporan> semua = layanan.getSemuaLaporan();
        model.addAttribute("laporans", semua);
        return "laporan_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable long id, Model model) {
        Laporan l = layanan.cariById(id);
        if (l == null) {
            return "redirect:/laporan/";
        }
        model.addAttribute("laporan", l);
        return "laporan_detail";
    }

    @GetMapping("/baru")
    public String form(Model model) {
        model.addAttribute("laporanForm", new LaporanForm());
        return "laporan_form";
    }

    @PostMapping("/simpan")
    public String save(@ModelAttribute("laporanForm") @Valid LaporanForm form,
                       BindingResult result) {
        if (result.hasErrors()) {
            return "laporan_form";
        }
        Laporan l = new Laporan();
        l.setNamaBarang(form.getNamaBarang());
        l.setDeskripsi(form.getDeskripsi());
        l.setLokasi(form.getLokasi());
        l.setTanggalLaporan(form.getTanggalLaporan());
        l.setKontak(form.getKontak());
        l.setHilang(form.isHilang());
        layanan.simpanLaporan(l);
        return "redirect:/laporan/";
    }

    @GetMapping("/cari")
    public String search(@RequestParam("q") String query, Model model) {
        List<Laporan> result = layanan.cariByNama(query);
        model.addAttribute("laporans", result);
        model.addAttribute("searchQuery", query);
        return "laporan_list";
    }
}
