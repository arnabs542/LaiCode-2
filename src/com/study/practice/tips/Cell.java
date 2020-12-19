package com.study.practice.tips;

import java.util.Objects;

// 学习如何写equals和hashCode等
class Cell {
    boolean aBoolean;
    char aChar;
    int anInt;
    float aFloat;
    double aDouble;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return aBoolean == cell.aBoolean &&
                aChar == cell.aChar &&
                anInt == cell.anInt &&
                Float.compare(cell.aFloat, aFloat) == 0 &&
                Double.compare(cell.aDouble, aDouble) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aBoolean, aChar, anInt, aFloat, aDouble);
    }
}
