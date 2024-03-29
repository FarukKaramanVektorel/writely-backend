package com.writelyblog.writely.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YorumDto {
	private Long id;
    private String ad;
    private String soyad;
    private String mail;
    private String mesaj;
    private Long yaziId;
    private Integer durum;

}
