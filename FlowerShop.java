import java.util.Scanner;

public class FlowerShop {
    private Flower[] inventory;

    public FlowerShop() {
        this.inventory = new Flower[10];
    }

    public void addFlower(int index, Flower flower) {
        inventory[index] = flower;
    }

    public void displayAllFlowers() {
        for (Flower flower : inventory) {
            if (flower != null) {
                System.out.println(flower);
            }
        }
    }

    public double calculateTotalValue() {
        double totalValue = 0;
        for (Flower flower : inventory) {
            if (flower != null) {
                totalValue += flower.getPrice() * flower.getQuantity();
            }
        }
        return totalValue;
    }

    public Flower searchFlowerByName(String name) {
        for (Flower flower : inventory) {
            if (flower != null && flower.getName().equalsIgnoreCase(name)) {
                return flower;
            }
        }
        return null;
    }

    public void restockFlower(String name, int quantity) {
        for (Flower flower : inventory) {
            if (flower != null && flower.getName().equalsIgnoreCase(name)) {
                flower.setQuantity(flower.getQuantity() + quantity);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlowerShop flowerShop = new FlowerShop();

        // Prompt user to enter data for each flower
        for (int i = 0; i < flowerShop.inventory.length; i++) {
            System.out.println("Enter details for flower " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Color: ");
            String color = scanner.nextLine();
            System.out.print("Price: ");
            double price = scanner.nextDouble();
            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            Flower flower = new Flower(name, color, price, quantity);
            flowerShop.addFlower(i, flower);
        }

        // Display all flower details
        System.out.println("\nAll Flower Details:");
        flowerShop.displayAllFlowers();

        // Calculate and display total value of flower inventory
        System.out.println("\nTotal Value of Flower Inventory: $" + flowerShop.calculateTotalValue());

        // Search for a flower by name
        System.out.print("\nEnter the name of the flower to search: ");
        String searchName = scanner.nextLine();
        Flower foundFlower = flowerShop.searchFlowerByName(searchName);
        if (foundFlower != null) {
            System.out.println("\nFound Flower:");
            System.out.println(foundFlower);
        } else {
            System.out.println("\nFlower not found.");
        }

        // Restock a specific flower
        System.out.print("\nEnter the name of the flower to restock: ");
        String restockName = scanner.nextLine();
        System.out.print("Enter the quantity to add: ");
        int restockQuantity = scanner.nextInt();
        flowerShop.restockFlower(restockName, restockQuantity);

        // Display updated flower details after restocking
        System.out.println("\nUpdated Flower Details after Restocking:");
        flowerShop.displayAllFlowers();

        scanner.close();
    }
}
