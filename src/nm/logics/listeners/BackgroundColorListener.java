package nm.logics.listeners;

import nm.gui.MainWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class BackgroundColorListener implements ActionListener {

    private JTextArea messages;
    private MainWindow mainWindow;

    public BackgroundColorListener(JTextArea messages, MainWindow mainWindow){
        this.messages = messages;
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog(mainWindow);
        dialog.setLocationRelativeTo(mainWindow);
        dialog.setTitle("Wybierz x");
        String[] kolory = { "Czerwony", "Zielony", "Niebieski", "Zolty", "Rozowy", "Szary", "Biały" };
        JComboBox koloryTla = new JComboBox(kolory);
        dialog.add(koloryTla);
        dialog.setPreferredSize(new Dimension(250, 90));
        koloryTla.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent key) {
                int k = key.getKeyCode();
                if (k == 88) { // 88 to kod klawisza 'x'
                    String kolor = (String) ((JComboBox) key.getSource()).getSelectedItem();

                    switch (kolor) {
                        case "Czerwony":
                            messages.setBackground(Color.RED);
                            break;

                        case "Zielony":
                            messages.setBackground(Color.GREEN);
                            break;

                        case "Niebieski":
                            messages.setBackground(Color.BLUE);
                            break;
                        case "Zolty":
                            messages.setBackground(Color.YELLOW);
                            break;
                        case "Rozowy":
                            messages.setBackground(Color.PINK);
                            break;
                        case "Szary":
                            messages.setBackground(Color.GRAY);
                            break;
                        case "Biały":
                            messages.setBackground(Color.WHITE);
                            break;


                    }
                }
            }
        });
        dialog.pack();
        dialog.setVisible(true);

    }

}
