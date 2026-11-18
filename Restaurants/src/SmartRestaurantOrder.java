import java.util.Scanner;

public class SmartRestaurantOrder {
    public static void main(String[] args) {
        final double DRINK_PRICE = 15.50;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer's name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer's age: ");
        int customerAge = scanner.nextInt();

        System.out.print("Enter price of the meal: ");
        double mealPrice = scanner.nextDouble();

        System.out.print("Enter number of drinks ordered: ");
        int numberOfDrinks = scanner.nextInt();

        System.out.print("Is the customer a student (true/false): ");
        boolean isStudent = scanner.nextBoolean();

        System.out.print("Enter service rating (1 to 5): ");
        int serviceRating = scanner.nextInt();

        if (serviceRating < 1 || serviceRating > 5) {
            System.out.println("Error: Service rating must be between 1 and 5.");
            scanner.close();
            return;
        }

        double drinksCost = numberOfDrinks * DRINK_PRICE;
        double subtotal = mealPrice + drinksCost;

        double studentDiscount = 0.0;
        if (isStudent) {
            studentDiscount = subtotal * 0.10;
        }

        double seniorDiscount = 0.0;
        if (customerAge >= 60) {
            seniorDiscount = subtotal * 0.05;
        }

        double discountAmount = 0.0;
        if (studentDiscount > seniorDiscount) {
            discountAmount = studentDiscount;
        } else {
            discountAmount = seniorDiscount;
        }

        double tipAmount = 0.0;
        if (serviceRating == 4 || serviceRating == 5) {
            tipAmount = subtotal * 0.10;
        }

        double finalBill = (subtotal - discountAmount) + tipAmount;
        int wholeAmount = (int) finalBill;

        System.out.println("\nSMART RESTAURANT");
        System.out.println("Customer: " + customerName);
        System.out.printf("Meal: $%.2f%n", mealPrice);
        System.out.printf("Drinks: $%.2f%n", drinksCost);
        System.out.printf("Discount: $%.2f%n", discountAmount);
        System.out.printf("Tip: $%.2f%n", tipAmount);
        System.out.printf("Final bill: $%.2f%n", finalBill);
        System.out.println("Whole amount: $" + wholeAmount);

        scanner.close();
    }
}