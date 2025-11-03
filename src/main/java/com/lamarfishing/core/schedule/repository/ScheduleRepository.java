package com.lamarfishing.core.schedule.repository;

import com.lamarfishing.core.schedule.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
