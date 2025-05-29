package main.java;

import java.util.Date;

public class Customer {
    private final String name;
    private final String email;
    private final Date birthday;

    public Customer(String name, String email, Date birthday) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public boolean hasBirthday(Date aDate) {
        return birthday.equals(aDate);
    }

    public void sendEmail(String template, EmailSender sender) {
        String message = template.replace("{name}", name);
        sender.send(email, message);
    }

    public String fillWithEmail(String template) {
        return template.replace("{email}", email);
    }
} 