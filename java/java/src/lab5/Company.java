package lab5;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Customer> customers;

    public Company() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Customer> searchCustomersByName(String name) {
        List<Customer> searchResults = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                searchResults.add(customer);
            }
        }
        return searchResults;
    }

    public List<Customer> searchCustomersByPhone(String phone) {
        List<Customer> searchResults = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getPhone().equals(phone)) {
                searchResults.add(customer);
            }
        }
        return searchResults;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Customer customer : customers) {
            sb.append(customer.toString()).append("\n");
        }
        return sb.toString();
    }
}