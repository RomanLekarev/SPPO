package services;

import model.Route;
import model.Stop;
import services.abstracts.DetectedWorkloadService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DetectedWorkloadServiceImpl implements DetectedWorkloadService {
    @Override
    public String execute(Set<Route> route) {
        StringBuffer stringBuffer = new StringBuffer();
        route.stream().forEach(action ->{
            Map<Integer,Integer> positionAndCount = new HashMap<>();
            positionAndCount.put(0,0);
            positionAndCount.put(1,0);
            positionAndCount.put(2,0);
            positionAndCount.put(3,0);
            positionAndCount.put(4,0);
            positionAndCount.put(5,0);
            if(action.getAlias().equals(45)){
                if(action.getLoad() == null || action.getLoad().isEmpty()){
                    stringBuffer.append("Продолжительность маршрута :: Пробок нет(0-1)\n");
                }
                for(var el:action.getLoad()){

                    if(!positionAndCount.containsKey(el)){
                        positionAndCount.put(el,1);
                    } else {
                        var nextCount = positionAndCount.get(el)+1;
                        positionAndCount.put(el,nextCount);
                    }
                }
                if(positionAndCount.get(5) > positionAndCount.get(4)
                        && positionAndCount.get(5) > positionAndCount.get(3)
                        && positionAndCount.get(5) > positionAndCount.get(2)
                        && positionAndCount.get(5) > positionAndCount.get(1)
                        && positionAndCount.get(5) > positionAndCount.get(0)){
                    stringBuffer.append("Продолжительность маршрута :: Очень долго(5)");
                }
                if(positionAndCount.get(4) > positionAndCount.get(5)
                        && positionAndCount.get(4) > positionAndCount.get(3)
                        && positionAndCount.get(4) > positionAndCount.get(2)
                        && positionAndCount.get(4) > positionAndCount.get(1)
                        && positionAndCount.get(4) > positionAndCount.get(0)){
                    stringBuffer.append("Продолжительность маршрута :: Умеренно долго(4)");
                }
                if(positionAndCount.get(3) > positionAndCount.get(4)
                        && positionAndCount.get(3) > positionAndCount.get(5)
                        && positionAndCount.get(3) > positionAndCount.get(2)
                        && positionAndCount.get(3) > positionAndCount.get(1)
                        && positionAndCount.get(3) > positionAndCount.get(0)){
                    stringBuffer.append("Продолжительность маршрута :: Хорошо(3)");
                }
                if(positionAndCount.get(2) > positionAndCount.get(4)
                        && positionAndCount.get(2) > positionAndCount.get(3)
                        && positionAndCount.get(2) > positionAndCount.get(5)
                        && positionAndCount.get(2) > positionAndCount.get(1)
                        && positionAndCount.get(2) > positionAndCount.get(0)){
                    stringBuffer.append("Продолжительность маршрута :: Довольно Быстро(2)");
                }
                if(positionAndCount.get(1) > positionAndCount.get(4)
                        && positionAndCount.get(1) > positionAndCount.get(3)
                        && positionAndCount.get(1) > positionAndCount.get(2)
                        && positionAndCount.get(1) > positionAndCount.get(5)
                        && positionAndCount.get(1) > positionAndCount.get(0)){
                    stringBuffer.append("Продолжительность маршрута :: Пробок нет(0-1)");
                }
                if(positionAndCount.get(0) > positionAndCount.get(4)
                        && positionAndCount.get(0) > positionAndCount.get(3)
                        && positionAndCount.get(0) > positionAndCount.get(2)
                        && positionAndCount.get(0) > positionAndCount.get(5)
                        && positionAndCount.get(0) > positionAndCount.get(1)){
                    stringBuffer.append("Продолжительность маршрута :: Пробок нет(0-1)");
                }
            }
        });
        return stringBuffer.toString();
    }
}
