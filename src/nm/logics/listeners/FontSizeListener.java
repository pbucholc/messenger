package nm.logics.listeners;

import nm.gui.MainWindow;
import java.awt.*;
import java.awt.event.*;

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

        dialog.setTitle("Wybierz rozmiar czcionki");

        dialog.setPreferredSize(new Dimension(250, 90));
        String[] fonts = { "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19" };

        JComboBox fontsList = new JComboBox(fonts);
        dialog.add(fontsList);

        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Object item = e.getItem();
                    int size = Integer.parseInt((String)item);
                    messages.setFont(new Font(messages.getFont().getName(), messages.getFont().getStyle(), size));
                }
            }
        };
        fontsList.addItemListener(itemListener);
        dialog.pack();
        dialog.setVisible(true);
    }
}