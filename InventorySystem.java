import java.util.ArrayList;
import java.util.Scanner;

public class InventorySystem {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> ids = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
    ArrayList<Double> prices = new ArrayList<>();
    ArrayList<Integer> quantities = new ArrayList<>();
    int count = 0;

    public static void main(String[] args) {
        InventorySystem inventory = new InventorySystem();
        inventory.runSystem();
    }

    public void runSystem() {
        int choice;
        boolean running = true;

        do {
            System.out.println("\n***************** STATIONERY SHOP INVENTORY *****************");
            System.out.println("1. Add product");
            System.out.println("2. View all products");
            System.out.println("3. Update product");
            System.out.println("4. Delete product");
            System.out.println("5. Exit");

            System.out.print("Enter a choice: ");

            choice=scanner.nextInt();

            switch (choice) {
                case 1-> addproduct();
                case 2-> viewproducts();
                case 3-> updateproduct();
                case 4-> deleteproduct();
                case 5-> running = false;
                default-> System.out.println("Invalid option!");
            }
        } while (running);

        System.out.println("THANK YOU FOR VISITING!");
        scanner.close();
    }

    void addproduct() {
        System.out.print("Enter the ID of the product: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter the name of the product: ");
        String name = scanner.nextLine();

        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter the price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        ids.add(id);
        names.add(name);
        quantities.add(quantity);
        prices.add(price);

        count++;
        System.out.println("Product added successfully!");
    }

    void viewproducts() {
        if (count == 0) {
            System.out.println("No products...");
            return;
        }

        System.out.println("\n***************** PRODUCT DETAILS *****************");
        System.out.printf("%-5s | %-20s | %-10s | %-10s\n", "ID", "Name", "Quantity", "Price");
        System.out.println("------|----------------------|------------|------------");

        for (int i = 0; i < count; i++) {
            System.out.printf("%-5d | %-20s | %-10d | $%-9.2f\n",
                    ids.get(i), names.get(i), quantities.get(i), prices.get(i));
        }
    }

    void updateproduct() {
        if (count == 0) {
            System.out.println("No products to update.");
            return;
        }

        System.out.print("Enter Product ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        int productIndex = -1;
        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i) == id) {
                productIndex = i;
                break;
            }
        }

        if (productIndex != -1) {
            System.out.println("Product found. Enter new details:");

            System.out.print("Enter new name (current: " + names.get(productIndex) + "): ");
            names.set(productIndex, scanner.nextLine());

            System.out.print("Enter new quantity (current: " + quantities.get(productIndex) + "): ");
            quantities.set(productIndex, scanner.nextInt());

            System.out.print("Enter new price (current: " + prices.get(productIndex) + "): ");
            prices.set(productIndex, scanner.nextDouble());
            scanner.nextLine();

            System.out.println("\nProduct updated successfully!");
        } 
        else {
            System.out.println("\nProduct not found!");
        }
    }

    void deleteproduct() {
        if (count == 0) {
            System.out.println("No products to delete.");
            return;
        }

        System.out.print("Enter Product ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        int productIndex = -1;
        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i) == id) {
                productIndex = i;
                break;
            }
        }

        if (productIndex != -1) {
            ids.remove(productIndex);
            names.remove(productIndex);
            prices.remove(productIndex);
            quantities.remove(productIndex);            
            count--;
            System.out.println("\nProduct with ID " + id + " deleted successfully!");
        } 
        else {
            System.out.println("\nProduct not found!");
       }
    }
}
