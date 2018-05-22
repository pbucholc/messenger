package nm.logics.listeners;

import nm.gui.MainWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class FontSizeListener implements ActionListener {

    private JTextArea messages;
    private MainWindow mainWindow;

    public FontSizeListener(JTextArea messages, MainWindow mainWindow) {
        this.messages = messages;
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog(mainWindow);
        dialog.setLocationRelativeTo(mainWindow);
        dialog.setTitle("Wybierz x");
        dialog.setPreferredSize(new Dimension(250, 90));
        String[] czcionki = { "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19" };
        JComboBox listaCzcionek = new JComboBox(czcionki);
        dialog.add(listaCzcionek);

        listaCzcionek.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent key) {
                int k = key.getKeyCode();
                if (k == 88) { // 88 to kod klawisza 'x'
                    int size = Integer.parseInt((String)((JComboBox) key.getSource()).getSelectedItem());
                    messages.setFont(new Font(messages.getFont().getName(), messages.getFont().getStyle(), size));
                }
            }
        });

        dialog.pack();
        dialog.setVisible(true);
    }

}