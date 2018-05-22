package nm.logics.listeners;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import nm.db.ConnectDatabase;
import nm.gui.LogInPanel;
import nm.gui.MainWindow;
import nm.gui.SignUpPanel;
import nm.gui.SoundPlayer;
import nm.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpButtonListener implements ActionListener {

    SignUpPanel signUpPanel;
    MainWindow mainWindow;
    Dimension dimension;

    public SignUpButtonListener(SignUpPanel signUpPanel,MainWindow mainWindow, Dimension dimension) {
        this.signUpPanel=signUpPanel;
        this.mainWindow=mainWindow;
        this.dimension = dimension;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SoundPlayer.playSound("beep");
        User.login = signUpPanel.getEmail().getText();
        if(User.login.length() < 3){
            JOptionPane.showMessageDialog(null, "Podany login jest za krótki. Minimalna długość to 3 znaki.");
            return;
        }

        User.password = signUpPanel.getPassword().getText();
        if(User.password.length() < 5){
            JOptionPane.showMessageDialog(null, "Podane hasło jest za krótkie. Minimalna długość hasła to 5 znaków.");
            return;
        }

        Long passwordMD5 = Hashing.md5().hashString(User.password, Charsets.UTF_8).asLong();

        boolean signUpCorrect = ConnectDatabase.signUp(User.login, passwordMD5 + "");
        if (signUpCorrect) {
            mainWindow.remove(signUpPanel);
            mainWindow.add(new LogInPanel(dimension.width,dimension.height,mainWindow));
            mainWindow.revalidate();
            mainWindow.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "Rejestracja niepowiodła się. Uzytkownik o podanym loginie już istnieje w bazie danych.");
        }
    }
}
