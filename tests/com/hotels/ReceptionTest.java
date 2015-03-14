package com.hotels;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by kaustavc on 3/14/2015.
 * Reception test file for a hotel transaction
 */
public class ReceptionTest {
    @Test
    public void testCustomerShouldGetRoomIfAvailable() {
        List<Room> rooms = new ArrayList<Room>();
        rooms.add(new Room(2, 3, 101, 2));

        Hotel hotel = new Hotel("Treejon Guest House", rooms, "Puri");
        hotel.addManager("Santosh");
        Customer sukhvindar = new Customer("Sukhvindar", new City("Chandigarh"), 42, 1234);

        Room rm = hotel.getRoom(sukhvindar.getDetails(), 3);
        assertNotNull(rm);
    }

    @Test
    public void testCustomerShouldGetRoomIfNotAvailable() {
        List<Room> rooms = new ArrayList<Room>();
        rooms.add(new Room(2, 3, 101, 2));

        Hotel hotel = new Hotel("Treejon Guest House", rooms, "Puri");
        hotel.addManager("Santosh");
        Customer sukhvindar = new Customer("Sukhvindar", new City("Chandigarh"), 42, 1234);

        Room rm = hotel.getRoom(sukhvindar.getDetails(), 4);
        assertNull(rm);
    }

    @Test
    public void testCustomerShouldGetRoomIfMultipleRoomAvailableFor3People() {
        List<Room> rooms = new ArrayList<Room>();
        rooms.add(new Room(2, 3, 201, 2));
        rooms.add(new Room(2, 3, 202, 2));
        rooms.add(new Room(1, 2, 102, 1));

        Hotel hotel = new Hotel("Treejon Guest House", rooms, "Puri");
        hotel.addManager("Santosh");
        Customer sukhvindar = new Customer("Sukhvindar", new City("Chandigarh"), 42, 1234);

        Room rm = hotel.getRoom(sukhvindar.getDetails(), 3);
        assertNotNull(rm);
    }
}
