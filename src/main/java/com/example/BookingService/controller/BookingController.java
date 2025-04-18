package com.example.BookingService.controller;

import com.example.BookingService.entity.Booking;
import com.example.BookingService.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//swagger url- http://localhost:8085/swagger-ui/index.html

@RestController
@RequestMapping("/booking")
@Slf4j
public class BookingController {
    private final BookingService bookingService;
    private final Logger logger= LoggerFactory.getLogger(BookingController.class);

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @PostMapping("/save")
    @Operation(summary = "create a new booking")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully added",
                    content = @Content(mediaType = "application/json")
            ), @ApiResponse(
            responseCode = "404",
            description = "failed",
            content = @Content
    )
    })
    public ResponseEntity<Booking> newBooking(@RequestBody Booking booking){
        Booking booking1=bookingService.saveBooking(booking);
        logger.info("Posting data");
        return  ResponseEntity.status(200).body(booking1);
    }
    @DeleteMapping("/{id}")
    @Operation(summary="Delete By Id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "deleted successfully",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "failed",
                    content = @Content
            )
    })

    public ResponseEntity<String> deletebyId(@PathVariable Integer id){
        String response=bookingService.deleteBooking(id);
        logger.info("deleting the data by Id "+ id);

        return ResponseEntity.status(200).body("deleted");
    }

    @GetMapping("/{id}")
    @Operation(summary="Get By Id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Get By id",
                    content=@Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "failed",
                    content = @Content
            )
    })
    public ResponseEntity<Booking> getBookingById(@PathVariable Integer id){
        Booking booking=bookingService.getBooking(id);
        logger.info("getting the data by Id");
        logger.info("data  "+booking.getBookingId());

        return ResponseEntity.status(200).body(booking);
    }


    @PutMapping("/{id}")
    @Operation(summary="Update By Id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "update by Id",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "failed",
                    content = @Content
            )
    })
    public ResponseEntity<Booking>  updatingBooking(@PathVariable Integer id,@RequestBody Booking booking){
        Booking booking1= bookingService.updateBooking(id,booking);
        logger.info("update the data by Id");
        logger.info("data  "+booking1.getBookingId());

        return ResponseEntity.status(200).body(booking1);
    }

}
