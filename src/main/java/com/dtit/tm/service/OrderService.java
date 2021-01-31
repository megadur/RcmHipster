package com.dtit.tm.service;

import com.dtit.tm.service.dto.IpAccessDTO;
import com.dtit.tm.service.dto.IpCredentailsDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {

    private final Logger log = LoggerFactory.getLogger(OrderService.class);

    public void process(IpAccessDTO iad) {
    }

    public void processNA(IpAccessDTO iad) {
    }

    public void processPC(IpAccessDTO iad) {
    }

    public void processLC(IpAccessDTO iad) {
    }

    public void process(IpCredentailsDTO iad) {
    }
}
