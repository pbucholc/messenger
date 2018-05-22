package nm.gui;

import client.Client;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

public class MainWindow extends JFrame {

    private Dimension frameDimension;
    private Client client;

    public MainWindow(Client client) {

        this.client=client;

        try {
            UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        frameDimension = new Dimension(400,515);
        setPreferredSize(frameDimension);

        setTitle("Network Messenger");
        add(new WelcomePanel(frameDimension.width, frameDimension.height, this));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //TODO add listener to close button, so that we can close all conections before exiting. Then null messeges will be send


        setVisible(true);
        pack();
        setLocationRelativeTo(null);

    }

    public Client getClient(){
        return client;
    }
}