package main.player;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PlayerGUI extends JFrame {

    private final AudioPlayer audioPlayer = new AudioPlayer();
    private final JLabel currentSongLabel = new JLabel("No song loaded");



    public PlayerGUI() {
        setTitle("Craftify");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        currentSongLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 14));

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

        Font buttonFont;
        buttonFont = new Font("Comic Sans MS", Font.BOLD, 12);

        JButton loadButton = new JButton("Load");
        JButton playButton = new JButton("Play");
        JButton stopButton = new JButton("Stop");

        loadButton.setFont(buttonFont);
        playButton.setFont(buttonFont);
        stopButton.setFont(buttonFont);

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
