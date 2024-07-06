package br.com.guilhermekellermann.individual_registration.modules.auditLog;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name = "AuditLog")
@Data
public class AuditLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank()
    private String username;

    @NotBlank()
    private String endpoint;

    @NotBlank()
    private String method; 

    @CreationTimestamp
    private LocalDateTime createdAt; 
}
