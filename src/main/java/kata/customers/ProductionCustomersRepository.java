package kata.customers;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ProductionCustomersRepository {
    private final List<Customer> customers;

    public ProductionCustomersRepository(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> findWithBirthday(Instant today) {
        throw new RuntimeException("🤦🏽‍♀️ You are using ProductionCustomerRepository in a test. It will mess up our data.");
    }
} 