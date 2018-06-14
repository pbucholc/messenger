package nm.gui;

import client.Client;

import net.java.dev.designgridlayout.DesignGridLayout;
import nm.gui.components.PlaceholderPasswordField;
import nm.gui.components.PlaceholderTextField;
import nm.logics.listeners.LogInBackToWelcomeButtonListener;
import nm.logics.listeners.LogInButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LogInPanel extends JPanel{

    private MainWindow mainWindow;
    private PlaceholderTextField email;
    private PlaceholderPasswordField password;
    private JButton logIn;
    private JButton backToWelcome;
    private Dimension dimension;

    public LogInPanel(int width, int height, MainWindow mainWindow){

        dimension = new Dimension(width, height);
        setPreferredSize(dimension);
        this.mainWindow = mainWindow;

        DesignGridLayout contentLayout = new DesignGridLayout(this);

        email = new PlaceholderTextField();
        email.setPlaceholder("Login");
        email.setFont(new Font(email.getFont().getName(), email.getFont().getStyle(), 18));
        email.setPreferredSize(new Dimension(0,35));

        password = new PlaceholderPasswordField();
        password.setPlaceholder("Hasło");
        password.setFont(new Font(password.getFont().getName(), password.getFont().getStyle(), 18));
        password.setPreferredSize(new Dimension(0,35));
        password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    logIn.doClick();
                }
            }
        });

        logIn = new JButton("Zaloguj się");
        logIn.addActionListener(new LogInButtonListener(this,mainWindow));
        logIn.setPreferredSize(new Dimension(0,35));
        backToWelcome = new JButton("Powrót");
        backToWelcome.setPreferredSize(new Dimension(0,35));
        backToWelcome.addActionListener(new LogInBackToWelcomeButtonListener(this,mainWindow,dimension));

        addEmptyRows(9, contentLayout);
        contentLayout.row().grid(null).add(new JLabel(), 1).add(email,2).add(new JLabel(), 1);;
        addEmptyRows(2, contentLayout);
        contentLayout.row().grid(null).add(new JLabel(), 1).add(password,2).add(new JLabel(), 1);;
        addEmptyRows(2, contentLayout);
        contentLayout.row().grid(null).add(new JLabel(), 1).add(logIn,2).add(new JLabel(), 1);;
        addEmptyRows(2, contentLayout);
        contentLayout.row().grid(null).add(new JLabel(), 1).add(backToWelcome,2).add(new JLabel(), 1);;
        
        setOpaque(true);
    }

    private void addEmptyRows(int rows, DesignGridLayout contentLayout){
        for(int i = 0; i < rows; i++){
            contentLayout.row().grid(new JLabel());
        }
    }

    public PlaceholderTextField getEmail() {
        return email;
    }
    public PlaceholderPasswordField getPassword() {
        return password;
    }
}