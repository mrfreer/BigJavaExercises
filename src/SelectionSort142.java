import java.util.Arrays;

/**
 * Created by dfreer on 6/29/2017.
 */

class Coin implements Comparable<Coin>{
    double value;
    String name;

    public Coin(double value, String name) {
        this.name = name;
        this.value = value;
    }

    public int compareTo(Coin other){
        if(value < other.value) return -1;
        if(value == other.value) return 0;
        return 1;
    }
}
public class SelectionSort142 {
    public static void main(String[] args) {
        Coin penny = new Coin(.01, "Penny");
        Coin nickel = new Coin(.05, "Nickel");
        Coin dime = new Coin(.1, "Dime");
        Coin quarter = new Coin(.25, "Quarter");
        Coin halfDollar = new Coin(.5, "Half-dollar");
        Coin dollar = new Coin(1, "Dollar");
        Coin [] allCoins = {nickel, dime, quarter, dollar, penny, halfDollar};
        Arrays.sort(allCoins);
        for(Coin c : allCoins){
            System.out.println(c.name);
        }
    }
}
