package twenty_fifteen.day_9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TripSegment {
    public String city;
    public int distanceFromParent = 0;
    public TripSegment parent;
    public List<TripSegment> children = new ArrayList<>();

    public TripSegment(String city, TripSegment parent, List<String> possibleDestinations, HashMap<String, Integer> distances) {
        this.parent = parent;
        this.city = city;

        if (parent != null && distances.containsKey(city + " to " + parent.city)){
            distanceFromParent = distances.get(city + " to " + parent.city);
        }

        for (String destination:
             possibleDestinations) {
            var nextDestinations = new ArrayList<String>(possibleDestinations);
            nextDestinations.remove(destination);

            TripSegment child = new TripSegment(destination, this, nextDestinations, distances);
            children.add(child);
        }
    }

    public ArrayList<Integer> getTotalDistance(){
        var distances = new ArrayList<Integer>();
        if(children.size() == 0){
            distances.add(distanceFromParent);
            return distances;
        }

        for (TripSegment child:
             children) {
            var childDistances = child.getTotalDistance();
            for (Integer childDistance:
                 childDistances) {
                distances.add(childDistance + distanceFromParent);
            }
        }
        return distances;
    }
}
