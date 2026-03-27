import java.util.*;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class ShoppingCart {

    static ArrayList<Product> productList = new ArrayList<>();

    static HashMap<String, Integer> cart = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        productList.add(new Product("Laptop", 50000));
        productList.add(new Product("Phone", 20000));
        productList.add(new Product("Headphones", 2000));
        productList.add(new Product("Mouse", 500));

        int choice;

        do {
            System.out.println("\n===== SHOPPING CART MENU =====");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Calculate Total");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewProducts();
                    break;

                case 2:
                    addToCart(sc);
                    break;

                case 3:
                    viewCart();
                    break;

                case 4:
                    calculateTotal();
                    break;

                case 5:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }

    static void viewProducts() {
        System.out.println("\nAvailable Products:");
        for (int i = 0; i < productList.size(); i++) {
            Product p = productList.get(i);
            System.out.println((i + 1) + ". " + p.name + " - ₹" + p.price);
        }
    }

    static void addToCart(Scanner sc) {
        viewProducts();
        System.out.print("Select product number: ");
        int index = sc.nextInt() - 1;

        if (index < 0 || index >= productList.size()) {
            System.out.println("Invalid product!");
            return;
        }

        Product selected = productList.get(index);

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        cart.put(selected.name, cart.getOrDefault(selected.name, 0) + qty);

        System.out.println(selected.name + " added to cart!");
    }

    static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("\nCart is empty!");
            return;
        }

        System.out.println("\nYour Cart:");
        for (String item : cart.keySet()) {
            System.out.println(item + " - Quantity: " + cart.get(item));
        }
    }


    static void calculateTotal() {
        double total = 0;

        for (String item : cart.keySet()) {
            int qty = cart.get(item);

            for (Product p : productList) {
                if (p.name.equals(item)) {
                    total += p.price * qty;
                }
            }
        }

        System.out.println("\nTotal Price: ₹" + total);
    }
}