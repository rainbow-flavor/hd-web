package com.rainbowflavor.hdcweb.service;

import com.rainbowflavor.hdcweb.domain.Schedule;
import com.rainbowflavor.hdcweb.dto.ScheduleDto;
import com.rainbowflavor.hdcweb.repository.JpaScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class ScheduleService {
    private final JpaScheduleRepository scheduleRepository;

    public void createSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public List<ScheduleDto> getScheduleInMonth(Integer year, Integer month){
        List<Schedule> schedules = scheduleRepository.findAll();
        /* TODO: 현재 출력되고 있는 화면 기준으로 년 월 받아와서 DB에서 Between query 날릴 수 있도록 작성*/
        List<ScheduleDto> scheduleDtos = new ArrayList<>();

        schedules.listIterator().forEachRemaining(attr->{
            ScheduleDto scheduleDto = new ScheduleDto();
            scheduleDto.setEndScheduleDate(attr.getScheduleEndDate());
            scheduleDtos.add(scheduleDto);
        });
        return scheduleDtos;
    }

}
