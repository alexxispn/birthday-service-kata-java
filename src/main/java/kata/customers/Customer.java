package kata.customers;

import kata.email.EmailSender;
import java.time.Instant;

public class Customer {
    private final String name;
    private final String email;
    private final Instant birthday;

    public Customer(String name, String email, Instant birthday) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public boolean hasBirthday(Instant aDate) {
        return birthday.equals(aDate);
    }

    public void sendEmail(String template, EmailSender sender) {
        String message = template.replace("{name}", name);
        sender.send(email, message);
    }

    public String fillWithEmail(String template) {
        return template.replace("{kata.email}", email);
    }
} 