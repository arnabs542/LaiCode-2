package com.study.object_oriented_design.ood2.vehicles;

public class Car extends Vehicle{
    public Car(String plate) {
        super(plate);
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.Compact;
    }
}
