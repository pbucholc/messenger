package nm.logics.listeners;

import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import nm.db.ConnectDatabase;
import nm.gui.ChatPanel;
import nm.gui.LogInPanel;
import nm.gui.MainWindow;
import nm.gui.SoundPlayer;
import nm.model.User;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInButtonListener implements ActionListener {

     LogInPanel logInPanel;
     MainWindow mainWindow;
     Dimension dimension;

     public LogInButtonListener(LogInPanel logInPanel, MainWindow mainWindow){
         this.logInPanel=logInPanel;
         this.mainWindow=mainWindow;
         this.dimension = new Dimension(700,500);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
         boolean userExists = true;
         if (userExists) {
             User.login = logInPanel.getEmail().getText();
             User.password = logInPanel.getPassword().getText();

             Long passwordMD5 = Hashing.md5().hashString(User.password, Charsets.UTF_8).asLong();

             boolean logInSuccesed = ConnectDatabase.logIn(User.login, passwordMD5 + "");

             if(logInSuccesed){
                 mainWindow.remove(logInPanel);
                 mainWindow.setSize(dimension);
                 mainWindow.add(new ChatPanel(dimension, mainWindow));
                 mainWindow.revalidate();
                 mainWindow.repaint();
                 mainWindow.getClient().sendToServer("[user_joined]" + User.login);
             }
             else{
                 JOptionPane.showMessageDialog(null, "Logowanie nie powiodło się. Wprowadzono nieprawidłowy login bądź hasło.");
             }

             SoundPlayer.playSound("beep");
         } else {


         }
    }
}
