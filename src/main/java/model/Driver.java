package model;

import java.util.HashSet;
import java.util.Set;

/**
 * A class that extends the User class, allowing a user to register vehicles
 * Created by wmu16 on 29/03/17.
 */
public class Driver extends User{

    private Set<Vehicle> vehicles;

    Driver(String username, String password, String givenName, String surname, Integer age) {
        super(username, password, givenName, surname, age);
        this.vehicles = new HashSet<>();
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
