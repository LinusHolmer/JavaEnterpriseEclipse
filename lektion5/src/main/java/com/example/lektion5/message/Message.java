package com.example.lektion5.message;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "messages")
public record Message (
        @Id Long id,
        @Column("message") String message,
        @Column("created_at") LocalDateTime createdAt,
        @Column("pinned") boolean pinned
) {}
