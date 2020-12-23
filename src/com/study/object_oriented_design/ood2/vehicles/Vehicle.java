package com.study.object_oriented_design.ood2.vehicles;

public abstract class Vehicle {
    private final String plate;

    public Vehicle(String plate) {
        this.plate = plate;
    }

    public abstract VehicleSize getSize();
}
