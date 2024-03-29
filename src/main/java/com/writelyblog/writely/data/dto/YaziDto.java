package com.writelyblog.writely.data.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YaziDto {
	 private Long id;
	    private Long kategoriId;
	    private String baslik;
	    private String yazi;
	    private String ozet;
	    private LocalDateTime tarih;
	    private Integer okunmaSayisi;
	    private Integer durum;
	    private String etiketler;
}
