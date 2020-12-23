package com.study.object_oriented_design.ood2.parkinglot;

import com.study.object_oriented_design.ood2.vehicles.Vehicle;
import com.study.object_oriented_design.ood2.vehicles.VehicleSize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {
    private final List<ParkingSpot> spots;

    Level(int numOfSpots) {
        // Assumption: half large, half compact
        List<ParkingSpot> list = new ArrayList<>(numOfSpots);
        int i = 0;
        for (; i < numOfSpots / 2; i++) {
            list.add(new ParkingSpot(VehicleSize.Compact));
        }
        for (; i < numOfSpots; i++) {
            list.add(new ParkingSpot(VehicleSize.Large));
        }
        spots = Collections.unmodifiableList(list);
        // immutable view - do not have add/set/remove, only has get
    }

    boolean hasSpot(Vehicle v) {
        for (ParkingSpot ps : spots) {
            if (ps.fit(v.getSize())) {
                return true;
            }
        }
        return false;
    }

    boolean park(Vehicle v) {
        for (ParkingSpot ps : spots) {
            if (ps.fit(v.getSize())) {
                ps.park(v);
                return true;
            }
        }
        return false;
    }

    boolean leave(Vehicle v) {
        for (ParkingSpot ps : spots) {
            if (ps.getCurrentVehicle() == v) {
                ps.leave();
                return true;
            }
        }
        return false;
    }
}
