package com.study.object_oriented_design.ood2.vehicles;

public enum VehicleSize {
  Compact(1), Regular(2), Large(3);
  private final int size;

  VehicleSize(int size) {
    this.size = size;
  }

  public int getSize() {
    return size;
  }
}
