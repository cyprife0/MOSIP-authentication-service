package io.mosip.authentication.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/health")
public class HealthController {

    @Value("${mosip.id.auth.health.enabled:true}")
    private boolean healthEnabled;

    @Value("${mosip.id.auth.someConfig}")
    private String someConfig;

    @Value("${spring.application.name:authentication-service}")
    private String serviceName;

    @Value("${spring.profiles.active:default}")
    private String environment;

    @Value("${mosip.version:1.0.0}")
    private String version;

    @GetMapping("/details")
    public ResponseEntity<Map<String, Object>> getHealthDetails() {
        Map<String, Object> details = new HashMap<>();
        details.put("timestamp", Instant.now().toString());
        details.put("serviceName", serviceName);
        details.put("version", version);
        details.put("environment", environment);
        details.put("configValue", someConfig);

        if (healthEnabled) {
            details.put("status", "UP");
            return ResponseEntity.ok(details);
        } else {
            details.put("status", "DOWN");
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(details);
        }
    }
}
