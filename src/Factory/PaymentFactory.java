package Factory;

import Payment.*;

import java.util.Scanner;

public class PaymentFactory {

    public static Payment createPayment(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Payment Method: ");
        System.out.println("1. Card");
        System.out.println("2. PayPal");
        System.out.println("3. Wallet");
        System.out.println("4. Cash");

        int choice = scanner.nextInt();

        if(choice < 1 || choice > 4){
            System.out.println("Invalid Choice");
            return createPayment();
        }

        return paymentMethodSelector(choice);
    }

    private static Payment paymentMethodSelector(int choice){
        Scanner scanner = new Scanner(System.in);
        switch (choice){
            case 1:
                System.out.println("Enter Card Number: ");
                int cardNumber = scanner.nextInt();
                System.out.println("Enter Card Holder Name: ");
                String cardHolderName = scanner.next();

                return new CardPayment(cardNumber, cardHolderName);

            case 2:
                System.out.println("Enter PayPal Email: ");
                String email = scanner.next();
                System.out.println("Enter OTP");
                int otp = scanner.nextInt();

                return new PaypalPayment(email, otp);

            case 3:
                System.out.println("Crypto Wallet Number: ");
                String walletNumber = scanner.next();
                System.out.println("otp: ");
                int cryptoOTP = scanner.nextInt();

                return new WalletPayment(walletNumber, cryptoOTP);

            case 4:
                return new CashPayment();



            default:
                System.out.println("Invalid Choice");
                return null;
        }
    }
}
