package com.hotels;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kaustavc on 3/14/2015.
 * Reception test file for a hotel transaction
 */
public class HotelTest {
    List<Room> rooms;
    Hotel hotel;
    Customer sukhvindar;

    @Before
    public void setUp() throws Exception {
        rooms = new ArrayList<Room>();
        rooms.add(new Room(2, 3, 101, 2, 350));

        hotel = new Hotel("Treejon Guest House", rooms, "Puri");
        hotel.addManager("Santosh");
        sukhvindar = new Customer("Sukhvindar", new City("Chandigarh", "Punjab", "India"), 42, 1234);
    }

    @After
    public void tearDown() throws Exception {
        rooms = new ArrayList<Room>();
        hotel = null;
        sukhvindar = null;
    }

    @Test
    public void testCustomerShouldGetRoomIfAvailable() {
        Room rm = hotel.getRoom(sukhvindar.toString(), 3);
        assertNotNull(rm);
    }

    @Test
    public void testCustomerShouldGetRoomIfNotAvailable() {
        Room rm = hotel.getRoom(sukhvindar.toString(), 4);
        assertNull(rm);
    }

    @Test
    public void testCustomerShouldGetRoomIfMultipleRoomAvailableFor3People() {
        List<Room> rooms = new ArrayList<Room>();
        rooms.add(new Room(2, 3, 201, 2,300 ));
        rooms.add(new Room(2, 3, 202, 2, 300));
        rooms.add(new Room(1, 2, 102, 1, 300));

        Room rm = hotel.getRoom(sukhvindar.toString(), 3);
        assertNotNull(rm);
    }

    @Test
    public void testHotelShouldAddANewRoom() {
        Room rm = new Room(3, 4, 301, 3, 300);

        hotel.addRoom(rm);
        assertEquals(2, hotel.totalRooms());

        new Room(3, 4, 301, 3, 300);
        hotel.addRoom(rm);
        assertEquals(3, hotel.totalRooms());
    }

    @Test
    public void testEnqueryShouldGiveListOfAvailableRooms() {
        rooms.add(new Room(2, 3, 201, 2, 300));
        rooms.add(new Room(2, 3, 202, 2, 300));
        rooms.add(new Room(1, 2, 102, 1, 300));
        List<Room> rm = hotel.enquery(sukhvindar.toString(), 3);
        assertEquals(rm.size(), 3);
    }

    @Test
    public void testEnqueryShouldGiveNullWhenNoRoomsAvailable() {
        rooms.add(new Room(2, 3, 201, 2, 300));
        rooms.add(new Room(2, 3, 202, 2, 300));
        rooms.add(new Room(1, 2, 102, 1, 300));
        List<Room> rm = hotel.enquery(sukhvindar.toString(), 4);
        assertNull(rm);
    }

    @Test
    public void testShouldBookARoomForAGuest() {
        List<Room> rm = hotel.enquery(sukhvindar.toString(), 3);
        assertTrue(rm.contains(new Room(2, 3, 101, 2, 300)));

        hotel.book(101);
        assertNull(hotel.enquery(sukhvindar.toString(), 3));
    }

    @Test
    public void testShouldReleaseARoomForAGuest() {
        List<Room> rm = hotel.enquery(sukhvindar.toString(), 3);
        assertTrue(rm.contains(new Room(2, 3, 101, 2, 300)));

        Room room = hotel.book(101);
        assertNull(hotel.enquery(sukhvindar.toString(), 3));
        hotel.release(room);
        assertTrue(hotel.enquery(sukhvindar.toString(), 3).contains(new Room(2, 3, 101, 2, 300)));
    }

    @Test
    public void testShouldGetRoomDetails() {
        List<Room> rm = hotel.enquery(sukhvindar.toString(), 3);
        String expected = "Bed: 2\nMaximum Capacity: 3 persons\nRoom no.: 101\nFloor: 2\nTariff: Rs.350";
        assertEquals(expected, rm.get(0).toString());
    }
}
