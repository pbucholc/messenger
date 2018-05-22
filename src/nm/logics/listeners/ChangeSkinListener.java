package nm.logics.listeners;

import de.javasoft.plaf.synthetica.*;
import nm.gui.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class ChangeSkinListener implements ActionListener {

    private MainWindow mainWindow;

    public ChangeSkinListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JMenuItem item = (JMenuItem) e.getSource();
        int number = (int) item.getClientProperty("Number");


        switch (number) {
            case 0:
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
                            SwingUtilities.updateComponentTreeUI(mainWindow);
                        } catch (UnsupportedLookAndFeelException e1) {
                            e1.printStackTrace();
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                break;
            case 1:
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
                            SwingUtilities.updateComponentTreeUI(mainWindow);
                        } catch (UnsupportedLookAndFeelException e1) {
                            e1.printStackTrace();
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                break;
            case 2:
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
                            SwingUtilities.updateComponentTreeUI(mainWindow);
                        } catch (UnsupportedLookAndFeelException e1) {
                            e1.printStackTrace();
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                break;
            case 3:
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            UIManager.setLookAndFeel(new SyntheticaBlueLightLookAndFeel());
                            SwingUtilities.updateComponentTreeUI(mainWindow);
                        } catch (UnsupportedLookAndFeelException e1) {
                            e1.printStackTrace();
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                break;
            case 4:
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            UIManager.setLookAndFeel(new SyntheticaBlueMoonLookAndFeel());
                            SwingUtilities.updateComponentTreeUI(mainWindow);
                        } catch (UnsupportedLookAndFeelException e1) {
                            e1.printStackTrace();
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                break;
            case 5:
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            UIManager.setLookAndFeel(new SyntheticaGreenDreamLookAndFeel());
                            SwingUtilities.updateComponentTreeUI(mainWindow);
                        } catch (UnsupportedLookAndFeelException e1) {
                            e1.printStackTrace();
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                break;
            case 6:
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            UIManager.setLookAndFeel(new SyntheticaOrangeMetallicLookAndFeel());
                            SwingUtilities.updateComponentTreeUI(mainWindow);
                        } catch (UnsupportedLookAndFeelException e1) {
                            e1.printStackTrace();
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                break;
            case 7:
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
                            SwingUtilities.updateComponentTreeUI(mainWindow);
                        } catch (UnsupportedLookAndFeelException e1) {
                            e1.printStackTrace();
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                break;
            case 8:
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            UIManager.setLookAndFeel(new SyntheticaSilverMoonLookAndFeel());
                            SwingUtilities.updateComponentTreeUI(mainWindow);
                        } catch (UnsupportedLookAndFeelException e1) {
                            e1.printStackTrace();
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                break;
            case 9:
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());
                            SwingUtilities.updateComponentTreeUI(mainWindow);
                        } catch (UnsupportedLookAndFeelException e1) {
                            e1.printStackTrace();
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                break;
        }
    }

}