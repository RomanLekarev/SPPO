package services;

import model.Route;
import model.Stop;
import services.abstracts.FindRoutePathService;
import services.abstracts.RouteService;

public class FindDirectRoutePath implements FindRoutePathService {

    private RouteService routeService = RouteServiceImpl.getInstance();

    @Override
    public String findPath(String from, String to) {
        StringBuilder stringBuilder = new StringBuilder();

        for(var route:routeService.getRoutAll()){
            stringBuilder.append(sorts(route,from, to));
        }
        return stringBuilder.toString();
    }

    private String sorts(Route route, String from, String to) {
        StringBuilder stringBuilder = new StringBuilder();
        if(route.getRoute().contains(Stop.builder().setName(from).build()) && route.getRoute().contains(Stop.builder().setName(to).build())){
            stringBuilder.append("::: \tМаршрутка с №").append(route.getAlias()).append("\t::::\n");
        }
        return stringBuilder.toString();
    }
}
