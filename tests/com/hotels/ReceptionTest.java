package com.hotels;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by kaustavc on 3/14/2015.
 */
public class ReceptionTest {
    @Test
    public void testManagerShouldEnlistAValidCustomerDetails() {
        List<Room> rooms = new ArrayList<Room>();
        rooms.add(new Room(2, 3, 101, 2));

        Hotel hotel = new Hotel("Treejon Guest House", rooms, "Puri");
        Manager manager = hotel.addManager("Santosh");
        Customer sukhvindar = new Customer("Sukhvindar", new City("Chandigarh"), 42, 1234);

        Room rm = hotel.getRoom(sukhvindar.getDetails(), 3);
        assertNotNull(rm);
    }

}
