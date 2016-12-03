package exchanges;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public abstract class Listener implements CanListen {
    public LinkedList<Message> receivedMessages = new LinkedList<>();
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void receiveMessage() {
        Message message = Main.messagesToEveryone.peek();
        receivedMessages.push(message);
        handleMessage(message);
    }

    public void report(String report) {
        System.out.println(getName() + ": \"" + report + "\"");
    }

    public int calculateMod(int base, int power, int divisor) {
        BigInteger p = new BigInteger(String.valueOf(base));
        p = p.pow(power);
        BigInteger r = new BigInteger(String.valueOf(divisor));
        p = p.mod(r);
        report("I've calculated: " + p);
        return p.intValue();
    }
}
