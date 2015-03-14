package com.hotels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaustavc on 3/14/2015.
 */
public class Hotel {
    private final String location;
    private List<Room> rooms;
    private String name;
    private Manager manager;
    List<Entry> register = new ArrayList<Entry>();

    public Hotel(String name, List<Room> rooms, String address) {
        this.name = name;
        this.rooms = rooms;
        this.location = address;
    }

    public Manager addManager(String managerName) {
        manager = new Manager(managerName);
        return manager;
    }

    public Room getRoom(Details details, int totalGuests) {
        return rooms.get(0);
    }
}
