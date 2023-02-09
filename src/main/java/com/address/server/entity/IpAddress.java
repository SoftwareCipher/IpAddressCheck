package com.address.server.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "address")
public class IpAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "time")
    private LocalDateTime time;

    public IpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        this.time = LocalDateTime.now();
    }
}
