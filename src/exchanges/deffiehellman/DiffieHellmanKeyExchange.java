package exchanges.deffiehellman;

public class DiffieHellmanKeyExchange {
    public static final String GENERATOR_MSG = "generator";
    public static final String PRIME_NUMBER_MSG = "prime number";
    public static final String COMPANION_RES_MSG = "companion result";
    public static void start() {
        DHListener eve = new DHListener();
        eve.setName("Eve");
        Talker alice = new Talker();
        alice.setName("Alice");
        Talker bob = new Talker();
        bob.setName("Bob");


        /*Step 1*/
        /*Alice sends generator*/
        alice.setGenerator(3);
        alice.sendMessage(GENERATOR_MSG, alice.getGenerator());
        eve.receiveMessage();
        bob.receiveMessage();

        /*Alice sends prime number*/
        alice.setPrimeNumber(17);
        alice.sendMessage(PRIME_NUMBER_MSG, alice.getPrimeNumber());
        eve.receiveMessage();
        bob.receiveMessage();

        /*Step 2*/
        /*Alice random private number*/
        alice.setPrivateKey(54);
        alice.sendMessage(COMPANION_RES_MSG,
                alice.calculateMod(alice.getGenerator(), alice.getPrivateKey(),alice.getPrimeNumber()));
        eve.receiveMessage();
        bob.receiveMessage();
        bob.setCompanionResult();

        /*Step 3*/
        /*Bob random private number*/
        bob.setPrivateKey(24);
        bob.sendMessage(COMPANION_RES_MSG,
                bob.calculateMod(bob.getGenerator(), bob.getPrivateKey(), alice.getPrimeNumber()));
        eve.receiveMessage();
        alice.receiveMessage();
        alice.setCompanionResult();

        /*Step 4*/
        /*Alice counts private key and so does Bob*/
        alice.setMyKey(alice.calculateMod(alice.getCompanionResult(), alice.getPrivateKey(), alice.getPrimeNumber()));
        bob.setMyKey(bob.calculateMod(bob.getCompanionResult(), bob.getPrivateKey(), alice.getPrimeNumber()));

        if(alice.getMyKey() == bob.getMyKey()){
            alice.report("Hooray!");
            bob.report("Hooray!");
            eve.report(":(");
        }else{
            alice.report(":(");
            bob.report(":(");
            eve.report("Hooray!");
        }

    }
}
