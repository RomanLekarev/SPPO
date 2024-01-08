package factory;

import model.Stop;

import java.util.HashSet;

public class StopFactory {
    public Stop release(String name) {
        return new Stop(null,new Double[2]);
    }
}
