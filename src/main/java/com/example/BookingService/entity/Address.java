package com.example.BookingService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer AddressId;
    private Integer BookingId;

    private String Street;
    private String State;
    private String Country;

    public Integer getAddressId() {
        return AddressId;
    }

    public void setAddressId(Integer addressId) {
        AddressId = addressId;
    }

    public Integer getBookingId() {
        return BookingId;
    }

    public void setBookingId(Integer bookingId) {
        BookingId = bookingId;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
