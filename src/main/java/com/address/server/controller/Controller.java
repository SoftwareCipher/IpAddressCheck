package com.address.server.controller;

import com.address.server.entity.IpAddress;
import com.address.server.service.CheckIpAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class Controller {
    CheckIpAddress checkIpAddress;
    @Autowired
    public Controller(CheckIpAddress checkIpAddress) {
        this.checkIpAddress = checkIpAddress;
    }

    @PostMapping("/{ipAddress}")
    public void IpAddress(@PathVariable String address){
        checkIpAddress.processing(address);
    }
}
