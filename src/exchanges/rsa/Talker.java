package exchanges.rsa;

import exchanges.Main;
import exchanges.Message;

public class Talker extends RSAListener{
    public void sendMessage(String typeOfMessage, int message) {
        Main.messagesToEveryone.push(new Message(this.getName(), typeOfMessage, message));
    }
}
