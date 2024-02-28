package com.hcl.jtl.portpolioservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.jtl.portpolioservice.entity.Portpolio;

@Repository
public interface PortpolioRepository extends JpaRepository<Portpolio, Integer> {

	void deletePortpolioByUserId(String userId);
	List<Portpolio> findPortpolioByUserId(String userId);
//	Portpolio findByUserId(String userId);
	
}
