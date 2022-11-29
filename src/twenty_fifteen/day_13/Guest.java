package twenty_fifteen.day_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Guest {
    public String name;
    public int happinessToParent = 0;
    public Guest guestAkaParent;
    public List<Guest> guestsAkaChildren = new ArrayList<>();

    public Guest(String name, Guest guestToTheRight, List<String> possibleNeighbours, HashMap<String, Integer> happinessLevels){
        this.guestAkaParent = guestToTheRight;
        this.name = name;

        if(guestToTheRight !=null && happinessLevels.containsKey(name + " next to " + guestToTheRight.name + ".")){
            happinessToParent = happinessLevels.get(name + " next to " + guestToTheRight.name + ".");
            happinessToParent += happinessLevels.get(guestToTheRight.name + " next to " + name + ".");
        }

        if(possibleNeighbours.size() > 0) {
            for (String nextGuest : possibleNeighbours) {
                var nextGuests = new ArrayList<String>(possibleNeighbours);
                nextGuests.remove(nextGuest);
                Guest guest = new Guest(nextGuest, this, nextGuests, happinessLevels);
                guestsAkaChildren.add(guest);
            }
        } else {
            if(guestToTheRight !=null && happinessLevels.containsKey(name + " next to " + "Alice.")) {
                happinessToParent += happinessLevels.get(name + " next to Alice.");
                happinessToParent += happinessLevels.get("Alice next to " + name + ".");
            }
        }
    }

    public ArrayList<Integer> getTotalHappiness(){
        var levelOfHappiness = new ArrayList<Integer>();
        if(guestsAkaChildren.size() == 0){
            levelOfHappiness.add(happinessToParent);
            return levelOfHappiness;
        }

        for (Guest guest:
                guestsAkaChildren) {
            var childrenGuestHappiness = guest.getTotalHappiness();
            for (Integer happiness:
                 childrenGuestHappiness) {
                levelOfHappiness.add(happiness + happinessToParent );
            }
        }
        return levelOfHappiness;
    }
}
