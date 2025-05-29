package main.java;

import java.util.Random;

public class DiscountCodeGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Random random = new Random();

    public DiscountCode generate() {
        StringBuilder discountCode = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(CHARACTERS.length());
            discountCode.append(CHARACTERS.charAt(index));
        }
        return new DiscountCode(discountCode.toString());
    }
} 