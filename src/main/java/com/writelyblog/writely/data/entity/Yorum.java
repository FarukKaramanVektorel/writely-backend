package com.writelyblog.writely.data.entity;

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
public class Yorum {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String ad;
	    private String soyad;
	    private String mail;
	    private String mesaj;

	    @ManyToOne
	    @JoinColumn(name = "yazi_id", nullable = false)
	    private Yazi yazi;

	    private Integer durum;
}
