package nm.gui;

import net.java.dev.designgridlayout.DesignGridLayout;
import nm.gui.components.PlaceholderPasswordField;
import nm.gui.components.PlaceholderTextField;
import nm.logics.listeners.SignUpBackToWelcomeButtonListener;
import nm.logics.listeners.SignUpButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPanel extends JPanel{

    private MainWindow mainWindow;
    private PlaceholderTextField email;
    private PlaceholderPasswordField password;
    private JButton signUp;
    private JButton backToWelcome;
    private Dimension dimension;

    public SignUpPanel(int width, int  height,  MainWindow mainWindow){

        dimension=new Dimension(width, height);
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

        signUp = new JButton("Zarejestruj się");
        signUp.setPreferredSize(new Dimension(0,35));
        signUp.addActionListener(new SignUpButtonListener(this,mainWindow,dimension));
        backToWelcome = new JButton("Powrót");
        backToWelcome.setPreferredSize(new Dimension(0,35));
        backToWelcome.addActionListener(new SignUpBackToWelcomeButtonListener(this,mainWindow,dimension));

        addEmptyRows(9, contentLayout);
        contentLayout.row().grid(null).add(new JLabel(), 1).add(email,2).add(new JLabel(), 1);;
        addEmptyRows(2, contentLayout);
        contentLayout.row().grid(null).add(new JLabel(), 1).add(password,2).add(new JLabel(), 1);;
        addEmptyRows(2, contentLayout);
        contentLayout.row().grid(null).add(new JLabel(), 1).add(signUp,2).add(new JLabel(), 1);;
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