package lab5;

import java.util.List;
import java.util.Scanner;

public class CompanyManagement {
    private Company company;

    public CompanyManagement() {
        company = new Company();
    }

    public void displayMenu() {
        System.out.println("========== MENU ==========");
        System.out.println("1. Add New Customer");
        System.out.println("2. Display All Customers");
        System.out.println("3. Search Customers");
        System.out.println("4. Sort Customers");
        System.out.println("0. Exit");
        System.out.println("==========================");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addNewCustomer(scanner);
                    break;
                case 2:
                    displayAllCustomers();
                    break;
                case 3:
                    searchCustomers(scanner);
                    break;
                case 4:
                    // Sort customers
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    public void addNewCustomer(Scanner scanner) {
        System.out.println("========== Add New Customer ==========");
        System.out.print("Enter customer code: ");
        String customerCode = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(customerCode, name, phone);
        company.addCustomer(customer);

        System.out.println("Customer added successfully!");
        System.out.println("======================================");
    }

    public void displayAllCustomers() {
        System.out.println("========== All Customers ==========");
        System.out.println(company.toString());
        System.out.println("====================================");
    }

    public void searchCustomers(Scanner scanner) {
        System.out.println("========== Search Customers ==========");
        System.out.println("1. Search by Name");
        System.out.println("2. Search by Phone");
        System.out.println("0. Back");
        System.out.println("======================================");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                System.out.print("Enter name to search: ");
                String name = scanner.nextLine();
                displaySearchResults(company.searchCustomersByName(name));
                break;
            case 2:
                System.out.print("Enter phone to search: ");
                String phone = scanner.nextLine();
                displaySearchResults(company.searchCustomersByPhone(phone));
                break;
            case 0:
                // Go back to the main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void displaySearchResults(List<Customer> searchResults) {
        System.out.println("========== Search Results ==========");
        if (searchResults.isEmpty()) {
            System.out.println("No matching customers found.");
        } else {
            for (Customer customer : searchResults) {
                System.out.println(customer.toString());
            }
        }
        System.out.println("====================================");
    }

    public static void main(String[] args) {
        CompanyManagement management = new CompanyManagement();
        management.start();
    }
}