package com.study.object_oriented_design.ood2.parkinglot;


import com.study.object_oriented_design.ood2.vehicles.Vehicle;
import com.study.object_oriented_design.ood2.vehicles.VehicleSize;

class ParkingSpot {
  private final VehicleSize size;
  private Vehicle currentVehicle;

  ParkingSpot(VehicleSize size) {
    this.size = size;
  }

  boolean fit(VehicleSize size) {
    // check
    return currentVehicle == null && size.getSize() <= this.size.getSize();
  }

  void park(Vehicle v) {
//        if (availability && fit(v.getSize())) {
//            currentVehicle = v;
//            return true;
//        }
//        return false;
    currentVehicle = v; // not responsible for checking, 一个function干一件事
  }

  void leave() {
    currentVehicle = null;
  }

  Vehicle getCurrentVehicle() {
    return currentVehicle;
  }
}
