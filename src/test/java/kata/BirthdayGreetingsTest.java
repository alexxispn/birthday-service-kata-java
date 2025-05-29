package kata;

import kata.customers.Customer;
import kata.customers.ProductionCustomersRepository;
import kata.email.ProductionEmailSender;
import kata.logger.ProductionLogger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class BirthdayGreetingsTest {

    @Test
    void shouldNotSendGreetingEmailsIfNoCustomerHasBirthdayToday() {
        var service = new BirthdayService(
            new ProductionCustomersRepository(List.of()),
            new ProductionEmailSender(),
            new ProductionLogger()
        );
        service.greetCustomersWithBirthday(new Date());

        // TODO: add assert
    }

    @Test
    void shouldSendGreetingEmailsToAllCustomersWithBirthdayToday() {
        List<Customer> customers = new java.util.ArrayList<>();
        customers.add(new Customer("John Doe", "john@example.com", Instant.from(LocalDate.parse("1990-02-14"))));
        customers.add(new Customer("Jane Doe", "jane@example.com", Instant.from(LocalDate.parse("2005-02-14"))));

        var service = new BirthdayService(
            new ProductionCustomersRepository(customers),
            new ProductionEmailSender(),
            new ProductionLogger()
        );

        service.greetCustomersWithBirthday(new Date());

        // TODO: add assert
    }

    @Test
    void doesNotThrowIfEmailSenderFails() {
        // TODO: Implement test
    }

    @Test
    void doesNotThrowIfRepositoryFails() {
        // TODO: Implement test
    }
} 