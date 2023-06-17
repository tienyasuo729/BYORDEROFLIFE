package lab5;

import lab5.model.Company;
import lab5.model.Customer;

import java.util.List;
import java.util.Scanner;

public class CompanyManagement {
    private static Company company = new Company();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    displayAllCustomers();
                    break;
                case 3:
                    searchCustomer();
                    break;
                case 4:
                    sortCustomerList();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("----- Company Management Menu -----");
        System.out.println("1. Add new customer");
        System.out.println("2. Display all customers");
        System.out.println("3. Search customer");
        System.out.println("4. Sort customer list");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addCustomer() {
        System.out.print("Enter customer ID: ");
        int customerID = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter customer phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(customerID, name, phone);
        company.addCustomer(customer);
        System.out.println("Customer added successfully.");
    }

    private static void displayAllCustomers() {
        List<Customer> customerList = company.getCustomerList();

        if (customerList.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("----- All Customers -----");
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        }
    }

    private static void searchCustomer() {
        System.out.println("----- Customer Search -----");
        System.out.println("Search by:");
        System.out.println("1. Customer ID");
        System.out.println("2. Name");
        System.out.println("3. Phone");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String criteria;
        switch (choice) {
            case 1:
                criteria = "CustomerID";
                break;
            case 2:
                criteria = "Name";
                break;
            case 3:
                criteria = "Phone";
                break;
            default:
                System.out.println("Invalid choice. Returning to the main menu.");
                return;
        }

        System.out.print("Enter the value to search: ");
        String value = scanner.nextLine();

        List<Customer> searchResults = company.searchCustomers(criteria, value);

        if (searchResults.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("----- Search Results -----");
            for (Customer customer : searchResults) {
                System.out.println(customer);
            }
        }
    }

    private static void sortCustomerList() {
        company.sortCustomerList();
        System.out.println("Customer list sorted by customerCode in ascending order.");
    }
}