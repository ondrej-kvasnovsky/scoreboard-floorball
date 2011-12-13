/**
 * SoundPlayer.java, 13.12.2011 16:05:34 
 */
package scoreboard.sound;

import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * @author kvasnond
 */
public class SoundPlayer {

    public void playHorn() {
        try {
            // Open an input stream to the audio file.
            final InputStream is = getClass().getResourceAsStream("horn.au");
            // Create an AudioStream object from the input stream.
            final AudioStream as = new AudioStream(is);
            // Use the static class member "player" from class AudioPlayer
            // to play clip.
            AudioPlayer.player.start(as);
            Thread.currentThread();
            Thread.sleep(2000);
            AudioPlayer.player.stop(as);
        }
        catch (final java.net.MalformedURLException e) {
            System.err.println("can't form horn.au URL");
        }
        catch (final IOException e) {
            System.out.println(e.getMessage());
        }
        catch (final InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
