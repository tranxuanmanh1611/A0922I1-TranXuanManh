package service;
import model.Customer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private static Map<Integer,Customer> customerList;
    static {
        customerList=new HashMap<>();
        customerList.put(1,new Customer("Mai Văn Hoàng","1983-08-20","Hà Nội","resources/avata.png"));
        customerList.put(2,new Customer("Nguyễn Văn Nam","1983-08-21","Bắc Giang","resources/avata.png"));
    }

    public List<Customer> display(){
        List<Customer> customers = new ArrayList<>();
        for (Customer customer : customerList.values()){
            customers.add(customer);
        }
        return customers;
    }
}
