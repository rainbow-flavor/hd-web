package com.rainbowflavor.hdcweb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
public class User {
    @Id @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String position;

    @Column
    private String phone;

    @Column
    private String address;

    @Temporal(TemporalType.DATE)
    private Date birth;

    @OneToMany(mappedBy = "user")
    private Set<UserRole> roles = new HashSet<>();
}
