package services;

import model.Route;
import services.abstracts.RouteService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RouteServiceImpl implements RouteService {

    private static RouteServiceImpl routeService;

    public static RouteServiceImpl getInstance() {
        if(routeService == null){
            routeService = new RouteServiceImpl();
        }
        return routeService;
    }

    private Set<Route> routes;

    private RouteServiceImpl() {
        routes = new HashSet<>();
    }
    private RouteServiceImpl(Set<Route> routes) {
        this.routes = routes;
    }
    @Override
    public Route getRoute(Integer alias) {
        for (var  route:routes) {
            if(route.getAlias().equals(alias)){
                return route;
            }
        }
        throw new RuntimeException("Такого маршрута не существует");
    }

    @Override
    public void bindRoutes(Set<Route> routeList) {
        routes = routeList;
    }

    @Override
    public Set<Route> getRoutAll() {
        return routes;
    }
}
