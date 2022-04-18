package com.yazukov.tests.dto.logs;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WarnErrorLogDto {
    private LocalDateTime logTime;
    private String message;
}
