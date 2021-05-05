package com.rainbowflavor.hdcweb.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Entity
@Data
public class User {
    @Id @Column(name="USER_ID") @Setter(AccessLevel.NONE)
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

    @OneToMany
    @JoinColumn(name = "id")
    private List<Schedule> schedule;

    @Builder
    public User(String name, String username, String password, String email, String position, String phone, String address, Date birth) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.position = position;
        this.phone = phone;
        this.address = address;
        this.birth = birth;
    }
}
