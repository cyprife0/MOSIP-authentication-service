package io.mosip.authentication.service.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@Data
@Table()
@Entity
public class AuditEvent {

    @Id
    private String eventId;
    private String eventType;
    private String description;
    private String userId;
    private Instant timestamp;


    public AuditEvent(String eventType, String description, String userId) {
        this.eventId = UUID.randomUUID().toString();
        this.eventType = eventType;
        this.description = description;
        this.userId = userId;
        this.timestamp = Instant.now();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getDescription() {
        return description;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventId() {
        return eventId;
    }


    public String getEventType() {
        return eventType;
    }

    public String getUserId() {
        return userId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}

