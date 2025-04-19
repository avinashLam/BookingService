package com.example.BookingService.service;

import com.example.BookingService.entity.Booking;
import com.example.BookingService.exception.CustomIdNotFound;
import com.example.BookingService.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class BookingService {
    @Autowired
     RestTemplate restTemplate;
    private final BookingRepository bookingRepository;


    public BookingService( BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking saveBooking(Booking booking){
        Booking booking1=bookingRepository.save(booking);
        return booking1;
    }

    public String deleteBooking(Integer id){
        Optional<Booking> booking= Optional.ofNullable(bookingRepository.findById(id).orElse(null));
        bookingRepository.deleteById(booking.get().getBookingId());
        return "id deleted";
    }
    public Booking getBooking(Integer id){
        if(id==0){
            throw new CustomIdNotFound("msg");
        }
            Booking booking2 = bookingRepository.findById(id).orElse(null);
            Booking booking1 = new Booking();
            booking1.setBookingId(booking2.getBookingId());
            booking1.setName(booking2.getName());
            booking1.setPrice(booking2.getPrice());
            booking1.setDate(booking2.getDate());


        return booking2;
    }

    public Booking updateBooking(Integer id,Booking booking){
        Booking booking2=bookingRepository.findById(id).orElse(null);
        booking2.setBookingId(id);
        booking2.setName(booking.getName());
        booking2.setPrice(booking.getPrice());
        booking2.setDate(booking.getDate());

        bookingRepository.save(booking2);
        return booking2;




    }
}
