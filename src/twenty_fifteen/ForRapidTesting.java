package twenty_fifteen;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ForRapidTesting {
    public static void main(String[] args) {

//        System.out.println(grainsOnSquare(1));
//        System.out.println(grainsOnBoard());
        System.out.println(score(1, 4));
    }



    public static int score(int xOfDart, int yOfDart) {
        double distance = Math.sqrt(Math.pow(xOfDart, 2) + Math.pow(yOfDart, 2));
        //int distance = (int)Math.round(dist);
        int points = 0;

        if(xOfDart <0 || yOfDart < 0){
            throw new IllegalArgumentException("invalid coordinates");
        }
        if(distance > 10.00){
            points = 0;
            System.out.println(distance);
        } if (distance > 5.00 && distance <=10.00){
            points = 1;
            System.out.println(distance);
        } if (distance > 1.00 && distance <=5.00) {
            points = 5;
            System.out.println(distance);
        } if (distance <=1.00){
            points = 10;
            System.out.println(distance);
        }
        return points;
    }

    public static BigInteger grainsOnSquare(final int square) {
        if (!(square>=1 && square<=64)){
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        BigInteger exponent = new BigInteger("2");
        return exponent.pow(square-1);
    }

    public static BigInteger  countGrains(final int square){
        if (!(square>=1 && square<=64)){
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        if(square == 1) {
            return new BigInteger("1");
        }
        BigInteger exponent = new BigInteger("2");
        return exponent.pow(square-1);
    }

    public static BigInteger grainsOnBoard() {
        BigInteger sum = new BigInteger("0");
        for(int i = 1; i <=16; i++){
            sum = sum.add(grainsOnSquare(i));
//            BigInteger grainsOnSquare = new BigInteger(String.valueOf(grainsOnSquare(i)));
//            System.out.println(grainsOnSquare);
        }
        return sum;
    }
}
