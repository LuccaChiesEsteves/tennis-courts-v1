package com.tenniscourts.schedules;

import com.tenniscourts.exceptions.EntityNotFoundException;
import com.tenniscourts.tenniscourts.TennisCourt;
import com.tenniscourts.tenniscourts.TennisCourtRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    private final ScheduleMapper scheduleMapper;

    private final TennisCourtRepository tennisCourtRepository;

    public ScheduleDTO addSchedule(Long tennisCourtId, CreateScheduleRequestDTO createScheduleRequestDTO) {
        Optional<TennisCourt> tennisCourt = tennisCourtRepository.findById(tennisCourtId);
        if(tennisCourt.isEmpty()) throw new EntityNotFoundException("Tennis court not found");
        Schedule newSchedule = new Schedule(tennisCourt.get(), createScheduleRequestDTO.getStartDateTime(),createScheduleRequestDTO.getStartDateTime().plusHours(1), null);
        return scheduleMapper.map(scheduleRepository.save(newSchedule));
    }

    public List<ScheduleDTO> findSchedulesByDates(LocalDateTime startDate, LocalDateTime endDate) {
        return scheduleMapper.map(scheduleRepository.findByStartDateTimeBetween(startDate, endDate));
    }

    public ScheduleDTO findSchedule(Long scheduleId) {
        Optional<Schedule> foundSchedule = scheduleRepository.findById(scheduleId);
        if(foundSchedule.isPresent()){
            return scheduleMapper.map(foundSchedule.get());
        } else {
            throw new EntityNotFoundException("Schedule not found");
        }
    }

    public List<ScheduleDTO> findSchedulesByTennisCourtId(Long tennisCourtId) {
        return scheduleMapper.map(scheduleRepository.findByTennisCourt_IdOrderByStartDateTime(tennisCourtId));
    }
}
