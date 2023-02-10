package com.address.server.repository;

import com.address.server.entity.IpAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IpAddressRep extends JpaRepository<IpAddress, Long> {

    @Query("select ip from IpAddress ip where ip.ipAddress = ?1")
    IpAddress findIpAddressBase(String address);
}
