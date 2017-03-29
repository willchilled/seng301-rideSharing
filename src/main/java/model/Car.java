package model;

/**
 * A Class defining the car object that users can register with their account
 * Created by wmu16 on 29/03/17.
 */
class Car {

    private Type type;
    private String model;
    private String color;
    private String licensePlate;
    private Integer year;
    private Integer numPhysicalSeats;

    /**
     * An enum defining the type of possible vehicles
     */
    enum Type {
        CAR,
        VAN
    }


    Car(String licensePlate, Type type, Integer numPhysicalSeats) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.numPhysicalSeats = numPhysicalSeats;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getNumPhysicalSeats() {
        return numPhysicalSeats;
    }

    public void setNumPhysicalSeats(Integer numPhysicalSeats) {
        this.numPhysicalSeats = numPhysicalSeats;
    }
}
