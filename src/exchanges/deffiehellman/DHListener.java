package exchanges.deffiehellman;

import exchanges.Message;

import static exchanges.deffiehellman.DiffieHellmanKeyExchange.COMPANION_RES_MSG;
import static exchanges.deffiehellman.DiffieHellmanKeyExchange.GENERATOR_MSG;
import static exchanges.deffiehellman.DiffieHellmanKeyExchange.PRIME_NUMBER_MSG;

public class DHListener extends exchanges.Listener {
    private int generator;
    private int primeNumber;
    private int companionResult;
    private int privateKey;
    private int myKey;

    public void handleMessage(Message message) {

        report("Received " + message.getTypeOfMessage() + " from  "
                + message.getAuthor() + ", value: " + message.getValue());
        switch (message.getTypeOfMessage()) {
            case GENERATOR_MSG:
                this.generator = message.getValue();
                break;
            case PRIME_NUMBER_MSG:
                this.primeNumber = message.getValue();
                break;
            case COMPANION_RES_MSG:
                this.companionResult = message.getValue();
        }
    }

    public int getGenerator() {
        return generator;
    }

    public void setGenerator(int generator) {
        this.generator = generator;
    }

    public int getPrimeNumber() {
        return primeNumber;
    }

    public void setPrimeNumber(int primeNumber) {
        this.primeNumber = primeNumber;
    }

    public int getCompanionResult() {
        return companionResult;
    }

    public void setCompanionResult() {
        this.companionResult = exchanges.Main.messagesToEveryone.peek().getValue();
    }

    public int getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(int privateKey) {
        this.privateKey = privateKey;
    }

    public int getMyKey() {
        return myKey;
    }

    public void setMyKey(int myKey) {
        this.myKey = myKey;
    }
}
