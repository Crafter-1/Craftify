package main.player;

import javax.swing.SwingUtilities;

public class MusicPlayerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PlayerGUI();
        });
    }
}
