package com.example.BookingService.controller;

import com.example.BookingService.entity.Booking;
import com.example.BookingService.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @PostMapping("/save")
    public ResponseEntity<Booking> newBooking(@RequestBody Booking booking){
        Booking booking1=bookingService.saveBooking(booking);
        return  ResponseEntity.status(200).body(booking1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletebyId(@PathVariable Integer id){
        String response=bookingService.deleteBooking(id);
        return ResponseEntity.status(204).body("deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Integer id){
        Booking booking=bookingService.getBooking(id);
        return ResponseEntity.status(200).body(booking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking>  updatingBooking(@PathVariable Integer id,@RequestBody Booking booking){
        Booking booking1= bookingService.updateBooking(id,booking);
        return ResponseEntity.status(201).body(booking1);
    }

}
