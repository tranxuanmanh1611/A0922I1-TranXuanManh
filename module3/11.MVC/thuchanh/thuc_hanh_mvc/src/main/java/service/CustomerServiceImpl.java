package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customers.put(2, new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customers.put(3, new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customers.put(4, new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customers.put(5, new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customers.put(6, new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }


    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : customers.values()) {
            customerList.add(customer);
        }


        return customerList;
    }

    @Override
    public void save(int id,Customer aCustomer) {
        customers.put(id,aCustomer);
    }
    public boolean isDuplicate(int key){
        return customers.containsKey(key);
    }

    @Override
    public Customer findById(int id) {
       return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.remove(id);
        customers.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}