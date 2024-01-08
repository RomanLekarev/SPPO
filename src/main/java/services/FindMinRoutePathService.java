package services;

import model.Route;
import model.Stop;
import services.abstracts.FindRoutePathService;
import services.abstracts.RouteService;

import java.util.List;

public class FindMinRoutePathService implements FindRoutePathService {
    private RouteService routeService = RouteServiceImpl.getInstance();
    @Override
    public String findPath(String from, String to) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Route> routes = new java.util.ArrayList<>(routeService.getRoutAll().stream().toList());
        var stopFrom = Stop.builder().setName(from).build();
        var stopTo = Stop.builder().setName(to).build();
        int step = 0;
        boolean flag = false;
        Route thisRoute = null;
        for(var route:routes) {
            if(route.getRoute().contains(stopFrom)){
                stringBuilder.append("::: \tМаршрутка с №").append(route.getAlias()).append("\t::::\n");
                for(int i = 0;i < route.getRoute().size()-1;i++){
                    if (route.getRoute().get(i).equals(stopFrom)) {
                        thisRoute = route;
                        stopFrom = route.getRoute().get(i+1);
                        break;
                    }
                }
            }
            if(route.getRoute().contains(stopTo)){
                flag = true;
            }
        }
        routes.remove(thisRoute);
        for(var route:routes){
            if(route.getRoute().contains(stopTo)){
                stringBuilder.append(sorts(route,stopTo));
            }
        }
        if(!flag){
            return "";
        }
        return stringBuilder.toString();
    }
    private String sorts(Route route,Stop to) {
        StringBuilder stringBuilder = new StringBuilder();
        if(route.getRoute().contains(to)){
            stringBuilder
                    .append(":::\tПересаживаетесь на маршрут с №").append(route.getAlias()).append("\t::::\n");
        }
        return stringBuilder.toString();
    }

}
