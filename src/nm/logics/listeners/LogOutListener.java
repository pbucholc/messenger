package nm.logics.listeners;

import nm.gui.ChatPanel;
import nm.gui.MainWindow;
import nm.gui.SoundPlayer;
import nm.gui.WelcomePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogOutListener implements ActionListener{

    ChatPanel chatPanel;
    MainWindow mainWindow;


    public LogOutListener(ChatPanel chatpanel, MainWindow mainWindow){
        this.chatPanel=chatpanel;
        this.mainWindow=mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.remove(chatPanel);
        mainWindow.add(new WelcomePanel(400,500,mainWindow));
        mainWindow.setSize(new Dimension(400,500));
        mainWindow.revalidate();
        mainWindow.repaint();


        SoundPlayer.playSound("intro");
    }
}
