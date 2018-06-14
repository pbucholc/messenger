package nm.logics.listeners;

import nm.gui.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        dialog.setTitle("Wybierz kolor czcionki");

        String[] colors = { "Czerwony", "Zielony", "Niebieski", "Zolty", "Rozowy", "Szary", "Czarny" };

        JComboBox fontsColors = new JComboBox(colors);
        dialog.add(fontsColors);
        dialog.setPreferredSize(new Dimension(250, 90));

        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Object item = e.getItem();

                    String color = (String) item;
                    switch (color) {
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
            }};

        fontsColors.addItemListener(itemListener);

        dialog.pack();
        dialog.setVisible(true);
    }
}