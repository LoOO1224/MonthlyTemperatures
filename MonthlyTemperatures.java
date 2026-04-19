import java.util.Scanner;

public class MonthlyTemperatures {
    public static void main(String[] args) {
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        double[] temps = {
            32.5, 35.8, 45.2, 55.7, 65.3, 74.1,
            78.9, 77.2, 68.4, 57.6, 46.3, 36.9
        };

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to Monthly Temperature Viewer!");

        while (running) {
            System.out.print("\nEnter month name (or 'year' for full report): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("year")) {
                displayYearlyReport(months, temps);
                running = false;
            } else {
                boolean found = false;
                for (int index = 0; index < months.length; index++) {
                    if (months[index].toLowerCase().equals(input)) {
                        System.out.printf("%s average temperature: %.1f°F%n", months[index], temps[index]);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Invalid month. Please enter a valid month name (e.g., January) or 'year'.");
                }
            }
        }
        scanner.close();
        System.out.println("\nThank you for using the program!");
    }

    public static void displayYearlyReport(String[] months, double[] temps) {
        System.out.println("\n=== Full Year Temperature Report ===");
        double total = 0.0;
        double maxTemp = temps[0];
        double minTemp = temps[0];
        String maxMonth = months[0];
        String minMonth = months[0];

        for (int index = 0; index < months.length; index++) {
            System.out.printf("%s: %.1f°F%n", months[index], temps[index]);
            total += temps[index];

            if (temps[index] > maxTemp) {
                maxTemp = temps[index];
                maxMonth = months[index];
            }
            if (temps[index] < minTemp) {
                minTemp = temps[index];
                minMonth = months[index];
            }
        }

        double yearlyAverage = total / months.length;
        System.out.printf("%nYearly Average: %.1f°F%n", yearlyAverage);
        System.out.printf("Highest Monthly Average: %s (%.1f°F)%n", maxMonth, maxTemp);
        System.out.printf("Lowest Monthly Average: %s (%.1f°F)%n", minMonth, minTemp);
    }
}