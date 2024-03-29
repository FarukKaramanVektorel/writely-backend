package com.writelyblog.writely.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.writelyblog.writely.data.dto.YaziDto;
import com.writelyblog.writely.data.entity.Yazi;
import com.writelyblog.writely.data.entity.Yorum;
import com.writelyblog.writely.repository.YaziRepository;
import com.writelyblog.writely.repository.YorumRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class YaziService {
	
	private final YaziRepository yazilarRepository;
    private final YorumRepository yorumlarRepository;
    private final ModelMapper modelMapper;

    public List<YaziDto> yazilariListele() {
        List<Yazi> yazilar = yazilarRepository.findAll();
        return yazilar.stream()
                .map(yazi -> modelMapper.map(yazi, YaziDto.class))
                .collect(Collectors.toList());
    }

    public YaziDto yazıEkle(YaziDto yazıDto) {
        Yazi yazı = modelMapper.map(yazıDto, Yazi.class);
        Yazi savedYazi = yazilarRepository.save(yazı);
        return modelMapper.map(savedYazi, YaziDto.class);
    }

    public YaziDto yazıGuncelle(YaziDto yazıDto) {
        Yazi yazı = modelMapper.map(yazıDto, Yazi.class);
        Yazi updatedYazi = yazilarRepository.save(yazı);
        return modelMapper.map(updatedYazi, YaziDto.class);
    }

    public void yazıSil(Long yazıId) {
        Yazi yazı = yazilarRepository.findById(yazıId)
                .orElseThrow(() -> new IllegalArgumentException("Yazı bulunamadı."));

        List<Yorum> yorumlar = yorumlarRepository.findByYazi(yazı);
        if (!yorumlar.isEmpty()) {
            throw new IllegalStateException("Bu yazıya ait yorumlar bulunmaktadır. Yazıyı silemezsiniz.");
        }

        yazilarRepository.delete(yazı);
    }

    public YaziDto tekYaziGetir(Long yazıId) {
        Yazi yazı = yazilarRepository.findById(yazıId)
                .orElseThrow(() -> new IllegalArgumentException("Yazı bulunamadı."));
        return modelMapper.map(yazı, YaziDto.class);
    }

}
