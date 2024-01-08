import model.BusTransport;
import model.MinibusTransport;
import model.Route;
import model.Stop;
import services.FindDirectRoutePath;
import services.FindMinRoutePathService;
import services.RouteServiceImpl;
import services.abstracts.FindRoutePathService;
import services.abstracts.RouteService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    static RouteService routeService = RouteServiceImpl.getInstance();
    static FindRoutePathService findRoutePathService = new FindDirectRoutePath();

    public static void main(String[] args) {

        if(args.length < 1){
            System.err.println("Не верные входные аргументы!");
            return;
        }
        
        /** Инициализируем **/
        String from = args[0];
        String to = args[1];

        /** Создаем маршруты **/
        Set<Route> routes = new HashSet<>();
        routes.add(Route.builder()
                .setRoute(new ArrayList<>(){{
                    add(Stop.builder()
                            .setCoordinates(54.224d,43.12)
                            .setName("Чаадаева")
                            .build());
                    add(Stop.builder()
                            .setCoordinates(54.225d,43.124)
                            .setName("t")
                            .build());
                    add(Stop.builder()
                            .setCoordinates(54.226d,43.55)
                            .setName("cr")
                            .build());
                }})
                .setAlias(45)
                .setTransport(
                    new HashSet<>(){{
                        add(new BusTransport("n222af"));
                        add(new BusTransport("n555af"));
                        add(new MinibusTransport("s425ff"))
                    ;}}
                )
                .build());
        routes.add(Route.builder()
                .setRoute(new ArrayList<>(){{
                    add(Stop.builder()
                            .setCoordinates(54.224d,43.12)
                            .setName("cr")
                            .build());
                    add(Stop.builder()
                            .setCoordinates(0.44,0.33)
                            .setName("z")
                            .build());
                }})
                .setAlias(46)
                .setTransport(
                        new HashSet<>(){{
                            add(new BusTransport("n222ax"));
                            add(new BusTransport("n555ax"));
                        }}
                )
                .build());

        /** Наш сервис выступает одновременно и хранилищем данных **/
        routeService.bindRoutes(routes);

        /** Вывод остановок одного маршрута **/
        System.out.println(
                String.format("Поиск по остановке \n\t start : %s \n\r end = %s",from,to)
        );

        /** Ищем и выводим номер маршрута до точки **/
        System.out.println(findRouteToPoint(from,to));
    }

    public static String findRouteToPoint(String from,String to){
        String response = findRoutePathService.findPath(from,to);

        if(response == null || response.isEmpty() || response.isBlank()){
            findRoutePathService = new FindMinRoutePathService();
            response = findRoutePathService.findPath(from,to);
        }
        return response;
    }
}
