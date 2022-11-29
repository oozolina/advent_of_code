package twenty_fifteen.day_10;

public class DayTen {

    public static void main(String[] args) {
        System.out.println("The length of the result: " + lengthOfResult());
    }

    public static String lookAndSay(int n){
        String string = "3113322113";
        int i = 1;
        while (i < n){
            StringBuilder stringBuilder = new StringBuilder();
            int count = 1;
            for (int j = 1; j < string.length(); j++){
                if(string.charAt(j) == string.charAt(j-1)){
                    count++;
                } else {
                    stringBuilder.append(count);
                    stringBuilder.append(string.charAt(j-1));
                    count=1;
                }
            }
            stringBuilder.append(count);
            stringBuilder.append(string.charAt(string.length()-1));
            string = stringBuilder.toString();
            i++;
        }
        return string;
    }

    public static int lengthOfResult(){
       // Part 1
        return lookAndSay(41).length();
        //Part 2
//        return lookAndSay(41).length();
    }
}
