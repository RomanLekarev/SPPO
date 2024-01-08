package builder;

import factory.RouteFactory;
import model.Route;
import model.Stop;
import model.abstracts.Transport;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RouteSupportBuilder {
    private RouteFactory routeFactory = new RouteFactory();

    private Integer alias = -1;
    private List<Stop> route = new ArrayList<>();
    private Set<Transport> transport;
    public RouteSupportBuilder setRoute(List<Stop> route) {
        this.route = route;
        return this;
    }
    public RouteSupportBuilder setTransport(Set<Transport> transport) {
        this.transport = transport;
        return this;
    }
    public RouteSupportBuilder setAlias(Integer alias){
        this.alias = alias;
        return this;
    }
    public Route build(){
        Route route = routeFactory.release(transport,alias);
        route.setAlias(alias);
        for (var el:this.route) {
            route.addStopsToEndRoute(el);
        }
        return route;
    }
    public Route buildEmpty(){
        Route route = routeFactory.release(null,null);
        route.setAlias(alias);
        for (var el:this.route) {
            route.addStopsToEndRoute(el);
        }
        return route;
    }
}
