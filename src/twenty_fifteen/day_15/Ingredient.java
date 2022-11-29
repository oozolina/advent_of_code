package twenty_fifteen.day_15;

import javax.xml.namespace.QName;

public enum Ingredient {
//    Frosting: capacity 4, durability -2, flavor 0, texture 0, calories 5
//    Candy: capacity 0, durability 5, flavor -1, texture 0, calories 8
//    Butterscotch: capacity -1, durability 0, flavor 5, texture 0, calories 6
//    Sugar: capacity 0, durability 0, flavor -2, texture 2, calories 1

    FROSTING(4, -2, 0, 0, 5),
    CANDY(0, 5, -1, 0, 8),
    BUTTERSCOTCH(-1, 0, 5, 0, 6),
    SUGAR(0, 0, -2, 2, 1),

    //Test data
    BUTTERSCOTCHTEST(-1, -2, 6, 3, 8),
    CINNAMON(2, 3, -2, -1, 3);

    int capacity;
    int durability;
    int flavor;
    int texture;
    int calories;

    Ingredient(int capacity, int durability, int flavor, int texture, int calories) {
        this.capacity = capacity;
        this.durability = durability;
        this.flavor = flavor;
        this.texture = texture;
        this.calories = calories;
    }
}
