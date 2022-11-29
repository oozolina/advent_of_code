package twenty_fifteen.day_11;

public class DayEleven {

    public static void main(String[] args) {
        //Part 1
        System.out.println(getNewPassword("cqjxjnds"));

        // Part 2
        System.out.println(getNewPassword("cqjxxyzz"));
    }

    public static String replaceCharacter(String string, int index, char character) {
        return string.substring(0, index) + character + string.substring(index+1);
    }

    public static String incrementingSpring(String string){

        for (int i = string.length()-1; i >= 0; i--) {
            char letterToChange = string.charAt(i);
            if(letterToChange == 'z'){
                string = replaceCharacter(string, i, 'a');
            } else {
                string = replaceCharacter(string, i, (char)(letterToChange+1));
                break;
            }
        }
        return string;
    }

    // Requirement 1: one increasing straight of at least three letters
    public static boolean threeLetterIncrementInARow(String string){
        for (int i = 0; i < string.length()-2; i++) {
            char letter = string.charAt(i);
            char nextLetter = ++letter;
            if(string.charAt(i+1)==nextLetter && string.charAt(i+2)==++nextLetter){
                return true;
            }
        }
        return false;
    }

    public static boolean notContainCertainVowels(String string){
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i)=='i' || string.charAt(i)=='o' || string.charAt(i)=='l'){
                return false;
            }
        }
        return true;
    }

    public static boolean ifContainsDoubleLetters(String string){
        for (int i = 0; i < string.length()-1; i++) {
            for (int j = i+2; j < string.length()-1; j++) {
                if(string.charAt(i) == string.charAt(i+1) && string.charAt(j) == string.charAt(j+1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static String getNewPassword(String string){
        do{
            string = incrementingSpring(string);
        } while(!(notContainCertainVowels(string)
                && ifContainsDoubleLetters(string)
                && threeLetterIncrementInARow(string)));
        return string;
    }
}
