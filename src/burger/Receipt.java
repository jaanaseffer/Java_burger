package burger;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Burger> soldBurgers;

    Receipt() {
        this.soldBurgers = new ArrayList<>();
    }

    public void addToReceipt(Burger burger) {
        soldBurgers.add(burger);
    }

    public double sumUpPrice() {
        double total = 0.0;
        for (Burger burger : soldBurgers) {
            total += burger.burgerPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder();
        for (Burger burger : soldBurgers) {
            receipt.append(burger.getName()).append(" - ").append(burger.getPrice()).append(" €\n");
            for (Extras soldExtras : burger.getBurgerExtras()) {
                receipt.append(" + ").append(soldExtras.getName()).append(" - ").append(soldExtras.getPrice()).append(" €\n");
            }
        }
        return receipt.toString();
    }
}
