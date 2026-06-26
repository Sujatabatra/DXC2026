package com.sujata.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sujata.entity.AuditLog;
import com.sujata.persistence.AuditLogDao;

@Service
public class AuditServiceImpl implements AuditService {

	@Autowired
	private AuditLogDao auditRepo;
/*
 * New Transaction t2 started
 * 
 * insert in Auditlog
 * 
 * commit
 * t2 transaction over
 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveAudit(String action) {

		AuditLog log = new AuditLog();

		log.setAction(action);
		log.setActionTime(LocalDateTime.now());

		auditRepo.save(log);
	}
}