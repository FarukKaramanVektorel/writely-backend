package com.writelyblog.writely.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.writelyblog.writely.data.dto.KategoriDto;
import com.writelyblog.writely.data.entity.Kategori;
import com.writelyblog.writely.data.entity.Yazi;
import com.writelyblog.writely.repository.KategoriRepository;
import com.writelyblog.writely.repository.YaziRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KategoriService {
	
	 
	    private final KategoriRepository kategoriRepository;
	    private final ModelMapper modelMapper;
	    
	    private final YaziRepository yazilarRepository;

	    public List<KategoriDto> kategorileriListele() {
	        List<Kategori> kategoriler = kategoriRepository.findAll();
	        return kategoriler.stream()
	                .map(kategori -> modelMapper.map(kategori, KategoriDto.class))
	                .collect(Collectors.toList());
	    }

	    public KategoriDto kategoriEkle(KategoriDto kategoriDto) {
	        Kategori kategori = modelMapper.map(kategoriDto, Kategori.class);
	        Kategori savedKategori = kategoriRepository.save(kategori);
	        return modelMapper.map(savedKategori, KategoriDto.class);
	    }

	    public KategoriDto kategoriGuncelle(KategoriDto kategoriDto) {
	        Kategori kategori = modelMapper.map(kategoriDto, Kategori.class);
	        Kategori updatedKategori = kategoriRepository.save(kategori);
	        return modelMapper.map(updatedKategori, KategoriDto.class);
	    }

	    public void kategoriSil(Long kategoriId) {
	        Kategori kategori = kategoriRepository.findById(kategoriId)
	                .orElseThrow(() -> new IllegalArgumentException("Kategori bulunamadı."));

	        List<Yazi> yazilar = yazilarRepository.findByKategori(kategori);
	        if (!yazilar.isEmpty()) {
	            throw new IllegalStateException("Bu kategoriye ait yazılar bulunmaktadır. Kategoriyi silemezsiniz.");
	        }

	        kategoriRepository.delete(kategori);
	    }

	    public KategoriDto tekKategoriGetir(Long kategoriId) {
	        Kategori kategori = kategoriRepository.findById(kategoriId)
	                .orElseThrow(() -> new IllegalArgumentException("Kategori bulunamadı."));
	        return modelMapper.map(kategori, KategoriDto.class);
	    }

}
