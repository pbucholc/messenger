package nm;

import client.Client;
import nm.gui.MainWindow;

public class Main {

    public static void main(String[] args) {

        Client client = new Client();
        MainWindow mainWindow = new MainWindow(client);
        client.start();
    }
}