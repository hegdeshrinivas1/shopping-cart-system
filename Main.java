import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n======================================");
            System.out.println("       SHOPPING CART SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add New Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. Update Price");
            System.out.println("5. View First and Last Item");
            System.out.println("6. Display All Items and Total Bill");
            System.out.println("7. Exit");
            System.out.println("======================================");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println(
                        "Invalid input! Please enter a number from 1 to 7."
                );
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    System.out.print("Enter price per unit: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    if (quantity <= 0 || price < 0) {
                        System.out.println(
                                "Quantity must be greater than 0 and price cannot be negative."
                        );
                    } else {
                        cart.addItem(name, quantity, price);
                    }
                    break;

                case 2:
                    System.out.print("Enter item name to remove: ");
                    String removeName = scanner.nextLine();

                    cart.removeItem(removeName);
                    break;

                case 3:
                    System.out.print("Enter item name: ");
                    String quantityName = scanner.nextLine();

                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine();

                    if (newQuantity <= 0) {
                        System.out.println("Quantity must be greater than 0.");
                    } else {
                        cart.updateQuantity(quantityName, newQuantity);
                    }
                    break;

                case 4:
                    System.out.print("Enter item name: ");
                    String priceName = scanner.nextLine();

                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();

                    if (newPrice < 0) {
                        System.out.println("Price cannot be negative.");
                    } else {
                        cart.updatePrice(priceName, newPrice);
                    }
                    break;

                case 5:
                    cart.showFirstAndLastItem();
                    break;

                case 6:
                    cart.displayCart();
                    break;

                case 7:
                    System.out.println("Exiting Shopping Cart System...");
                    scanner.close();
                    return;

                default:
                    System.out.println(
                            "Invalid choice! Please enter a number from 1 to 7."
                    );
            }
        }
    }
}