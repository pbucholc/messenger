package nm.logics.listeners;

import nm.gui.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FontColorListener implements ActionListener {

    private JTextArea messages;
    private MainWindow mainWindow;

    public FontColorListener(JTextArea messages, MainWindow mainWindow){
        this.messages = messages;
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        JDialog dialog = new JDialog(mainWindow);
        dialog.setLocationRelativeTo(mainWindow);
        dialog.setTitle("Wybierz x");
        String[] kolory = { "Czerwony", "Zielony", "Niebieski", "Zolty", "Rozowy", "Szary", "Czarny" };
        JComboBox koloryCzcionek = new JComboBox(kolory);
        dialog.add(koloryCzcionek);
        dialog.setPreferredSize(new Dimension(250, 90));
        koloryCzcionek.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent key) {
                int k = key.getKeyCode();
                if (k == 88) { // 88 its key code 'x'
                    String kolor = (String) ((JComboBox) key.getSource()).getSelectedItem();
                    switch (kolor) {
                        case "Czerwony":
                            messages.setForeground(Color.RED);
                            break;

                        case "Zielony":
                            messages.setForeground(Color.GREEN);
                            break;

                        case "Niebieski":
                            messages.setForeground(Color.BLUE);
                            break;

                        case "Zolty":
                            messages.setForeground(Color.YELLOW);
                            break;
                        case "Rozowy":
                            messages.setForeground(Color.PINK);
                            break;
                        case "Szary":
                            messages.setForeground(Color.GRAY);
                            break;

                        case "Czarny":
                            messages.setForeground(Color.BLACK);
                            break;

                    }
                }
            }
        });
        dialog.pack();
        dialog.setVisible(true);

    }

}