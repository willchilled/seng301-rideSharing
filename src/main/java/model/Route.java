package model;

import java.sql.Time;
import java.util.TreeSet;

/**
 * A Class defining Routes for the Ride Sharing system, also contains the inner class StopPoint for defining stop points
 * Created by wmu16 on 29/03/17.
 */
class Route {

    private TreeSet<StopPoint> route = new TreeSet<>();

    Route() {

    }

    public TreeSet<StopPoint> getRoute() {
        return route;
    }

    public void setRoute(TreeSet<StopPoint> route) {
        this.route = route;
    }



    private class StopPoint {

        private String streetAddress;
        private Time stopTime;

        StopPoint(String streetAddress) {
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
