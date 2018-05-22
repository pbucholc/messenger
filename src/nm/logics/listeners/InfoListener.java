package nm.logics.listeners;

import nm.gui.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoListener implements ActionListener {

    private MainWindow mainWindow;

    public InfoListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        JOptionPane.showMessageDialog(mainWindow, "Network messenger - komunikator grupowy stworzony w ramach projektu zespołowego."
                + " \n" + "Autorzy : Paulina Bucholc, Krystian Witek, Szymon Romaniuk, Michał Paluszkiewicz.");
    }
}