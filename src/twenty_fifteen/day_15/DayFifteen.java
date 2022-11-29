package twenty_fifteen.day_15;

import java.io.FileNotFoundException;

public class DayFifteen {

    public static void main(String[] args) throws FileNotFoundException {
       // System.out.println(findMaxCapacityForTestData());
        //Part 1
        System.out.println("Total score of the highest-scoring cookie you can make from given ingredients: " + findMaxCookieScore());

        //Part 2
        System.out.println("Given the ingredients in your kitchen and their properties, the total score of the highest-scoring cookie you can make with a calorie total of 500 is: " + whenCaloriesEqualFiveHundreds());
    }

    //Part 1
    public static int findMaxCookieScore(){
        int maxProduct = 0;
        int product;
        for (int i = 1; i < 97; i++) {
            for (int j = 1; j < 97; j++) {
                for (int k = 1; k < 97; k++) {
                    for (int l = 100-k-i-j; l > 0 ; l--) {
                        int totalCapacity = i*Ingredient.BUTTERSCOTCH.capacity + j*Ingredient.CANDY.capacity + k*Ingredient.FROSTING.capacity + l*Ingredient.SUGAR.capacity;
                        if(totalCapacity<0){
                            totalCapacity=0;
                        }
                        int totalDurability = i*Ingredient.BUTTERSCOTCH.durability + j*Ingredient.CANDY.durability + k*Ingredient.FROSTING.durability + l*Ingredient.SUGAR.durability;
                        if(totalDurability<0){
                            totalDurability=0;
                        }
                        int totalFlavor = i*Ingredient.BUTTERSCOTCH.flavor + j*Ingredient.CANDY.flavor + k*Ingredient.FROSTING.flavor + l*Ingredient.SUGAR.flavor;
                        if(totalFlavor < 0){
                            totalFlavor =0;
                        }
                        int totalTexture = i*Ingredient.BUTTERSCOTCH.texture + j*Ingredient.CANDY.texture + k*Ingredient.FROSTING.texture + l*Ingredient.SUGAR.texture;
                        if(totalTexture<0){
                            totalTexture=0;
                        }
                        product = totalCapacity*totalDurability*totalFlavor*totalTexture;
                        maxProduct = Math.max(maxProduct, product);
                        break;
                    }
                }
            }
        }
        return maxProduct;

    }

    //Part 2
    public static int whenCaloriesEqualFiveHundreds(){
        int maxProduct = 0;
        int product;
        for (int i = 1; i < 97; i++) {
            for (int j = 1; j < 97; j++) {
                for (int k = 1; k < 97; k++) {
                    for (int l = 100-k-i-j; l > 0 ; l--) {
                        int totalCapacity = i*Ingredient.BUTTERSCOTCH.capacity + j*Ingredient.CANDY.capacity + k*Ingredient.FROSTING.capacity + l*Ingredient.SUGAR.capacity;
                        if(totalCapacity<0){
                            totalCapacity=0;
                        }
                        int totalDurability = i*Ingredient.BUTTERSCOTCH.durability + j*Ingredient.CANDY.durability + k*Ingredient.FROSTING.durability + l*Ingredient.SUGAR.durability;
                        if(totalDurability<0){
                            totalDurability=0;
                        }
                        int totalFlavor = i*Ingredient.BUTTERSCOTCH.flavor + j*Ingredient.CANDY.flavor + k*Ingredient.FROSTING.flavor + l*Ingredient.SUGAR.flavor;
                        if(totalFlavor < 0){
                            totalFlavor =0;
                        }
                        int totalTexture = i*Ingredient.BUTTERSCOTCH.texture + j*Ingredient.CANDY.texture + k*Ingredient.FROSTING.texture + l*Ingredient.SUGAR.texture;
                        if(totalTexture<0){
                            totalTexture=0;
                        }
                        int totalCalories = i*Ingredient.BUTTERSCOTCH.calories + j*Ingredient.CANDY.calories + k*Ingredient.FROSTING.calories + l*Ingredient.SUGAR.calories;

                        product = totalCapacity*totalDurability*totalFlavor*totalTexture;
                        if(totalCalories==500){
                            maxProduct = Math.max(maxProduct, product);
                        }
                        break;
                    }
                }
            }
        }
        return maxProduct;

    }

    //That's for test data
    public static int findHighestScoringCookie(){
        int maxProduct = 0;
        int product;
        for (int i = 1; i < 100; i++) {
            for (int j = 100-i; j > 0; j--) {
                int totalCapacity = i*Ingredient.BUTTERSCOTCHTEST.capacity + j*Ingredient.CINNAMON.capacity;
                if(totalCapacity<0){
                    totalCapacity=0;
                }
                int totalDurability = i*Ingredient.BUTTERSCOTCHTEST.durability + j*Ingredient.CINNAMON.durability;
                if(totalDurability<0){
                    totalDurability=0;
                }
                int totalFlavor = i*Ingredient.BUTTERSCOTCHTEST.flavor + j*Ingredient.CINNAMON.flavor;
                if(totalFlavor < 0){
                    totalFlavor =0;
                }
                int totalTexture =i*Ingredient.BUTTERSCOTCHTEST.texture + j*Ingredient.CINNAMON.texture;
                if(totalTexture<0){
                    totalTexture=0;
                }
                product = totalCapacity*totalDurability*totalFlavor*totalTexture;
                maxProduct = Math.max(maxProduct, product);
                break;
            }
        }
        return maxProduct;
    }

}
