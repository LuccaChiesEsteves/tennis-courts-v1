package com.tenniscourts.reservations;

import com.tenniscourts.config.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotNull;

import javax.validation.Valid;

@AllArgsConstructor
@Api
@RestController
@RequestMapping("/reservations")
public class ReservationController extends BaseRestController {

    private final ReservationService reservationService;

    @ApiOperation(value = "Book a new reservation")
    @PostMapping
    public ResponseEntity<Void> bookReservation(@Valid CreateReservationRequestDTO createReservationRequestDTO) {
        return ResponseEntity.created(locationByEntity(reservationService.bookReservation(createReservationRequestDTO).getId())).build();
    }

    @ApiOperation(value = "Search for a reservation with given ID")
    @GetMapping("/{reservationId}")
    public ResponseEntity<ReservationDTO> findReservation(@NotNull @PathVariable Long reservationId) {
        return ResponseEntity.ok(reservationService.findReservation(reservationId));
    }

    @ApiOperation(value = "Cancel a reservation with given ID")
    @DeleteMapping("/{reservationId}")
    public ResponseEntity<ReservationDTO> cancelReservation(@NotNull @PathVariable Long reservationId) {
        return ResponseEntity.ok(reservationService.cancelReservation(reservationId));
    }

    @ApiOperation(value = "Reschedule a reservation")
    @PatchMapping("/{reservationId}")
    public ResponseEntity<ReservationDTO> rescheduleReservation(@NotNull @PathVariable Long reservationId, @NotNull @RequestBody Long scheduleId) {
        return ResponseEntity.ok(reservationService.rescheduleReservation(reservationId, scheduleId));
    }
}
