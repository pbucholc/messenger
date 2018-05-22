package nm.logics.listeners;

import client.Client;
import nm.gui.SoundPlayer;
import nm.gui.components.PlaceholderTextField;
import nm.model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendMessageListener implements ActionListener {

    private Client client;
    private PlaceholderTextField myMessage;

    public SendMessageListener(PlaceholderTextField myMessage, Client client){
        this.myMessage = myMessage;
        this.client = client;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SoundPlayer.playSound("beep");
        client.sendToServer("[message]" + User.login + ": " + myMessage.getText());
        myMessage.setText("");
    }
}
