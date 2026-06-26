package com.sujata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sujata.entity.AuditLog;

@Repository
public interface AuditLogDao extends JpaRepository<AuditLog, Long> {

}
