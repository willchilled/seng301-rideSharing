package model;

import java.sql.Time;
import java.util.TreeSet;

/**
 * A Class defining Routes for the Ride Sharing system, also contains the inner class StopPoint for defining stop points
 * Created by wmu16 on 29/03/17.
 */
public class Route {

    private String identifier;
    private TreeSet<StopPoint> route = new TreeSet<>();

    public Route(String identifier) {
        this.identifier = identifier;
    }

    public TreeSet<StopPoint> getRoute() {
        return route;
    }

    public void setRoute(TreeSet<StopPoint> route) {
        this.route = route;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    private class StopPoint {

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
}
