package com.rainbowflavor.hdcweb.domain;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(uniqueConstraints =
        @UniqueConstraint(columnNames = {"email","username"}))
@Getter
@Setter
public class User{
    @Id @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String username;

    @Column
    @NotNull
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

    @Column
    @ColumnDefault("0")
    private boolean emailVerify;

    @OneToMany(mappedBy = "user")
    private Set<UserRole> roles = new HashSet<>();

    @OneToMany(mappedBy = "user")
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
