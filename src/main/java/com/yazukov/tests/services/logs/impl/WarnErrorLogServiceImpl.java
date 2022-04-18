package com.yazukov.tests.services.logs.impl;

import com.yazukov.tests.repositories.logs.WarnErrorLogRepository;
import com.yazukov.tests.services.logs.WarnErrorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarnErrorLogServiceImpl implements WarnErrorLogService {
    @Autowired
    private WarnErrorLogRepository warnErrorLogRepository;
}
