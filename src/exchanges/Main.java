package exchanges;

import exchanges.deffiehellman.DiffieHellmanKeyExchange;
import exchanges.rsa.RSAKeyExchange;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static Stack<Message> messagesToEveryone = new Stack<>();

    public static void main(String[] args) {
        System.out.println("0 - Diffie-Hellman Key Exchange\n" +
                "1 - RSA Key Exchange");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        if (input == 0) {
            DiffieHellmanKeyExchange.start();
        } else if (input == 1) {
            RSAKeyExchange.start();
        } else {
            System.out.println("Bad input");
        }

    }
}
