package com.hotels;

/**
 * Created by kaustavc on 3/14/2015.
 */
public class Room {
    private final int numberOfBeds;
    private final int maxPeople;
    private final int number;
    private final int floor;

    public Room(int numberOfBeds, int maxPeople, int number, int floor) {
        this.numberOfBeds = numberOfBeds;
        this.maxPeople = maxPeople;
        this.number = number;
        this.floor = floor;
    }
}
