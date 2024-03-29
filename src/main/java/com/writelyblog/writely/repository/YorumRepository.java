package com.writelyblog.writely.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.writelyblog.writely.data.entity.Yazi;
import com.writelyblog.writely.data.entity.Yorum;

@Repository
public interface YorumRepository extends JpaRepository<Yorum, Long> {
	
	List<Yorum> findByYazi(Yazi yazilar);
	List<Yorum> findByYaziId(Long yaziId);
}
