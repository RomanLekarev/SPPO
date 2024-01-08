package services.abstracts;

import model.Route;
import model.Stop;

import java.util.List;
import java.util.Set;

public interface DetectedWorkloadService {

    String execute(Set<Route> stopList);

}
