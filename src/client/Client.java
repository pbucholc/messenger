package client;

import nm.gui.ChatPanel;
import java.io.*;
import java.net.*;

public class Client extends Thread{

    private Socket clientSocket;
    private DataOutputStream outToServer;
    private BufferedReader inFromServer;
    private ChatPanel chatPanel;

   public Client(){
       try {
           System.out.println("Oczekiwanie na połącznie...");
           clientSocket = new Socket("localhost", 6789);
           outToServer = new DataOutputStream(clientSocket.getOutputStream());
           inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
           System.out.println("Połączono");
           sendToServer("Wiadomosc powitalna");

       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public void run(){
       while(true) {
           try {
               String receivedMessage = inFromServer.readLine();
               receiveMessage(receivedMessage);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }

   public void sendToServer(String message){
       try {
           outToServer.writeBytes(message + '\n');
       } catch(IOException e){
           e.printStackTrace();
       }
   }

   public void receiveMessage(String message) {
       System.out.println("FROM SERVER: " + message);

       if (message.startsWith("[list]")) {
           String text = "";
           for (char c : message.substring(6).toCharArray()) {
               if (c == ';') {
                   text += '\n';
               } else {
                   text += c;
               }
           }
           chatPanel.getUsers().setText(text);
       } else if (chatPanel != null) {
           String allMessages = chatPanel.getMessages().getText();
           if (allMessages.isEmpty()) {
               chatPanel.getMessages().setText(message);
           } else {
               chatPanel.getMessages().setText(allMessages + '\n' + message);
           }
       }
   }

   public void setChatPanel(ChatPanel chatPanel){
       this.chatPanel = chatPanel;
   }
}
