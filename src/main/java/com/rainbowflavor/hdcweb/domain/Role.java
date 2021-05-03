package com.rainbowflavor.hdcweb.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Role {
    @Id @Column(name="ROLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ERole role;

    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles = new ArrayList<>();
}
