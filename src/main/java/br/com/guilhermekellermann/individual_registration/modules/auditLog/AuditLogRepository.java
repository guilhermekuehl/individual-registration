package br.com.guilhermekellermann.individual_registration.modules.auditLog;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLogEntity, UUID> {

}
