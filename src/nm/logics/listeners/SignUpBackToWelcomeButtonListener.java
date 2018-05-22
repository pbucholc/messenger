package nm.logics.listeners;

import nm.Main;
import nm.gui.MainWindow;
import nm.gui.SignUpPanel;
import nm.gui.SoundPlayer;
import nm.gui.WelcomePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpBackToWelcomeButtonListener implements ActionListener {

    SignUpPanel signUpPanel;
    MainWindow mainWindow;
    Dimension dimension;

    public SignUpBackToWelcomeButtonListener(SignUpPanel signUpPanel, MainWindow mainWindow, Dimension dimension){
        this.signUpPanel=signUpPanel;
        this.mainWindow=mainWindow;
        this.dimension=dimension;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.remove(signUpPanel);
        mainWindow.add(new WelcomePanel(dimension.width,dimension.height,mainWindow));
        mainWindow.revalidate();
        mainWindow.repaint();

        SoundPlayer.playSound("beep");
    }
}
