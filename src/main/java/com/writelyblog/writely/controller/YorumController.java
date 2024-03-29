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

import com.writelyblog.writely.data.dto.YorumDto;
import com.writelyblog.writely.service.YorumService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/yorumlar")
@RequiredArgsConstructor
public class YorumController {
	private final YorumService yorumServis;

	@GetMapping("/listele/{yaziId}")
	public List<YorumDto> yorumlariListele(@PathVariable Long yaziId) {
		return yorumServis.yorumlariListele(yaziId);
	}

	@PostMapping("/ekle")
	public ResponseEntity<YorumDto> yorumEkle(@RequestBody YorumDto yorumDto) {
		YorumDto savedYorum = yorumServis.yorumEkle(yorumDto);
		return ResponseEntity.ok(savedYorum);
	}

	@PutMapping("/guncelle")
	public ResponseEntity<YorumDto> yorumGuncelle(@RequestBody YorumDto yorumDto) {
		YorumDto updatedYorum = yorumServis.yorumGuncelle(yorumDto);
		return ResponseEntity.ok(updatedYorum);
	}

	@DeleteMapping("/sil/{id}")
	public ResponseEntity<String> yorumSil(@PathVariable Long id) {
		try {
			yorumServis.yorumSil(id);
			return ResponseEntity.ok("Yorum başarıyla silindi.");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/getir/{id}")
	public ResponseEntity<YorumDto> tekYorumGetir(@PathVariable Long id) {
		try {
			YorumDto yorumDto = yorumServis.tekYorumGetir(id);
			return ResponseEntity.ok(yorumDto);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}

}