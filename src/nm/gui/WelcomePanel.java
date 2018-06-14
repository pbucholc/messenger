package nm.gui;

import net.java.dev.designgridlayout.DesignGridLayout;
import nm.logics.listeners.LogInPanelButtonListener;
import nm.logics.listeners.SignUpPanelButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WelcomePanel extends JPanel {

    private MainWindow mainWindow;
    private JButton logInButton;
    private JButton signUpButton;
    private Dimension dimension;

    public WelcomePanel(int width, int height, MainWindow mainWindow) {

        dimension = new Dimension(width, height);
        setPreferredSize(dimension);
        this.mainWindow = mainWindow;

        DesignGridLayout contentLayout = new DesignGridLayout(this);

        logInButton = new JButton("Logowanie");
        logInButton.setPreferredSize(new Dimension(0,35));
        logInButton.setVisible(true);
        logInButton.addActionListener(new LogInPanelButtonListener(this,mainWindow,dimension));
        logInButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        signUpButton = new JButton("Rejestracja");
        signUpButton.setPreferredSize(new Dimension(0,35));
        signUpButton.setVisible(true);

        signUpButton.addActionListener(new SignUpPanelButtonListener(this,mainWindow,dimension));

        addEmptyRows(20, contentLayout);
        contentLayout.row().grid(null).add(new JLabel(), 1).add(logInButton,2).add(new JLabel(), 1);
        addEmptyRows(2, contentLayout);
        contentLayout.row().grid(null).add(new JLabel(), 1).add(signUpButton,2).add(new JLabel(), 1);

        setOpaque(true); // Thanks to this function, panel does not disappear immediately.
    }

    private void addEmptyRows(int rows, DesignGridLayout contentLayout){
        for(int i = 0; i < rows; i++){
            contentLayout.row().grid(new JLabel());
        }
    }
}