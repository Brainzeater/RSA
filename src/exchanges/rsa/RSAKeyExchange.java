package exchanges.rsa;

import exchanges.Message;

import java.util.ArrayList;

public class RSAKeyExchange {
    public static final String N_MSG = "n";
    public static final String E_MSG = "e";
    public static final String TEXT_MSG = "text";

    public static void start(){
        ArrayList<Character> chars = new ArrayList<>();
        FileHelper myFileHelper = new FileHelper();
//        chars = myFileHelper.readFile("message.txt");
//        myFileHelper.writeFile(chars, "received.txt");
        Talker bob = new Talker();
        bob.setName("Bob");
        Talker alice = new Talker();
        alice.setName("Alice");
        RSAListener eve = new RSAListener();
        eve.setName("Eve");

        /*Step 1: Bob calculates numbers and send them*/
        bob.calculateNumbers();

        bob.sendMessage(N_MSG, bob.getBigNum());
        eve.receiveMessage();
        alice.receiveMessage();

        bob.sendMessage(E_MSG, bob.getExp());
        eve.receiveMessage();
        alice.receiveMessage();

        /*Step 2: Alice crypts text and sends it to Bob*/
        chars = myFileHelper.readFile("messageToBob.txt");
        ArrayList<Integer> messageFromAlice = alice.cryptText(chars);
        myFileHelper.writeFileInt(messageFromAlice, "whatBobReceived.txt");
        for(int msg : messageFromAlice){
            alice.sendMessage(TEXT_MSG, msg);
            eve.receiveMessage();
            bob.receiveMessage();
        }

        /*Step 3: Bob encrypts text*/
        System.out.println("Step 3");
        System.out.println(bob.receivedMessages.size());

        int i = 0;
        while(i < bob.receivedMessages.size()){
            chars.add(bob.encryptText(bob.receivedMessages.pollFirst().getValue()));
            i++;
        }
        myFileHelper.writeFile(chars, "howBobEncrypted.txt");
    }
}
