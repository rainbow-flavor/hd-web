package com.rainbowflavor.hdcweb.repository;

import com.rainbowflavor.hdcweb.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaScheduleRepository extends JpaRepository<Schedule, Long> {
}
