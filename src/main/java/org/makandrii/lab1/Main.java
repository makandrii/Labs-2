package org.makandrii.lab1;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cart user = new Cart();
        List<Product> products = List.of(
                new Product("Monitor", Category.Electronics, 3000),
                new Product("Keyboard", Category.Electronics, 1200),
                new Product("Mouse", Category.Electronics, 800)
        );

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("""
                    *** Menu ***
                    Please make your choice:
                    1) Show products list
                    2) Show products in cart
                    3) Make order
                    0) Exit
                    """);

            Scanner input = new Scanner(System.in);
            int userInput;
            do {
                userInput = input.nextInt();
            } while (userInput < 0 || userInput > 3);

            switch (userInput) {
                case 1: {
                    System.out.println("*** Products ***");
                    for (int i = 0; i < products.size(); i++) {
                        Product product = products.get(i);
                        System.out.printf("%d) %s\t\t$%.2f%n", i + 1, product.getName(), product.getPrice());
                    }
                    System.out.println("0) Back");

                    do {
                        userInput = input.nextInt();
                    } while (userInput < 0 || userInput > products.size() + 1);
                    user.add(products.get(userInput - 1), 1);
                    break;
                }
                case 2: {
                    System.out.println("*** Cart ***");
                    for (var product : user) {
                        System.out.printf("%s\tAmount: %d\tPrice: $%.2f%n",
                                product.getKey().getName(),
                                product.getValue(),
                                product.getKey().getPrice() * product.getValue()
                        );
                    }
                    break;
                }
                case 3: {
                    user.makeOrder();
                    System.out.println("Done");
                    break;
                }
                case 0: {
                    isRunning = false;
                    break;
                }
            }
        }
    }
}