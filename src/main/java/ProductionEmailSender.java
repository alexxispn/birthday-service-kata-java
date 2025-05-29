package main.java;

public class ProductionEmailSender implements EmailSender {
    @Override
    public void send(String email, String message) {
        throw new RuntimeException("🤦🏽‍♀️ You are using ProductionEmailSender in a test. It will send real emails.");
    }
} 