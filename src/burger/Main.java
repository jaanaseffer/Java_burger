package burger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner reader = new Scanner(System.in);

        // Create burgers
        Burger ChickenBurger = new Burger("Chicken Burger", "chicken", "white bread", 5.00);
        Burger OldFashionedCheeseburger = new Burger("Old Fashioned Cheeseburger", "beef", "white bread", 6.00);
        Burger NewYorkBurger = new Burger("New York Burger", "pork", "grain bread", 5.50);

        // Adding extras to the burgers
        SelectionOfExtras chickenBurgerExtras = new SelectionOfExtras(new Extras("cheese", 0.5), new Extras("salad", 0.3), new Extras("tomato", 0.5), new Extras("mayo", 0.5));
        SelectionOfExtras oldFashionedCheeseBurgerExtras = new SelectionOfExtras(new Extras("bacon", 0.7), new Extras("cucumber", 0.5), new Extras("onion", 0.3), new Extras("bacon sauce", 0.5));
        SelectionOfExtras newYorkBurgerExtras = new SelectionOfExtras(new Extras("pineapple", 0.7), new Extras("tomato", 0.5), new Extras("cucumber", 0.5), new Extras( "onion", 0.3));

        // Creating new burger menu
        BurgerMenu burgerMenu = new BurgerMenu();

        // Adding burger to the menu
        burgerMenu.addToBurgerMenu(ChickenBurger, chickenBurgerExtras);
        burgerMenu.addToBurgerMenu(OldFashionedCheeseburger, oldFashionedCheeseBurgerExtras);
        burgerMenu.addToBurgerMenu(NewYorkBurger, newYorkBurgerExtras);

        // Print out the menu for the customer
        System.out.println("Burgers menu:");

        // Start the receipt
        Receipt receipt = new Receipt();

        while (true) {
            System.out.println(burgerMenu);
            System.out.println("Choose burger (Press 0 when order is done): ");
            int selectionNumber;
            try {
                selectionNumber = Integer.parseInt(input.nextLine());

                if (selectionNumber > burgerMenu.getBurgers().size()) {
                    throw new BurgerException();
                } else if (selectionNumber == 0) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Not valid burger number");
                continue;
            }

            // Burger that the client has selected and its additions
            Burger selectedBurger = burgerMenu.getBurgers().get(selectionNumber - 1);
            SelectionOfExtras selectedBurgerExtras = burgerMenu.getBurgerMenu().get(selectedBurger);

            System.out.println("Extras for this burger: " + selectedBurgerExtras);

            // Loop of extras
            while (true) {
                System.out.println("Choose extras (Press enter when you are done): ");
                String extraChosen = reader.nextLine();

                if (extraChosen.isEmpty()) {
                    break;
                }

                for (Extras extra : selectedBurgerExtras.getExtras()) {
                    if (extra.getName().toLowerCase().equals(extraChosen)) {
                        selectedBurger.addExtras(extra);
                        break;
                    }
                }
            }

            receipt.addToReceipt(selectedBurger);
            System.out.println("Current amount to pay: " + receipt.sumUpPrice() + " €");
        }

        System.out.println("Your receipt:");
        System.out.println(receipt);
        System.out.println("You have to pay: " + receipt.sumUpPrice() + " €");
    }
}