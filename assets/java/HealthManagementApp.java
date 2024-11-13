// HealthManagementApp.java
package assets.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HealthManagementApp {

    private SymptomChecker symptomChecker;

    public HealthManagementApp() {
        // Initialize the SymptomChecker instance
        symptomChecker = new SymptomChecker();
    }

    public void start() {
        System.out.println("Welcome to the Health Management App");
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Check Symptoms for Diagnosis");
            System.out.println("2. Exit");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                checkSymptoms(scanner);
            } else if (choice.equals("2")) {
                System.out.println("Thank you for using the Health Management App.");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private void checkSymptoms(Scanner scanner) {
        List<String> symptoms = new ArrayList<>();
        
        System.out.println("Please enter symptoms (type 'done' to finish):");
        
        while (true) {
            String symptom = scanner.nextLine();
            if (symptom.equalsIgnoreCase("done")) {
                break;
            }
            symptoms.add(symptom);
        }

        String diagnosis = symptomChecker.checkDiagnosis(symptoms);
        System.out.println("Possible Diagnosis: " + diagnosis);
    }

    public static void main(String[] args) {
        HealthManagementApp app = new HealthManagementApp();
        app.start();
    }
}
