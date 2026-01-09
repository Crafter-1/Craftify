package main.player;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PlayerGUI extends JFrame {

    private final AudioPlayer audioPlayer = new AudioPlayer();
    private final JLabel currentSongLabel = new JLabel("No song loaded");

    public PlayerGUI() {
        setTitle("Java Music Player");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        add(createTopPanel(), BorderLayout.NORTH);
        add(createButtonPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel();
        panel.add(currentSongLabel);
        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();

        JButton loadButton = new JButton("Load");
        JButton playButton = new JButton("Play");
        JButton stopButton = new JButton("Stop");

        loadButton.addActionListener(e -> loadMusic());
        playButton.addActionListener(e -> audioPlayer.play());
        stopButton.addActionListener(e -> audioPlayer.stop());

        panel.add(loadButton);
        panel.add(playButton);
        panel.add(stopButton);

        return panel;
    }

    private void loadMusic() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                audioPlayer.load(file);
                currentSongLabel.setText(file.getName());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Unsupported audio format.\nUse WAV files.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}
