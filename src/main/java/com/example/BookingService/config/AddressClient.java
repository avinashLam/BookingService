package com.example.BookingService.config;

import com.example.BookingService.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AddressClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<Address> saveAddress(List<Address> addressList, Integer bookingId) {
        List<Address> savedAddresses = new ArrayList<>();

        addressList.forEach(address -> {
            address.setBookingId(bookingId);

            try {
                HttpHeaders headers = new HttpHeaders();
                headers.setAccept(List.of(MediaType.APPLICATION_JSON));
                headers.setContentType(MediaType.APPLICATION_JSON);

                HttpEntity<Address> request = new HttpEntity<>(address, headers);

                ResponseEntity<Address> response = restTemplate.exchange(
                        "http://localhost:8084/address",
                        HttpMethod.POST,
                        request,
                        Address.class
                );

                if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                    savedAddresses.add(response.getBody());
                }

            } catch (Exception e) {
                System.out.println("Error saving address: " + e.getMessage());
            }
        });

        return savedAddresses;
    }
}
