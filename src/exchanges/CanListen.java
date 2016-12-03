package exchanges;

public interface CanListen {
    void receiveMessage();
    void handleMessage(Message message);
    void report(String somethingToTell);
    int calculateMod(int base, int power, int divisor);
}
