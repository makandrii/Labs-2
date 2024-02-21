package org.makandrii.lab1;

import java.util.List;
import java.util.Optional;
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
            System.out.print("""
                    *** Menu ***
                    Please make your choice:
                    1) Show products list
                    2) Show products in cart
                    3) Remove product from cart
                    4) Make order
                    0) Exit
                    """);

            Scanner input = new Scanner(System.in);
            int userInput;
            do {
                userInput = input.nextInt();
            } while (userInput < 0 || userInput > 4);

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

                    if (userInput == 0) {
                        break;
                    }

                    System.out.print("Please enter the quantity: ");
                    int userAmount;
                    do {
                        userAmount = input.nextInt();
                    } while (userAmount <= 0);

                    user.add(products.get(userInput - 1), userAmount);
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
                    System.out.println("*** Cart ***");
                    System.out.print("Please enter the name: ");

                    String inputName = input.next();

                    Optional<Product> findResult = user.findBy(inputName);
                    if (findResult.isPresent()) {
                        Product product = findResult.get();
                        System.out.print("Please enter the quantity: ");

                        int userAmount;
                        do {
                            userAmount = input.nextInt();
                        } while (userAmount <= 0);

                        user.remove(product, userAmount);
                        System.out.println("Done");
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                }
                case 4: {
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