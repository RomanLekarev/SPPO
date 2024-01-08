package builder;

import factory.StopFactory;
import model.Stop;
import model.abstracts.Transport;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StopSupportBuilder {
    private StopFactory factory = new StopFactory();
    private String name = "NONE";
    private final Double[] coordinates = new Double[2];
    private List<Integer> workload = new ArrayList<>();

    public StopSupportBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StopSupportBuilder setCoordinates(Double x,Double y) {
        this.coordinates[0] = x;
        this.coordinates[1] = y;
        return this;
    }

    public StopSupportBuilder setWorkload(List<Integer> list){
        this.workload = list;
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
