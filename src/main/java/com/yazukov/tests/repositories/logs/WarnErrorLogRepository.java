package com.yazukov.tests.repositories.logs;

import com.yazukov.tests.model.logs.WarnErrorLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarnErrorLogRepository extends JpaRepository<WarnErrorLog, Long> {
}
