package com.address.server.controller;

import com.address.server.repository.IpAddressRep;
import com.address.server.service.IpAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class IpController {

    IpAddressService addressRep;

    @Autowired
    public IpController(IpAddressService addressRep) {
        this.addressRep = addressRep;
    }

    @GetMapping("/{ipAddress}")
    public String IpAddress(@PathVariable String ipAddress){
        return addressRep.processing(ipAddress);
    }
}
