package com.example.BookingService.entity;

import java.util.List;

public class BookingAddressDTO {
    private Booking booking;
    private List<Address> addressList;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
