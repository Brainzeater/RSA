package exchanges.rsa;

import exchanges.Message;

import java.util.ArrayList;
import java.util.Random;

import static exchanges.rsa.RSAKeyExchange.E_MSG;
import static exchanges.rsa.RSAKeyExchange.N_MSG;
import static exchanges.rsa.RSAKeyExchange.TEXT_MSG;

public class RSAListener extends exchanges.Listener {
    private static final int MAX = 99;
    private static final int MIN = 90;
    private int bigNum;         //n
    private int exp;            //e
    private int randNum1;
    private int randNum2;
    private int phiOfBigNum;    //k
    private int privateKey = 0;     //d
    private char lastEncryptedChar;


    public void calculateNumbers() {
        Random random = new Random();

        do {
            randNum1 = random.nextInt(MAX - MIN + 1) + MIN;
            randNum2 = random.nextInt(MAX - MIN + 1) + MIN;
            bigNum = randNum1 * randNum2;
            phiOfBigNum = (randNum1 - 1) * (randNum2 - 1);
        } while (phiOfBigNum % 3 != 0);
        exp = 3;
        /*boolean done = false;
        while (!done) {
            for (int i = 3; i < 100 && !done; i += 2) {
                System.out.println(i);
                if (phiOfBigNum % i == 0) {
                    int b = i;
                    int a = phiOfBigNum;
                    while (b != 0) {
                        int tmp = a % b;
                        a = b;
                        b = tmp;
                    }
                    System.out.println("!!!" + a);
                    if (a == 1) {
                        exp = i;
                        done = true;
                    }
                }
            }
        }*/
        privateKey = ((exp - 1) * phiOfBigNum + 1) / exp;
        System.out.println(randNum1);
        System.out.println(randNum2);
        System.out.println(bigNum);
        System.out.println(phiOfBigNum);
        System.out.println(exp);
        System.out.println(privateKey);
    }

    public void handleMessage(Message message) {
        report("Received " + message.getTypeOfMessage() + " from  "
                + message.getAuthor() + ", value: " + message.getValue());
        switch (message.getTypeOfMessage()) {
            case N_MSG:
                this.bigNum = message.getValue();
                break;
            case E_MSG:
                this.exp = message.getValue();
                break;
            case TEXT_MSG:
                break;
        }
    }

    public ArrayList<Integer> cryptText(ArrayList<Character> chars) {
        ArrayList<Integer> crypted = new ArrayList<>();
        for (Character ch : chars) {
            System.out.println((int) ch);
            crypted.add(calculateMod((int) ch, exp, bigNum));   //c
        }
        return crypted;
    }

    public char encryptText(int value){
        if(privateKey!=0) {
            return (char) calculateMod(value, privateKey, bigNum);
        }else{
            report("I can't do that");
            return ' ';
        }
    }

    public char getLastEncryptedChar() {
        return lastEncryptedChar;
    }

    public int getExp() {
        return exp;
    }

    public int getBigNum() {
        return bigNum;
    }
}
