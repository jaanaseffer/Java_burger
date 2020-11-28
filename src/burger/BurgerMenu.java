package burger;

import java.util.*;

public class BurgerMenu {
    private Map<Burger, SelectionOfExtras> burgerMenu;
    private List<Burger> burgers;

    public BurgerMenu() {
        burgerMenu = new HashMap<>();
        burgers = new ArrayList<>();
    }

    public Map<Burger, SelectionOfExtras> getBurgerMenu() {
        return burgerMenu;
    }

    public void addToBurgerMenu(Burger burger, SelectionOfExtras extras) {
        burgerMenu.put(burger, extras);
        burgers.add(burger);
    }

    public List<Burger> getBurgers() {
        Collections.sort(burgers);
        return burgers;
    }

    @Override
    public String toString() {
        StringBuilder menu = new StringBuilder();
        int counter = 1;
        for (Burger burger : this.burgerMenu.keySet()) {
            menu.append(counter).append(" - ").append(burger).append("\n");
            counter++;
        }
        return menu.toString();
    }
}
