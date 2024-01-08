package model;

import builder.RouteSupportBuilder;
import model.abstracts.Transport;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Route {
    private Integer alias = -1;
    private final List<Stop> route;
    private List<Integer> load;
    private Set<Transport> transport;



    public Route(Set<Transport> transport,List<Stop> route) {
        this.transport = transport;
        this.route = route;
    }

    public Route(Integer alias, List<Stop> route,List<Integer> load, Set<Transport> transport) {
        this.alias = alias;
        this.route = route;
        this.load = load;
        this.transport = transport;
    }

    public List<Stop> getRoute() {
        return route;
    }

    public void addStopsToEndRoute(Stop stop){
        route.add(stop);
    }

    public void removeStop(Stop stop){
        route.remove(stop);
    }

    public Set<Transport> getTransport() {
        return transport;
    }

    public void setTransport(Set<Transport> transport) {
        this.transport = transport;
    }

    public Integer getAlias() {
        return alias;
    }

    public void setAlias(Integer alias) {
        this.alias = alias;
    }

    public List<Integer> getLoad() {
        return load;
    }

    public void setLoad(List<Integer> load) {
        this.load = load;
    }

    public static RouteSupportBuilder builder(){
        return new RouteSupportBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route1 = (Route) o;
        return Objects.equals(route, route1.route);
    }

    @Override
    public int hashCode() {
        return Objects.hash(route);
    }
}
