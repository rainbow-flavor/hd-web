package com.rainbowflavor.hdcweb.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
public class ScheduleDto {

    private String userName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startScheduleDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endScheduleDate;

    private String scheduleDay;

    private String scheduleDetail;
}
