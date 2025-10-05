package io.mosip.authentication.service.controller;

import io.mosip.authentication.service.entities.AuditEvent;
import io.mosip.authentication.service.repositories.AuditEventRepository;
import io.mosip.authentication.service.dto.AuditRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/audit")
public class AuditController {

    private final AuditEventRepository repository;

    public AuditController(AuditEventRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/log")
    public ResponseEntity<Map<String, Object>> logEvent(@Valid @RequestBody AuditRequest request) {
        AuditEvent event = new AuditEvent(request.getEventType(), request.getDescription(), request.getUserId());
        repository.save(event);

        return ResponseEntity.ok(Map.of(
                "eventId", event.getEventId(),
                "timestamp", event.getTimestamp().toString(),
                "status", "SUCCESS"
        ));
    }
}
