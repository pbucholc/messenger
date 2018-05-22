package nm.gui;

import client.Client;
import nm.logics.listeners.*;
import nm.gui.components.PlaceholderTextField;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChatPanel extends JPanel {

    private JMenuBar menu;
    private JPanel contentPanel;

    private JTextArea messages;
    private JTextArea users;
    private JLabel usersLabel;
    private PlaceholderTextField myMessage;
    private JMenu editing;
    private JMenu info;
    private JMenu exit;
    private JMenu skin;
    private JMenuItem logout;
    private JMenuItem fontColor;
    private JMenuItem information;
    private JMenuItem font;
    private JMenuItem backgroundColor;
    private JMenuItem[] skins;
    private JScrollPane scrollChatPane;
    private JScrollPane scrollUserPane;
    private JButton send;
    private Client client;

    public ChatPanel(Dimension frameDimension, MainWindow mainWindow) {

        setPreferredSize(frameDimension);
        setLayout(new BorderLayout());
        client = mainWindow.getClient();
        client.setChatPanel(this);

    //----------------------------contentPanel-------------------------

        contentPanel = new JPanel();
        contentPanel.setLayout(null);

        messages = new JTextArea();
        messages.setEditable(false);
        messages.setBackground(null);
        ((DefaultCaret) messages.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        scrollChatPane = new JScrollPane(messages, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contentPanel.add(scrollChatPane);
        scrollChatPane.setSize(450,365);
        scrollChatPane.setLocation(15,15);


        usersLabel = new JLabel("Dostępni użytkownicy:");
        usersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(usersLabel);
        usersLabel.setSize(185,25);
        usersLabel.setLocation(480,15);

        users = new JTextArea();
        users.setForeground(Color.BLACK);
        users.setEditable(false);
        ((DefaultCaret) users.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        scrollUserPane = new JScrollPane(users, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contentPanel.add(scrollUserPane);
        scrollUserPane.setSize(185,340);
        scrollUserPane.setLocation(480,40);


        myMessage = new PlaceholderTextField();
        myMessage.setDisabledTextColor(Color.BLACK);
        myMessage.setPlaceholder("Napisz wiadomość...");
        myMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            send.doClick();
          }
            }
        });
        contentPanel.add(myMessage);
        myMessage.setSize(450,30);
        myMessage.setLocation(15,390);


        send = new JButton("Wyślij");
        contentPanel.add(send);
        send.setSize(185,30);
        send.setLocation(480,390);

        this.add(contentPanel, BorderLayout.CENTER);

    //----------------------------menu-------------------------

        menu = new JMenuBar();
        editing = new JMenu("Edycja"); // child 1
        fontColor = new JMenuItem("Kolor Czcionki");
        font = new JMenuItem("Edycja Czcionki");
        backgroundColor = new JMenuItem("Kolor tła");
        info = new JMenu("O programie"); // child 2
        information = new JMenuItem("Informacje");
        exit = new JMenu("Wyjście"); //child 3
        logout = new JMenuItem("Wyloguj się");
        skin = new JMenu("Zmień skórkę");
        skins = new JMenuItem[10];
        skins[0] = new JMenuItem("Alu Oxide");
        skins[1] = new JMenuItem("Black Eye");
        skins[2] = new JMenuItem("Black Star");
        skins[3] = new JMenuItem("Blue Light");
        skins[4] = new JMenuItem("Blue Moon");
        skins[5] = new JMenuItem("Green Dream");
        skins[6] = new JMenuItem("Orange Metallic");
        skins[7] = new JMenuItem("Plain");
        skins[8] = new JMenuItem("Silver Moon");
        skins[9] = new JMenuItem("White Vision");

        menu.add(editing);
        menu.add(skin);
        menu.add(info);
        menu.add(exit);

        editing.add(fontColor);
        editing.add(font);
        editing.add(backgroundColor);

        for (int i = 0; i < skins.length; i++) {
            skins[i].putClientProperty("Number", i);
            skins[i].addActionListener(new ChangeSkinListener(mainWindow));
            skin.add(skins[i]);
        }

        info.add(information);
        exit.add(logout);

        this.add(menu, BorderLayout.NORTH);

        fontColor.addActionListener(new FontColorListener(messages, mainWindow));
        font.addActionListener(new FontSizeListener(messages, mainWindow));
        backgroundColor.addActionListener(new BackgroundColorListener(messages, mainWindow));
        information.addActionListener(new InfoListener(mainWindow));
        logout.addActionListener(new LogOutListener(this, mainWindow));
        send.addActionListener(new SendMessageListener(myMessage, client));

        setVisible(true);
        setOpaque(true);

        SoundPlayer.playSound("intro");
    }

    public JTextArea getMessages(){
        return messages;
    }

    public JTextArea getUsers() {
        return users;
    }
}
