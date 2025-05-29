package kata.logger;

public class ProductionLogger {
    public void log(String level, String message) {
        throw new RuntimeException("🤦🏽‍♀️ You are using ProductionLogger in a test. It will log to production.");
    }
} 