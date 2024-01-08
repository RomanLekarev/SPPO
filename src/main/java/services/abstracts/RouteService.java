package services.abstracts;

import model.Route;

import java.util.List;
import java.util.Set;

public interface RouteService {
    Route getRoute(Integer alias);

    Set<Route> getRoutAll();

    void bindRoutes(Set<Route> routeList);

}
