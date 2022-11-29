package twenty_fifteen.day_25;

public class DayTwentyFive {

    public static void main(String[] args) {
        long value = 20151125;
        for(int startRow = 1;; startRow ++){
            for(int row = startRow, column = 1; column <=startRow; row--, column++){
                //To continue, please consult the code grid in the manual.  Enter the code at row 2981, column 3075.
                if(row == 2981 && column == 3075){
                    System.out.println(value);
                    return;
                }
                value = (value*252533)%33554393;
            }
        }
    }
}
