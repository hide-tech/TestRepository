package com.yazukov.tests.repositories.logs;

import com.yazukov.tests.model.logs.InfoLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoLogRepository extends JpaRepository<InfoLog, Long> {
}
