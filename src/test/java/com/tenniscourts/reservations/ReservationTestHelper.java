package com.tenniscourts.reservations;

import com.tenniscourts.guests.Guest;
import com.tenniscourts.schedules.Schedule;
import com.tenniscourts.schedules.ScheduleDTO;
import com.tenniscourts.tenniscourts.TennisCourt;
import com.tenniscourts.tenniscourts.TennisCourtDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReservationTestHelper {

    public static ReservationDTO createReservationDTO(){
        TennisCourtDTO tennisCourtDTO = new TennisCourtDTO(1L, "TennisCourtName", null);
        LocalDateTime startDateTime = LocalDateTime.of(2021,1,1,1,0);
        LocalDateTime endDatetime = startDateTime.plusHours(1);
        ScheduleDTO scheduleDTO = new ScheduleDTO(1L,tennisCourtDTO, tennisCourtDTO.getId(), startDateTime,endDatetime );
        return new ReservationDTO(1L, scheduleDTO, ReservationStatus.READY_TO_PLAY.toString(), null, BigDecimal.TEN, BigDecimal.TEN, scheduleDTO.getId(), 1L);
    }

    public static Reservation createReservationCanceled(){
        Guest guest = new Guest("GuestName");
        TennisCourt tennisCourt = new TennisCourt("TennisCourtName");
        LocalDateTime startDateTime = LocalDateTime.of(2021,1,1,1,0);
        LocalDateTime endDatetime = startDateTime.plusHours(1);
        Schedule schedule = new Schedule(tennisCourt, startDateTime, endDatetime, null);
        return new Reservation(guest,schedule, BigDecimal.TEN,ReservationStatus.CANCELLED, BigDecimal.TEN);
    }

    public static Reservation createReservationReadyToPlay(){
        Guest guest = new Guest("GuestName");
        TennisCourt tennisCourt = new TennisCourt("TennisCourtName");
        LocalDateTime startDateTime = LocalDateTime.of(2021,1,1,1,0);
        LocalDateTime endDatetime = startDateTime.plusHours(1);
        Schedule schedule = new Schedule(tennisCourt, startDateTime, endDatetime, null);
        return new Reservation(guest,schedule, BigDecimal.TEN,ReservationStatus.READY_TO_PLAY, BigDecimal.TEN);
    }
}
