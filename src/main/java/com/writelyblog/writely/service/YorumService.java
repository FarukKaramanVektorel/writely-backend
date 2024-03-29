package com.writelyblog.writely.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.writelyblog.writely.data.dto.YorumDto;
import com.writelyblog.writely.data.entity.Yorum;
import com.writelyblog.writely.repository.YorumRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class YorumService {
	private final YorumRepository yorumlarRepository;
	private final ModelMapper modelMapper;

	public List<YorumDto> yorumlariListele(Long yaziId) {
		List<Yorum> yorumlar = yorumlarRepository.findByYaziId(yaziId);
		return yorumlar.stream().map(yorum -> modelMapper.map(yorum, YorumDto.class)).collect(Collectors.toList());
	}

	public YorumDto yorumEkle(YorumDto yorumDto) {
		Yorum yorum = modelMapper.map(yorumDto, Yorum.class);
		Yorum savedYorum = yorumlarRepository.save(yorum);
		return modelMapper.map(savedYorum, YorumDto.class);
	}

	public YorumDto yorumGuncelle(YorumDto yorumDto) {
		Yorum yorum = modelMapper.map(yorumDto, Yorum.class);
		Yorum updatedYorum = yorumlarRepository.save(yorum);
		return modelMapper.map(updatedYorum, YorumDto.class);
	}

	public void yorumSil(Long yorumId) {
		yorumlarRepository.deleteById(yorumId);
	}

	public YorumDto tekYorumGetir(Long yorumId) {
		Yorum yorum = yorumlarRepository.findById(yorumId)
				.orElseThrow(() -> new IllegalArgumentException("Yorum bulunamadı."));
		return modelMapper.map(yorum, YorumDto.class);
	}
}
