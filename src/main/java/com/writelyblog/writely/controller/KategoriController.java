package com.writelyblog.writely.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.writelyblog.writely.data.dto.KategoriDto;
import com.writelyblog.writely.service.KategoriService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/kategori")
@RequiredArgsConstructor
public class KategoriController {
	
    private final KategoriService kategoriServis;

    @GetMapping("/listele")
    public List<KategoriDto> kategorileriListele() {
        return kategoriServis.kategorileriListele();
    }

    @PostMapping("/ekle")
    public ResponseEntity<KategoriDto> kategoriEkle(@RequestBody KategoriDto kategoriDto) {
        KategoriDto savedKategori = kategoriServis.kategoriEkle(kategoriDto);
        return ResponseEntity.ok(savedKategori);
    }

    @PutMapping("/guncelle")
    public ResponseEntity<KategoriDto> kategoriGuncelle(@RequestBody KategoriDto kategoriDto) {
        KategoriDto updatedKategori = kategoriServis.kategoriGuncelle(kategoriDto);
        return ResponseEntity.ok(updatedKategori);
    }

    @DeleteMapping("/sil/{id}")
    public ResponseEntity<String> kategoriSil(@PathVariable Long id) {
        try {
            kategoriServis.kategoriSil(id);
            return ResponseEntity.ok("Kategori başarıyla silindi.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getir/{id}")
    public ResponseEntity<KategoriDto> tekKategoriGetir(@PathVariable Long id) {
        try {
            KategoriDto kategoriDto = kategoriServis.tekKategoriGetir(id);
            return ResponseEntity.ok(kategoriDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}