package com.company.employeeattendance.entities;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
public class BaseEntity {
    @Column(name = "active", columnDefinition = "TINYINT(1) DEFAULT 1", nullable = false)
    private boolean active = true;

    @Column(name = "deleted", columnDefinition = "TINYINT(1) DEFAULT 0", nullable = false)
    private boolean deleted;

    @CreatedBy
    @Column(name = "processed_by", columnDefinition = "VARCHAR(225) DEFAULT 'SYSTEM'", nullable = false)
    private String processedBy;


    @UpdateTimestamp
    @Column(name = "processed_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP()", nullable = false)
    private Timestamp processedAt;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public Timestamp getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(Timestamp processedAt) {
        this.processedAt = processedAt;
    }

    public void setCurrentUser() {
        setProcessedBy("Guest");
    }
}
