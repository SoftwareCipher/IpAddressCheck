package com.address.server.repository;

import com.address.server.entity.IpAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface IpAddressRep extends JpaRepository<IpAddress, Long> {
}
