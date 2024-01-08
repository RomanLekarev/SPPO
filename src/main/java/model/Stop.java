package model;

import builder.StopSupportBuilder;
import model.abstracts.Transport;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public class Stop {
    private String name;
    private final Double[] coordinates = new Double[2];;

    public Stop(String name, Double[] coordinates) {
        this.name = name;
        if(this.coordinates.length > coordinates.length) {
            for (int i = 0; i < this.coordinates.length; i++) {
                this.coordinates[i] = coordinates[i];
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Double x,Double y){
        this.coordinates[0] = x;
        this.coordinates[1] = y;
    }

    public Double[] getCoordinates() {
        return coordinates;
    }

    public static StopSupportBuilder builder(){
        return new StopSupportBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stop stop = (Stop) o;
        return Objects.equals(name, stop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("Остановка ощественного транспорта : %s",name);
    }
}
