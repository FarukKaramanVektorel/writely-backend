package com.writelyblog.writely.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.writelyblog.writely.data.entity.Kategori;
import com.writelyblog.writely.data.entity.Yazi;

@Repository
public interface YaziRepository extends JpaRepository<Yazi, Long> {
	List<Yazi> findByKategori(Kategori kategori);
}
