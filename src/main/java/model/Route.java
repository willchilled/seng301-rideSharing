package model;

import java.util.ArrayList;

/**
 * A Class defining Routes for the Ride Sharing system, also contains the inner class StopPoint for defining stop points
 * Created by wmu16 on 29/03/17.
 */
public class Route {

    private String identifier;
    private ArrayList<StopPoint> stopPoints = new ArrayList<>();

    public Route(String identifier) {
        this.identifier = identifier;
    }

    public ArrayList<StopPoint> getStopPoints() {
        return stopPoints;
    }

    public void setStopPoints(ArrayList<StopPoint> stopPoints) {
        this.stopPoints = stopPoints;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
