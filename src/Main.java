import javax.sound.sampled.*;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        String filePath = "C:/Users/User/Music/familiar.wav";

        try {
            File audioFile = new File(filePath);

            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(audioFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();


            Thread.sleep(clip.getMicrosecondLength() / 1000);

            clip.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
