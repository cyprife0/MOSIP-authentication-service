package io.mosip.authentication.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class AuditRequest {
        @NotBlank
        private String eventType;
        private String description;
        @NotBlank
        private String userId;
        public AuditRequest(String eventType,String description,String userId){
                this.description=description;
                this.userId=userId;
                this.eventType=eventType;
        }

        public String getDescription() {
                return description;
        }

        public String getEventType() {
                return eventType;
        }

        public String getUserId() {
                return userId;
        }

        public void setUserId(String userId) {
                this.userId = userId;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public void setEventType(String eventType) {
                this.eventType = eventType;
        }
}