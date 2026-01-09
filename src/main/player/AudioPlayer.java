package main.player;


import javax.sound.sampled.*;
import java.io.File;

public class AudioPlayer {

    private Clip clip;

    public void load(File file) throws Exception {
        if (clip != null && clip.isOpen()) {
            clip.close();
        }

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
    }

    public void play() {
        if (clip != null) {
            clip.start();
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);
        }
    }

    public boolean isLoaded() {
        return clip != null;
    }
}
