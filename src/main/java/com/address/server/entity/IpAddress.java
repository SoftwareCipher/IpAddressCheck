package com.address.server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "IpAddress")
public class IpAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ipAddress")
    private String ipAddress;
    @Column(name = "time")
    private LocalDateTime time;

    public IpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
