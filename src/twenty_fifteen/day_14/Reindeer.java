package twenty_fifteen.day_14;

public class Reindeer {
    private String name;
    private int flyingDistancePerSecond;
    private int flyingTime;
    private int timeForRest;
    // for Part 2
    private int points = 0;
    private int currentDistance = 0;
    int remainingFlyingTime;
    int remainingRestTime = 0;

    public Reindeer(String name, int flyingDistancePerSecond, int flyingTime, int timeForRest) {
        this.name = name;
        this.flyingDistancePerSecond = flyingDistancePerSecond;
        this.flyingTime = flyingTime;
        this.timeForRest = timeForRest;
        this.remainingFlyingTime = flyingTime;
    }

    public void step(){
        if(remainingFlyingTime > 0){
            currentDistance += flyingDistancePerSecond;
            remainingFlyingTime--;
            if (remainingFlyingTime==0){
                remainingRestTime = timeForRest;
            }
        } else {
            remainingRestTime--;
            if(remainingRestTime==0){
                remainingFlyingTime = flyingTime;
            }
        }
    }

    public void step(int seconds){
        for (int i = 0; i < seconds; i++) {
            step();
        }
    }

    public String getName() {
        return name;
    }

    public int getTotalDistance() {
        return currentDistance;
    }

    public int getPoints() {
        return points;
    }

    public void addPoint() {
        this.points++;
    }
}
