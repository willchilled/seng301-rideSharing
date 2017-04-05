package model;

import java.util.Date;
import java.util.Set;

/**
 * Class defining a trip, which contains info about the route as well as other data
 * Created by wmu16 on 29/03/17.
 */
class Trip {

    private Route route;
    private Vehicle car;
    private User driver;
    private Set<Day> days;
    private Boolean repeats;
    private Date expiryDate;

    /**
     * An enum for specifying the days a trip can be on
     */
    enum Day {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }


    /**
     * Constructor for making a trip that does not repeat, although it may happen on different days for a single week
     * @param route The route that this trip will be taking
     * @param driver The driver of this route
     * @param vehicle The vehicle used on this trip
     * @param days The days in which this trip will happen
     */
    Trip(Route route, User driver, Vehicle vehicle, Set<Day> days) {
        this.route = route;
        this.driver = driver;
        this.car = vehicle;
        this.days = days;
        this.repeats = false;

    }


    /**
     * Constructor for making a trip that repeats
     * @param route The route that this trip will be taking
     * @param driver The driver of this route
     * @param vehicle The vehicle used on this trip
     * @param days The days in which this trip will happen AND repeat
     * @param expiryDate The date up to which the trip will repeat on the given days
     */
    Trip(Route route, User driver, Vehicle vehicle, Set<Day> days, Date expiryDate) {
        this.route = route;
        this.driver = driver;
        this.car = vehicle;
        this.days = days;
        this.expiryDate = expiryDate;
        this.repeats = true;
    }


    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Vehicle getCar() {
        return car;
    }

    public void setCar(Vehicle vehicle) {
        this.car = vehicle;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    /**
     *
     * @return A set of the days on which this trip is active
     */
    public Set<Day> getDays() {
        return days;
    }

    public void setDays(Set<Day> days) {
        this.days = days;
    }

    /**
     * Indicates whether or not this is a repeating trip
     * @return A boolean True if this is a repeating trip, false otherwise
     */
    public Boolean repeats() {
        return repeats;
    }

    /**
     * @return Expiry date of the trip
     */
    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
