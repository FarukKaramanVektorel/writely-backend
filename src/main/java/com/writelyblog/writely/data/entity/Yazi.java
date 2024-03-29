package com.writelyblog.writely.data.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Yazi {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "kategori_id", nullable = false)
	    private Kategori kategori;

	    private String baslik;
	    private String yazi;
	    private String ozet;
	    private LocalDateTime tarih;
	    private Integer okunmaSayisi;
	    private Integer durum;
	    private String etiketler;
}
