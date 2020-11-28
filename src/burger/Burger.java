package burger;

import java.util.ArrayList;
import java.util.List;

public class Burger implements Comparable<Burger> {
    private String name;
    private String meatType;
    private String breadType;
    private double price;
    private List<Extras> burgerExtras;

    public Burger(String name, String meatType, String breadType, double price) {
        this.name = name;
        this.meatType = meatType;
        this.breadType = breadType;
        this.price = price;
        this.burgerExtras = new ArrayList<>();
    }

    public List<Extras> getBurgerExtras() {
        return burgerExtras;
    }

    public void addExtras(Extras extra) {
        burgerExtras.add(extra);
    }

    public double burgerPrice() {
        double total = 0;
        total += this.price;
        for (Extras extra : burgerExtras) {
            total += extra.getPrice();
        }
        return total;
    }

    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }

    @Override
    public int compareTo(Burger burger) {
        return Integer.compare(this.name.compareTo(burger.getName()), 0);
    }

    @Override
    public String toString() {
        return this.name + " - " + this.meatType + ", " + this.breadType + this.price + " €";
    }
}
