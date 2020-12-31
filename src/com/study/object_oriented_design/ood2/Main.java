package com.study.object_oriented_design.ood2;

import com.study.object_oriented_design.ood2.parkinglot.ParkingLot;
import com.study.object_oriented_design.ood2.vehicles.Car;
import com.study.object_oriented_design.ood2.vehicles.Truck;
import com.study.object_oriented_design.ood2.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    ParkingLot lot = new ParkingLot(4, 10);
    List<Vehicle> list = new ArrayList<>();
    for (int i = 0; i < 50; i++) {
      final Vehicle v = i % 2 == 0 ? new Car("103-527") : new Truck("256-885");
      list.add(v);
      boolean hasSpot = lot.hasSpot(v);
      if (i < 40) {
        // make sure you enable assert if using it for test
        assert hasSpot;
        assert lot.park(v);
      } else {
        assert !hasSpot;
        assert !lot.park(v);
      }
    }
    assert list.size() == 50;
    int i = 0;
    for (Vehicle v : list) {
      assert i >= 40 || lot.leave(v);
      i++;
    }
  }

}
