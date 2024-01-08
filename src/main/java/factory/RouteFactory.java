package factory;

import model.BusTransport;
import model.ElectroBusTransport;
import model.MinibusTransport;
import model.Route;
import model.abstracts.Transport;
import model.abstracts.enums.TypeTransport;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RouteFactory {

    public Route release(Set<Transport> transport, Integer number) {
        return new Route(number,new ArrayList<>(),new ArrayList<>(),transport);
    }
}
