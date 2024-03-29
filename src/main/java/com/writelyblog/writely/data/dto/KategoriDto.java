package com.writelyblog.writely.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KategoriDto {
    private Long id;
    private String ad;
    private Integer durum;
}
