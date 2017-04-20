package model;

import java.sql.Time;

/**
 * Created by Computer Doctor on 4/20/2017.
 */
public class StopPoint {

    private String streetAddress;
    private Time stopTime;

    public StopPoint(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Time getStopTime() {
        return stopTime;
    }

    public void setStopTime(Time stopTime) {
        this.stopTime = stopTime;
    }
}