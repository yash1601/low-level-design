package models;

public abstract class Vehicle {
    protected String licenseNumber;
    protected VehicleType type;

    public Vehicle(String licenseNumber, VehicleType type) {
        this.licenseNumber = licenseNumber;
        this.type = type;
    }

    public VehicleType getType() { return type; }
    public String getLicenseNumber() { return licenseNumber; }

    public String getLicensePlate() {
        return licenseNumber;
    }
}
