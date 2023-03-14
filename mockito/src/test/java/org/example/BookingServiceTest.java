package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    private BookingService service;
    private PaymentService mockPaymentService;
    private RoomService mockRoomService;
    private BookingDAO mockBookingDAO;
    private MailSender mockMailSender;


    @BeforeEach
    void setup() {

        mockPaymentService= Mockito.mock(PaymentService.class);
        mockRoomService= Mockito.mock(RoomService.class);
        mockBookingDAO= Mockito.spy(BookingDAO.class);
        mockMailSender= Mockito.mock(MailSender.class);
        this.service = new BookingService(mockPaymentService,mockRoomService,mockBookingDAO,mockMailSender);

   }

   @Test
   void shouldThrowException(){

        BookingRequest bookingRequest = new BookingRequest("1",LocalDate.now(), LocalDate.now(),2,false);
        when(mockRoomService.findAvailableRoomId(bookingRequest)).thenThrow(BusinessException.class);


        // when
        Executable executable = () -> service.makeBooking(bookingRequest);

        //then
        assertThrows(BusinessException.class,executable);

    }



    @Test
    void shouldThrowException_argumentmatchers(){

        BookingRequest bookingRequest = new BookingRequest("1",LocalDate.now(), LocalDate.now(),2,false);
        BookingRequest bookingRequest2 = new BookingRequest("2",LocalDate.now(), LocalDate.now(),2,false);
        when(mockRoomService.findAvailableRoomId(any())).thenThrow(BusinessException.class);

        // when
        Executable executable =() -> service.makeBooking(bookingRequest2);


        // then
       assertThrows(BusinessException.class,executable);

       }


    @Test
    void shouldThrowException_argumentmatchers_payment(){

        BookingRequest bookingRequest = new BookingRequest("1",LocalDate.now(), LocalDate.now(),2,true);
        when(mockPaymentService.pay(any(),anyDouble())).thenThrow(BusinessException.class);

        // when
        Executable executable =() -> service.makeBooking(bookingRequest);


        // then
        assertThrows(BusinessException.class,executable);

    }

    @Test
    void should_argumentmatchers_verify2(){
        // given
        BookingRequest bookingRequest = new BookingRequest("1",LocalDate.now(), LocalDate.now(),6,true);
   /*     when(mockBookingDAO.save(bookingRequest)).thenReturn("1");
        String expected = "5";*/

        // when
        String actual =service.makeBooking(bookingRequest);
        System.out.println("actual "+actual);
        verify(mockBookingDAO).save(bookingRequest);
        System.out.println("bookingid" +actual);
        // then
   //     assertEquals(expected,actual );


    }


}