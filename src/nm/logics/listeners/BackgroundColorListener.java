package nm.logics.listeners;

import nm.gui.MainWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

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

        String[] colors = { "Czerwony", "Zielony", "Niebieski", "Zolty", "Rozowy", "Szary", "Biały" };

        JComboBox backgorundColors = new JComboBox(colors);
        dialog.add(backgorundColors);
        dialog.setPreferredSize(new Dimension(250, 90));
        dialog.setTitle("Wybierz kolor tła");

        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Object item = e.getItem();

                    String color = (String) item;
                    switch (color) {
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

        };

        backgorundColors.addItemListener(itemListener);

        dialog.pack();
        dialog.setVisible(true);
    }
}
