package nm.logics.listeners;

import nm.gui.SoundPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

public class AddFileListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        SoundPlayer.playSound("beep");
    }
}
