package com.rainbowflavor.hdcweb.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Schedule extends AuditingTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Temporal(TemporalType.DATE)
    private Date scheduleStartDate;

    @Temporal(TemporalType.DATE)
    private Date scheduleEndDate;

    @Column
    private String scheduleDetail;
}
