package model;

import java.util.HashSet;
import java.util.Set;

/**
 * A class that extends the User class, allowing a user to register cars
 * Created by wmu16 on 29/03/17.
 */
public class Driver extends User{

    private Set<Car> cars;

    Driver(String username, String password, String givenName, String surname, Integer age) {
        super(username, password, givenName, surname, age);
        this.cars = new HashSet<>();
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
