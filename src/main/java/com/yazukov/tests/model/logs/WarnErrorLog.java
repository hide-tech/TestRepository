package com.yazukov.tests.model.logs;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "logs_warns_errors")
@Data
public class WarnErrorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "log_time")
    private LocalDateTime logTime;
    @Column(name = "message")
    private String message;
}
