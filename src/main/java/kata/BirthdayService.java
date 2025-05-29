package kata;

import kata.customers.Customer;
import kata.customers.ProductionCustomersRepository;
import kata.discounts.DiscountCodeGenerator;
import kata.email.EmailSender;
import kata.logger.ProductionLogger;

import java.time.Instant;
import java.util.Date;

public class BirthdayService {
    private final ProductionCustomersRepository customerRepository;
    private final EmailSender emailSender;
    private final ProductionLogger logger;

    public BirthdayService(
            ProductionCustomersRepository customerRepository,
            EmailSender emailSender,
            ProductionLogger logger) {
        this.customerRepository = customerRepository;
        this.emailSender = emailSender;
        this.logger = logger;
    }

    public void greetCustomersWithBirthday(Instant today) {
        var customers = customerRepository.findWithBirthday(today);
        for (Customer customer : customers) {
            var discountCode = new DiscountCodeGenerator().generate();
            var template = "Happy birthday, {name}! Here is your discount code: {discount}"
                    .replace("{discount}", discountCode.getCode());
            customer.sendEmail(template, emailSender);
            logger.log("INFO", customer.fillWithEmail("Email sent to {kata.email}"));
        }
    }
} 