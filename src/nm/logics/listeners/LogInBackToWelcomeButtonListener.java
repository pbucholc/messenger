package nm.logics.listeners;

import nm.gui.LogInPanel;
import nm.gui.MainWindow;
import nm.gui.SoundPlayer;
import nm.gui.WelcomePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInBackToWelcomeButtonListener implements ActionListener {

    LogInPanel logInPanel;
    MainWindow mainWindow;
    Dimension dimension;

    public LogInBackToWelcomeButtonListener(LogInPanel logInPanel, MainWindow mainWindow, Dimension dimension){
        this.logInPanel=logInPanel;
        this.mainWindow=mainWindow;
        this.dimension=dimension;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.remove(logInPanel);
        mainWindow.add(new WelcomePanel(dimension.width,dimension.height,mainWindow));
        mainWindow.revalidate();
        mainWindow.repaint();

        SoundPlayer.playSound("beep");
    }
}
