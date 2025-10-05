package io.mosip.authentication.service.repositories;

import io.mosip.authentication.service.entities.AuditEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditEventRepository extends JpaRepository<AuditEvent, String> {
}
