package nm.logics.listeners;

import nm.gui.LogInPanel;
import nm.gui.MainWindow;
import nm.gui.SoundPlayer;
import nm.gui.WelcomePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInPanelButtonListener implements ActionListener {

    WelcomePanel welcomePanel;
    MainWindow mainWindow;
    Dimension dimension;

    public LogInPanelButtonListener(WelcomePanel welcomePanel, MainWindow mainWindow, Dimension dimension){
        this.welcomePanel=welcomePanel;
        this.mainWindow=mainWindow;
        this.dimension=dimension;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        mainWindow.remove(welcomePanel);
        mainWindow.add(new LogInPanel(dimension.width,dimension.height,mainWindow));
        mainWindow.revalidate();
        mainWindow.repaint();

        SoundPlayer.playSound("beep");

    }

}
