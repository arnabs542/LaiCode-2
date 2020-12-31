package com.study.object_oriented_design.ood2.vehicles;

public class Truck extends Vehicle {
  public Truck(String plate) {
    super(plate);
  }

  @Override
  public VehicleSize getSize() {
    return VehicleSize.Large;
  }
}
