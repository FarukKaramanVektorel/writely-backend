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

import com.writelyblog.writely.data.dto.YaziDto;
import com.writelyblog.writely.service.YaziService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/yazilar")
@RequiredArgsConstructor
public class YaziController {
	
	 private final YaziService yazilarServis;

	    @GetMapping("/listele")
	    public List<YaziDto> yazilariListele() {
	        return yazilarServis.yazilariListele();
	    }

	    @PostMapping("/ekle")
	    public ResponseEntity<YaziDto> yazıEkle(@RequestBody YaziDto yazıDto) {
	        YaziDto savedYazi = yazilarServis.yazıEkle(yazıDto);
	        return ResponseEntity.ok(savedYazi);
	    }

	    @PutMapping("/guncelle")
	    public ResponseEntity<YaziDto> yazıGuncelle(@RequestBody YaziDto yazıDto) {
	        YaziDto updatedYazi = yazilarServis.yazıGuncelle(yazıDto);
	        return ResponseEntity.ok(updatedYazi);
	    }

	    @DeleteMapping("/sil/{id}")
	    public ResponseEntity<String> yazıSil(@PathVariable Long id) {
	        try {
	            yazilarServis.yazıSil(id);
	            return ResponseEntity.ok("Yazı başarıyla silindi.");
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }

	    @GetMapping("/getir/{id}")
	    public ResponseEntity<YaziDto> tekYaziGetir(@PathVariable Long id) {
	        try {
	            YaziDto yaziDto = yazilarServis.tekYaziGetir(id);
	            return ResponseEntity.ok(yaziDto);
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
