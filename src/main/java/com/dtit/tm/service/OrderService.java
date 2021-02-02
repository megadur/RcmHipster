package com.dtit.tm.service;

import com.dtit.tm.service.dto.IpAccessDTO;
import com.dtit.tm.service.dto.IpCredentailsDTO;

import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {

    private final Logger log = LoggerFactory.getLogger(OrderService.class);

    public Boolean process(IpAccessDTO iad) {
        throw new NotImplementedException("TODO");
    }

    public void processNA(IpAccessDTO iad) {
        throw new NotImplementedException("TODO");
    }

    public void processPC(IpAccessDTO iad) {
        throw new NotImplementedException("TODO");
    }

    public void processLC(IpAccessDTO iad) {
        throw new NotImplementedException("TODO");
    }

    public void process(IpCredentailsDTO iad) {
        throw new NotImplementedException("TODO");
    }
}
