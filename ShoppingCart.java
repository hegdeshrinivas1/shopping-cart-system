import java.util.LinkedList;
import java.util.Iterator;

public class ShoppingCart {

    private final LinkedList<Item> cart = new LinkedList<>();

    // Add new item
    public void addItem(String name, int quantity, double price) {

        Item item = new Item(name, quantity, price);
        cart.add(item);

        System.out.println("Item added successfully.");
    }

    // Remove item by name
    public void removeItem(String name) {

    Iterator<Item> iterator = cart.iterator();

    while (iterator.hasNext()) {

        Item item = iterator.next();

        if (item.getName().equalsIgnoreCase(name)) {
            iterator.remove();
            System.out.println("Item removed successfully.");
            return;
        }
    }

    System.out.println("Item not found.");
}

    // Update quantity
    public void updateQuantity(String name, int quantity) {

        for (Item item : cart) {

            if (item.getName().equalsIgnoreCase(name)) {
                item.setQuantity(quantity);
                System.out.println("Quantity updated successfully.");
                return;
            }
        }

        System.out.println("Item not found.");
    }

    // Update price
    public void updatePrice(String name, double price) {

        for (Item item : cart) {

            if (item.getName().equalsIgnoreCase(name)) {
                item.setPrice(price);
                System.out.println("Price updated successfully.");
                return;
            }
        }

        System.out.println("Item not found.");
    }

    // Display first and last item
    public void showFirstAndLastItem() {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\nFirst Added Item:");
        System.out.println(cart.getFirst().getName());

        System.out.println("\nLast Added Item:");
        System.out.println(cart.getLast().getName());
    }

    // Display all items and total bill
    public void displayCart() {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\n---------------- Shopping Cart ----------------");
        System.out.printf(
                "%-20s %-10s %-12s %-12s%n",
                "Item Name", "Quantity", "Price", "Total"
        );

        System.out.println("------------------------------------------------");

        double overallTotal = 0;

        for (Item item : cart) {

            System.out.println(item);
            overallTotal += item.getTotal();
        }

        System.out.println("------------------------------------------------");
        System.out.printf("Overall Total Bill: %.2f%n", overallTotal);
    }
}
