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
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class BirthdayGreetingsTest {

    @Test
    void shouldNotSendGreetingEmailsIfNoCustomerHasBirthdayToday() {
        var service = new BirthdayService(
            new ProductionCustomersRepository(new ArrayList<>()),
            new ProductionEmailSender(),
            new ProductionLogger()
        );
        service.greetCustomersWithBirthday(Instant.now());
    }

    @Test
    void shouldSendGreetingEmailsToAllCustomersWithBirthdayToday() {
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer("John Doe", "john@example.com", LocalDate.parse("1990-02-14").atStartOfDay(ZoneOffset.UTC).toInstant()));
        customers.add(new Customer("Jane Doe", "jane@example.com", LocalDate.parse("2005-02-14").atStartOfDay(ZoneOffset.UTC).toInstant()));

        var service = new BirthdayService(
            new ProductionCustomersRepository(customers),
            new ProductionEmailSender(),
            new ProductionLogger()
        );

        service.greetCustomersWithBirthday(Instant.now());
    }

    @Test
    void sendsAMessageWithTheDiscountCode() {
        // TODO: Implement test
    }
}
