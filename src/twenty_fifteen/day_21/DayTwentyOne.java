package twenty_fifteen.day_21;

public class DayTwentyOne {
    public static void main(String[] args) {
        StrategyCorner howToPlay = new StrategyCorner();
        howToPlay.minCostToWin();
        System.out.println("=======================================================");
        howToPlay.maxCostToLose();
    }
}
