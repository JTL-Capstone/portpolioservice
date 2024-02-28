package com.hcl.jtl.portpolioservice.service;

import java.util.List;

import com.hcl.jtl.portpolioservice.entity.Portpolio;
import com.hcl.jtl.portpolioservice.exception.ObjectNotExistsException;

public interface PortpolioService {

	List<Portpolio> getAllPortpolios();
	
	Portpolio createPortPolio(Portpolio portpolio) throws ObjectNotExistsException;
	
	void deletePortPolioByUserId(String userId);
	
	public List<Portpolio> getPortpolioByUserId(String userId) ;

	void deleteAllPortPolios();
	
}
