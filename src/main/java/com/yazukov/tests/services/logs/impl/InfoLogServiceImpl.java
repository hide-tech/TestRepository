package com.yazukov.tests.services.logs.impl;

import com.yazukov.tests.repositories.logs.InfoLogRepository;
import com.yazukov.tests.services.logs.InfoLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoLogServiceImpl implements InfoLogService {
    @Autowired
    private InfoLogRepository infoLogRepository;
}
