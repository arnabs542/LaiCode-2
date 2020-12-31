package com.study.object_oriented_design.ood2.parkinglot;

/* Negotiation:  */
// One level or multiple levels? - may be multiple
// Size? - should consider
// Track the location of each vehicle? - not neccessary

/* Assumption:  */
// Multiple levels
// Check vehicle size]

/*   API:   */
// ParkingLot:
// boolean hasSpot(Vehicle v);
// boolean park(Vehicle v);    --> can also be a ticket
// boolean leave(Vehicle v);   --> can also provide ticket

// Level:
// boolean hasSpot(Vehicle v);
// boolean park(Vehicle v);    --> can also be a ticket
// boolean leave(Vehicle v);   --> can also provide ticket

// ParkingSpot:
// boolean fit(VehicleSize size);
// void park(Vehicle v);    --> VOID!!!
// void leave();            --> VOID!!!
// Vehicle getVehicle();


import com.study.object_oriented_design.ood2.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// since each parking spot and levels has their own physical attributes
// we abstract them out from parking lot
// parking lot -- level -- parking spot
public class ParkingLot {
  // tips: implement code from the class without dependency
  // i.e. write the Vehicle first, and then the ParkingSpot.
  private final List<Level> levels;
  private final HashMap<Vehicle, ParkingSpot> vehicleToSpot = new HashMap<>();


  public ParkingLot(int numOfLevels, int numOfSpotsPerLevel) {
    List<Level> list = new ArrayList<>(numOfLevels);
    for (int i = 0; i < numOfLevels; i++) {
      list.add(new Level(numOfSpotsPerLevel));
    }
    levels = Collections.unmodifiableList(list);
  }

  public boolean hasSpot(Vehicle v) {
    for (Level l : levels) {
      if (l.hasSpot(v)) {
        return true;
      }
    }
    return false;
  }

  public boolean park(Vehicle v) {
    for (Level l : levels) {
      ParkingSpot ps = l.park(v);
      if (ps != null) {
        vehicleToSpot.put(v, ps);
        return true;
      }
    }
    return false;
  }

  public boolean leave(Vehicle v) {
    ParkingSpot ps = vehicleToSpot.getOrDefault(v, null);
    if (ps != null) {
      vehicleToSpot.remove(v);
      ps.leave();
      return true;
    }
    return false;
  }
}
