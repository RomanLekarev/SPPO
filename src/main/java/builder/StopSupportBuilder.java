package builder;

import factory.StopFactory;
import model.Stop;
import model.abstracts.Transport;

import java.util.Set;

public class StopSupportBuilder {
    private StopFactory factory = new StopFactory();
    private String name = "NONE";
    private final Double[] coordinates = new Double[2];

    public StopSupportBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StopSupportBuilder setCoordinates(Double x,Double y) {
        this.coordinates[0] = x;
        this.coordinates[1] = y;
        return this;
    }



    public Stop build(){
        Stop stop = factory.release(name);
        stop.setCoordinates(coordinates[0],coordinates[1]);
        stop.setName(name);

        return stop;
    }

    public Stop buildEmpty(){
        return factory.release(name);
    }
}
