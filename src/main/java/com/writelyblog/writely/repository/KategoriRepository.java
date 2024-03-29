package com.writelyblog.writely.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.writelyblog.writely.data.entity.Kategori;

@Repository
public interface KategoriRepository extends JpaRepository<Kategori, Long> {
}
