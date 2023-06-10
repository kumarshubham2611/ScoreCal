package com.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.entity.SATResult;
import com.repository.SATResultRepository;

import java.util.Scanner;

@Component
public class MenuApplication implements CommandLineRunner {

    private final SATResultRepository repository;
    private final Scanner scanner;

    @Autowired
    public MenuApplication(SATResultRepository repository) {
        this.repository = repository;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) {
        boolean running = true;
        while (running) {
            System.out.println("Welcome to SAT Result Management System");
            System.out.println("1. Insert data");
            System.out.println("2. View all data");
            System.out.println("3. Get rank");
            System.out.println("4. Update score");
            System.out.println("5. Delete one record");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    insertData();
                    break;
                case 2:
                    viewAllData();
                    break;
                case 3:
                    getRank();
                    break;
                case 4:
                    updateScore();
                    break;
                case 5:
                    deleteRecord();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private void insertData() {
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Address:");
        String address = scanner.nextLine();
        System.out.println("Enter City:");
        String city = scanner.nextLine();
        System.out.println("Enter Country:");
        String country = scanner.nextLine();
        System.out.println("Enter Pincode:");
        String pincode = scanner.nextLine();
        System.out.println("Enter SAT Score:");
        int score = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        boolean passed = score > 0.3 * 1600; // Assuming the maximum SAT score is 1600

        SATResult satResult = new SATResult();
        satResult.setName(name);
        satResult.setAddress(address);
        satResult.setCity(city);
        satResult.setCountry(country);
        satResult.setPincode(pincode);
        satResult.setScore(score);
        satResult.setPassed(passed);

        repository.save(satResult);

        System.out.println("Data inserted successfully.");
    }

    private void viewAllData() {
        Iterable<SATResult> results = repository.findAll();
        for (SATResult result : results) {
            System.out.println(result.toString());
        }
    }

    private void getRank() {
        System.out.println("Enter Name:");
        String name = scanner.nextLine();

        SATResult result = repository.findByName(name);
        if (result != null) {
            // Perform rank calculation logic based on your requirements
            // ...
            System.out.println("Rank: <rank>");
        } else {
            System.out.println("No data found for the given name.");
        }
    }

    private void updateScore() {
        System.out.println("Enter Name:");
        String name = scanner.nextLine();

        SATResult result = repository.findByName(name);
        if (result != null) {
            System.out.println("Enter new SAT Score:");
            int score = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            result.setScore(score);
            result.setPassed(score > 0.3 * 1600); // Assuming the maximum SAT score is 1600
            repository.save(result);

            System.out.println("Score updated successfully.");
        } else {
            System.out.println("No data found for the given name.");
        }
    }

    private void deleteRecord() {
        System.out.println("Enter Name:");
        String name = scanner.nextLine();

        SATResult result = repository.findByName(name);
        if (result != null) {
            repository.delete(result);

            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("No data found for the given name.");
        }
    }
}
